<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--
// 손익계산서
순매출액 (총매출액-매출에누리,매출할인,매출환입)
매출원가 ( 기초상품재고액 + 당기상품매입액(순매입액) - 기말상품재고액 )
------------				순매입액 = 총매입액-매입에누리,매입할인,매입환출     
    매출총이익
- 판매비 및 관리비		*(운반비) 매입 : 총매입엑에 더한다(가산) / 매출 : 운반비계정과목 별도처리
----------
    영업이익
+ 영업외수익													
- 영업외비용
--------------------
    법인세차감전순이익
- 법인세비용
--------------
당기순이익
-->

<!-- 매출액  -->

<!-- 매출액 = 상품매출 + 제품매출  -->
<!-- 상품매출  -->
<c:set var="sales_cost" value="${dto.sales_cost}"/>
<!-- 제품매출 없음(제조업만 있음) -->

<!-- 기초상품재고액 -->
<!-- 전기이월이 없어서 임의설정  -->
<c:set var="basic_product" value="${dto.basic_product}"/>

<!-- 당기상품재고액 -->
<!-- 당해년도 총 상품매입액 --> 
<c:set var="current_product" value="${dto.current_product}"/>

<!-- 기말상품재고액 -->
<!-- 기말상품재고액 = 전기이월된 기초재고액 + 당기상품재고액 -->
<c:set var="end_product" value="${dto.basic_product + dto.current_product}"/>

<!-- 매출책, 매출총이익 -->
<!-- 매출총이익 = 상품매출 + 재품매출 -->
<c:set var="income1" value="${sales_cost}"/>


<!-- 판관비(영업활동에 관련된 모든 지출) -->
<!-- 직원급여  -->
<c:set var="employee_salary" value="${dto.employee_salary}"/>
<!-- 복리후생비 -->
<!-- 소모품비 -->
<!-- 복리후생비 -->
<!-- 복리후생비 -->
<!-- 판관비합계(계정과목 추가시 합산) -->
<c:set var="income2" value="${employee_salary}"/>
 
<!-- 영업이익  -->
<!-- 영업이익 = 매출총이익 - 판관리비  -->
<c:set var="income3" value="${income1 - income2}"/>             	
<!-- 영업외수익 non-operating income  -->
<!-- 영업활동외적으로 벌어들인 수입(예) 이자수입,수입임대료,유형자산처분이익등  -->              	
<c:set var="income4" value="0"/>             	
<!-- 영업외비용 non-operating expenses -->
<!-- 영업활동외적으로 나간 지출 (예) 이자비용  -->              	
<c:set var="income5" value="0"/>             	

<!-- 법인세 차감전 순이익  -->
<c:set var="income6" value="${income3 + income4 -income5}"/>             	
<!-- 법인세비용  -->
<c:set var="income7" value="0"/>             	
<!-- 당기순이익 -->
<!-- 당기순이익 = 법인세차감전순이익 - 법인세비용  -->
<c:set var="income8" value="${income6 - income7}"/>             	


    
    
    
    

    
    