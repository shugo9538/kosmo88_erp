$(document).ready(function(){
	
	// 상품 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		
		$("#item_name2", opener.document).val(child.find("#c_item_name2").val());
		$("#price2", opener.document).val(child.find("#c_price2").val());
		
		var price = child.find('#c_price2').val();
		var sale_price2 = child.find('#c_price2').val() * 1.4;
		console.log(price);
		$("#sale_price2", opener.document).attr('value', sale_price2);
		$("#category2", opener.document).val(child.find("#c_category2").val());
		window.close();
	});
});


