<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		<!--body wrapper start-->
		<div class="wrapper">
			구매관리
			<div class="white-box">
	            <div class="col-md-6">
	              <h2 class="header-title">Input States</h2>
	               <form class="form-horizontal">
	                   <div class="form-group has-success">
	                       <label class="col-md-3 control-label" for="state-success">Success</label>
	                       <div class="col-md-6">
	                           <input id="state-success" name="state-success" class="form-control" placeholder="..." type="text">
	                       </div>
	                   </div>
	
	
	                   <div class="form-group has-warning">
	                       <label class="col-md-3 control-label" for="state-warning">Warning</label>
	                       <div class="col-md-6">
	                           <input id="state-warning" name="state-warning" class="form-control" placeholder="..." type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group has-error">
	                       <label class="col-md-3 control-label" for="state-danger">Danger</label>
	                       <div class="col-md-6">
	                           <input id="state-danger" name="state-danger" class="form-control" placeholder="..." type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group has-success has-feedback">
	                       <label class="col-sm-3 control-label">Input with success </label>
	                       <div class="col-sm-6">
	                           <input class="form-control" type="text">
	                           <span class="glyphicon glyphicon-ok form-control-feedback"></span>
	                       </div>
	                   </div>
	
	                   <div class="form-group has-warning has-feedback">
	                       <label class="col-sm-3 control-label">Input with warning </label>
	                       <div class="col-sm-6">
	                           <input class="form-control inputmask" type="text">
	                           <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
	                       </div>
	                   </div>
	
	                   <div class="form-group has-error has-feedback">
	                       <label class="col-sm-3 control-label">Input with error </label>
	                       <div class="col-sm-6">
	                           <input class="form-control inputmask" type="text">
	                           <span class="glyphicon glyphicon-remove form-control-feedback"></span>
	                       </div>
	                   </div>
	
	               </form>
	           </div>
	            <div class="col-md-6">
	               <h2 class="header-title">Input Sizes</h2>
	               <form class="form-horizontal">
	                   <div class="form-group">
	                       <label class="col-sm-3 control-label" for="example-input-small">Small</label>
	                       <div class="col-sm-6">
	                           <input id="example-input-small" name="example-input-small" class="form-control input-sm" placeholder=".input-sm" type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group">
	                       <label class="col-sm-3 control-label" for="example-input-normal">Normal</label>
	                       <div class="col-sm-6">
	                           <input id="example-input-normal" name="example-input-normal" class="form-control" placeholder="Normal" type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group">
	                       <label class="col-sm-3 control-label" for="example-input-large">Large</label>
	                       <div class="col-sm-6">
	                           <input id="example-input-large" name="example-input-large" class="form-control input-lg" placeholder=".input-lg" type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group">
	                       <label class="col-sm-3 control-label">Grid Sizes</label>
	                       <div class="col-sm-4">
	                           <input class="form-control" placeholder=".col-sm-4" type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group">
	                       <div class="col-sm-5 col-sm-offset-3">
	                           <input class="form-control" placeholder=".col-sm-5" type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group">
	                       <div class="col-sm-6 col-sm-offset-3">
	                           <input class="form-control" placeholder=".col-sm-6" type="text">
	                       </div>
	                   </div>
	
	                   <div class="form-group">
	                       <div class="col-sm-9 col-sm-offset-3">
	                           <input class="form-control" placeholder=".col-sm-9" type="text">
	                       </div>
	                   </div>
	               </form>
	           </div>
        	</div>
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
</body>
</html>