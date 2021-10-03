<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">견 적 서</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal ">
	                <table id="example" class="display table mt-12">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">견적서 번호</th>
	                		<td colspan="3" style="padding:10px;">212234</td>
	                		
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처명</th>
	                		<td style="padding:10px;">삼성</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">대표자</th>
	                		<td style="padding:10px;">홍길동</td>
	                		
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처 연락처</th>
	                		<td style="padding:10px;"> 010-2222-3222</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처 이메일</th>
	                		<td style="padding:10px;">sdafa@naver.com</td>
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자</th>
	                		<td style="padding:10px;">아이유</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 부서</th>
	                		<td style="padding:10px;">영업팀</td>
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 연락처</th>
	                		<td style="padding:10px;">010-3232-2332</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 이메일</th>
	                		<td style="padding:10px;">dksisjd@hanmail.net</td>
	                	</tr>	
	                	
	                </table>
	                
	                <h2 style="font-size:18px; text-align:left;" class="header-title col-md-12 mt-12">total : 5,500,000 원</h2>
	                <table id="example" class="display table ">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">상품명</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">상품종류</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">구매단가</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">수량</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">공급가액</th>
	                	</tr>
	                	<tr>
	                		<td>선풍기</td>
	                		<td>가전제품</td>
	                		<td>50,000원</td>
	                		<td>10</td>
	                		<td>500,000원</td>
	                	</tr>
	                	<tr>
	                		<td>아이폰</td>
	                		<td>전자기기</td>
	                		<td>1,000,000원</td>
	                		<td>15</td>
	                		<td>5,000,000원</td>
	                	</tr>
	                </table>
	                <div style="text-align:center;" class="form-group mt-5 col-md-12">
                            <input class="btn  btn-primary" type="button" value="삭제"
                            	onclick="window.location='clientDelete?client_id=${cdto.id}'"/>
                            <input class="btn  btn-defalte" type="button" value="닫기"
                            	onclick="window.close();"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>
</body>
</html>