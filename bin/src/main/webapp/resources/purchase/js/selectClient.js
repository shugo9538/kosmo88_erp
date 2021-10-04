$(document).ready(function(){
	
	// 거래처 값 전달
	$("input[name]").click(function() {
		var child = $(this).parents();
<<<<<<< HEAD
		$("#name", opener.document).val(child.find("#c_name").val());
		$("#ceo_name", opener.document).val(child.find("#c_ceo_name").val());
		$("#phone", opener.document).val(child.find("#c_phone").val());
		$("#email", opener.document).val(child.find("#c_email").val());
		$("#zip_code", opener.document).val(child.find("#c_zip_code").val());
		$("#address", opener.document).val(child.find("#c_address").val());
		$("#detail_address", opener.document).val(child.find("#c_detail_address").val());
		$(window.close());
	})
	
	// 담당자 값 전달
	
	
	
	// 상품 값 전달
	
	
	
=======
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
>>>>>>> 93c57a16fe887c0213199b3599ad6f190506bdb7
});
