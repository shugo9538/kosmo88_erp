<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/accountsettings.jsp"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />

</head>
<body>

<script type="text/javascript">

swal("hellow","성공","success");
//Success Message
	var alert = function(msg,type){
		swal({
			title : '',
			text : msg,
			type : type,
			timer : 1500,
			customClass : 'sweet-size',
			showConfirmButton : false
		});
	}	
	
	function Alert() {
		alert('gg', 'success');
	}
	
	swal("통장목록","신규통장이 추가되었습니다. 목록으로 이동합니다.","success",{
		//closeOnclickOutside : false,
		//closeEsc: false,
		timer : 3000,
		buttons : {
			text : '확인',
			value : true
		}
	});
	
	swal({
	    title: "Wow!",
	    text: "Message!",
	    type: "success"
	}),(function() {
	    window.location = "http://www.naver.com";
	});
	
	swal("통장목록","신규통장이 추가되었습니다. 목록으로 이동합니다.","success",{
		buttons : {
			text : '확인',
			value : true,
			timer : 1500
		}
	});	

</script>

<button onclick="Alert();">Alert</button>

		

</body>
</html>