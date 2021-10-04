var csrfData = {};
var currTab;
var csrfParameter;
var csrfToken;

$(document).ready(function(){
	csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
	csrfToken = $("meta[name='_csrf']").attr("content");
	var currLocation = window.location.href;
	
	currLocation = currLocation.toString();
	csrfData[csrfParameter] = csrfToken;
	
	// 시작 주소로 처음 구분
	if(currLocation.split('/')[5] == 'estimateManagement') {
		
		$('#estimateList').ready(function(){
			estimateList();
		});
	}
	
	
});

// 날짜 형식 조정
$.fn.dataTable.render.moment = function(from, to, locale) {
	// Argument shifting
	if(arguments.length === 1) {
		locale = 'en';
		to = from;
		from = 'YYYY-MM-DD';
	} else if (arguments.length === 2) {
		locale = 'en';
	}
	
	return function(d, type, row) {
		if (!d) { return type === 'sort' || type === 'type' ? 0 : d; }
		
		var m = window.moment(d, from, locale, true);
		
		return m.format(type === 'sort' || type === 'type' ? 'x' : to);
	};
};

//거래처(구매처) 목록
function estimateList() {
	// 테이블 id
	currTab = $('#estimateList').DataTable({
        ajax : {
            url : window.location.href + '/estimateList', // 현 위치
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
                        return '<a href="/logistics_erp/sales/estimateDetail?request_id=' + row.request_id + '" onclick="window.open(this.href, width=1300, height=900); return false;">' + row.request_id + '</a>'; 
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
			var totalCnt = currTab.page.info().length;	// 화면에 보이는 체크박스 개수
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
		
		// 견적서 삭제(선택삭제)
		$(".col-md-2").on("click", "#estimateChoiceDeleteBtn", function() {
			var check = $("input:checkbox[name=request_id]:checked").length;
			
			if (check == 0) {
				alert("삭제할 견적서를 선택해주세요!!");
	    		return false;
			} else {
				
				var result = confirm("선택한 견적서를 삭제하시겠습니까?");
				
				if (result) {
					estimateChoiceDelete(csrfParameter, csrfToken);
				} else {
					return false;
				}
			}
		});
	});
}

//견적서 삭제(선택삭제)
function estimateChoiceDelete(csrfParameter, csrfToken) {
	var formData = JSON.stringify($('input[name=request_id]:checked').serialize());
	console.log(formData);
	
	
	$.ajax({
	    type : 'POST',
	    url : window.location.href + '/estimateChoiceDelete?' + csrfParameter + '=' + csrfToken, // 현 위치 + RestController url
	    data : formData,
	    dataType : 'json',
	    accept : "application/json",
	    contentType : "application/json; charset=utf-8",
	    beforeSend : function(xhr) {
	    	xhr.setRequestHeader(csrfParameter, csrfToken);
	    },
	    success : function(data) {
	        if (data) {
	            alert('선택한 견적서가 삭제되었습니다');
	            currTab.ajax.reload();
	        }
	    },
	    error : function() {
	        alert('오류');
	    },
	});
	event.preventDefault();
}