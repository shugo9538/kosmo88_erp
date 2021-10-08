/**
 * 
 */

// 계좌등록 페이지 포커스 설정
function accountSimplFocus() {
	document.account_simple_from.abs.focus();
}

function abs(){
	swal("되라좀");
}

// 계좌추가 이력 유효성 체크
function accountSimpleCheck() {

	// 계좌소유주 선택
	if (! document.account_simple_from.transaction_date.value) {
		swal("거래일자"," 거래일자를 선택 해주시기 바랍니다.","info");
		return false;
		
		// 계좌은행 선택
	} else if (document.account_simple_from.account_number.value == 0) {
		swal("계좌은행","은행 선택을 바랍니다.","info");
		document.account_simple_from.account_number.focus();
		return false;
		
		// 적요
	} else if (!document.account_simple_from.abs.value) {
		swal("거래내용","입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.","info");
		document.account_simple_from.abs.focus();
		return false;
		
		// 유형
	} else if (document.account_simple_from.type.value == 0) {
		swal("거래유형","입금 또는 출금을 선택 바랍니다.","info");
		document.account_simple_from.type.focus();
		return false;
		
	}// 입력사항을 확인 후 체크 박스 선택
	else if (! document.account_simple_from.balance.value || document.account_simple_from.balance.value < 0) {
		swal("기초잔액","0 또는 0 이상입력 하세요.","info");
		document.account_simple_from.balance.focus();
		return false;
		
	}// 입력사항을 확인 후 체크 박스 선택
	else if (! document.account_simple_from.inputChk.checked) {
		swal("입력확인","입력 내용을 확인 후 체크 바랍니다.","warning");
		document.account_simple_from.inputChk.focus();
		return false;
	}
}
