/**
 * 
 */

//전역
let checkedId;
// -------------------------------- slipList.jsp --------------------------------
//일반전표 페이지 확인
function slipCheck() {

	/*
	 * if (! document.slipFrom.slipid_chk.checked){ alert("승인하실 전표를 선택 바랍니다.");
	 * return false; }
	 */

/*
	// 체크박스 체크여부 확인
	var slipid_chk = document.getElementsByName("slipid_chk");
	var count = 0;

	for (var i = 0; i < slipid_chk.length; i++) {
		console.log("slipid_chk[i] : " + slipid_chk[i].value);

		if (slipid_chk[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("승인할 전표를 승인ㅎ ㅏ ㅅ ㅣ 오");
		return false;
	} else {
		var result = confirm("승인 전표를 선택 하셨습니다. \n선택하신 전표를 승인 하시겠습니까?");
		if ( result == true ) {
			slipFrom.submit();
			//return false;
		}
	}
	*/
}

	
// 체크박스 선택
function checkbox_slipId(element){
	
	var slipid_chk = document.getElementsByName("slipid_chk");
	
	for (var i=0; i < slipid_chk.length; i++){
		console.log("slipid_chk[i].value : " + slipid_chk[i].value);
	}
	
	checkedId = element.value;
	console.log("checkedId : " + checkedId);
}




