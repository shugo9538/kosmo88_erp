
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
    if (currLocation.split('/')[5] == 'clientManagement') {
    	
        $('#clientList').ready(function() {
        	clientList();
        });
    }
    
    if (currLocation.split('/')[5] == 'clientRegister') {
        
        $('#registeredClientList').ready(function() {
        	registeredClientList();
        });
    }
    
 // 거래처 등록 처리
	// '#clientRegisterAction', 버튼 id
	$('#white-box').on('click', '#clientRegisterAction', function() {
	    var loc = $('#clientRegisterForm').attr('action');
	    var flag = false;
	    
	    // 입력 유효성 검사
	    
	    if(!$('#name').val()) {
	    	swal("거래처명을 입력하세요!!", "거래처명 입력 누락", "error");
	    	return false;
	    } else if(!$('#ceo_name').val()) {
	    	swal("대표자를 입력하세요!!", "대표자 입력 누락", "error");
	    	return false;
	    } else if(!$('#register_num1').val()) {
	    	swal("사업자 번호를 입력하세요!!", "사업자번호 입력 누락", "error");
	    	return false;
	    } else if(!$('#register_num2').val()) {
	    	swal("사업자 번호를 입력하세요!!", "사업자번호 입력 누락", "error");
	    	return false;
	    } else if(!$('#register_num3').val()) {
	    	swal("사업자 번호를 입력하세요!!", "사업자번호 입력 누락", "error");
	    	return false;
	    } else if(!$('#email1').val()) {
	    	swal("이메일을 입력하세요!!", "이메일 입력 누락", "error");
	    	return false;
	    } else if(!$('#email2').val()) {
	    	swal("이메일을 입력하세요!!", "이메일 입력 누락", "error");
	    	return false;
	    } else if(!$('#phone1').val()) {
	    	swal("연락처를 입력하세요!!", "연락처 입력 누락", "error");
	    	return false;
	    } else if(!$('#phone2').val()) {
	    	swal("연락처를 입력하세요!!", "연락처 입력 누락", "error");
	    	return false;
	    } else if(!$('#phone3').val()) {
	    	swal("연락처를 입력하세요!!", "연락처 입력 누락", "error");
	    	return false;
	    } else if(!$('#zip_code').val()) {
	    	swal("우편번호를 입력하세요!!", "우편번호 입력 누락", "error");
	    	return false;
	    } else if(!$('#address').val()) {
	    	swal("주소를 입력하세요!!", "주소 입력 누락", "error");
	    	return false;
	    } else if(!$('#detail_address').val()) {
	    	swal("상세주소를 입력하세요!!", "상세주소 입력 누락", "error");
	    	return false;
	    } 
	    
	    /*
	    1. 거래처 등록 {id:'id', type:'type', name:'name' ... }
	     * */
	    // $(form id tr id)
	    var dataObject = new Object();
	    $('#client').find('input').each(function() {
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
                itemRegister();
            },
            error : function() {
    			swal({
    				title:"거래처 등록 오류",
    				type: "error",
    				text: "잠시 후 다시 시도해주세요!",
    				timer: 2500
    			}, function() {
    				return false;
    			});
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

// 거래처 목록
function clientList() {
	currTab = $('#clientList').DataTable({
		"order": [[ 0, "desc" ]],
		dom: 'lfrtip<"clear">B',
        buttons: [ {
            extend: 'excelHtml5',
            autoFilter: true,
            attr:{
            	class: "btn btn-primary"
            },
            text:'<i class="fa fa-download">거래처목록 다운로드</i>',
            sheetName: '영업팁 거래처 목록',
            messageBottom : '커밋 3팀'
        }
        ],
        ajax : {
            url : window.location.href + '/clientList', // 현 위치
            // + 요청
            // url 로
            // div별로 결과물 뿌리기 위해
            // 이렇게 작성함
            type : 'POST',
            data : csrfData,
            dataSrc : ''
            
        },
        columns : [
                {
                    data : 'id',
                    render : function(data) {
                        return '<input type="checkBox" class="client_id" name="client_id" value="' + data + '">';
                    }
                }, {
                	data : 'id',
                }, {
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/sales/clientDetail?id=' + row.id + '" onclick="window.open(this.href, width=1200, height=700); return false;">' + row.name + '</a>'; 
                    }
                }, {
                    data : 'register_num',
                }, {
                    data : 'ceo_name',
                }, {
                    data : 'phone',
                }, {
                    data : 'address',
                }, {
                	data : 'register_date',
                	render : $.fn.dataTable.render.moment()
                }
        ],
        destroy : true,
        retrieve : true
    });
	
	currTab.on('draw', function(){
		// 개별 체크박스 클릭
		$(".client_id").click(function(){
			var totalCnt = currTab.page.info().length;  // 화면에 보이는 체크박스 전체 개수
			var checkedCnt = $("input[name=client_id]:checked").length;  // 화면에 보이는 체크된 체크박스 개수
			
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
		
		// 거래처 삭제(선택삭제)
	    $(".col-md-2").on("click", "#clientChoiceDeleteBtn", function() {
	    	var check = $("input:checkbox[name=client_id]:checked").length;
	    	
	    	if (check == 0) {
	    		alert("삭제할 거래처를 선택해주세요!!");
	    		return false;
	    	} else {
	    		
	    		var result = confirm("선택한 거래처를 삭제하시겠습니까?");
	    		
	    		if (result) {
	    			clientChoiceDelete(csrfParameter, csrfToken);
	    		} else {
	    			return false;
	    		}
	    	}
	    });
	});
}

// 거래처 삭제(선택삭제)
function clientChoiceDelete(csrfParameter, csrfToken) {
	var formData = JSON.stringify($('input[name=client_id]:checked').serialize());
    console.log(formData);
    
    $.ajax({
        type : 'POST',
        url : window.location.href + '/clientChoiceDelete?' + csrfParameter + '=' + csrfToken, // 현 위치 + RestController url
        data : formData,
        dataType : 'json',
        accept : "application/json",
        contentType : "application/json; charset=utf-8",
        beforeSend : function(xhr) {
            xhr.setRequestHeader(csrfParameter, csrfToken);
        },
        success : function(data) {
        	if (data) {
				swal({
					title:"거래처 삭제",
					type: "success",
					text: "선택한 거래처가 삭제되었습니다",
					timer: 2500
				}, function() {
					currTab.ajax.reload();
				});
            }
        },
        error : function() {
        	swal({
				title:"거래처 삭제 오류",
				type: "error",
				text: "잠시 후 다시 시도해주세요!",
				timer: 2500
			}, function() {
				return false;
			});
        },
    });
    
    event.preventDefault();
}


//등록한 거래처 목록
function registeredClientList() {
    currTab = $('#registeredClientList').DataTable({
    	"order": [[ 0, "desc" ]],
        ajax : {
            url : window.location.href + '/registeredClientList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
			    {
			    	data : 'id',
			    }, {
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/sales/clientDetail?id=' + row.id + '" onclick="window.open(this.href, width=1200, height=700); return false;">' + row.name + '</a>'; 
                    }
                }, {
                    data : 'register_num',
                }, {
                    data : 'ceo_name',
                }, {
                    data : 'phone',
                }, {
                    data : 'address',
                }, {
                    data : 'register_date',
                    render : $.fn.dataTable.render.moment()
                }
        ],
        destroy : true,
        retrieve : true
    });
}
