/**
 * 
 */

//-------------------------------- accountList.jsp --------------------------------
//재무제표 (계정과목 선택시 내역 팝업창)

//매출 채권
function sales(){
	
	const salesCost = document.getElementById("sales");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/sales?account_Name=" + sales.value;
	window.open(url, "salesCost", "menubar=no, width=1600, height=1200");	
}

//매출 채권
function ddd(){
	
	const sales = document.getElementById("sales");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/sales?sales=" + sales.value;
	window.open(url, "sales", "menubar=no, width=1200, height=800");	
}

//------------------------------------------------------------------------------------------------
