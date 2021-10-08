<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<body class="sticky-header">
	<!--Start login Section-->
	<section class="login-section">
		<div class="container">
			<div class="row">
				<div class="login-wrapper">
					<div class="login-inner">
						<div class="logo">
							<img src="${RESOURCES_PATH}/assets/images/logo-dark.png" alt="logo" />
						</div>
						<h2 class="header-title text-center">회원가입</h2>
						<form action="${ROOT_PATH}/signInAction" method="post">
							<sec:csrfInput />
							<div class="form-group">
								<input class="form-control" type="email" id="signup_id" name="userid" placeholder="아이디(이메일)" maxlength="50"
									value="${employee.id}@uyeogogjeol.org" required
								>
							</div>
							<div class="form-group">
								<input class="form-control" type="text" id="signup_name" name="username" placeholder="이름" maxlength="50"
									value="${employee.id}" required
								>
							</div>
							<div class="form-group">
								<input class="form-control" type="password" id="signup_pw" name="password" placeholder="비밀번호" maxlength="50"
									required
								>
							</div>
							<div class="form-group">
								<input class="form-control" type="password" id="signup_repw" name="repassword" placeholder="비밀번호 확인"
									maxlength="50" required
								>
							</div>
							<div class="form-group">
								<c:if test="${employee.department_id == 200}">
									<input class="form-control" type="text" id="authority" name="authority" value="ROLE_ADMIN" required readonly>
								</c:if>
								<c:if test="${employee.department_id != 200}">
									<input class="form-control" type="text" id="authority" name="authority" value="ROLE_USER" required readonly>
								</c:if>
							</div>
							<div class="form-group">
								<input type="submit" value="계정 생성" class="btn btn-primary btn-block">
							</div>
						</form>
						<div class="copy-text">
							<p class="m-0">Copyright © 2021 주식회사 우여곡절</p>
							<p class="m-0">Co.,Ltd All Rights Reserved</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--End login Section-->
	<!--Begin core plugin -->
	<script src="${RESOURCES_PATH}/assets/js/jquery.min.js"></script>
	<script src="${RESOURCES_PATH}/assets/js/bootstrap.min.js"></script>
	<script src="${RESOURCES_PATH}/assets/plugins/moment/moment.js"></script>
	<script src="${RESOURCES_PATH}/assets/js/jquery.slimscroll.js "></script>
	<script src="${RESOURCES_PATH}/assets/js/jquery.nicescroll.js"></script>
	<script src="${RESOURCES_PATH}/assets/js/functions.js"></script>
	<!-- End core plugin -->
</body>
</html>