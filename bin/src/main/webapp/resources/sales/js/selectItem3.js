$(document).ready(function(){
	
	// 상품 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		
		$("#item_name3", opener.document).val(child.find("#c_item_name3").val());
		$("#price3", opener.document).val(child.find("#c_price3").val());
		
		var price = child.find('#c_price3').val();
		console.log(price);
		$("#price3", opener.document).attr('value', price);
		$("#category3", opener.document).val(child.find("#c_category3").val());
		window.close();
	});
});


