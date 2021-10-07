$(document).ready(function(){
	
	// 상품 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		
		$("#item_name", opener.document).val(child.find("#c_item_name").val());
		$("#price", opener.document).val(child.find("#c_price").val());
		
		var price = child.find('#c_price').val();
		console.log(price);
		$("#price", opener.document).attr('value', price);
		$("#category", opener.document).val(child.find("#c_category").val());
		window.close();
	});
});


