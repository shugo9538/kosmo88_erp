//csrf 토큰 넣기. common으로 보내기



//초기화
//warehousing
document.addEventListener("DOMContentLoaded", function () {
  // console.log(location.href.indexOf('wms/inbound/warehousing'))
  var bodyClass = document.querySelector("body").getAttribute("class");
  console.log("bodyClass : " + bodyClass);
  // if(location.href.indexOf('wms/inbound/warehousing')){
  if ((bodyClass = warehousing)) {
    var items = document.getElementsByClassName("item");
    var sections = document.getElementsByClassName("section");
    console.log(
      "items : " +
      Array.from(items)
        .map((i) => i.innerHTML)
        .toString()
    );
    console.log("sections : " + sections);
    // console.log('sections : ' + Array.from(sections).map(s=>s.innerHTML)..toString())
  }

  //재고가 있으면 해당 섹션 select 잠그기
  //가능하다면 해당 옵션을 기억해서 다른데서 제거하고싶다
  for (var section of sections) {
    console.log("?" + section.hasAttribute("selected"));
    if (section.hasAttribute("selected")) {
      console.log("section.parentElement : " + section.parentElement.nodeName);
      section.parentElement.addEventListener("focus", function () {
        this.initialSelect = this.selectedIndex;
        console.log("this.initialSelect :" + this.initialSelect);
        console.log("this.selectedIndex:" + this.selectedIndex);
      });
      section.parentElement.addEventListener("change", function () {
        this.selectedIndex = this.initialSelect;
        console.log("this.initialSelect :" + this.initialSelect);
        console.log("this.selectedIndex:" + this.selectedIndex);
      });
    }
  }


  //select 자동으로 채워넣기
  // var sections = Array.from(document.getElementById('section')).filter(e=>e.querySelector('.selected')==null);
  // console.log('length :' +sections.length)
  // console.log(sections.toString())
  // // var sections = document.querySelectorAll('#section').forEach();
  // var lastSection = sections[sections.length - 1];
  // var sectionValues = lastSection.childNodes;
  // console.log(lastSection);
  // for (var section of sections) {
  //   var sectionOptions = section.child
  //   for (var sectionValue of sectionValues) {
  //     console.log('sectionValue : ' + sectionValue.innerHTML);

  //   }
  // }



});

//자바스크립트의 this는 호출한 객체를 가리킨다? 기본 window
let dispatchWindow;
let warehouse_id;

function dispatchInbound(requestId) {
  csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
  csrfToken = $("meta[name='_csrf']").attr("content");
  
  console.log(getContextPath() + "/wms/inbound/dispatch");
  this.requestId = requestId;
  console.log("입하 지시창 오. requestId : " + requestId);
  dispatchwindow = window.open(
    getContextPath() + "/wms/inbound/dispatch?requestId=" + requestId,
    "haha",
    "width=800,height=600"
  );
}

function dispatchAction(requestId) {
  csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
  csrfToken = $("meta[name='_csrf']").attr("content");

  var select = document.getElementById("destination");
  var warehouseId = select.options[select.selectedIndex].value;

  // var url = getContextPath() + "/wms/inbound/dispatchAction?warehouse_id=" + warehouse_id
  var url = getContextPath() + "/wms/inbound/dispatchAction";
  console.log("요청 url : " + url);

  var xhr = new XMLHttpRequest();
  var query =
    // "warehouseId=" + warehouseId + "&=" + opener.requestId;
    "warehouseId=" + warehouseId + "&requestId=" + opener.requestId
  console.log("query : " + query);

  if (!xhr) {
    alert("XMLHTTP 인스턴스 생성 불가");
    return false;
  }

  xhr.onreadystatechange = alertContents(xhr);
  // xhr.open("GET", url + "?" + query, true);
   xhr.open("POST", url, true);
   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  // xhr.setRequestHeader(csrfParameter, csrfToken)
  xhr.setRequestHeader('X-XSRF-TOKEN', csrfToken)
   xhr.send(query);


  alert("입하 지시 되었습니다.\n test: " + query);
  window.close();
  opener.location.reload();
}

