// 견적서 상품(숨겨진것) disabled
$(document).ready(function() {
	
	// 거래처 선택
	$("#selectClient").on('click', function() {
		
		var url = "/logistics_erp/purchase/selectClient"
		window.open(url, "selectClient", 'height=' + screen.height + ',width=' + screen.width + 'fullscreen=yes');
	});
	
	// 담당자 선택
	$("#selectEmployee").on('click', function() {
		
		var url = "/logistics_erp/purchase/selectEmployee"
		window.open(url, "selectEmployee", 'height=' + screen.height + ',width=' + screen.width + 'fullscreen=yes');
	});
});


