/**
 * 
 */
//-------------------------------- accountList.jsp --------------------------------
//금융-자금관리(통장->통장입출금 내역 팝업창)
function accountDetail(account_number){
	// 배열생성
	var arr = new Array();
	
	const rootPath = document.getElementById("root");
	var number = document.getElementsByName("account_number");
	console.log("계좌번호getElementsByName : " + number.value);
	console.log("계좌번호getElementsByName[0] : " + number[0].value);
	console.log("계좌번호getElementsByName[1] : " + number[1].value);
	console.log("계좌번호getElementsByName 길이 : " + number.length);
	
	for(var i =0; i<number.length; i++){
		arr.push(number[i].value);
		console.log(arr[i]);
	}
	
	const url = rootPath.value + "/account/accountDetail?account_number=" + account_number;
	window.open(url, "accountDetail", "menubar=no, width=1500, height=900");	
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