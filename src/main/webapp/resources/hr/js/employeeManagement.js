var currTab;
var csrfData = {};
var csrfParameter;
var csrfToken;
var preventMultiFlag = false;
var employeeCol = [
        '전체 항목', '인사 코드', '코드 명칭', '코드 그룹', '코드 그룹 명칭'
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
var configTab = '#selectEmployee';
$(document).on("click", configTab, function() {
    $(this).parent().parent().find('li').removeClass('active');
    $(this).parent().addClass('active').addClass('nav-hover');
    url = '/' + $(this).attr('id');

    columns = employeeColumns;
    ordering = employeeOrder;

    callEmployeeList(url, columns, ordering);
});

function setImage(event) { 
    item = document.getElementById('img');
    if(item != null) {
        item.parentNode.removeChild(item);
    }
    
    for (var image of event.target.files) { 
        var reader = new FileReader(); 
        reader.onload = function(event) { 
            var img = document.createElement("img"); 
            img.setAttribute("src", event.target.result);
            img.setAttribute("id", "img"); 
            document.querySelector("div#temp_image").appendChild(img); 
        };         
        reader.readAsDataURL(image); 
    } 
}


// 테이블 호출
function callEmployeeList(url, columns, ordering) {
    $("#employeeDatatables").empty();
    $('#employeeDatatables').append('<table id="employeeTable" class="display table dataTable" style="width:100%"></table>');
    console.log(window.location.href + url);
    currTab = $('#employeeTable').DataTable({
        "dom" : '<"top"l>rt<"bottom"ip><"clear">B',
        order : ordering,
        select : true,
        ajax : {
            url : window.location.href + url,
            type : 'POST',
            data : csrfData,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",  
            dataSrc : ''
        },
        columns : columns,
        destroy : true,
        buttons: [
            {
                text: '사원 등록',
                attr: {
                    class: "btn btn-default outline-btn round set-color",
                    id: 'insertEmployee'
                }
            }, {
                text: '선택 삭제',
                attr: {
                    class: "btn btn-default outline-btn round set-color",
                    id: 'deleteEmployeeCode'
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
    
    currTab.on( 'xhr', function () {
        var json = currTab.ajax.json();
        $(json).each(function() {
            console.log($(this)[0].id);
        });
        
    } );

    $('#employeeTable_length').after(
            '<div id = employeeTable_filter style="text-align: right;"></div>');
    $('#employeeTable_filter').append('<label for="searchBar">검색 : &nbsp</label>');
    $('#employeeTable_filter').append('<input type="search" class="column_filter" id="searchBar">');

    var searchDiv = $('#employeeTable_filter').find('label');
    searchDiv.before('<select id="searchHRCode" style="margin-right:10px">');
    for (var i = 0; i < employeeCol.length; i++) {
        $('#searchHRCode').append('<option value=' + i + '>' + employeeCol[i] + '</option>');
    }

    currTab.on('click', 'tr', function(e, dt, type, indexes) {
        console.log(currTab.row(this).data().address);
        $(this).dblclick(function() {
            td = $(this).children();
            loc = window.location.href + '/' + td.eq(1).text();
            console.log(td);
            var options = "width=1000,height=600,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200";
            
            win = window.open(loc, "popupWindow", options);
            
            var timer = setInterval(function() {
                if (win.closed) {
                    clearInterval(timer);
                    currTab.ajax.reload();
                }
            }, 1000);
        });
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

$("#updateEmployee").on('click', function() {
   window.location = window.location.href + '/updatesEmployee';
});

$('#pdfmake').on('click', function() {
    html2canvas($('#white-box')[0]).then(function(canvas) {
        var imgData = canvas.toDataURL('image/png');
        
        var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
        var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
        var imgHeight = canvas.height * imgWidth / canvas.width;
        var heightLeft = imgHeight;
        var position = 0;
        
        var doc = new jsPDF('p', 'mm', 'a4'); // jspdf객체 생성
        
        var imgData = canvas.toDataURL('image/png'); 
        doc.addImage(imgData, "PNG", 0, position, imgWidth, imgHeight);
        doc.save('재직증명서.pdf'); // pdf저장
      });
});

$("#signIn").on('click', function() {
    window.location = window.location.href + '/signIn';
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
            'sTitle' : '전화번호',
            data : 'phone'
        }, {
            'sTitle' : '이메일',
            data : 'email'
        }, {
            'sTitle' : '입사일',
            data : 'hire_date',
        }, {
            'sTitle' : '부서 코드',
            data : 'department_name'
        }, {
            'sTitle' : '직급명',
            data : 'position_name'
        }
];

var employeeOrder = [
        [
                1, 'desc'
// ], [
// 9, 'desc'
// ], [
// 10, 'desc'
        ]
];