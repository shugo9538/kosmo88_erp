$(document).ready(function(){
	
	// 담당자 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
		$("#employee_id", opener.document).val(child.find("#employee_id").val());
		$("#employee_name", opener.document).val(child.find("#employee_name").val());
		$("#employee_phone", opener.document).val(child.find("#employee_phone").val());
		$("#employee_email", opener.document).val(child.find("#employee_email").val());
		$("#department_name", opener.document).val(child.find("#department_name").val());
		$(window.close());
	});	
});
