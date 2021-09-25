function addItem() {
	var item = document.getElementById("item");
	var addItemBtn = document.getElementById("addItem");
	var newItem = document.createElement("div");
	
	newItem = item.cloneNode(true);
	newItem.style.display = "block";
	document.getElementById("item-group").insertBefore(newItem, addItemBtn);
}

function delItem(obj) {
	var itemGroup = document.getElementById("item-group");
	var selectedItem = $(obj);
	var item = selectedItem.parent().parent();
	
	if (itemGroup.childElementCount < 4) {
		alert("최소 하나 이상의 상품을 등록해야 합니다.")
	} else {
		item.remove();
	}
}

$(document).ready(function() {
	$("input[name=item_name]").show().prop("required", true);
	$("input[name=category]").show().prop("required", true);
	$("input[name=price]").show().prop("required", true);
});




