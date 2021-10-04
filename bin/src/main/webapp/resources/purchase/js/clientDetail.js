function clientDelete() {
	
	var client_id = document.getElementById('client_id').value;
	
	var check = confirm("거래처를 삭제하시겠습니까?");
	
	if (check) {
		window.location="clientDelete?client_id=" + client_id;
	} else {
		return false;
	}
}
	

