// 견적서 상품(숨겨진것) disabled
$(document).ready(function() {
	
	// 견적서 선택
	$("#selectEstimate").click(function() {
		
		var url = "/logistics_erp/sales/selectEstimate"
		window.open(url, "selectEstimate", "menubar=no, width=1500, height=700");
	});
	
});


