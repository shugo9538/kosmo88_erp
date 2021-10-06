//자바스크립트의 this는 호출한 객체를 가리킨다? 기본 window
let dispatchWindow;
let warehouse_id;

function dispatchInbound(purchase_id) {
	console.log(getContextPath() + "/wms/inbound/dispatch");
	this.purchase_id = purchase_id;
	console.log("입하 지시창 오. purchase_id : " + purchase_id);
	dispatchwindow = window.open(getContextPath() + "/wms/inbound/dispatch?purchase_id="+purchase_id, "haha", "width=800,height=600");
}




function dispatchAction() {
	var select = document.getElementById("destination");
	var warehouse_id = select.options[select.selectedIndex].value;

	// alert("입하 지시 처리되었습니다.\n test: inbound_id : " + opener.inbound_id + " warehouse_id : " + warehouse_id)

	// var url = getContextPath() + "/wms/inbound/dispatchAction?warehouse_id=" + warehouse_id
	var url = getContextPath() + "/wms/inbound/dispatchAction";
	console.log("요청 url : " + url);


	var req = new XMLHttpRequest();
	var query = 'warehouse_id=' + warehouse_id + "&purchase_id=" + opener.purchase_id;	
	console.log("query : " + query);

	if (!req) {
		alert('XMLHTTP 인스턴스 생성 불가');
		return false;
	}

	req.onreadystatechange = alertContents(req);
	req.open('GET', url + "?" + query, true);
	req.send();

	alert("입하 지시 처리되었습니다.\n test: " + query);

	window.close();
}


function alertContents(req) {
	if (req.readyState === XMLHttpRequest.DONE) {
		if (req.status === 200) {
			alert(req.responseText);
		} else {
			alert('request에 문제가 있음\nreadyState : ' + req.readyState + "\nstatus : " + req.status);
		}
	}

}



function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};