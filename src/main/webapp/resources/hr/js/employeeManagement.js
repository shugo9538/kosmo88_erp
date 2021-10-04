var currTab;
var csrfData = {};
var csrfParameter;
var csrfToken;
var preventMultiFlag = false;
var hrCodeCol = [
        '전체 항목', '인사 코드', '코드 명칭', '코드 그룹', '코드 그룹 명칭'
];
var deptCodeCol = [
        '전체 항목', '부서 코드', '부서명'
];

// 페이지 탭 시작 시
$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();
    csrfData[csrfParameter] = csrfToken;
    // 시작 주소로 처음 구분
    console.log(currLocation.split('/')[5]);
    if (currLocation.split('/')[5] == 'employee') {
        $('#employeeDatatables').append('<table id="employeeTable" style="width:100%"></table>');
        columns = employeeColumns;
        ordering = employeeOrder;

        url = '/selectEmployee';
        callEmployeeList(url, columns, ordering);
    }
});

// 윗 탭 메뉴 버튼 눌렀을때
var configTab = '#selectEmployee, #selectMember';
$(document).on("click", configTab, function() {
    $(this).parent().parent().find('li').removeClass('active');
    $(this).parent().addClass('active').addClass('nav-hover');
    url = '/' + $(this).attr('id');

    switch (url) {
    case '/selectEmployee':
        columns = employeeColumns;
        ordering = employeeOrder;
        break;

    default:
        columns = memberColumns;
        ordering = memberOrder;
        break;
    }

    callEmployeeList(url, columns, ordering);
});

// 입력 버튼 클릭시 처리
$('.white-box').on('click', '#insertholidayAction, #insertCommuteAction', function(event) {
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");
    var list = new Array();
    var i = 0;
    $('#insertholidayForm #holiday').each(function() {
        var dataObject = new Object();
        $('.form-control' + i).each(function() {
            var data = $(this);
            dataObject[data.attr('name')] = data.val();
        });
        console.log(dataObject);
        list.push(dataObject);
        i++;
    });
    list.pop();
    var formData = JSON.stringify(list);
    var loc = $('#insertholidayForm').attr('action');
    console.log(loc, formData);

    if (preventMultiFlag) {
        alert('처리중입니다.');
        return false;
    } else {
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
                    preventMultiFlag = true;
                    window.close();
                }
            },
            error : function() {
                alert('오류');
            },
        });
    }

    event.preventDefault();
});

// 테이블 호출
function callEmployeeList(url, columns, ordering) {
    $("#employeeDatatables").empty();
    $('#employeeDatatables').append('<table id="employeeTable" style="width:100%"></table>');
    console.log(window.location.href + url);
    currTab = $('#employeeTable').DataTable({
        "dom" : '<"top"l>rt<"bottom"ip><"clear">',
        order : ordering,
        select : true,
        ajax : {
            url : window.location.href + url,
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : columns,
        destroy : true
    });

    $('#employeeTable_length').after(
            '<div id = employeeTable_filter style="text-align: right;"></div>');
    $('#employeeTable_filter').append('<label for="searchBar">검색 : &nbsp</label>');
    $('#employeeTable_filter').append('<input type="search" class="column_filter" id="searchBar">');

    if (url == '/selectEmployee') {
        $('#employeeDatatables').append('<button id="insertHRGroupCode">');
        $('#employeeDatatables').append('&nbsp;');
        $('#employeeDatatables').append('<button id="deleteHRCode">');
        $('#insertHRCode').append('신규 코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#insertHRGroupCode').append('신규 그룹코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#deleteHRCode').append('선택 삭제').attr('class',
                "btn btn-default outline-btn round set-color");

        var searchDiv = $('#employeeTable_filter').find('label');
        searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
        for (var i = 0; i < hrCodeCol.length; i++) {
            $('#searchHRCode').append('<option value=' + i + '>' + hrCodeCol[i] + '</option>');
        }
    } else {
        $('#employeeDatatables').append('<button id="insertAttendanceCode">');
        $('#employeeDatatables').append('&nbsp;');
        $('#employeeDatatables').append('<button id="deleteAttendanceCode">');
        $('#insertAttendanceCode').append('근태 코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#deleteAttendanceCode').append('선택 삭제').attr('class',
                "btn btn-default outline-btn round set-color");

        var searchDiv = $('#employeeTable_filter').find('label');
        searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
        for (var i = 0; i < attCodeCol.length; i++) {
            $('#searchHRCode').append('<option value=' + i + '>' + attCodeCol[i] + '</option>');
        }
    }

    currTab
            .on(
                    'click',
                    'tr',
                    function(e, dt, type, indexes) {
                        td = $(this).children();
                        loc = window.location.href + td.eq(1).text();
                        var options = "width=1800,height=320,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200";

                        win = window.open(loc, "popupWindow", options);
                    });
}

$('#employeeTable_filter').ready(function() {
    $('#searchHRCode').on('click', function() {
        var searchingText = $('#searchBar').val();
        currTab.search('').columns().search('').draw();
        if (this.value == 0) {
            currTab.search(searchingText).draw();
        } else {
            currTab.columns(this.value).search(searchingText).draw();
        }
    });

    $('#searchBar').on('change keyup input', function() {
        var col = $('#searchHRCode').val();
        currTab.search('').columns().search('').draw();
        if (col == 0) {
            console.log(col);
            console.log(this.value);
            currTab.search(this.value).draw();
        } else {
            currTab.columns(col).search(this.value).draw();
        }

    });
});

var employeeColumns = [
        {
            'sTitle' : '<input type="checkbox">',
            data : 'id',
            render : function(data) {
                return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                        + '">';
            }
        }, {
            'sTitle' : '사원 코드',
            data : 'id'
        }, {
            'sTitle' : '이름',
            data : 'name'
        }, {
            'sTitle' : '사진',
            data : 'photo'
        }, {
            'sTitle' : '주민등록번호',
            data : 'resident_reg_num'
        }, {
            'sTitle' : '전화번호',
            data : 'phone'
        }, {
            'sTitle' : '이메일',
            data : 'email'
        }, {
            'sTitle' : '주소',
            data : 'address'
        }, {
            'sTitle' : '입사일',
            data : 'hire_date'
        }, {
            'sTitle' : '부서 코드',
            data : 'department_id'
        }, {
            'sTitle' : '직급명',
            data : 'position_id'
        }, {
            'sTitle' : '직급 코드',
            data : 'id'
        }, {
            'sTitle' : '직급명',
            data : 'name'
        }
];

var employeeOrder = [
        [
                1, 'desc'
        ], [
                9, 'desc'
        ], [
                10, 'desc'
        ]
];

var memberColumns = [
        {
            'sTitle' : '<input type="checkbox">',
            data : 'id',
            render : function(data) {
                return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                        + '">';
            }
        }, {
            'sTitle' : '근태 코드',
            data : 'id'
        }, {
            'sTitle' : '근태 명칭',
            data : 'name'
        }, {
            'sTitle' : '근태 유형',
            data : 'type'
        }, {
            'sTitle' : '등록여부',
            data : 'enabled'
        }
];

var memberOrder = [
    [
            1, 'desc'
    ]
];