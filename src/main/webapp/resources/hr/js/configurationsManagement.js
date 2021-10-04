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
var positionCodeCol = [
        '전체 항목', '직급 코드', '직급명'
];
var attCodeCol = [
        '전체 항목', '근태 코드', '근태 명칭', '근태 유형', '등록여부'
];

// 페이지 탭 시작 시
$(document)
        .ready(
                function() {
                    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
                    var csrfToken = $("meta[name='_csrf']").attr("content");
                    var currLocation = window.location.href;

                    currLocation = currLocation.toString();
                    csrfData[csrfParameter] = csrfToken;
                    // 시작 주소로 처음 구분
                    console.log(currLocation.split('/')[5]);
                    if (currLocation.split('/')[5] == 'configurations') {
                        $('#configDatatables').append(
                                '<table id="configTable" style="width:100%"></table>');
                        columns = [
                                {
                                    'sTitle' : '<input type="checkbox" id="checkAll">',
                                    data : 'id',
                                    render : function(data) {
                                        return '<input type="checkBox" class="client_id" name="client_id" value="'
                                                + data + '">';
                                    }
                                }, {
                                    'sTitle' : '인사 코드',
                                    data : 'id'
                                }, {
                                    'sTitle' : '코드 명칭',
                                    data : 'name'
                                }, {
                                    'sTitle' : '코드 그룹',
                                    data : 'hr_group_id'
                                }, {
                                    'sTitle' : '코드 그룹 명칭',
                                    data : 'hr_group_name'
                                }
                        ];

                        ordering = [
                            [
                                    1, 'desc'
                            ]
                        ];

                        url = '/selectHRCode';
                        callConfigList(url, columns, ordering);
                    }
                });

// 윗 탭 메뉴 버튼 눌렀을때
var configTab = '#selectHRCode, #selectDepartments, #selectPosition, #selectAttendanceCode';
$(document).on("click", configTab, function() {
    $(this).parent().parent().find('li').removeClass('active');
    $(this).parent().addClass('active').addClass('nav-hover');
    url = '/' + $(this).attr('id');

    switch (url) {
    case '/selectHRCode':
        columns = hrCodeColumns;
        ordering = hrCodeOrder;
        break;

    case '/selectDepartments':
        columns = departmentCodeColumns;
        ordering = departmentCodeOrder;
        break;

    case '/selectPosition':
        columns = positionCodeColumns;
        ordering = positionCodeOrder;
        break;

    default:
        columns = attendanceCodeColumns;
        ordering = attendanceCodeOrder;
        break;
    }

    callConfigList(url, columns, ordering);
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
function callConfigList(url, columns, ordering) {
    $("#configDatatables").empty();
    $('#configDatatables').append('<table id="configTable" style="width:100%"></table>');
    console.log(window.location.href + url);
    currTab = $('#configTable').DataTable({
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

    $('#configTable_length')
            .after('<div id = configTable_filter style="text-align: right;"></div>');
    $('#configTable_filter').append('<label for="searchBar">검색 : &nbsp</label>');
    $('#configTable_filter').append('<input type="search" class="column_filter" id="searchBar">');

    if (url == '/selectHRCode') {
        $('#configDatatables').append('<button id="insertHRGroupCode">');
        $('#configDatatables').append('&nbsp;');
        $('#configDatatables').append('<button id="insertHRCode">');
        $('#configDatatables').append('&nbsp;');
        $('#configDatatables').append('<button id="deleteHRCode">');
        $('#insertHRCode').append('신규 코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#insertHRGroupCode').append('신규 그룹코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#deleteHRCode').append('선택 삭제').attr('class',
                "btn btn-default outline-btn round set-color");

        var searchDiv = $('#configTable_filter').find('label');
        searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
        for (var i = 0; i < hrCodeCol.length; i++) {
            $('#searchHRCode').append('<option value=' + i + '>' + hrCodeCol[i] + '</option>');
        }
    } else if (url == '/selectDepartments') {
        $('#configDatatables').append('<button id="insertDeptCode">');
        $('#configDatatables').append('&nbsp;');
        $('#configDatatables').append('<button id="deleteDeptCode">');
        $('#insertDeptCode').append('부서 코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#deleteDeptCode').append('선택 삭제').attr('class',
                "btn btn-default outline-btn round set-color");

        var searchDiv = $('#configTable_filter').find('label');
        searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
        for (var i = 0; i < deptCodeCol.length; i++) {
            $('#searchHRCode').append('<option value=' + i + '>' + deptCodeCol[i] + '</option>');
        }
    } else if (url == '/selectPosition') {
        $('#configDatatables').append('<button id="insertPositionCode">');
        $('#configDatatables').append('&nbsp;');
        $('#configDatatables').append('<button id="deletePositionCode">');
        $('#insertPositionCode').append('직급 코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#deletePositionCode').append('선택 삭제').attr('class',
                "btn btn-default outline-btn round set-color");

        var searchDiv = $('#configTable_filter').find('label');
        searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
        for (var i = 0; i < positionCodeCol.length; i++) {
            $('#searchHRCode')
                    .append('<option value=' + i + '>' + positionCodeCol[i] + '</option>');
        }
    } else {
        $('#configDatatables').append('<button id="insertAttendanceCode">');
        $('#configDatatables').append('&nbsp;');
        $('#configDatatables').append('<button id="deleteAttendanceCode">');
        $('#insertAttendanceCode').append('근태 코드 등록').attr('class',
                "btn btn-default outline-btn round set-color");
        $('#deleteAttendanceCode').append('선택 삭제').attr('class',
                "btn btn-default outline-btn round set-color");

        var searchDiv = $('#configTable_filter').find('label');
        searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
        for (var i = 0; i < attCodeCol.length; i++) {
            $('#searchHRCode').append('<option value=' + i + '>' + attCodeCol[i] + '</option>');
        }
    }
    
    currTab.on('click', 'tr', function(e, dt, type, indexes) {
        td = $(this).children();
        td.each(function(i) {
            console.log(td.eq(i).text());
        });
    });
}

$('#configTable_filter').ready(function() {
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

var hrCodeColumns = [
        {
            'sTitle' : '<input type="checkbox">',
            data : 'id',
            render : function(data) {
                return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                        + '">';
            }
        }, {
            'sTitle' : '인사 코드',
            data : 'id'
        }, {
            'sTitle' : '코드 명칭',
            data : 'name'
        }, {
            'sTitle' : '코드 그룹',
            data : 'hr_group_id'
        }, {
            'sTitle' : '코드 그룹 명칭',
            data : 'hr_group_name'
        }
];

var hrCodeOrder = [
    [
            1, 'desc'
    ]
];

var departmentCodeColumns = [
        {
            'sTitle' : '<input type="checkbox">',
            data : 'id',
            render : function(data) {
                return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                        + '">';
            }
        }, {
            'sTitle' : '부서 코드',
            data : 'id'
        }, {
            'sTitle' : '부서명',
            data : 'name'
        }
];

var departmentCodeOrder = [
    [
            1, 'desc'
    ]
];

var positionCodeColumns = [
        {
            'sTitle' : '<input type="checkbox">',
            data : 'id',
            render : function(data) {
                return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                        + '">';
            }
        }, {
            'sTitle' : '직급 코드',
            data : 'id'
        }, {
            'sTitle' : '직급명',
            data : 'name'
        }
];

var positionCodeOrder = [
    [
            1, 'desc'
    ]
];

var attendanceCodeColumns = [
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

var attendanceCodeOrder = [
    [
            1, 'desc'
    ]
];