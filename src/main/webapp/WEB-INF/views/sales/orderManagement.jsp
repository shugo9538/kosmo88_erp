<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
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
                <h4 class="page-title">주문 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">전체 목록</a>
                    </li>
                    <li class="active">
                    	
                      	  주문 관리
                    </li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->

            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	주문 등록</h2>
                        <div class="form-group">
                        </div>
                        <form class="js-validation-bootstrap form-horizontal" action="base_forms_validation.html"
                            method="post">
                            
                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">주문코드</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="주문코드">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">요청일자</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="date" id="val-username" name="val-username"
                                        placeholder="요청일자">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">납기일자</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="date" id="val-username" name="val-username"
                                        placeholder="납기일자">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">거래처명</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="거래처명">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">대표자명</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="대표자명">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">거래처 연락처</label>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="010">
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                                <div>
                                    
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">거래처 이메일</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="email" id="val-username" name="val-username"
                                        placeholder="거래처 이메일">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">담당자</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="담당자">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">담당자 연락처</label>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="010">
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                                <div>
                                    
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">담당자 이메일</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="email" id="val-username" name="val-username"
                                        placeholder="담당자 이메일">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">상품명</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="상품명">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">상품수량</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="number" id="val-username" name="val-username"
                                        placeholder="상품수량">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">구매원가</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="number" id="val-username" name="val-username"
                                        placeholder="구매원가">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">판매가</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="number" id="val-username" name="val-username"
                                        placeholder="판매가">
                                </div>
                            </div>
                            

                            <div class="form-group">
                                <div class="col-md-5 col-md-offset-5">
                                	<input class="btn  btn-primary" type="submit" value="등록">
                                    <input class="btn  btn-default" type="reset" value="취소">
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end row -->
            
            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	주문 전체 목록</h2>
                        <div class="table-responsive">
                        <div class="form-group">
                        </div>
                        <div class="col-md-1 col-md-offset-0">
                                <input class="btn  btn-default" type="submit" value="삭제">
                            </div>
                            <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <td style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </td>
                                        <th>주문번호</th>
                                        <th>주문일자</th>
                                        <th>납기요청일자</th>
                                        <th>거래처명</th>
                                        <th>주문자</th>
                                        <th>주문자연락처</th>
                                        <th>상품명</th>
                                        <th>수량</th>
                                        <th>판매가</th>
                                        <th>담당자</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">21424582</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>삼익전자</td>
                                        <td>우창준</td>
                                        <td>032-333-4423</td>
                                        <td>냉장고</td>
                                        <td>270개</td>
                                        <td>900,000원</td>
                                        <td>김철수</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">234234324</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>이노텍</td>
                                        <td>구지현</td>
                                        <td>032-253-4423</td>
                                        <td>노트북</td>
                                        <td>630개</td>
                                        <td>880,000원</td>
                                        <td>김철수</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">34525443</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>SGS</td>
                                        <td>홍길동</td>
                                        <td>032-333-4423</td>
                                        <td>공기청정기</td>
                                        <td>550개</td>
                                        <td>500,000원</td>
                                        <td>김철수</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">2343214</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>인터텍</td>
                                        <td>김재중</td>
                                        <td>032-333-4423</td>
                                        <td>선풍기</td>
                                        <td>150개</td>
                                        <td>800,000원</td>
                                        <td>김철수</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">2341244</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>엘지</td>
                                        <td>고찬호</td>
                                        <td>032-333-4423</td>
                                        <td>아이폰</td>
                                        <td>100개</td>
                                        <td>1,200,000원</td>
                                        <td>김철수</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">2342244</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>삼성</td>
                                        <td>김동혁</td>
                                        <td>032-333-4423</td>
                                        <td>이북</td>
                                        <td>200개</td>
                                        <td>700,000원</td>
                                        <td>김철수</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                </div>
                <!--End row-->
            <div>

            </div>
        </div>
        <!-- End Wrapper-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
</body>
</html>