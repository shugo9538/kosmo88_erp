function getCurrentDate() {
  var newDate = new Date();
  var year = newDate.getFullYear().toString();
  var month = (parseInt(newDate.getMonth().toString()) + 1).toString();
  var date = newDate.getDate().toString();
  if (parseInt(month) < 10) month = "0" + month;
  if (parseInt(date) < 10) date = "0" + date;
  return month + "/" + date + "/" + year;
}

function addRack() {
  var rack = document.getElementById("rack");
  // var addRackBtn = document.getElementById("addRack");
  var newRack = rack.cloneNode(true);
  newRack.style.display = "block";
  newRack.setAttribute("class", "additionalForm");
  Array.from(newRack.getElementsByClassName("form-control")).forEach((f) =>
    f.removeAttribute("disabled")
  );
  Array.from(newRack.getElementsByClassName("form-control")).forEach((f) =>
    f.setAttribute("required", true)
  );
  // document.getElementById("rack-group").insertBefore(newRack, addRackBtn);
  document.getElementById("rack-group").appendChild(newRack);
  document
    .getElementById("additionalFormCnt")
    .setAttribute("value", getAdditionalFormCnt());
}
// window.onload = addRack();

function delRack(obj) {
  var rackGroup = document.getElementById("rack-group");
  if (document.getElementsByClassName("additionalForm").length < 2) {
    alert("최소 하나 이상의 랙은 등록해야 합니다.");
  } else {
    obj.parentElement.parentElement.remove();
    document
      .getElementById("additionalFormCnt")
      .setAttribute("value", getAdditionalFormCnt());
  }
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

function warehouseAddAction() {
  alert("등록되었습니다");
  return true;
}

// function selTab(tab) {
// 	var tab = $(tab);
// 	tab.click();
// 	console.log("dkdkdd");
// 	console.log(tab);

// 	$('#firstTab').click();
// 	document.getElementById('firstTab').click();
// 	document.getElementById('firstli').click();
// }
function selTab() {
  $("#firstTab").click();
  // document.getElementById('firstTab').click();
  // document.getElementById('firstli').click();
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

function adjustIncludedPage() {
  // var includePages = document.querySelectorAll(".include");
  var includePages = Array.from(document.getElementsByClassName("include"));
  console.log(includePages);
  // var includePagesHasFilter = Array.from(includePages).filter(i=>i.querySelector(".filter")!=null);
  var includePagesHasFilter = includePages.filter(
    (i) => i.querySelector(".filter") != null
  );
  console.log(includePagesHasFilter);

  try {
    includePages.forEach((i) => i.querySelector(".page-title-box").remove());
    includePages.forEach((i) =>
      i.querySelector(".main-content").setAttribute("class", "")
    );
    includePagesHasFilter.forEach((i) => {
      console.log("잉" + i.nodeName);
      i.querySelector(".filter").remove();
    });
  } catch (e) {
    console.log(e);
  }
  //  includePages.forEach(i=>i.querySelector(".page-title-box").remove());
  //  includePages.forEach(i=>i.querySelector(".main-content").setAttribute("class", ""));
}
