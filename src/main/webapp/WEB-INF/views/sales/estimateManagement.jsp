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
				<h4 class="page-title">견적서 등록</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/purchase/estimateManagement">견적서 관리</a></li>
					<li class="active">견적서 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<form class="form-horizontal">
				<!-- Start white-box -->
				<div class="white-box">
					<div class="col-md-12">
						<h4 class="page-title">
							<i class="fa fa-chevron-circle-right mr-2"></i>견적서
						</h4>

						<div class="form-group"></div>
						<div class="form-group">
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
							<label class="col-md-1 control-label">견적번호</label>
							<div class="col-md-3">
								<p class="form-control-static">21estimate0923</p>
							</div>

							<label class="col-md-1 control-label">견적일자</label>
							<div class="col-md-3">
								<input class="form-control" placeholder="견적일자" type="date">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-1 control-label">영업 담당자</label>
							<div class="col-md-3">
								<input class="form-control" placeholder="영업담당자" type="text">
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

							<label class="col-md-1 control-label" for="val-email">담당자
								이메일 </label>
							<div class="col-md-3">
								<input class="form-control" type="text" id="val-email"
									name="val-email" placeholder="담당자 이메일">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-1 control-label">거래처대표자명</label>
							<div class="col-md-3">
								<input class="form-control" placeholder="거래처 대표자명" type="text">
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

							<label class="col-md-1 control-label" for="val-email">거래처
								이메일 </label>
							<div class="col-md-3">
								<input class="form-control" type="text" id="val-email"
									name="val-email" placeholder="거래처 이메일">
							</div>
						</div>
					</div>

					<div class="form-group"></div>
					<div class="form-group"></div>

					<div class="col-md-12">
						<h4 class="page-title">
							<i class="fa fa-chevron-circle-right mr-2"></i>견적서 품목내역
						</h4>
						<div class="table-responsive">
							<div class="col-md-2 mt-3 mb-3">
								<input class="btn btn-default mx-2" type="button" value="품목추가">
								<input class="btn btn-default" type="button" value="품목삭제">
							</div>
							<table id="example" class="display table">
								<thead>
									<tr>
										<td style="text-align: center;"><input type="checkbox"
											name="select" id="select"></td>
										<th>순번</th>
										<th>품목명</th>
										<th>종류</th>
										<th>공급단가</th>
										<th>수량</th>
										<th>공급가액</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>1</td>
										<td><a href="#">백미러</a></td>
										<td>자동차부품</td>
										<td>250,000</td>
										<td>100</td>
										<td>25,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>2</td>
										<td><a href="#">겹판 스프링</a></td>
										<td>자동차부품</td>
										<td>100,000</td>
										<td>500</td>
										<td>50,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>3</td>
										<td><a href="#">내연기관 펌프</a></td>
										<td>자동차부품</td>
										<td>3,000,000</td>
										<td>400</td>
										<td>1,200,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>4</td>
										<td><a href="#">기체압축기</a></td>
										<td>자동차부품</td>
										<td>5,000,000</td>
										<td>200</td>
										<td>1,000,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>5</td>
										<td><a href="#">액체여과기</a></td>
										<td>자동차부품</td>
										<td>300,000</td>
										<td>300</td>
										<td>90,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>6</td>
										<td><a href="#">공기여과기</a></td>
										<td>자동차부품</td>
										<td>400,000</td>
										<td>150</td>
										<td>60,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>7</td>
										<td><a href="#">전동축</a></td>
										<td>자동차부품</td>
										<td>20,000,000</td>
										<td>150</td>
										<td>3,000,000,000</td>
									</tr>
									<tr>
										<th style="text-align: center;"><input type="checkbox"
											name="select" id="select"></th>
										<td>8</td>
										<td><a href="#">배기가스 정화용 여과기</a></td>
										<td>자동차부품</td>
										<td>2,000,000</td>
										<td>150</td>
										<td>300,000,000</td>
									</tr>
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
				</div>
				<!-- End white-box -->
			</form>
		</div>
		<!-- End Wrapper-->
		
		<%@ include file="../common/footer.jsp"%>
</body>
</html>