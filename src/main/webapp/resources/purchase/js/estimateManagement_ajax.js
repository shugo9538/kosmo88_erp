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
    if (currLocation.split('/')[5] == 'estimateManagement') {
    	
        $('#estimateList').ready(function() {
        	estimateList();
        });
    }
/*    
    if (currLocation.split('/')[5] == 'clientRegister') {
        
        $('#registeredClientList').ready(function() {
        	registeredClientList();
        });
    }
    
    // 거래처, 상품 등록 처리
    $("#insertClient").click(function() {
    	clientRegisterAction(csrfParameter, csrfToken);
    });


    // 견적서 삭제(선택삭제) 버튼 눌렀을대
    $("#deleteEstimate").click(function() {
    	estimateChoiceDelete(csrfParameter, csrfToken);
    });

    
/*
    // 버튼 눌렀을때
    $('#selectAttendacne').click(function() {
        refeshAttendanceList();
    });

    $('#insertAttendanceAction').click(function() {
        insertAttendance(csrfParameter, csrfToken);
    });
*/    
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

// 거래처(구매처) 목록
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
                        return '<a href="/logistics_erp/estimate/estimateDetail?request_id=' + row.request_id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.request_id + '</a>'; 
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

/*
//등록한 거래처(구매처) 목록
function registeredClientList() {
    $('#registeredClientList').DataTable({
        ajax : {
            url : window.location.href + '/registeredClientList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
                {
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/purchase/clientDetail?id=' + row.id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.name + '</a>'; 
                    }
                }, {
                	data : 'id',
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

//거래처, 상품 등록 처리
function clientRegisterAction(csrfParameter, csrfToken) {
	$('#clientRegisterform').submit(function(event) {
        var formData = {
            '_csrf' : $('input[name=_csrf]').val(),
            'id' : $('input[name=id]').val(),
            'ceo_name' : $('input[name=ceo_name]').val(),
            'phone1' : $('input[name=phone1]').val(),
            'phone2' : $('input[name=phone2]').val(),
            'phone3' : $('input[name=phone3]').val(),
            'email' : $('input[name=email]').val(),
            'register_num1' : $('input[name=register_num1]').val(),
            'register_num2' : $('input[name=register_num2]').val(),
            'register_num3' : $('input[name=register_num3]').val(),
            'zip_code' : $('input[name=zip_code]').val(),
            'address' : $('input[name=address]').val(),
            'detail_address' : $('input[name=detail_address]').val(),
            'item_name' : $('input[name=item_name]').val(),
            'category' : $('input[name=category]').val(),
            'price' : $('input[name=price]').val(),
        };
        var loc = $('#clientRegisterform').attr('action');
        $.ajax({
            type : 'POST',
            url : loc,
            data : formData,
            dataType : 'json',
            success : function(data) {
                if (data) {
                    alert('거래처가 등록되었습니다.');
                }
            },
            error : function() {
                alert('오류');
            },
        });

        event.preventDefault();
    });
	
}




*/

/*
function insertAttendance(csrfParameter, csrfToken) {
    $('#insertAttendanceForm').submit(function(event) {
        var formData = {
            '_csrf' : $('input[name=_csrf]').val(),
            'id' : $('input[name=id]').val(),
            'attendance_cd_id' : $('input[name=attendance_cd_id]').val(),
            'application_date' : $('input[name=application_date]').val(),
            'begin_date' : $('input[name=begin_date]').val(),
            'end_date' : $('input[name=end_date]').val(),
            'reason' : $('input[name=reason]').val(),
        };
        var loc = $('#insertAttendanceForm').attr('action');
        $.ajax({
            type : 'POST',
            url : loc,
            data : formData,
            dataType : 'json',
            success : function(data) {
                if (data) {
                    window.close();
                }
            },
            error : function() {
                alert('오류');
            },
        });

        event.preventDefault();
    });
}

function refeshAttendanceList() {
    $('#attendanceTable').ready(function() {
        $('#attendanceTable').DataTable().clear().draw().destroy();
        attendanceList();
    });
}
*/