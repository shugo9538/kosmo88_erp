/**
 * 
 */
// 지출결의 페이지 포커스설정
function clientDetail() {
	document.client_detail_form.name.focus();
}

// 계좌추가 이력 유효성 체크
function clientDetailChk() {

	// 계좌소유주 선택
	if (!document.client_detail_form.name.value) {
		swal("거래처명", " 거래처명을 입력 해주시기 바랍니다..", "info");
		document.client_detail_form.name.focus();
		return false;
		// 계좌소유주 선택
	} else if (!document.client_detail_form.ceo_name.value) {
		swal("대표자명", " 거래처명을 입력 해주시기 바랍니다.", "info");
		document.client_detail_form.ceo_name.focus();
		return false;
		// 적요입력
	} else if (!document.client_detail_form.register_num.value) {
		swal("대표자명", "입력을 확인 해주세요", "info");
		document.client_detail_form.register_num.focus();
		return false;
	} else if (!document.client_detail_form.address.value) {
		swal("사업자주소지1", "입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.", "info");
		document.client_detail_form.address.focus();
		return false;
	} else if (!document.client_detail_form.detail_address.value) {
		swal("사업자주소지2", "입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.", "info");
		document.client_detail_form.detail_address.focus();
		return false;
	} else if (!document.client_detail_form.zip_code.value) {
		swal("사업자주소지3", "입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.", "info");
		document.client_detail_form.zip_code.focus();
		return false;
	} else if (!document.client_detail_form.register_date.value) {
		swal("사업자번호", "입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.", "info");
		document.client_detail_form.register_date.focus();
		return false;
	} else if (!document.client_detail_form.phone.value) {
		swal("사업자연락처", "입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.", "info");
		document.client_detail_form.phone.focus();
		return false;
	} else if (!document.client_detail_form.email.value) {
		swal("담당자이메일", "입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.", "info");
		document.client_detail_form.email.focus();
		return false;
	}// 입력사항을 확인 후 체크 박스 선택
	else if (!document.client_detail_form.inputChk.checked) {
		swal("입력사항", "입력사항을 반드시 확인 바랍니다.", "info");
		document.client_detail_form.inputChk.focus();
		return false;
	}
}
