//====== 랙등록

let submitWindow;
// let warehouse_id;

function addSection(inboundId, warehouseId) {
    var url = getContextPath() + "/wms/warehouse/addSection";
    var query = "?sectionId=" + sectionId + "&warehouseId=" + warehouseId;
    console.log("url : " + url);
    console.log("query : " + query)

    this.inboundId = inboundId;
    this.warehousId = warehouseId;

    //근데 여기서 this 는 open한 window 객체인데 ,쟤한테 저 속성들이 있나???
    // console.log("입고처리 창  오픈  inboundId : " + inboundId + " warehouseId : " + warehouseId);
    submitWindow = window.open(url + query, "haha", "width=800,height=600");
}

//=================
// function addAction() {
//     success('성공', '등록되었습니다', function(){return true;})
//   swal("성공", "등록되었습니다", 'success', 1500);

//   return true;
// }

function addWarehouseAction() {
    success('성공', '등록되었습니다', function () { return true })
    //   swal("성공", "등록되었습니다", 'success', 1500);

    //   return true;
}


function addSectionAction() {
    swal("성공", "등록되었습니다", 'success', 1500);
    // sameNameValuesToArray(section);
    //sameNameValuesToArray(section_section);
    //sameNameValuesToArray(capacity);

    return true;
}


var csrfData = {};
var currTab;
var csrfParameter;
var csrfToken;

// document.addEventListener("DOMContentLoaded, function(){"
$(document).ready(function () {
    //csrf 토큰값 받아오기?
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");

    //현재 url에서 명령어 구하기
    var currLocation = window.location.href;
    console.log("currLocation : " + currLocation);

    csrfData[csrfParameter] = csrfToken;

    var pathArr = currLocation.split('/');
    var pathIndexLength = pathArr.length;
    var lastPath = pathArr[pathIndexLength - 1];
    console.log(lastPath)

    switch (lastPath) {
        case "":
        case "warehouse":
            //  $('#receivingStatusList').ready(function() {
            receivingStatusList(); break;
        case "info":
            break;
    }
})




function cloneSection() {
    var sectionForm = document.getElementById("sectionForm");
    var newSection = sectionForm.cloneNode(true);
    var sectionList = document.getElementsByName('section');
    var lastSection = sectionList.item(sectionList.length - 1).getAttribute('value');
    console.log("lastSection : " + lastSection)
    // console.log(newSection.getElementsByClassName('form-control'));
    newSection_section = getNewSection(lastSection);
    console.log("nss: " + newSection_section)
    newSection.getElementsByClassName('form-control').item(0).setAttribute("value", newSection_section);

    newSection.style.display = "block";
    newSection.setAttribute("class", "additionalForm");
    Array.from(newSection.getElementsByClassName("form-control")).forEach((f) =>
        f.removeAttribute("disabled")
    );
    Array.from(newSection.getElementsByClassName("form-control")).forEach((f) =>
        f.setAttribute("required", true)
    );
    // document.getElementById("rack-group").insertBefore(newRack, addSectionBtn);
    document.getElementById("section-group").appendChild(newSection);
    document
        .getElementById("additionalFormCnt")
        .setAttribute("value", getAdditionalFormCnt());
}
// window.onload = addSection();

function getNewSection(lastSection) {
    var newSection;
    var length = lastSection.length;
    console.log('length : ' + length);
    var firstDigit;
    var secondDigit;
    var lastSectionCharArr;
    if (length == 1) {
        if (lastSection != 'Z')
            newSection = String.fromCharCode(lastSection.charCodeAt(0) + 1);
        else if (lastSection == 'Z')
            newSection = 'AA';
    }
    else if (length == 2) {
        // lastSectionCharArr = lastSection.split();
        // firstDigit = lastSectionCharArr[0];
        // secondDigit = lastSectionCharArr[1];
        firstDigit = String.fromCharCode(lastSection.charCodeAt(0));
        secondDigit = String.fromCharCode(lastSection.charCodeAt(1));
        console.log("firstDigit : " + firstDigit + " secondDigit : " + secondDigit)
        if (secondDigit != 'Z')
            secondDigit = String.fromCharCode(secondDigit.charCodeAt(0) + 1);
        else if (secondDigit == 'Z') {
            secondDigit = 'A';
            firstDigit = String.fromCharCode(firstDigit.charCodeAt(0) + 1);
        }
        newSection = firstDigit + secondDigit;
    }
    console.log("newSection : " + newSection)
    return newSection
}




function removeSection(obj) {
    var sectionGroup = document.getElementById("section-group");
    if (document.getElementsByClassName("additionalForm").length < 2) {
        alert("최소 하나 이상의 랙은 등록해야 합니다.");
    } else {
        obj.parentElement.parentElement.remove();
        document
            .getElementById("additionalFormCnt")
            .setAttribute("value", getAdditionalFormCnt());
    }
}


// 	}
// 	// '#clientRegisterAction', 버튼 id
// 	$('#white-box').on('click', '#clientRegisterAction', function() {
// 	    var loc = $('#clientRegisterForm').attr('action');
// 	    /*
// 	     * 1. 거래처 등록 {id:'id', type:'type', name:'name' ... }
// 	     * */
// 	    // $(form id tr id)
// 	    var dataObject = new Object();
// 	    $('#client').find('input').each(function() {
//     		var data = $(this);
//     		dataObject[data.attr('name')] = data.val();
// 	    });
// 	    console.log(dataObject);

// 	    var formData = JSON.stringify(dataObject);

// 	    $.ajax({
// 	        type : 'POST',
// 	        url : loc + '?' + csrfParameter + '=' + csrfToken,
// 	        data : formData,
// 	        accept : "application/json",
// 	        contentType : "application/json; charset=utf-8",
// 	        dataType : 'text',
// 	        beforeSend : function(xhr) {
// 	            xhr.setRequestHeader(csrfParameter, csrfToken);
// 	        },
// 	        success : function(data) {

