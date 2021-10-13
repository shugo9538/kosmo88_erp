var currTab;
var csrfData = {};
var csrfParameter;
var csrfToken;
var preventMultiFlag = false;
var salaryCol = [
        '전체 항목', '기본급', '초과근무 수당', '성과금', '식대료', '근로 소득', '급여일', '월급(합계)', "이체현황", '지급 대상'
];

$(document).ready(function() {
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();
    csrfData[csrfParameter] = csrfToken;
    // 시작 주소로 처음 구분
    console.log(currLocation.split('/')[5]);
    if (currLocation.split('/')[5] == 'salary') {
        $('#salaryDatatables').append('<table id="salaryTable" style="width:100%"></table>');
        columns = salaryColumns;
        ordering = salaryOrdering;

        url = '/salaryList';
        callSalaryList(url, columns, ordering);
    }
});


// 윗 탭 메뉴 버튼 눌렀을때
var configTab = '#salaryList, #salaryStatistics';
$(document).on("click", configTab, function() {
    $(this).parent().parent().find('li').removeClass('active');
    $(this).parent().addClass('active').addClass('nav-hover');
    url = '/' + $(this).attr('id');

    if (url == "/salaryList") {
        columns = salaryColumns;
        ordering = salaryOrdering;
    } else {
        columns = salaryStaticColumns;
        ordering = salaryStaticOrdering;
    }

    callSalaryList(url, columns, ordering);
});

$('#searchEmployeeSalary').on('click', "input[name]",function() {
    var child = $(this).parents();
    console.log(opener.document);
    console.log(i);
    $("input[name=employee_id]", opener.document).val(child.find("#employee_id").val());
    $("input[name=basic_pay]", opener.document).val(child.find("#employee_basic_pay").val());
    $("input[name=overtime_pay]", opener.document).val(child.find("#employee_over_time").val());
    $("input[name=bonus]", opener.document).val(0);
    $("input[name=meal_fee]", opener.document).val(10000);
    $("input[name=payday]", opener.document).val(new Date().toISOString().slice(0, 10));
    var sum = 
        Number(child.find('#employee_basic_pay').val()) + 
        Number(child.find('#employee_over_time').val()) * 
        1.5 * 
        Number(child.find('#employee_time_pay').val());
    sum = Math.round(sum / 10000) * 10000;
    var tax = Math.round((sum * 0.06)/10000) * 10000;
    var total = sum - tax;
    $("input[name=income_tax]", opener.document).val(tax);
    $("input[name=employee_salary]", opener.document).val(total);
    $(window.close());
})


