/*
$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;
    currLocation = currLocation.toString();

    // 시작 주소로 처음 구분
    if (currLocation.split('/')[5] == 'attendance') {
        $('#selectAttendacne').ready(function() {
            selectAttendancec(csrfToken, csrfParameter);
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
*/

function selectAttendancec(csrfToken, csrfParameter) {
    var data = {};
    data[csrfParameter] = csrfToken;

    $('#attendanceList').css("visibility", "visible");
    $.ajax({
        url : window.location.href + 'selectAttendacne', // 현 위치 + 요청 url 로 div별로 결과물 뿌리기 위해 이렇게 작성함
        type : 'POST',
        data : data,
        success : function(result) {
            var target = $('#attendanceList');
            target.empty(); // 테이블 초기화
            // 결과 리스트 전부 테이블에 추가
            $.each(result, function(i, result) {
                var attendanceList = "";
                attendanceList += '<tr>';

                attendanceList += '<td>';
                attendanceList += result.rownums;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.id;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.attendance_cd_id;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.application_date;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.begin_date;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.end_date;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.reason;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.state;
                attendanceList += '</td>';

                attendanceList += '</tr>';

                target.append(attendanceList);
            });
        },
        error : function() {
            alert("오류");
        }
    });
}
