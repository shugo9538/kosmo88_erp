$(document).ready(function(){
	
	// 상품 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		
		$("#item_id", opener.document).val(child.find("#c_item_id").val());
		$("#item_name", opener.document).val(child.find("#c_item_name").val());
		$("#price", opener.document).val(child.find("#c_price").val());
		
		var price = child.find('#c_price').val();
		var sale_price = child.find('#c_price').val() * 1.4;
		console.log(price);
		console.log(sale_price);
		
		$("#sale_price", opener.document).attr('value', sale_price);
		$("#category", opener.document).val(child.find("#c_category").val());
		window.close();
	});
});