$('.white-box').on('click', '#insertSalaryAction, #insertCommuteAction', function(event) {
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");
    var list = new Array();
    var i = 0;
    console.log($('#insertsalaryForm #salary-group').children());
    console.log($('#insertsalaryForm #salary').children());
    $('#salary-group').each(function() {
        var dataObject = new Object();
        console.log($(this));
        console.log($('.form-control' + i));
        $('.form-control' + i).each(function() {
            var data = $(this);
            console.log(data);
            dataObject[data.attr('name')] = data.val();
        });
        console.log(dataObject);
        list.push(dataObject);
        i++;
    });
//    list.pop();
    var formData = JSON.stringify(list);
    var loc = $('#insertSalaryForm').attr('action');
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


function callSalaryList(url, columns, ordering) {
    $("#salaryDatatables").empty();
    $('#salaryDatatables').append('<table id="salaryTable" style="width:100%"></table>');
    currTab = $('#salaryTable').DataTable({
        "dom" : '<"top"l>rt<"bottom"ip><"clear">B',
        order : ordering,
        select : true,
        ajax : {
            url : window.location.href + url,
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : columns,
        destroy : true,
        buttons: [
            {
                text: '신규 등록',
                attr: {
                    class: "btn btn-default outline-btn round set-color",
                    id: 'insertSalary'
                }
            }, {
                text: '선택 삭제',
                attr: {
                    class: "btn btn-default outline-btn round set-color",
                    id: 'deleteSalaryCode'
                }
            }, {
                text: 'PDF 출력',
                extend: 'pdfHtml5',
                attr: {
                    class: "btn btn-default outline-btn round set-color",
                },
                messageBottom: 'PDF created by PDFMake with Buttons for DataTables.'
            }
        ]
    });

    if (url == '/salaryList') {
        $('#salaryTable_length').after(
                '<div id = salaryTable_filter style="text-align: right;"></div>');
        $('#salaryTable_filter').append('<label for="searchBar">검색 : &nbsp</label>');
        $('#salaryTable_filter').append('<input type="search" class="column_filter" id="searchBar">');
        var searchDiv = $('#salaryTable_filter').find('label');
        searchDiv.before('<select id="searchsalary" style="margin-right:10px">');
        for (var i = 0; i < salaryCol.length; i++) {
            $('#searchsalary').append('<option value=' + i + '>' + salaryCol[i] + '</option>');
        }

    } else if (url == '/salaryStatistics') {
        
    }
}

$.fn.dataTable.ext.errMode = 'throw';
$('#salaryTable').ready(function() {
    $('#searchsalary').on('click', function() {
        var searchingText = $('#searchBar').val();
        currTab.search('').columns().search('').draw();
        if (this.value == 0) {
            currTab.search(searchingText).draw();
        } else {
            currTab.columns(this.value).search(searchingText).draw();
        }
    });

    $('#searchBar').on('keyup click', function() {
        var col = $('#searchsalary').val();
        currTab.search('').columns().search('').draw();
        if (col == 0) {
            currTab.search(this.value).draw();
        } else {
            currTab.columns(col).search(this.value).draw();
        }

    });
});

function searchEmployee() {
    options = '"width=100","height=100","scrollbars=no","menubar=no","status=no","titlebar=no","left=150","top=200","_blank"';
    thisLoc = window.location.href.toString() + '/searchEmployee';
    win = window.open(thisLoc, "popupWindow2", options);
}

var salaryColumns = [
    {
        'sTitle' : '<input type="checkbox">',
        data : 'id',
        render : function(data) {
            return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                    + '">';
        }
    }, {
        'sTitle' : '기본급',
        data : 'basic_pay',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '초과근무 수당',
        data : 'overtime_pay',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '성과금',
        data : 'bonus',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '식대료',
        data : 'meal_fee',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '근로 소득',
        data : 'income_tax',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '급여일',
        data : 'payday',
        render : $.fn.dataTable.render.moment()
    }, {
        'sTitle' : '월급(합계)',
        data : 'employee_salary',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '이체 현황',
        data : 'payment_status'
    }, {
        'sTitle' : '지급 대상',
        data : 'employee_id'
    }
];

salaryOrdering = [
    [
            1, 'desc'
    ]
];


var salaryStaticColumns = [
    {
        'sTitle' : '<input type="checkbox">',
        data : 'id',
        render : function(data) {
            return '<input type="checkBox" class="client_id" name="client_id" value="' + data
                    + '">';
        }
    }, {
        'sTitle' : '기본급',
        data : 'basic_pay',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '초과근무 수당',
        data : 'overtime_pay',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '성과금',
        data : 'bonus',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '식대료',
        data : 'meal_fee',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '근로 소득',
        data : 'income_tax',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '급여일',
        data : 'payday',
        render : $.fn.dataTable.render.moment()
    }, {
        'sTitle' : '월급(합계)',
        data : 'employee_salary',
        render: function(data) {
            return data.toString().replace(/(\d)(?=(\d\d\d)+$)/g, "$1,") + '원';
        }
    }, {
        'sTitle' : '이체 현황',
        data : 'payment_status'
    }, {
        'sTitle' : '지급 대상',
        data : 'employee_id'
    }
];

salaryStaticOrdering = [
    [
            1, 'desc'
    ]
];
