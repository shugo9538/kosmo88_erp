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
                <h4 class="page-title">거래처 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">Dashboard</a>
                    </li>
                    <li>
                        <a href="#">Table</a>
                    </li>
                    <li class="active">
                        Data Table
                    </li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->
			<%-- <%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/wms/warehouseList.do">거래처 삭제</a></li>
				<li class="active"><a href="${ROOT_PATH}/saile/clientResister">등록</a></li>
			</ul>
                <!--Start row-->
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box">
                            <h2 class="header-title">전체</h2>
                            <div class="table-responsive">
                                <table id="example" class="display table">
                                    <thead>
                                        <tr>
                                            <th>회사명</th>
                                            <th>사업자번호</th>
                                            <th>대표자명</th>
                                            <th>전화번호</th>
                                            <th>주소</th>
                                            <th>수정일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th><a href="#">이노텍</a></th>
                                            <td>2222-3444-2243</td>
                                            <td>김철수</td>
                                            <td>032-2222-2342</td>
                                            <td>서울 금천구</td>
                                            <td>2021-08-24</td>
                                        </tr>
                                        <tr>
                                            <th><a href="#">삼성</a></th>
                                            <td>1111-2234-1233</td>
                                            <td>감창수</td>
                                            <td>032-2222-5446</td>
                                            <td>경기도 안양시</td>
                                            <td>2021-08-24</td>
                                        </tr>
                                        <tr>
                                            <th><a href="#">대우</a></th>
                                            <td>5555-11234-5522</td>
                                            <td>김영태</td>
                                            <td>032-2222-3423</td>
                                            <td>서울 도봉구</td>
                                            <td>2021-08-24</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--End row-->
                    </div>
            	<div>
            </div>
        </div>
        
        <!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>