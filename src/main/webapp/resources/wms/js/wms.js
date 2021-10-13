//ajax 관련
function setPostCsrfHeader(url, query) {
  // csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
  csrfParameter = 'X-XSRF-TOKEN'
  csrfToken = $("meta[name='_csrf']").attr("content");

  url = getContextPath() + "/wms/inbound/dispatchAction";
  console.log("요청 url : " + url);

  var xhr = new XMLHttpRequest();
  console.log("query : " + query);

  if (!xhr) {
    alert("XMLHTTP 인스턴스 생성 불가");
    return false;
  }

  xhr.onreadystatechange = alertContents(xhr);
   xhr.open("POST", url, true);
   xhr.setRequestHeader('X-XSRF-TOKEN', csrfToken)
   xhr.send(query);
}




function getCurrentDate() {
  var newDate = new Date();
  var year = newDate.getFullYear().toString();
  var month = (parseInt(newDate.getMonth().toString()) + 1).toString();
  var date = newDate.getDate().toString();
  if (parseInt(month) < 10) month = "0" + month;
  if (parseInt(date) < 10) date = "0" + date;
  return month + "/" + date + "/" + year;
}


//폼 추가
document.addEventListener("DomContentLoaded", function () {
  if (document.getElementById(""))
    addSection()
})


//컨텍스트패스
function getContextPath() {
  var hostIndex = location.href.indexOf(location.host) + location.host.length;
  return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
}






function getAdditionalFormCnt() {
  return document.getElementsByClassName("additionalForm").length;
}

function setAdditionalFormNum() {
  var additionalForms = Array.from(
    document.getElementsByClassName("additionalForm")
  );
  var num = 1;
  var inputs;
  for (var f of additionalForms) {
    inputs = f.getElementsByClassName("form-control");
    for (var i of inputs) {
      i.setAttribute("name", i.getAttribute("name") + num);
    }
    num++;
    console.log("num: " + num);
  }
}


//이름이 같은 파라미터들 묶어서 보내기
//1. 같은 파라미터별로 
//2. 주제단위별로
//어차피
function sameNameValuesToArray(paramName) {
  var additionalForms = Array.from(
    document.getElementsByClassName("additionalForm")
  );
  var arr = [];
  // var section_number = [];
  // var capacity = [];
  additionalForms.forEach(f => Array.from(f.getElementsByTagName(paramName)).forEach(p => section.push(p)))
  console.log(arr);
  return arr;
}




function log() {
  console.log("sadfas");
}

function currentDate() {
  var newDate = new Date();
  var year = newDate.getFullYear().toString();
  var month = (parseInt(newDate.getMonth().toString()) + 1).toString();
  var date = newDate.getDate().toString();
  if (parseInt(month) < 10) month = "0" + month;
  if (parseInt(date) < 10) date = "0" + date;
  document.getElementById("datepicker-autoclose").value =
    month + "/" + date + "/" + year;
}

function initDatePicker() {
  var datePicker = document.getElementById("datepicker-autoclose");
  datePicker.value = getCurrentDate();
}

function initDateRange() {
  // var ranges = document.getElementById("date-range").children;
  //  Array.from(ranges).= getCurrentDate();
}


// function adjustIncludedPage() {
//   var includePages = Array.from(document.getElementsByClassName("include"));
//   console.log(includePages);
//   var includePagesHasFilter = includePages.filter(
//     (i) => i.querySelector(".filter") != null
//   );
//   console.log(includePagesHasFilter);

//   try {
//     includePages.forEach((i) => i.querySelector(".page-title-box").remove());
//     includePages.forEach((i) =>
//       i.querySelector(".main-content").setAttribute("class", "")
//     );
//     includePagesHasFilter.forEach((i) => {
//       console.log("잉" + i.nodeName);
//       i.querySelector(".filter").remove();
//     });
//   } catch (e) {
//     console.log(e);
//   }
// }


//들어가는 메뉴에 따라 다른 그거 탭하기
$(document).ready(function () {
  var tab = getParameterByName("tab");
  console.log("선택 탭 : " + tab);
  if (tab != "") {
    // var li = document.getElementById("li_" + tab);
    console.log("클릭할 탭 : " + 'tab_' + tab);
    document.getElementById("tab_" + tab).click();
  }
})

//퍼온
function getParameterByName(name) {
  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

//swal은 매개변수로 객체하나랑 리스너가 들어간다?
function success(title, text, listener) {
  swal({
    title: title,
    type: "success",
    text: text,
    timer: 2000
  },
    listener
    // function () {
    //   location.reload();
    // }
  )

}

function error(title, text, listener) {
  swal({
    title: title,
    type: "error",
    text: text,
    timer: 2000
  },
    listener
    // function () {
    //   location.reload();
    // }
  )
}


function addAction() {
  //  swal({
  //     title: title,
  //     type: "error",
  //     text: text ,
  //     timer: 2000
  //   }, 
  //  function(){
  //    return false;
  //  }
  //   )
  alert('등록되었습니다');
  return true;

}

function cloneForm() {
  var sectionForm = document.getElementById('sectionForm');
  console.log(sectionForm);
  // var addSectionBtn = document.getElementById("addSection");
  var newSection = sectionForm.cloneNode(true);
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

function removeNode(obj) {
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


//
// function success(){swal('성공', '', '', 1500); location.reload()}