var currTab;
var csrfData = {};
var csrfParameter;
var csrfToken;
var preventMultiFlag = false;
var attCol = [
        '전체 항목', '근태 아이디', '근태 코드', '근태 신청일', '시작', '종료', '사유', '상태'
];

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
                    data : 'r_num',
                    render : function(data) {
                        return '<input type="checkBox" value="' + data + '">';
                    }
                }, {
                    'sTitle' : '근태 아이디',
                    data : 'id'
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

        url = 'selectAttendacne';
        callList(url, columns);
    }
});

$('.white-box').on('click', '#insertAttendanceAction, #insertCommuteAction', function(event) {
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");
    var list = new Array();
    var i = 0;
    $('#insertAttendanceForm #attendance').each(function() {
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
    var loc = $('#insertAttendanceForm').attr('action');
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

// 버튼 눌렀을때
$(document).on("click", '#selectAttendacne', function() {
    $(this).parent().parent().find('li').removeClass('active');
    $(this).parent().addClass('active').addClass('nav-hover');
    columns = [
            {
                'sTitle' : '#',
                data : 'r_num',
                render : function(data) {
                    return '<input type="checkBox" value="' + data + '">';
                }
            }, {
                'sTitle' : '근태 아이디',
                data : 'id'
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

    ordering = [
        [
                1, 'desc'
        ]
    ];
    
    url = 'selectAttendacne';
    callList(url, columns, ordering);
});

$(document).on('click', '#commutingRecords', function() {
    $(this).parent().parent().find('li').removeClass('active');
    $(this).parent().addClass('active').addClass('custom-click');
    ordering = [
        [
                0, 'desc'
        ]
    ];
    columns = [
            {
                'sTitle' : '#',
                data : 'id',
                render : function(data, type, row, meta) {
                    return '<a href="item?id=' + data + '">' + data + '</a>';
                }
            }, {
                'sTitle' : '근무일',
                data : 'work_date',
                render : $.fn.dataTable.render.moment()
            }, {
                'sTitle' : '시작 시각',
                data : 'begin_date',
                render : $.fn.dataTable.render.moment('YYYY-MM-DD HH:mm:ss', 'A HH시 mm분')
            }, {
                'sTitle' : '종료 시각',
                data : 'end_date',
                render : $.fn.dataTable.render.moment('YYYY-MM-DD HH:mm:ss', 'A HH시 mm분')
            }, {
                'sTitle' : '야근 시간',
                data : 'night_time',
                render : function(data) {
                    if (data == 0) return '없음';
                    return data + '시간';
                }
            }, {
                'sTitle' : '초과근무 시간',
                data : 'over_time',
                render : function(data) {
                    if (data == 0) return '없음';
                    return data + '시간';
                }
            }, {
                'sTitle' : '근태',
                data : 'attendance_id'
            }, {
                'sTitle' : '사원번호',
                data : 'employee_id'
            }
    ];

    url = 'commuteList';
    callList(url, columns, ordering);
});

function callList(url, columns, ordering) {
    $("#datatables").empty();
    $('#datatables').append('<table id="attendanceTable" style="width:100%"></table>');
    currTab = $('#attendanceTable').DataTable({
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

    if (url == 'selectAttendacne') {
        $('#datatables').append('<button id="insertAttendance">');
        $('#attendanceTable_length').after(
                '<div id = attendanceTable_filter style="text-align: right;"></div>');
        $('#attendanceTable_filter').append('<label for="searchBar">검색 : &nbsp</label>');
        $('#attendanceTable_filter').append(
                '<input type="search" class="column_filter" id="searchBar">');
        var searchDiv = $('#attendanceTable_filter').find('label');
        searchDiv.before('<select id="searchAttendance" style="margin-right:10px">');
        for (var i = 0; i < attCol.length; i++) {
            $('#searchAttendance').append('<option value=' + i + '>' + attCol[i] + '</option>');
        }

        $('#insertAttendance').append('신규 등록');
    } else if (url == 'commuteList') {
        $('#datatables').append('<button id="insertCommute">');
        $('#insertCommute').append('신규 등록');
    }
}

$('#attendanceTable_filter').ready(function() {
    $('#searchAttendance').on('change', function() {
        currTab.search('').columns().search('').draw();
        var searchingText = $('#searchBar').val();
        if (this.value == 0) {
            currTab.search(searchingText).draw();
        } else {
            currTab.columns(this.value).search(searchingText).draw();
        }
    });

    $('#searchBar').on('input keyup click', function() {
        var col = $('#searchAttendance').val();
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