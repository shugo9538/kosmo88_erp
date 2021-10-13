/**
 * 
 */

//전역
let checkedId; //체크박스 값 저장할 곳
// -------------------------------- slipList.jsp --------------------------------
//일반전표 페이지 확인
function slipCheck() {

	/*
	 * if (! document.slipFrom.slipid_chk.checked){ alert("승인하실 전표를 선택 바랍니다.");
	 * return false; }
	 */

	// 체크박스 체크여부 확인
	var slipid_chk = document.getElementsByName("slipid_chk");
	var count = 0;

	for (var i = 0; i < slipid_chk.length; i++) {
		console.log("slipid_chk[i] : " + slipid_chk[i].value);

		if (slipid_chk[i].checked == true) {
			count++;
		}
	}
	
	// 체크박스가 선택되지 않을때 체크박스 선택 알림
	if (count == 0) {
		swal("승인할 전표를 선택하세요");
		
		return false;
	} else {
		swal({
			title : "선택하신 전표를 승인 하시 겠습니까?",
			text : "승인 전표를 선택 하셨습니다.",
			type : "warning",
			showCancelButton: true,
			cancelButtonText: "아니요",
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "예",
			closeOnConfirm: false
			}, function(){
				//swal("Deleted!", "Your imaginary file has been deleted.", "success");  -- 요거 주석 해제하면 
				slipFrom.submit();
			});
		return false;
		//var result = confirm("승인 전표를 선택 하셨습니다. \n선택하신 전표를 승인 하시겠습니까?");
	/*	if (result == true ) {
			//slipFrom.submit();
			// return false;
		}else{
			return false;
		}*/
	}
}

// 체크박스 선택했을때 값
function checkbox_slipId(element){
	
	var slipid_chk = document.getElementsByName("slipid_chk");
	
	for (var i=0; i < slipid_chk.length; i++){
		console.log("slipid_chk[i].value : " + slipid_chk[i].value);
	}
	
	checkedId = element.value;
	console.log("checkedId : " + checkedId);
}

//전표 번호 선택
function slip_Id(emlement){
	
		root = document.getElementById("root"); // 패키지 경로
		console.log("element : " + emlement);
		console.log("rootPath : " + rootPath.value);
		const url = rootPath.value + "/account/slipDetailInfo?slip_id=" + emlement;
		
	swal({
		title : emlement + "번 전표를 선택 하셨습니다.",
		text : "",
		type : "info"}, function(){
			window.open(url, "accountDetail", "menubar=no, width=1000, height=750");
			
		});
}





//-------------------------------- slipDetail --------------------------------
// 지출결의 페이지 포커스설정
function slipDetail() {
	document.slip_detail_form.abs.focus();
}

//계좌추가 이력 유효성 체크
function slipDetailChk() {

	// 계좌소유주 선택
	if (document.slip_detail_form.account_title.value == 0) {
		swal("지출계정"," 선택 해주시기 바랍니다.","info");
		document.slip_detail_form.account_title.focus();
		return false;
		// 적요입력
	} else if (document.slip_detail_form.client_id.value  == 0) {
		swal("거래처명","선택 되지 않았습니다.\n 확인 후 입력 바랍니다.","info");
		document.slip_detail_form.client_id.focus();
		return false;
	} else if (! document.slip_detail_form.abs.value) {
		swal("지출내용","입력이 되지 않았습니다.\n 확인 후 입력 바랍니다.","info");
		document.slip_detail_form.abs.focus();
		return false;
	} else if (document.slip_detail_form.expenses.value <= 0) {
		swal("지출금액","0 또는 0 이상입력 하세요.","info");
		document.slip_detail_form.expenses.focus();
		return false;
	}// 입력사항을 확인 후 체크 박스 선택
	else if (! document.slip_detail_form.inputChk.checked) {
		swal("입력확인","입력사항을 반드시 확인 바랍니다.","info");
		document.slip_detail_form.inputChk.focus();
		return false;
	}
}