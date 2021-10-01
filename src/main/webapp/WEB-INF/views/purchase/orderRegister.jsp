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
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">발주서 등록</h4>
				<ol class="breadcrumb">
					<li>
						<a href="${ROOT_PATH}/purchase/purchaseManagement">발주서 관리</a>
					</li>
					<li class="active">발주서 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!-- Start row -->
			<div class="row">
				<!-- Start white-box -->
				<div class="white-box">
					<form class="form-horizontal">
						<div class="col-md-12">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>
								발주서
							</h2>
							<div class="form-group mt-5">
								<label class="col-md-1 control-label">회사명</label>
								<div class="col-md-3">
									<p class="form-control-static">주식회사 우여곡절</p>
								</div>
								<label class="col-md-1 control-label">거래처명</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="거래처명" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">대금결제방법</label>
								<div class="col-md-3">
									<p class="form-control-static">계좌이체</p>
								</div>
								<label class="col-md-1 control-label">증명구분</label>
								<div class="col-md-3">
									<p class="form-control-static">세금계산서(과세)</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">발주번호</label>
								<div class="col-md-3">
									<p class="form-control-static">21estimate0923</p>
								</div>
								<label class="col-md-1 control-label">발주일자</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="발주일자" type="date">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">담당자</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="담당자" type="text">
								</div>
								<label class="col-md-1 control-label">담당자 연락처</label>
								<div class="col-md-1">
									<input class="form-control" placeholder="010" type="text" maxlength="3" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="1111" type="text" maxlength="4" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="2222" type="text" maxlength="4" required>
								</div>
								<label class="col-md-1 control-label" for="val-email">담당자 이메일 </label>
								<div class="col-md-3">
									<input class="form-control" type="text" id="val-email" name="val-email" placeholder="담당자 이메일">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">대표자명</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="대표자명" type="text">
								</div>
								<label class="col-md-1 control-label">거래처 연락처</label>
								<div class="col-md-1">
									<input class="form-control" placeholder="010" type="text" maxlength="3" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="1111" type="text" maxlength="4" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="2222" type="text" maxlength="4" required>
								</div>
								<label class="col-md-1 control-label" for="val-email">거래처 이메일 </label>
								<div class="col-md-3">
									<input class="form-control" type="text" id="val-email" name="val-email" placeholder="거래처 이메일">
								</div>
							</div>
						</div>
						<div class="col-md-12 mt-5">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>
								발주서 품목내역
							</h2>
							<div class="table-responsive">
								<div class="col-md-2 mt-3 mb-3">
									<input class="btn btn-default mx-2" type="button" value="품목추가">
									<input class="btn btn-default" type="button" value="품목삭제">
								</div>
								<table id="example" class="display table">
									<thead>
										<tr>
											<td style="text-align: center;">
												<input type="checkbox" name="select" id="select">
											</td>
											<th>순번</th>
											<th>품목명</th>
											<th>종류</th>
											<th>공급단가</th>
											<th>수량</th>
											<th>공급가액</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-5 col-md-offset-5 mt-3">
								<input class="btn btn-primary mx-1" type="submit" value="등록">
								<input class="btn btn-primary" type="reset" value="취소">
							</div>
						</div>
					</form>
				</div>
				<!-- End white-box -->
			</div>
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
</body>
</html>