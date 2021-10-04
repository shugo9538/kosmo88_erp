/**
 * 
 */

const rootPath = document.getElementById("root"); // 패키지 경로
let checkedNum; // 체크박스 값 (계좌번호)
//-------------------------------- accountList.jsp --------------------------------
//금융-자금관리(통장->통장입출금 내역 팝업창) 
function accountDetail(account_number){
	// 배열생성
	var arr = new Array();
	
	//const rootPath = document.getElementById("root");
	var number = document.getElementsByName("account_number");
	
	for(var i =0; i<number.length; i++){
		arr.push(number[i].value);
		console.log(arr[i]);
	}
				// accountDetail.jsp 이동
	const url = rootPath.value + "/account/accountDetail?account_number=" + account_number;
	window.open(url, "accountDetail", "menubar=no, width=1500, height=800");	
	return false;
}

//금융-자금관리 (체크박스 값을 가지고)
function checkbox_accountNum(element){
	
	var number = document.getElementsByName("check_accountNum");
	
	number.forEach((cb) => { cb.checked = false; }) //모든 체크박스 체크해제
	element.checked = true; //파라미터로 전달받은 값의 체크박스만 체크되도록
	
	console.log("element.value : " + element.value);
	console.log("==========================");
	
	//document.getElementById('result').innerText = element.value;
	checkedNum = element.value;
}

// 통장리스트에서 accountList.jsp -> 정보수정 페이지로 이동 accountModifyDetail.jsp
function accountModifyDetail(){
	
	if (checkedNum == undefined){
		alert("미사용 하실 계좌를 선택 바랍니다..");
		return false;
	}
	
	//const url = rootPath.value + "/account/accountModifyDetail?account_number=" + checkedNum;
	//window.open(url, "accountModifyDetail", "menubar=no, width=800, height=900");	
	location.href=rootPath.value + "/account/accountEnabledAction?account_number=" + checkedNum;
	return false;
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