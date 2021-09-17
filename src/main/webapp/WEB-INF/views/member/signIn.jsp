<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<body class="sticky-header">
	<form name="signInForm" action="${ROOT_PATH}/signInAction" method="post">
		<fieldset>
			<sec:csrfInput />
			<table>
				<tr>
					<td>
						<input type="email" id="signup_id" name="userid" placeholder="아이디(이메일)" maxlength="50" required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" id="signup_pw" name="password" placeholder="비밀번호" maxlength="50" required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" id="signup_repw" name="repassword" placeholder="비밀번호 확인" maxlength="50" required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" id="signup_name" name="username" placeholder="이름" maxlength="50" required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" id="signup_phone" name="tel" placeholder="휴대폰번호" maxlength="11" onkeyup="telCheck();" required>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="telChecker" name="telChecker" value="0">(-)없이 번호만 작성해주세요</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" id="btn" value="회원가입">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="reset" id="btn" value="취소" onclick="window.history.back();">
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>