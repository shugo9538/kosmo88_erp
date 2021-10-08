// 견적서 상품(숨겨진것) disabled
$(document).ready(function() {
	
	// 거래처 선택
	$("#selectClient").click(function() {
		
		var url = "/logistics_erp/purchase/selectClient"
		window.open(url, "selectClient", "menubar=no, width=1500, height=700");
	});
	
	// 담당자 선택
	$("#selectEmployee").click(function() {
		
		var url = "/logistics_erp/purchase/selectEmployee"
		window.open(url, "selectEmployee", "menubar=no, width=1500, height=700");
	});
});


