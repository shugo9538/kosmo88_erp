<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Meter - Responsive Admin Dashboard Template</title>
</head>
<body class="sticky-header">
	<form class="accountForm" action="${ROOT_PATH}/loginAction" method="post">
		<fieldset>
			<sec:csrfInput />
			<table>
				<tr>
					<td>
						<input type="email" id="login_id" name="userid" placeholder="아이디(이메일)" size="50" required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" id="login_pw" name="password" placeholder="비밀번호" size="50" required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="btn" value="로그인">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" id="btn" onclick="window.location='${ROOT_PATH}/signIn'" value="회원가입">
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>