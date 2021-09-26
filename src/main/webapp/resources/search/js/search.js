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
        $('#selectAttendacne').ready(function() {
            attendanceList();
        });
    }

    // 버튼 눌렀을때
    $('#selectAttendacne').click(function() {
        selectAttendancec(csrfToken, csrfParameter);
    });

    $('#insertAttendance').click(function() {
        selectAttendancec();
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
                    data : 'r_num'
                }, {
                    data : 'id'
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
        ]
    });
}