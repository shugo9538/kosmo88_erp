/**
 * 
 */

// -------------------------------- accountNewDetail.jsp --------------------------------
// 계좌등록 페이지 포커스 설정
function accountFocus() {
	document.account_new_from.name.focus();
}

// 계좌추가 이력 유효성 체크
function accountCheck() {

	// 계좌소유주 선택
	if (document.account_new_from.account_holder_id.value == 0) {
		alert("소유주를 선택하세요");
		document.account_new_from.account_holder_id.focus();
		return false;
		// 계좌은행 선택
	} else if (document.account_new_from.bank.value == 0) {
		alert("계좌은행을 선택하세요");
		document.account_new_from.bank.focus();
		return false;
		// 계좌별칭 선택
	} else if (!document.account_new_from.name.value) {
		alert("계좌별칭을 입력하세요");
		document.account_new_from.name.focus();
		return false;
		// 계좌번호를 입력하세요
	} else if (!document.account_new_from.account_number.value) {
		alert("계좌번호 입력 하세요");
		document.account_new_from.account_number.focus();
		return false;
		// 계좌번호 중복확인 체크accountNumberCheck
	} else if (document.account_new_from.accountNumberCheck.value == 0) {
		alert("계좌번호 중복 확인을 해주세요");
		document.account_new_from.accountNumChk.focus();
		return false;
		// 기초잔액 체크 0이하 또는 문자열 x
	} else if (!document.account_new_from.balance.value) {
		alert("기초잔액을 0 또는 0 이상입력 하세요");
		document.account_new_from.balance.focus();
		return false;
	}// 입력사항을 확인 후 체크 박스 선택
	else if (!document.account_new_from.inputChk.checked) {
		alert("입력 사항을 다시 한번 확인 후 체크를 하시기 바랍니다.");
		document.account_new_from.inputChk.focus();
		return false;
	}
}


//-------------------------------- accountNumberCheck.jsp --------------------------------
// 계좌번호 중복확인 팝업창
function accountChk() {

	if (!document.account_new_from.account_number.value) {
		alert("계좌번호 입력 후 중복확인 바랍니다.");
		document.account_new_from.account_number.focus();
		return false;
	} else {
		const account_number = document.getElementById("account_number");
		const rootPath = document.getElementById("root");

		console.log("account_number : " + account_number.value);

		const url = rootPath.value
				+ "/account/accountNumberCheck?account_number="	+ account_number.value;
		window.open(url, "accountNumberCheck", "menubar=no, width=500, height=550");
		return false;
	}
}
//계좌번호확인 팝업창 - 포커스
function accountNumberCheckFocus() {
	document.accountChkFrom.account_number.focus();
}
//팝업창에 입력한 값을 전달
//opener : window객체 open() 메서드로 열린 새창(=중복확인창)에서 부모창(=회원가입)에 접근할때사용
function settingAccountNum(account_number){
	opener.document.account_new_from.account_number.value = account_number;
	opener.document.account_new_from.accountNumberCheck.value = "1"; //중복확인 완료
	self.close();
}


//-------------------------------- accountModifyDetail.jsp --------------------------------

