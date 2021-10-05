//자바스크립트의 this는 호출한 객체를 가리킨다? 기본 window
let dispatchWindow;
let warehouse_id;

function dispatchInbound(inbound_id) {
	console.log(getContextPath() + "/wms/inbound/dispatch");
	this.inbound_id = inbound_id;
	console.log("입하 지시창 열기. inbound_id : " + inbound_id);
	dispatchwindow = window.open(getContextPath() + "/wms/inbound/dispatch", "haha", "width=800,height=600");
}

function dispatchAction() {
	var select = document.getElementById("destination");
	var warehouse_id = select.options[select.selectedIndex].value;
	console.log("inbound_id : " + opener.inbound_id)
	console.log("warehouse_id : " + warehouse_id)
	
	alert("입하 지시 처리되었습니다.\n test: inbound_id : " + opener.inbound_id +" warehouse_id : " + warehouse_id)
	
	// var url = getContextPath + "/wms/inbound/dispatchAction?warehouse_id=" + warehouse_id;
	var url = getContextPath + "/wms/inbound/dispatchAction";
	const request = new XMLHttpRequest();
	request.open('get', url);
	request.send('warehouse_id=' + warehouse_id + "&inbound_id="+opener.inbound_id);
	window.close();
}





function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};