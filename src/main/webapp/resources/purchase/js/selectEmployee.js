$(document).ready(function(){
	
	// 담당자 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
<<<<<<< HEAD
		$("#employee_id", opener.document).val(child.find("#c_employee_id").val());
		$("#employee_name", opener.document).val(child.find("#c_employee_name").val());
		$("#employee_phone", opener.document).val(child.find("#c_employee_phone").val());
		$("#employee_email", opener.document).val(child.find("#c_employee_email").val());
		$("#employee_dp", opener.document).val(child.find("#c_employee_dp").val());
=======
		$("#employee_id", opener.document).val(child.find("#employee_id").val());
		$("#employee_name", opener.document).val(child.find("#employee_name").val());
		$("#employee_phone", opener.document).val(child.find("#employee_phone").val());
		$("#employee_email", opener.document).val(child.find("#employee_email").val());
		$("#department_name", opener.document).val(child.find("#department_name").val());
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
		$(window.close());
	});	
});
