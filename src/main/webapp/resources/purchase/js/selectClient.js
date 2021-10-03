$(document).ready(function(){
	
	// 거래처 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		$("#id", opener.document).val(child.find("#c_id").val());
		$("#name", opener.document).val(child.find("#c_name").val());
		$("#ceo_name", opener.document).val(child.find("#c_ceo_name").val());
		$("#phone", opener.document).val(child.find("#c_phone").val());
		$("#email", opener.document).val(child.find("#c_email").val());
		$("#zip_code", opener.document).val(child.find("#c_zip_code").val());
		$("#address", opener.document).val(child.find("#c_address").val());
		$("#detail_address", opener.document).val(child.find("#c_detail_address").val());
		$(window.close());
	})
	
	// 상품 값 전달
	
	
	
});
