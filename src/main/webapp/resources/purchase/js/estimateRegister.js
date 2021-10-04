// 견적서 상품(숨겨진것) disabled
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
	$("#selectClient").click(function() {
		
		var url = "/logistics_erp/purchase/selectClient"
		window.open(url, "selectClient", "menubar=no, width=1500, height=700");
	});
	
	// 거래처 값 전달
	$(".select").click(function() {
		var par = $(this).attr('name');
		var client = {};
		client[c_id] = $('input[name=c_id]').val();
		$("#name", opener.document).val("#c_name".val);
	})
	
	// 담당자 선택
	$("#selectEmployee").click(function(){
		var url = "/logistics_erp/purchase/selectEmployee"
		window.open(url, "selectEmployee", "menubar=no, width=1500, height=700");
	});
});


$('#estimateManagementForm').ready(function(){
	addItem();
});

var i = 0;

// 견적서 상품 등록 추가
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

// 견적서 상품 삭제
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






