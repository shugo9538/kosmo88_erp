var startPage = 0;
var endPage = 0;
var currPage = 1;
$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();

    csrfData = {};
    csrfData[csrfParameter] = csrfToken;

    // 시작 주소로 처음 구분
    if (currLocation.split('/')[5] == 'attendance') {
        $('#attendanceTable').ready(function() {
            attendanceList();
        });
    }

    // 버튼 눌렀을때
    $('#selectAttendacne').click(function() {
        refeshAttendanceList();
    });

    $('#insertAttendanceAction').click(function() {
        insertAttendance(csrfParameter, csrfToken);
    });
    
    $('#commutingRecords').click(function() {
        $('.white-box').empty();
        callTable('commutingRecords');
        commutingRecords();
    });
    
});

function callTable(url) {
    $.ajax({
        url : window.location.href + url,  
        type : 'GET',
        success: function(result) {
            $('.white-box').html(result);
        },
        error: function() {
            alert('오류');
        },
    });
}

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

function attendanceList() {
    $('#attendanceTable').DataTable({
        ajax : {
            url : window.location.href + 'selectAttendacne', // 현 위치
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
                        return '<input type="checkBox" value="' + data + '">';
                    }
                }, {
                    data : 'r_num'
                }, {
                    data : 'id',
                    render : function(data) {
                        return '<a href="' + data + '">' + data + '</a>';
                    }
                }, {
                    data : 'attendance_cd_id'
                }, {
                    data : 'application_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    data : 'begin_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    data : 'end_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    data : 'reason'
                }, {
                    data : 'state'
                }
        ],
        destroy : true,
        retrieve : true
    });
}

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

function commutingRecords() {
    $('#commutingRecordsTable').DataTable({
        ajax : {
            url : window.location.href + 'commutingRecords', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
                {
                    data : 'rnum'
                }, {
                    data : 'id',
                    render : function(data) {
                        return '<a href="' + data + '">' + data + '</a>';
                    }
                }, {
                    data : 'work_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    data : 'begin_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    data : 'end_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    data : 'night_time'
                }, {
                    data : 'over_time'
                }, {
                    data : 'attendance_id'
                }, {
                    data : 'employee_id'
                }
        ],
        destroy : true,
        retrieve : true
    });
}