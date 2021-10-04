var csrfData = {};
var currTab;
var csrfParameter;
var csrfToken;

$(document).ready(function() {
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();
    csrfData[csrfParameter] = csrfToken;

    // 시작 주소로 처음 구분
    if (currLocation.split('/')[5] == 'orderManagement') {
    	
        $('#orderList').ready(function() {
        	orderList();
        });
    }
    
    if (currLocation.split('/')[5] == 'orderRegister') {
        
        $('#registeredOrderList').ready(function() {
        	registeredOrderList();
        });
    }
    
    // 발주서, 상품 등록 처리
	// '#orderRegisterAction', 버튼 id
	$('#white-box').on('click', '#orderRegisterAction', function() {
	    var loc = $('#orderRegisterForm').attr('action');
	    /*
	     * 1. 발주서 등록 {id:'id', type:'type', name:'name' ... }
	     * */
	    // $(form id tr id)
	    var dataObject = new Object();
	    $('#order').find('input').each(function() {
    		var data = $(this);
    		dataObject[data.attr('name')] = data.val();
	    });
	    console.log(dataObject);
	    
	    var formData = JSON.stringify(dataObject);
	    
	    $.ajax({
	        type : 'POST',
	        url : loc + '?' + csrfParameter + '=' + csrfToken,
	        data : formData,
	        accept : "application/json",
	        contentType : "application/json; charset=utf-8",
	        dataType : 'text',
	        beforeSend : function(xhr) {
	            xhr.setRequestHeader(csrfParameter, csrfToken);
	        },
	        success : function(data) {
	        	
	        },
	        error : function() {
	            alert('오류');
	        },
	    });
	    
	    var list = new Array();
	    var i = 0;
	    
	    // 2.상품
	    $('#orderRegisterForm #item-group').each(function() {
	    	var dataObject = new Object();
	    	$('.form-control').each(function() {
	    		var data = $(this);
	    		var name = data.attr('name');
	    		if (name == 'item_name') name = 'name';
	    		dataObject[name] = data.val();
	    	});
	    	console.log(dataObject);
	    	list.push(dataObject);
	    	i++
	    });
	    list.pop();
	    
	    formData = JSON.stringify(list);
	    // alert(formData);
	    
	    console.log(formData);
	    loc = window.location.href + '/itemRegisterAction';
	    
	    $.ajax({
	        type : 'POST',
	        url : loc + '?' + csrfParameter + '=' + csrfToken,
	        data : formData,
	        accept : "application/json",
	        contentType : "application/json; charset=utf-8",
	        dataType : 'text',
	        beforeSend : function(xhr) {
	            xhr.setRequestHeader(csrfParameter, csrfToken);
	        },
	        success : function(data) {
	            if (data) {
	            	alert('발주서가 등록되었습니다.');
	            	$('.form-control').each(function() {
	            		$(this).val('');
	            	});
	            	currTab.ajax.reload();
	            }
	        },
	        error : function() {
	            alert('오류');
	        },
	    });
	});  
});

// 날짜 형식 조정
$.fn.dataTable.render.moment = function(from, to, locale) {
    // Argument shifting
    if (arguments.length === 1) {
        locale = 'en';
        to = from;
        from = 'YYYY-MM-DD';
    } else if (arguments.length === 2) {
        locale = 'en';
    }

    return function(d, type, row) {
        if (!d) { return type === 'sort' || type === 'type' ? 0 : d; }

        var m = window.moment(d, from, locale, true);

        // Order and type get a number value from Moment, everything else
        // sees the rendered value
        return m.format(type === 'sort' || type === 'type' ? 'x' : to);
    };
};

// 발주서(주문서) 목록
function orderList() {
	currTab = $('#orderList').DataTable({
		"order": [[ 1, "desc" ]],
        ajax : {
            url : window.location.href + '/orderList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
        		{
                    data : 'request_id',
                    render : function(data) {
                        return '<input type="checkBox" class="request_id" name="request_id" value="' + data + '">';
                    }
                }, {
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/purchase/orderDetail?request_id=' + row.request_id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.request_id + '</a>'; 
                    }
                }, {
                	data : 'client_name',
                }, {	
                    data : 'client_ceo_name',
                }, {
                    data : 'client_phone',
                }, {   
                    data : 'employee_name',
                }, {
                    data : 'begin_date',
                    render : $.fn.dataTable.render.moment()
                }
        ],
        destroy : true,
        retrieve : true
    });
	
	currTab.on('draw', function(){
		// 개별 체크박스 클릭
		$(".request_id").click(function(){
			var totalCnt = currTab.page.info().length;  // 화면에 보이는 체크박스 전체 개수
			var checkedCnt = $("input[name=request_id]:checked").length;  // 화면에 보이는 체크된 체크박스 개수
			
			// 두 수량이 다르면
			if (totalCnt != checkedCnt) {
				// 전체 체크박스 false
				$("#checkAll").prop("checked", false);
			
			// 두 수량이 같으면	
			} else {
				// 전체 체크박스 true
				$("#checkAll").prop("checked", true);
			}
		});
		
		// 발주서 삭제(선택삭제)
	    $(".col-md-2").on("click", "#orderChoiceDeleteBtn", function() {
	    	var check = $("input:checkbox[name=request_id]:checked").length;
	    	
	    	if (check == 0) {
	    		alert("삭제할 발주서를 선택해주세요!!");
	    		return false;
	    	} else {
	    		
	    		var result = confirm("선택한 발주서를 삭제하시겠습니까?");
	    		
	    		if (result) {
	    			orderChoiceDelete(csrfParameter, csrfToken);
	    		} else {
	    			return false;
	    		}
	    	}
	    });
	});
}

// 발주서 삭제(선택삭제)
function orderChoiceDelete(csrfParameter, csrfToken) {
	var formData = JSON.stringify($('input[name=request_id]:checked').serialize());
    console.log(formData);
    
    $.ajax({
        type : 'POST',
        url : window.location.href + '/orderChoiceDelete?' + csrfParameter + '=' + csrfToken, // 현 위치 + RestController url
        data : formData,
        dataType : 'json',
        accept : "application/json",
        contentType : "application/json; charset=utf-8",
        beforeSend : function(xhr) {
            xhr.setRequestHeader(csrfParameter, csrfToken);
        },
        success : function(data) {
            if (data) {
                alert('선택한 발주서가 삭제되었습니다');
            	currTab.ajax.reload();
            }
        },
        error : function() {
            alert('오류');
        },
    });
    
    event.preventDefault();
}


//등록한 발주서 목록
function registeredOrderList() {
    currTab = $('#registeredOrderList').DataTable({
    		"order": [[ 1, "desc" ]],
        ajax : {
            url : window.location.href + '/registeredOrderList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
                {
                    data : null,
                    render : function(data, type, row, meta) {
                    	return '<a href="/logistics_erp/purchase/orderDetail?request_id=' + row.request_id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.request_id + '</a>'; 
                    }
                }, {
                	data : 'client_name',
                }, {
                    data : 'client_ceo_name',
                }, {
                    data : 'client_phone',
                }, {
                    data : 'employee_name',
                }, {
                    data : 'begin_date',
                    render : $.fn.dataTable.render.moment()
                }
        ],
        destroy : true,
        retrieve : true
    });
}
