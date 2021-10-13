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
	
	// 상품 선택
	$("#selectItem").click(function(){
		
		var url = "/logistics_erp/sales/selectItem"
		window.open(url, "select", "menubar=no, width=1400, height=900");
	});
});

var price;
var quantity;

function init() {
	sales_price = document.estimateRegisterForm.sales_price.value;
	quantity = document.estimateRegisterForm.quantity.value;
	document.estimateRegisterForm.total_price.value = sales_price;
	change();
}

function price(){
	init();
}
function add () {
	hm = document.estimateRegisterForm.quantity;
//	total_price = document.estimateRegisterForm.total_price;
	hm.value ++ ;

	total_price.value = parseInt(hm.value) * document.estimateRegisterForm.sales_price.value;
}

function del () {
	hm = document.estimateRegisterForm.quantity;
	total_price = document.estimateRegisterForm.total_price;
		if (hm.value > 1) {
			hm.value -- ;
			total_price.value = parseInt(hm.value) * document.estimateRegisterForm.sales_price.value;
		}
}

function change () {
	hm = document.estimateRegisterForm.quantity;
	total_price = document.estimateRegisterForm.total_price;
		if (hm.value < 0) {
			hm.value = 0;
		}
		total_price.value = parseInt(hm.value) * document.estimateRegisterForm.sales_price.value;
}




