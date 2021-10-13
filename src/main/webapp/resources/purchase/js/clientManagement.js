$(document).ready(function() {
	
	// 전체 체크박스 클릭
	$("#checkAll").on('click', function(){
		// 전체 체크박스가 클릭상태이면
		if($("#checkAll").is(":checked")) {
			// 전체 체크
			$("input[name=client_id]").prop("checked", true);
		// 전체 체크박스가 클릭상태가 아니면	
		} else { 
			// 전체 미체크
			$("input[name=client_id]").prop("checked", false);
		}
	});
	
});