function alertContents(req) {
  if (req.readyState === XMLHttpRequest.DONE) {
    if (req.status === 200) {
      alert(req.responseText);
    } else {
      alert(
        "request에 문제가 있음\nreadyState : " +
        req.readyState +
        "\nstatus : " +
        req.status
      );
    }
  }
}

//warehousing에 있던거

// window.onload=function(){
// 		selTab();
// 			initDatePicker();
// 			adjustIncludedPage();
// }

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

  var pathArr = currLocation.split("/");
  var pathIndexLength = pathArr.length;
  var lastPath = pathArr[pathIndexLength - 1];
  console.log(lastPath);

  switch (lastPath) {
    case "":
    case "receivingStatus":
      //  $('#receivingStatusList').ready(function() {
      receivingStatusList();
    case "receivingHistory":
    //         $('#receivingHistoryList').ready(function() {
    //         	receivingHistoryList();
    //         });
    case "buttonAction":
  }
});

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

console.log(document);
console.log($(document));

function receivingStatusList() {
  console.log("----receivingStatusList 실행");
  $("#receivingStatusList").append('<table class="table table-hover"></table>');
  columns = [
    {
      sTitle: "#",
      data: "r_num",
      render: function (data) {
        return '<input type="checkBox" value="' + data + '">';
      },
    },
    {
      sTitle: "앗",
      data: "id",
    },
    {
      sTitle: "이것은",
      data: "attendance_cd_id",
    },
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

  url = "selectAttendacne";
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

let submitWindow;
// let warehouse_id;

function warehousing(requestId, warehouseId) {
  var url = getContextPath() + "/wms/inbound/warehousing";
  var query = "?requestId=" + requestId + "&warehouseId=" + warehouseId;
  console.log("url : " + url);
  console.log("query : " + query);

  this.requestId = requestId;
  this.warehousId = warehouseId;

  //근데 여기서 this 는 open한 window 객체인데 ,쟤한테 저 속성들이 있나???
  // console.log("입고처리 창  오픈  inboundId : " + inboundId + " warehouseId : " + warehouseId);
  submitWindow = window.open(url + query, "haha", "width=800,height=600");
}

function disableSameOption(value) { }

function warehousingAction() {
  //   var select = document.getElementById("destination");
// var itemIdArr = document.getElementsByName('itemId');   
// var quantityArr = document.getElementsByName('itemId');   
// var itemIdArr = document.getElementsByName('itemId');   

  //   var url = getContextPath() + "/wms/inbound/warehousingAction";
  //   console.log("요청 url : " + url);
  //   var req = new XMLHttpRequest();

  //   var itemIds = document.getElementsByClassName("itemId");
  //   var itemNames = document.getElementsByClassName("item");
  //   var sections = document.getElementsByName("section");

  //   var query =
  //     "warehouseId=" +
  //     warehouse_id +
  //     "&inboundId=" +
  //     opener.inboundId +
  //     "&sectionId=" +
  //     opener.sectionId;
  //   console.log("query : " + query);

  //   if (!req) {
  //     alert("XMLHTTP 인스턴스 생성 불가");
  //     return false;
  //   }

  //   req.onreadystatechange = alertContents(req);
  //   req.open("POST", url + "?" + query, true);
  //   req.send();

  alert("입고 처리되었습니다.\n");
    // window.close();
  opener.location.reload();
  
  return true;
}

function alertContents(req) {
  if (req.readyState === XMLHttpRequest.DONE) {
    if (req.status === 200) {
      alert(req.responseText);
    } else {
      alert(
        "request에 문제가 있음\nreadyState : " +
        req.readyState +
        "\nstatus : " +
        req.status
      );
    }
  }
}
