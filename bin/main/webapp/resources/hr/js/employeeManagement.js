var currTab;
var csrfData = {};
var csrfParameter;
var csrfToken;
var preventMultiFlag = false;
var attCol = [
        '전체 항목', '인사 코드', '코드 명칭', '코드 그룹', '코드 그룹 명칭'
];

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
        columns = [
                {
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
                }
        ];

        ordering = [
                [
                        0, 'desc'
                ], [
                        8, 'desc'
                ], [
                        9, 'desc'
                ]
        ];

        url = '/selectEmployee';
        callEmployeeList(url, columns, ordering);
    }
});

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

function callEmployeeList(url, columns, ordering) {
    $("#employeeDatatables").empty();
    $('#employeeDatatables').append('<table id="employeeTable" style="width:100%"></table>');
    console.log(window.location.href + url);
    currTab = $('#employeeTable').DataTable({
        "dom" : '<"top"l>rt<"bottom"ip><"clear">',
        order : ordering,
        ajax : {
            url : window.location.href + url,
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : columns,
        destroy : true,
    });

    if (url == '/selectEmployee') {
        $('#employeeDatatables').append('<button id="insertholiday">');
        $('#employeeTable_length').after(
                '<div id = employeeTable_filter style="text-align: right;"></div>');
        $('#employeeTable_filter').append('<label for="searchBar">검색 : &nbsp</label>');
        $('#employeeTable_filter').append(
                '<input type="search" class="column_filter" id="searchBar">');
        var searchDiv = $('#employeeTable_filter').find('label');
        searchDiv.before('<select id="searchholiday" style="margin-right:10px">');
        for (var i = 0; i < attCol.length; i++) {
            $('#searchholiday').append('<option value=' + i + '>' + attCol[i] + '</option>');
        }

        $('#insertholiday').append('신규 등록');
    } else if (url == 'commuteList') {
        $('#employeeDatatables').append('<button id="insertCommute">');
        $('#insertCommute').append('신규 등록');
    }
}

$.fn.dataTable.ext.errMode = 'throw';
$('#employeeTable').ready(function() {
    $('#searchholiday').on('click', function() {
        var searchingText = $('#searchBar').val();
        currTab.search('').columns().search('').draw();
        if (this.value == 0) {
            currTab.search(searchingText).draw();
        } else {
            currTab.columns(this.value).search(searchingText).draw();
        }
    });

    $('#searchBar').on('keyup click', function() {
        var col = $('#searchholiday').val();
        currTab.search('').columns().search('').draw();
        if (col == 0) {
            currTab.search(this.value).draw();
        } else {
            currTab.columns(col).search(this.value).draw();
        }

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