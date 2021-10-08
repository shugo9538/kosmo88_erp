<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">상품 목록</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal">
	                <table id="example" class="display table">
	                    <thead>
	                        <tr>
	                            <th>상품 번호</th>
	                            <th>상품명</th>
	                            <th>카테고리</th>
	                            <th>판매가</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                       	<c:if test="${cnt != 0}">
	                       		<c:forEach var="dto" items="${dtos}">
	                        		<tr>
	                                 <td><input style="border:none;" type="text" name="c_item_id2" id="c_item_id2" value="${dto.id}" ></td>
	                                 <td><input style="border:none;" type="text" name="c_item_name2" id="c_item_name2" value="${dto.name}" ></td>
	                                 <td><input style="border:none;" type="text" name="c_category2" id="c_category2" value="${dto.category}" ></td>
	                                 <td><input style="border:none;" type="number" name="c_price2" id="c_price2" value="${dto.price}" ></td>
	                                 <td><input class="btn  btn-primary" type="button" id="select2" name="${dto.name}" value="선택"></td>
	                             </tr>
	                       		</c:forEach>
	                       	</c:if>
	                       	
	                       	<c:if test="${cnt == 0}">
	                       		<tr>
	                       			<td colspan="6">
	                       				"등록된 상품이 없습니다."
	                       			</td>
	                       		</tr>
	                       	</c:if>
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
	
	<script src="${RESOURCES_PATH}/sales/js/selectItem2.js"></script>
</body>
</html>