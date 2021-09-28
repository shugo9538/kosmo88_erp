/*
$(document).ready(function() {
	
	// 전체 체크박스 클릭
	$("#checkAll").click(function(){
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
	
	// 개별 체크박스 클릭
	$("input[name=client_id]").click(function(){
		var totalCnt = $("input[name=client_id]").length;  // 개별 체크박스 전체 개수
		var checkedCnt = $("input[name=client_id]:checked").length;  // 체크된 개별체크박스 개수
		
		// 두 수량이 다르면
		if (totalCnt != checkedCnt) {
			// 전체 체크박스 false
			$("#checkAll").prop("checked", false);
		
		// 두 수량이 같으면	
		} else {
			// 전체 체크박스 true
			$("#checkAll").prop("checked", true);
		}
	});
	
	// 선택 거래처 삭제
	$("#delButton").click(function(){
		
		var clientIdArr = new Array();
		
		// check 된 값만 checkArr에 저장
		$("input:checkbox[name=client_id]:checked").each(function(){
			clientIdArr.push($(this).val());
		});
		
		var check = $("input:checkbox[name=client_id]:checked").length;
		
		if (check == 0) {
			alert("삭제할 거래처를 선택해주세요!!");
		} else {
			var result = confirm("선택한 거래처를 삭제하시겠습니까?");
			if (result) {
				window.location = "/logistics_erp/purchase/clientChoiceDeleteAction?=client_id" + clientIdArr;
			} else {
				return false;
			}
		}
	});
	
	// 거래처 상세페이지
	$(".detailBtn").click(function() {
		
		var id = $(this).parent().parent().find(".client_id").val();
		
		var url = "/logistics_erp/purchase/clientDetail?id=" + id;
		window.open(url, "거래처 상세페이지", "menubar=no, width=1000, height=700");
	});
});
*/