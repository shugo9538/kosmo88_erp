function estimateDelete() {
	
	var request_id = document.getElementById('request_id').value;
	
	swal({
		title : "견적서를 삭제하시겠습니까?",
		text : "삭제할 견적서를 선택 하셨습니다.",
		type : "warning",
		showCancelButton: true,
		cancelButtonText: "아니요",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "예",
		closeOnConfirm: false
		}, function(){
			window.location="estimateDelete?request_id=" + request_id;
		});
	return false;
}
	

