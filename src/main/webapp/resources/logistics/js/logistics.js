
function addRack(){
	
var newRack = document.createElement('div');
var addRackBtn = document.getElementById("addRack")
newRack.setAttribute("class", "rack");
newRack.innerHTML = "<div class='form-group'>" 
					+"<label class='col-md-2 control-label'>랙 이름</label>"
					+"<div class='col-md-4'>"
						+"<input class='form-control' value='Some text value...'"
							+"type='text'>"
					+"</div>"
				+"</div>"
				+"<div class='form-group'>"
					+"<label class='col-md-2 control-label'>Text</label>"
					+"<div class='col-md-4'>"
						+"<input class='form-control' value='Some text value...'"
							+"type='text'>"
					+"</div>"
					+"<label class='col-md-2 control-label'>Text</label>"
					+"<div class='col-md-4'>"
						+"<input class='form-control' value='Some text value...'"
							+"type='text'>"
					+"</div>"
				+"</div>"
				+"<div class='form-group'></div>";
	document.getElementById("rack-group").insertBefore(newRack, addRackBtn);
}

function warehouseAddAction(){
	alert("등록되었습니다");
	// location.href="${ROOT_PATH}/warehouse/addAction";
	window.location="logistics_erp/warehouse/addAction";
}