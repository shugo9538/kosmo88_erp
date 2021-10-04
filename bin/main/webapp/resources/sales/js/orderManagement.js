$(document).ready(function(){
	
	// 전체 체크박스 클릭
	$("#checkAll").click(function(){
		// 전체 체크박스가 클릭상태이면
		if($("checkAll").is(":checked")){
			// 전체 체크
			$("input[name=order_id]").prop("checked", true);
		// 전체 체크박스가 클릭상태가 아니면
		} else {
			// 전체 미체크
			$("input[name=order_id]").prop("checked", false);
		}
	});
	
	// 개별 체크박스 클릭
	$("input[name=order_id]").click(function(){
		var totalCnt = $("input[name=order_id]").length;  // 개별 체크박스 전체 개수
		var checkedCnt = $("input[name=order_id]").length;  // 체크된 개별체크박스 갯수
		
		// 두 수량이 다르면
		if(totalCnt != checkedCnt) {
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
		$("input:checkbox[name=order_id]:checked").each(function(){
			clientIdArr.push($(this).val());
		});
		
		var check = $("input:checkbox[name=order_id]:checked").length;
		
		if (check == 0) {
			alert("삭제할 거래처를 선택해주세요!!");
		} else {
			var result = confirm("선택한 거래처를 삭제하시겠습니까?");
			if(result) {
				window.location = "/logistics_erp/sales/clientChoiceDelete?=order_id" + clientIdArr;
			} else {
				return false;
			}
		}
	});
	
	// 거래처 선택
	$("#selectClient").click(function(){
		
		var url = "/logistics_erp/sales/selectClient"
		window.open(url, "select", "menubar=no, width=1200, height=700");
		
	});
	
	
	// 거래처 값 전달
	$(".select").click(function() {
		var par = $(this).attr('name');
		cosole.log(par);
		var client = {};
		client[c_id] = $('input[name=c_id]').val();
		$("#name", opener.document).val("#c_name".val);
//		$(window.close());
	})
	
});



















