// 거래처 상품(숨겨진것) disabled
$(document).ready(function() {
	$("input[name=item_name]:hidden").each(function(){
		$(this).prop("disabled", true);
	})
	
	$("input[name=category]:hidden").each(function(){
		$(this).prop("disabled", true);
	})
	
	$("input[name=price]:hidden").each(function(){
		$(this).prop("disabled", true);
	})
	
	
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
	
	// 상품 선택1
	$("#selectItem").click(function(){
		
		var url = "/logistics_erp/sales/selectItem"
		window.open(url, "select", "menubar=no, width=1400, height=900");
	});
	
	// 상품 선택2
	$("#selectItem2").click(function(){
		
		var url = "/logistics_erp/sales/selectItem2"
		window.open(url, "select2", "menubar=no, width=1400, height=900");
	});
	
	// 상품 선택3
	$("#selectItem3").click(function(){
		
		var url = "/logistics_erp/sales/selectItem3"
		window.open(url, "select3", "menubar=no, width=1400, height=900");
	});
	
	
	
});





var i = 0;



// 입력 후 커서 이동
function nextRegisterNum1(){
	if(document.clientRegisterForm.register_num1.value.length >= 3){
		document.clientRegisterForm.register_num2.focus();
	}
}
function nextRegisterNum2(){
	if(document.clientRegisterForm.register_num2.value.length >= 2){
		document.clientRegisterForm.register_num3.focus();
	}
}
function nextRegisterNum3(){
	if(document.clientRegisterForm.register_num3.value.length >= 5){
		document.clientRegisterForm.email1.focus();
	}
}

function nextPhone1() {
	if(document.clientRegisterForm.phone1.value.length >= 3) {
		document.clientRegisterForm.phone2.focus();
	}
}

function nextPhone2() {
	if(document.clientRegisterForm.phone2.value.length >= 4) {
		document.clientRegisterForm.phone3.focus();
	}
}

function nextPhone3() {
	if(document.clientRegisterForm.phone3.value.length >= 4) {
		document.clientRegisterForm.zip_code.focus();
	}
}


//  --------- 상품 수량
var price;
var amount;

function init() {
	sale_price = document.estimateRegisterForm.sale_price.value;
	amount = document.estimateRegisterForm.amount.value;
	document.estimateRegisterForm.total_price.value = sale_price;
	change();
}

function sale_price(){
	init();
}
function add () {
	hm = document.estimateRegisterForm.amount;
//	total_price = document.estimateRegisterForm.total_price;
	hm.value ++ ;

	total_price.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price.value;
}

function del () {
	hm = document.estimateRegisterForm.amount;
	total_price = document.estimateRegisterForm.total_price;
		if (hm.value > 1) {
			hm.value -- ;
			total_price.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price.value;
		}
}

function change () {
	hm = document.estimateRegisterForm.amount;
	total_price = document.estimateRegisterForm.total_price;
		if (hm.value < 0) {
			hm.value = 0;
		}
		total_price.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price.value;
}

//----------------
var sale_price2;
var amount2;

function init () {
	sale_price2 = document.estimateRegisterForm.sale_price2.value;
	amount2 = document.estimateRegisterForm.amount2.value;
	document.estimateRegisterForm.total_price2.value = sale_price2;
	change2();
}

function sale_price2(){
//	price = document.estimateRegisterForm.price.value;
//	console.log("test")
//	price = document.getElementById("price").getAttribute("value");
//	console.log(price);
	init();
}
function add2 () {
	hm = document.estimateRegisterForm.amount2;
//	total_price = document.estimateRegisterForm.total_price;
	hm.value ++ ;

	total_price2.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price2.value;
}

function del2 () {
	hm = document.estimateRegisterForm.amount2;
	total_price2 = document.estimateRegisterForm.total_price2;
		if (hm.value > 1) {
			hm.value -- ;
			total_price2.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price2.value;
		}
}

function change2 () {
	console.log("onchange")
	hm = document.estimateRegisterForm.amount2;
	total_price2 = document.estimateRegisterForm.total_price2;
	
		if (hm.value < 0) {
			hm.value = 0;
		}
		total_price2.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price2.value;
}


//----------------
var sale_price3;
var amount3;

function init () {
	sale_price3 = document.estimateRegisterForm.sale_price3.value;
	amount3 = document.estimateRegisterForm.amount3.value;
	document.estimateRegisterForm.total_price3.value = sale_price3;
	change3();
}

function sale_price3(){
//	price = document.estimateRegisterForm.price.value;
//	console.log("test")
//	price = document.getElementById("price").getAttribute("value");
//	console.log(price);
	init();
}
function add3 () {
	hm = document.estimateRegisterForm.amount3;
//	total_price = document.estimateRegisterForm.total_price;
	hm.value ++ ;

	total_price3.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price3.value;
}

function del3 () {
	hm = document.estimateRegisterForm.amount3;
	total_price3 = document.estimateRegisterForm.total_price3;
		if (hm.value > 1) {
			hm.value -- ;
			total_price3.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price3.value;
		}
}

function change3 () {
	console.log("onchange")
	hm = document.estimateRegisterForm.amount3;
	total_price3 = document.estimateRegisterForm.total_price3;
	
		if (hm.value < 0) {
			hm.value = 0;
		}
		total_price3.value = parseInt(hm.value) * document.estimateRegisterForm.sale_price3.value;
}



