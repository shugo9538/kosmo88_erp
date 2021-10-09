function orderDelete() {
	
	var request_id = document.getElementById('request_id').value;
	
	swal({
		title : "주문서를 삭제하시겠습니까?",
		text : "삭제할 주문서를 선택 하셨습니다.",
		type : "warning",
		showCancelButton: true,
		cancelButtonText: "아니요",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "예",
		closeOnConfirm: false
		}, function(){
			window.location="orderDelete?request_id=" + request_id;
		});
	return false;
}
	

