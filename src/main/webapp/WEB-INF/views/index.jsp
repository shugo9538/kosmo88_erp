<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="common/header.jsp"%>
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">Dashboard1</h4>
				<ol class="breadcrumb">
					<li><a href="#">Dashboard</a></li>
					<li class="active">Dashboard 1</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!--Start row-->

			<!--End row-->
			<!--Start row-->
			<div class="row">

				<iframe
					class="col-md-12"
					src="http://www.dulgi.xyz:5601/app/dashboards#/view/36e7ac10-3967-11ec-bb34-ad38b9b09fc8?embed=true&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-30d,to:now))&_a=(description:'',filters:!(),fullScreenMode:!f,options:(hidePanelTitles:!f,useMargins:!t),query:(language:kuery,query:''),timeRestore:!f,title:'kosmoerp%20main',viewMode:view)&hide-filter-bar=true"
					height="1000px" width="800px"
					frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
			</div>
			
			<div class="row">

				<iframe
					class="col-md-12"
					src="http://127.0.0.1:8000/"
					height="1000px" width="800px"
					frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
			</div>
			<!-- Start inbox widget-->
		</div>
		<!--End row-->
	</div>
	<!-- End Wrapper-->
	<%@ include file="common/footer.jsp"%>
	<%@ include file="common/js_main.jsp"%>

</body>
</html>