$(document).ready(function(){
	
	// 거래처 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		$("#client_id", opener.document).val(child.find("#client_id").val());
		$("#client_name", opener.document).val(child.find("#client_name").val());
		$("#client_ceo_name", opener.document).val(child.find("#client_ceo_name").val());
		$("#client_phone", opener.document).val(child.find("#client_phone").val());
		$("#client_email", opener.document).val(child.find("#client_email").val());
		$("#client_zip_code", opener.document).val(child.find("#client_zip_code").val());
		$("#client_address", opener.document).val(child.find("#client_address").val());
		$("#client_detail_address", opener.document).val(child.find("#client_detail_address").val());
		$(window.close());
	})
});
