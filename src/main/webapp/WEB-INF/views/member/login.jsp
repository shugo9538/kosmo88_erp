<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Meter - Responsive Admin Dashboard Template</title>
</head>
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
						<h2 class="header-title text-center">로그인</h2>
						<form action="${ROOT_PATH}/loginAction" method="post">
							<sec:csrfInput />
							<div class="form-group">
								<input class="form-control" type="email" id="login_id" name="id" placeholder="아이디(이메일)" size="50" required>
							</div>
							<div class="form-group">
								<input class="form-control" type="password" id="login_pw" name="password" placeholder="비밀번호" size="50" required>
							</div>
							<div class="form-group">
								<div class="pull-left">
									<div class="checkbox primary">
										<input id="checkbox-2" type="checkbox">
									</div>
								</div>
								<div class="pull-right">
									<a href="reset-password.html" class="a-link">
										<i class="fa fa-unlock-alt"></i>
										비밀번호 찾기
									</a>
								</div>
							</div>
							<div class="form-group">
								<input type="submit" value="로그인" class="btn btn-primary btn-block">
							</div>
						</form>
						<div class="copy-text">
							<p class="m-0">Copyright © 2021 KU Ultimate ERP</p>
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
	<!-- End core plugin -->
</body>
</html>