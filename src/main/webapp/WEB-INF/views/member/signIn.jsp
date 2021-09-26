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
									required
								>
							</div>
							<div class="form-group">
								<input class="form-control" type="text" id="signup_name" name="username" placeholder="이름" maxlength="50"
									required
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
								<input class="form-control" type="text" id="signup_phone" name="tel" placeholder="휴대폰번호" maxlength="11"
									onkeyup="telCheck();" required
								>
								<div class="pull-left" id="telChecker" name="telChecker" value="0">(-)없이 번호만 작성해주세요</div>
							</div>
							<div class="form-group">
								<div class="pull-left">
									<div class="checkbox primary">
										<input id="checkbox-1" type="checkbox">
										<label for="checkbox-1">
											I accept
											<a href="#">Terms and Conditions</a>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<input type="submit" value="Sign Up" class="btn btn-primary btn-block">
							</div>
							<div class="form-group text-center">
								계정이 있으십니까?
								<a href="login.html">로그인</a>
							</div>
						</form>
						<div class="copy-text">
							<p class="m-0">2017 &copy; Meter admin</p>
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