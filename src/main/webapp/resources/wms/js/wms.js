function addRack() {
	var rack = document.getElementById("rack");
	//   var lastLack = document.getElementById("rack-group").lastChild.get
	var addRackBtn = document.getElementById("addRack");
	var newRack = document.createElement("div");
	//   newRack.setAttribute("class", "rack");
	newRack = rack.cloneNode(true);
	newRack.style.display = "block";
	document.getElementById("rack-group").insertBefore(newRack, addRackBtn);
}
// window.onload = addRack();

function delRack(obj) {
	var rackGroup = document.getElementById("rack-group");
	var selectedRack = $(obj);
	//   selectedRack.parents("#rack").remove();
	var rack = selectedRack.parent().parent();

	console.log(rackGroup.childElementCount)
	console.log(rackGroup.children)
	if (rackGroup.childElementCount < 4) {
		alert("최소 하나 이상의 랙은 등록해야 합니다.")
	} else {
		rack.remove();
	}
}

function warehouseAddAction() {
	alert("등록되었습니다");
	// location.href="${ROOT_PATH}/warehouse/addAction";
	window.location = "logistics_erp/warehouse/addAction";
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
	$('#firstTab').click();
	// document.getElementById('firstTab').click();
	// document.getElementById('firstli').click();
}

function log(){
	console.log('sadfas');
}