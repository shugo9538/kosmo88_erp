<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
	
		<!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">거래처 등록</h2>
                        <form class="js-validation-bootstrap form-horizontal" action="base_forms_validation.html"
                            method="post">
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">회사명</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="회사명">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">대표자명</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="대표자명">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">사업자번호</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="사업자번호">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">대표전화</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="대표전화">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">사업장주소</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="사업장주소">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">담당자</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="담당자">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">담당자 부서</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="담당자 부서">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 120px; font-weight: bold;" class="col-md-3 control-label" for="val-username">담당자 전화</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="담당자 전화">
                                </div>
                            </div>
                            <div class="form-group">
                                <label style="width: 125px; font-weight: bold;" class="col-md-3 control-label" for="val-username">담당자 이메일</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="email" id="val-username" name="val-username"
                                        placeholder="담당자 이메일">
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-8 col-md-offset-3">
                                    <input class="btn  btn-default" type="reset" value="취소">
                                    <input class="btn  btn-default" type="button" value="목록">
                                    <input class="btn  btn-primary" type="submit" value="등록">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end row -->
	
		
<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>