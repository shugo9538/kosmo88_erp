var csrfData = {};
$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
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
    
    if (currLocation.split('/')[5] == 'estimateManagement') {
    	
        $('#estimateList').ready(function() {
        	estimateList();
        });
    }
    
    // 거래처, 상품 등록 처리
    $("#insertClient").click(function() {
    	clientRegisterAction(csrfParameter, csrfToken);
    });
*/

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
    $('#estimateList').DataTable({
        ajax : {
            url : window.location.href + '/estimateList', // 현 위치
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
                    data : 'request_id',
                    render : function(data) {
                        return '<input type="checkBox" class="request_id" name="request_id" value="' + data + '">';
                    }
                }, {
                	data : 'request_id',
                }, {
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/estimate/estimateDetail?request_id=' + row.id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.client_name + '</a>'; 
                    }
                }, {
                    data : 'ceo_name',
                }, {
                    data : 'employee_name',
                }, {
                    data : 'request_date',
                    render : $.fn.dataTable.render.moment()
                }
        ],
        destroy : true,
        retrieve : true
    });
}

//견적서 삭제(선택삭제)
function estimateChoiceDelete(csrfParameter, csrfToken) {
	// 버튼 id
    $('#deleteEstimate').click(function(event) {
        var formData = {
            '_csrf' : $('input[name=_csrf]').val(),
            'request_id' : $('input[name=request_id]').val(),
        };
        // 폼 id
        var loc = $('#estimateManagementform').attr('action');
        $.ajax({
            type : 'POST',
            url : loc,
            data : formData,
            dataType : 'json',
            success : function(data) {
                if (data) {
                    alert('선택한 견적서가 삭제되었습니다');
                }
            },
            error : function() {
                alert('오류');
            },
        });
        event.preventDefault();
    });
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




function estimateList() {
    $('#estimateList').DataTable({
        ajax : {
            url : window.location.href + '/estimateList', // 현 위치
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
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/purchase/estimateDetail?id=' + row.id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.name + '</a>'; 
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