$(document).ready(function(){
	
	// 견적서 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		$("#client_email", opener.document).val(child.find("#client_email").val());
		$("#client_zip_code", opener.document).val(child.find("#client_zip_code").val());
		$("#client_address", opener.document).val(child.find("#client_address").val());
		$("#client_detail_address", opener.document).val(child.find("#client_detail_address").val());
		$("#request_id", opener.document).val(child.find("#request_id").val());
		$("#client_name", opener.document).val(child.find("#client_name").val());
		$("#client_ceo_name", opener.document).val(child.find("#client_ceo_name").val());
		$("#client_phone", opener.document).val(child.find("#client_phone").val());
		$("#employee_id", opener.document).val(child.find("#employee_id").val());
		$("#employee_name", opener.document).val(child.find("#employee_name").val());
		$("#employee_phone", opener.document).val(child.find("#employee_phone").val());
		$("#employee_email", opener.document).val(child.find("#employee_email").val());
		$("#department_id", opener.document).val(child.find("#department_id").val());
		$("#department_name", opener.document).val(child.find("#department_name").val());
		$("#client_id", opener.document).val(child.find("#client_id").val());
		$(window.close());
	})
});
