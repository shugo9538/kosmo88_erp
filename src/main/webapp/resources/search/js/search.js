var startPage = 0;
var endPage = 0;
var currPage = 1;

$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();

    init();
    paging(startPage, endPage, currPage);

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

function init() {
    // 목록 수
    var selectBar = '<select name="example2_length" aria-controls="example2" class=""><option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select>';
    $('#example_length').empty().append('목록 ').append(selectBar).append('개 씩 보기');

    // 검색
    var searchBar = '<input type="search" class="" placeholder="" aria-controls="example">';
    $('#example_filter > label').empty().append('검색:').append(searchBar);

    // 페이징 이름 바꾸기
    $('#example_previous').empty().append('이전');
    $('#example_next').empty().append('다음');
}

function paging(startPage, endPage, currPage) {
    // 페이징 전체 범위
    var pageInfo = '페이지 ' + startPage + ' 부터 ' + endPage + ' 까지';
    $('#example_info').empty().append(pageInfo);

    // 페이징 번호
    var tag = $('<a>');
    tag.attr({
        'class' : 'paginate_button current',
        'aria-controls' : 'example2',
        'data-dt-idx' : 1,
        'tabindex' : 0
    })
    tag.append(currPage);
    $('#example_paginate > span').append(tag);
}

// 날짜 형식 조정
function reformatDate(longDate) {
    var tmp = new Date(longDate);
    console.log(tmp);
    var date = '';
    var dayMap = new Map([
        [0, '일'],
        [1, '월'],
        [2, '화'],
        [3, '수'],
        [4, '목'],
        [5, '금'],
        [6, '토']
    ]);

    date += tmp.getFullYear() + '년 ';
    date += tmp.getMonth()+1 + '월 ';
    date += tmp.getDate() + '일 ';
    date += dayMap.get(tmp.getDay());

    return date;
}

// 근태 조회
function selectAttendancec(csrfToken, csrfParameter) {
    var data = {};
    data[csrfParameter] = csrfToken;
    data[startPage] = 0;
    data[endPage] = 0;
    data[currPage] = 1;
    var element = $("[aria-sort=ascending]");
    console.log(element.ariaLabel);
    if (!element) {
//        data['sorting'] = element.
        data['orderBy'] = 'desc';
    } else {
        data['orderBy'] = 'asc';
    }
    
    console.log(data);
    
    $('#attendanceList').css("visibility", "visible");
    $.ajax({
        url : window.location.href + 'selectAttendacne', // 현 위치 + 요청 url 로
        // div별로 결과물 뿌리기 위해
        // 이렇게 작성함
        type : 'POST',
        data : data,
        success : function(result) {
            var target = $('#attendanceList');
            target.empty(); // 테이블 초기화
            // 결과 리스트 전부 테이블에 추가
            $.each(result, function(i, result) {
                console.log(result);
                var attendanceList = "";
                attendanceList += '<tr>';

                attendanceList += '<td>';
                attendanceList += result.r_num;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.id;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += result.attendance_cd_id;
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += reformatDate(result.application_date);
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += reformatDate(result.begin_date);
                attendanceList += '</td>';

                attendanceList += '<td>';
                attendanceList += reformatDate(result.end_date);
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