function orderDelete() {
	
	var request_id = document.getElementById('request_id').value;
	
	var check = confirm("거래처를 삭제하시겠습니까?");
	
	if (check) {
		window.location="orderDelete?request_id=" + request_id;
	} else {
		return false;
	}
}
	

