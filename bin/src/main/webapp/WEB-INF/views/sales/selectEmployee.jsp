<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">담당자 목록</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal">
	                <table id="example" class="display table">
	                    <thead>
	                        <tr>
	                            <th>사원 번호</th>
	                            <th>담당자 이름</th>
	                            <th>담당자 부서</th>
	                            <th>담당자 연락처</th>
	                            <th>담당자 이메일</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                       	<c:if test="${cnt != 0}">
	                       		<c:forEach var="dto" items="${dtos}">
	                        		<tr>
	                                 <th><input style="border:none;" type="text" id="c_employee_id" value="${dto.id}" readonly></th>
	                                 <td><input style="border:none;" type="text" id="c_employee_name" value="${dto.name}" readonly></td>
	                                 <td><input style="border:none;" type="text" id="c_employee_dp" value="${dto.department_name}" readonly></td>
	                                 <td><input style="border:none;" type="text" id="c_employee_phone" value="${dto.phone}" readonly></td>
	                                 <td><input style="border:none;" type="text" id="c_employee_email" value="${dto.email}" readonly></td>
	                                 <td>
	                                 	<input class="btn  btn-primary" type="button" id="select" name="${dto.id}" value="선택"/>
	                                 </td>
	                             </tr>
	                       		</c:forEach>
	                       	</c:if>
	                       	
	                       	<c:if test="${cnt == 0}">
	                       		<tr>
	                       			<td colspan="6">
	                       				"등록된 영업팀 사원이 없습니다."
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
	
	<script src="${RESOURCES_PATH}/sales/js/selectEmployee.js"></script>
</body>
</html>