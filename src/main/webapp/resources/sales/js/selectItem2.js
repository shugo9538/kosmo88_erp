$(document).ready(function(){
	
	// 상품 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		
		$("#item_name2", opener.document).val(child.find("#c_item_name2").val());
		$("#price2", opener.document).val(child.find("#c_price2").val());
		
		var price = child.find('#c_price2').val();
		console.log(price);
		$("#price2", opener.document).attr('value', price);
		$("#category2", opener.document).val(child.find("#c_category2").val());
		window.close();
	});
});


