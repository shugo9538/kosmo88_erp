$(document).ready(function(){
	
	// 거래처 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		$("#id", opener.document).val(child.find("#client_id").val());
		$("#name", opener.document).val(child.find("#client_name").val());
		$("#ceo_name", opener.document).val(child.find("#client_ceo_name").val());
		$("#phone", opener.document).val(child.find("#client_phone").val());
		$("#email", opener.document).val(child.find("#client_email").val());
		$("#zip_code", opener.document).val(child.find("#client_zip_code").val());
		$("#address", opener.document).val(child.find("#client_address").val());
		$("#detail_address", opener.document).val(child.find("#client_detail_address").val());
		$(window.close());
	})
	
});
