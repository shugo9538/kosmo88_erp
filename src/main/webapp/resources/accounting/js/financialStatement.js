/**
 * 
 */

//-------------------------------- accountList.jsp --------------------------------
//재무제표 (계정과목 선택시 내역 팝업창)

// 현금및 현금성 자산
function accountTitleDetail(){
	
	const accountTitle = document.getElementById("accountTitle");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/accountTitleDetail?account_Name=" + accountTitle.value;
	window.open(url, "accountTitleDetail", "menubar=no, width=1000, height=600");	
}

//------------------------------------------------------------------------------------------------