function clientDelete() {
	
	var client_id = document.getElementById('client_id').value;
	
	swal({
		title : "거래처를 삭제하시겠습니까?",
		text : "삭제할 거래처를 선택 하셨습니다.",
		type : "warning",
		showCancelButton: true,
		cancelButtonText: "아니요",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "예",
		closeOnConfirm: false
		}, function(){
			window.location="clientDelete?client_id=" + client_id;
		});
	return false;
}
	

