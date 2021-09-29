/**
 * 
 */

//금융-자금관리(통장->통장입출금 내역 팝업창)
function accountDetail(){
	const accountNum = document.getElementById("account_number");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/accountDetail?account_number=" + accountNum.value;
	window.open(url, "accountDetail", "menubar=no, width=1500, height=900");	
}

//재무제표 (계정과목 선택시 내역 팝업창)

// 현금및 현금성 자산
function accountTitleDetail(){
	
	const accountTitle = document.getElementById("accountTitle");
	const rootPath = document.getElementById("root");
	
	const url = rootPath.value + "/account/accountTitleDetail?account_Name=" + accountTitle.value;
	window.open(url, "accountTitleDetail", "menubar=no, width=1000, height=600");	
}


//accountNewDetail.jsp


//-----
// namaing rule : commnd + verd : doSometing
// tyscirpt
let success ="성공 하였습니다.";
let fallier ="실패 하였습니다.";
let happy ="축하합니다.";

function log(message){
	console.log(message);
}
//log(message);

//2. Prameter
function changeName(obj){
	obj.name = 'coder';
}
const ellie = {name: 'ellie'};
//changeName(ellie);
//console.log(ellie);

//3. Default prameter (added in ES6)
//4. Rest parameters (added in ES6)