// 	        },
// 	        error : function() {
// 	            alert('오류');
// 	        },
// 	    });

// 	    var list = new Array();
// 	    var i = 0;

// 	    // 2.상품
// 	    $('#clientRegisterForm #item-group').each(function() {
// 	    	var dataObject = new Object();
// 	    	$('.form-control').each(function() {
// 	    		var data = $(this);
// 	    		var name = data.attr('name');
// 	    		if (name == 'item_name') name = 'name';
// 	    		dataObject[name] = data.val();
// 	    	});
// 	    	console.log(dataObject);
// 	    	list.push(dataObject);
// 	    	i++
// 	    });
// 	    list.pop();

// 	    formData = JSON.stringify(list);
// 	    // alert(formData);

// 	    console.log(formData);
// 	    loc = window.location.href + '/itemRegisterAction';

// 	    $.ajax({
// 	        type : 'POST',
// 	        url : loc + '?' + csrfParameter + '=' + csrfToken,
// 	        data : formData,
// 	        accept : "application/json",
// 	        contentType : "application/json; charset=utf-8",
// 	        dataType : 'text',
// 	        beforeSend : function(xhr) {
// 	            xhr.setRequestHeader(csrfParameter, csrfToken);
// 	        },
// 	        success : function(data) {
// 	            if (data) {
// 	            	alert('거래처가 등록되었습니다.');
// 	            	$('.form-control').each(function() {
// 	            		$(this).val('');
// 	            	});
// 	            	currTab.ajax.reload();
// 	            }
// 	        },
// 	        error : function() {
// 	            alert('오류');
// 	        },
// 	    });
// 	});  
// });



function receivingStatusList() {
    console.log("----receivingStatusList 실행")
    $('#receivingStatusList').append('<table class="table table-hover"></table>');
    columns = [
        {
            'sTitle': '#',
            data: 'r_num',
            render: function (data) {
                return '<input type="checkBox" value="' + data + '">';
            }
        }, {
            'sTitle': '앗',
            data: 'id'
        }, {
            'sTitle': '이것은',
            data: 'attendance_cd_id'
        }
        // , 
        // {
        //     'sTitle' : '근태 신청일',
        //     data : 'application_date',
        //     render : $.fn.dataTable.render.moment()
        // }, {
        //     'sTitle' : '시작',
        //     data : 'begin_date',
        //     render : $.fn.dataTable.render.moment()
        // }, {
        //     'sTitle' : '종료',
        //     data : 'end_date',
        //     render : $.fn.dataTable.render.moment()
        // }, {
        //     'sTitle' : '사유',
        //     data : 'reason'
        // }, {
        //     'sTitle' : '상태',
        //     data : 'state'
        // }
    ];

    url = 'selectAttendacne';
    // callList(url, columns);
}



// 거래처(구매처) 목록
// function receivingHistoryList() {
// 	currTab = $('#clientList').DataTable({
// 		"order": [[1, "desc"]],
// 		ajax: {
// 			url: window.location.href + '/clientList', // 현 위치
// 			// + 요청
// 			// url 로
// 			// div별로 결과물 뿌리기 위해
// 			// 이렇게 작성함
// 			type: 'POST',
// 			data: csrfData,
// 			dataSrc: ''
// 		},
// 		columns: [
// 			{
// 				data: 'id',
// 				render: function (data) {
// 					return '<input type="checkBox" class="client_id" name="client_id" value="' + data + '">';
// 				}
// 			}, {
// 				data: 'id',
// 			}, {
// 				data: null,
// 				render: function (data, type, row, meta) {
// 					return '<a href="/logistics_erp/purchase/clientDetail?id=' + row.id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.name + '</a>';
// 				}
// 			}, {
// 				data: 'register_num',
// 			}, {
// 				data: 'ceo_name',
// 			}, {
// 				data: 'phone',
// 			}, {
// 				data: 'address',
// 			}, {
// 				data: 'register_date',
// 				render: $.fn.dataTable.render.moment()
// 			}
// 		],
// 		destroy: true,
// 		retrieve: true
// 	});

// 	currTab.on('draw', function () {
// 		// 개별 체크박스 클릭
// 		$(".client_id").click(function () {
// 			var totalCnt = currTab.page.info().length;  // 화면에 보이는 체크박스 전체 개수
// 			var checkedCnt = $("input[name=client_id]:checked").length;  // 화면에 보이는 체크된 체크박스 개수

// 			// 두 수량이 다르면
// 			if (totalCnt != checkedCnt) {
// 				// 전체 체크박스 false
// 				$("#checkAll").prop("checked", false);

// 				// 두 수량이 같으면	
// 			} else {
// 				// 전체 체크박스 true
// 				$("#checkAll").prop("checked", true);
// 			}
// 		});

// 		// 거래처 삭제(선택삭제)
// 		$(".col-md-2").on("click", "#clientChoiceDeleteBtn", function () {
// 			var check = $("input:checkbox[name=client_id]:checked").length;

// 			if (check == 0) {
// 				alert("삭제할 거래처를 선택해주세요!!");
// 				return false;
// 			} else {

// 				var result = confirm("선택한 거래처를 삭제하시겠습니까?");

// 				if (result) {
// 					clientChoiceDelete(csrfParameter, csrfToken);
// 				} else {
// 					return false;
// 				}
// 			}
// 		});
// 	});
// }


//문서 로딩과 함께 넘겨받은 값으로 탭 선택하기
//처음 메뉴로 들어갈 때만 발동하기를 원하지만 메뉴 내에서 또 쿼리를 보냈을 때 작동 여부는 보장할 수 없을 듯 하다
