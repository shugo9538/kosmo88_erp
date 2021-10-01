<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">거래처 목록</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal ">
	                <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <th>거래처 번호</th>
                                        <th>회사명</th>
                                        <th>대표자명</th>
                                        <th>전화번호</th>
                                        <th>선택</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="dto" items="${dto}">
                                		<input type="hidden" id="c_email" name="c_email" value="${dto.email}">
                                		<input type="hidden" id="c_zip_code" name="c_zip_code" value="${dto.zip_code}">
                                		<input type="hidden" id="c_address" name="c_address" value="${dto.address}">
                                		<input type="hidden" id="c_detail_address" name="c_detail_address" value="${dto.detail_address}">
                                		<tr>
	                                        <td>
	                                        	<input style="border:none;" type="text" id="c_id" name="c_id" value="${dto.id}">
	                                        </td>
	                                        <th><input style="border:none;" type="text" id="c_name" name="c_name" value="${dto.name}"></th>
	                                        <td><input style="border:none;" type="text" id="c_ceo_name" name="c_ceo_name" value="${dto.ceo_name}"></td>
	                                        <td><input style="border:none;" type="text" id="c_phone" name="c_phone" value="${dto.phone}"></td>
	                                        <td>
	                                        	<input class="btn  btn-primary" type="button" id="select" name="${dto.id}" value="선택"/>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                           </tbody>
                       </table>
                       <div style="text-align:center;" class="form-group mt-5 col-md-12">
                            <input class="btn  btn-primary" type="button" value="닫기"
                            	onclick="window.close();"/>
                   	 </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>
	
	<script src="${RESOURCES_PATH}/sales/js/selectClient.js"></script>
</body>
</html>