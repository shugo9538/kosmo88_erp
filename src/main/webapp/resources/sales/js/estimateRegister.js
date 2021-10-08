// 거래처 상품(숨겨진것) disabled
$(document).ready(function() {
	
	// 거래처 선택
	$("#selectClient").click(function(){
		
		var url = "/logistics_erp/sales/selectClient"
		window.open(url, "select", "menubar=no, width=1400, height=900");
		
	});
	
	// 담당자 선택
	$("#selectEmployee").click(function(){
		
		var url = "/logistics_erp/sales/selectEmployee"
		window.open(url, "select", "menubar=no, width=1400, height=900");
	});
});





