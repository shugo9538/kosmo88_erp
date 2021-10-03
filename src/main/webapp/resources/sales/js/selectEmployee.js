$(document).ready(function(){
	
	// 담당자 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		$("#employee_id", opener.document).val(child.find("#c_employee_id").val());
		$("#employee_name", opener.document).val(child.find("#c_employee_name").val());
		$("#employee_phone", opener.document).val(child.find("#c_employee_phone").val());
		$("#employee_email", opener.document).val(child.find("#c_employee_email").val());
		$("#employee_dp", opener.document).val(child.find("#c_employee_dp").val());
		$(window.close());
	});	
});
