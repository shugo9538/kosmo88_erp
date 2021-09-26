/**
 * 
 */


//금융-자금관리(통장->통장입출금 내역 팝업창)
function accountDetail(){
	
	const accountNum = document.getElementById("num");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/accountDetail?account_number=" + accountNum.value;
	window.open(url, "accountDetail", "menubar=no, width=1500, height=900");	
}

//재무제표(계정과목 선택시 내역 팝업창)
function accountTitleDetail(){
	
	const accountTitle = document.getElementById("accountTitle");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/accountTitleDetail?account_Name=" + accountTitle.value;
	window.open(url, "accountTitleDetail", "menubar=no, width=1000, height=600");	
}