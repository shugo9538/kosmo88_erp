<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/settings.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- alert 추가  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

</head>
<body>

<script type="text/javascript">
swal("알럿 울려라");
</script>
<script type="text/javascript">
swal("입력확인하슈", "잘못 입력했다 짜샤~", "error");
</script>
<script type="text/javascript">
function dbc(){
	swal({
		title : "선택하신 전표를 승인 하시 겠습니까?",
		text : "승인 전표를 선택 하셨습니다.",
		type : "warning",
		showCancelButton: true,
		cancelButtonText: "아니요",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "예",
		closeOnConfirm: false
		}, function(){
			swal("승인완료!", "지워졌다, 이누마.", "success");
		});
	return false;
}


</script>



<button onclick="abc();"> 울려라1 </button>
<button onclick="dbc();"> 울려라2 </button>




</body>
</html>