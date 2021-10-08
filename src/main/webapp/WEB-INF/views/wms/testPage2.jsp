<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button {
	width: 5.5em;
	height: 3.5em;
}
</style>
</head>
<body>
	<button type="button" id="test1"
		onclick="whatYourName('miniddo', finishFunc)">test1</button>
	<button type="button" id="test2" onclick="delBtn()">test2</button>

	<%-- <script src="${pageContext.request.contextPath}/resources/wms/js/test.js"> --%>



	<script>
	function whatYourName(name, callback) {
	    console.log('name: ', name);
// 	    callback();
	}

	function finishFunc() {
	    console.log('finish function');
	}

	whatYourName('miniddo', finishFunc);
	</script>
</body>
</html>