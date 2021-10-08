<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<div class="header-section">
	<a class="toggle-btn">
		<i class="fa fa-bars"></i>
	</a>
	<form class="searchform">
		<input type="text" class="form-control" name="keyword" placeholder="Search here..." />
	</form>
	<!--notification menu start -->
	<div class="menu-right">
		<ul class="notification-menu">
			<sec:authorize access="!isAnonymous()">
				<li>
					<a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
						<i class="fa fa-bell-o"></i>
						<!-- 					<span class="badge">4</span> -->
					</a>
					<div class="dropdown-menu dropdown-menu-head pull-right">
						<h5 class="title">Notifications</h5>
						<ul class="dropdown-list normal-list">
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						<img src="${RESOURCES_PATH}/assets/images/users/avatar-6.jpg" alt="" />
						<sec:authentication property="principal.authorities"/>
						<sec:authentication property="principal.id"/>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
						<li>
							<a href="#">
								<i class="fa fa-info"></i>
								Help
							</a>
						</li>
						<li>
							<form:form action="${ROOT_PATH}/logout" method="POST">
								<i class="fa fa-lock"></i>
								<input type="submit" value="Logout" />
							</form:form>
						</li>
					</ul>
				</li>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li>"로그인 후 이용"</li>
			</sec:authorize>
		</ul>
	</div>
	<!--notification menu end -->
</div>
<!-- header section end-->