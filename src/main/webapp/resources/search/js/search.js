var currTab;
var csrfData = {};

$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();
    csrfData[csrfParameter] = csrfToken;
    // 시작 주소로 처음 구분
    if (currLocation.split('/')[5] == 'attendance') {
        $('#datatables').append('<table id="attendanceTable"></table>');
        columns = [
                {
                    'sTitle' : '#',
                    data : 'r_num'
                }, {
                    'sTitle' : '근태 아이디',
                    data : 'id',
                    render : function(data) {
                        return '<input type="checkBox" value="' + data + '">';
                    }
                }, {
                    'sTitle' : '근태 코드',
                    data : 'attendance_cd_id'
                }, {
                    'sTitle' : '근태 신청일',
                    data : 'application_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    'sTitle' : '시작',
                    data : 'begin_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    'sTitle' : '종료',
                    data : 'end_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                    'sTitle' : '사유',
                    data : 'reason'
                }, {
                    'sTitle' : '상태',
                    data : 'state'
                }
        ];

        url = window.location.href + 'selectAttendacne';
        callList(url, columns);
    }
});

$('.white-box').on('click', '#insertAttendanceAction', function() {
    insertAttendance(csrfParameter, csrfToken);
});

// 버튼 눌렀을때
$(document).on("click", '#selectAttendacne', function() {
    columns = [
            {
                'sTitle' : '#',
                data : 'r_num'
            }, {
                'sTitle' : '근태 아이디',
                data : 'id',
                render : function(data) {
                    return '<input type="checkBox" value="' + data + '">';
                }
            }, {
                'sTitle' : '근태 코드',
                data : 'attendance_cd_id'
            }, {
                'sTitle' : '근태 신청일',
                data : 'application_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '시작',
                data : 'begin_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '종료',
                data : 'end_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '사유',
                data : 'reason'
            }, {
                'sTitle' : '상태',
                data : 'state'
            }
    ];

    url = window.location.href + 'selectAttendacne';
    callList(url, columns);
});

$(document).on('click', '#commutingRecords', function() {
    columns = [
            {
                'sTitle' : '#',
                data : 'rnum'
            }, {
                'sTitle' : '출퇴근 아이디',
                data : 'id',
                render : function(data) {
                    return '<a href="' + data + '">' + data + '</a>';
                }
            }, {
                'sTitle' : '근무일',
                data : 'work_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '시작 시각',
                data : 'begin_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '종료 시각',
                data : 'end_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '야근 시간',
                data : 'night_time'
            }, {
                'sTitle' : '초과근무 시간',
                data : 'over_time'
            }, {
                'sTitle' : '근태',
                data : 'attendance_id'
            }, {
                'sTitle' : '사원번호',
                data : 'employee_id'
            }
    ];

    url = window.location.href + 'commuteList';
    callList(url, columns);
});

function callList(url, columns) {
    $("#datatables").empty();
    $('#datatables').append('<table id="attendanceTable"></table>');
    currTab = $('#attendanceTable').DataTable({
        ajax : {
            url : url,
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : columns,
        destroy : true
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
    currTab.ajax.reload();
}