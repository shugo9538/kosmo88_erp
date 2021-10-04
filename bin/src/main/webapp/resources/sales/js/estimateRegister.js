// 거래처 상품(숨겨진것) disabled
$(document).ready(function() {
	$("input[name=item_name]:hidden").each(function(){
		$(this).prop("disabled", true);
	})
	
	$("input[name=category]:hidden").each(function(){
		$(this).prop("disabled", true);
	})
	
	$("input[name=price]:hidden").each(function(){
		$(this).prop("disabled", true);
	})
	
	
	// 거래처 선택
	$("#selectClient").click(function(){
		
		var url = "/logistics_erp/sales/selectClient"
		window.open(url, "select", "menubar=no, width=1200, height=700");
		
	});
	
	// 거래처 선택
	$("#selectEmployee").click(function(){
		
		var url = "/logistics_erp/sales/selectEmployee"
		window.open(url, "select", "menubar=no, width=1200, height=700");
		
	});
	
});



$('#clientManagementForm').ready(function(){
	addItem();
});

var i = 0;

// 거래처 상품 등록 추가
function addItem() {
	var item = document.getElementById("item");
	var addItemBtn = document.getElementById("addItem");
	var newItem = document.createElement("tr");
	
	newItem = item.cloneNode(true);
	newItem.removeAttribute("style");
	
	
	tmp = newItem.getElementsByTagName('input');
	for (var j = 0 ; j < tmp.length ; j++) { 
		tmp[j].className = "form-control"+i;
	}
	
	Array.from(newItem.getElementsByClassName("form-control" + i)).forEach(f => f.removeAttribute("disabled"));
    Array.from(newItem.getElementsByClassName("form-control" + i)).forEach((f) =>
        f.setAttribute("required", true));
  
	document.getElementById("item-group").appendChild(newItem);
	i++;
}

// 거래처 상품 삭제
function delItem(obj) {
	var itemGroup = document.getElementById("item-group");
	var selectedItem = $(obj);
	var item = selectedItem.parent().parent();
	
	if (itemGroup.childElementCount < 3) {
		alert("최소 하나 이상의 상품을 등록해야 합니다.")
	} else {
		item.remove();
	}
}

// 입력 후 커서 이동
function nextRegisterNum1(){
	if(document.clientRegisterForm.register_num1.value.length >= 3){
		document.clientRegisterForm.register_num2.focus();
	}
}
function nextRegisterNum2(){
	if(document.clientRegisterForm.register_num2.value.length >= 2){
		document.clientRegisterForm.register_num3.focus();
	}
}
function nextRegisterNum3(){
	if(document.clientRegisterForm.register_num3.value.length >= 5){
		document.clientRegisterForm.email1.focus();
	}
}

function nextPhone1() {
	if(document.clientRegisterForm.phone1.value.length >= 3) {
		document.clientRegisterForm.phone2.focus();
	}
}

function nextPhone2() {
	if(document.clientRegisterForm.phone2.value.length >= 4) {
		document.clientRegisterForm.phone3.focus();
	}
}

function nextPhone3() {
	if(document.clientRegisterForm.phone3.value.length >= 4) {
		document.clientRegisterForm.zip_code.focus();
	}
}



