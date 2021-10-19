<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- 자산 -->
<!-- 현금및현금성자산(보통예금 기말잔액)  -->
<c:set var="cash_asets" value="${dto.cash_asets}"/>

<!-- 매출채권(외상매출금) -->
<c:set var="accounts_receivable" value="${dto.accounts_receivable}"/>

<!-- 부가세대급금(미리낸세금)  -->
<c:set var="vatPayment" value="${dto.vatPayment}"/>
<!-- 당좌자산 합계 -->
<c:set var="asset1" value="${cash_asets + accounts_receivable + vatPayment}"/>

<!-- 상품재고액 -->
<c:set var="inventory_assets" value="${dto.inventory_assets}"/>
<!-- 재고자산 합계-->
<c:set var="asset2" value="${dto.inventory_assets}"/>

<!-- 자산총계  -->
<c:set var="asset3" value="${asset1 +asset2}"/>

<!--  부             채  -->
<!-- Ⅰ. 유  동    부  채   -->
<!-- 외상매입금  -->
<c:set var="purchase_receivable" value="${dto.purchase_receivable}"/>
<!-- 부가세예수금(받은세금) -->
<c:set var="vatDeposit" value="${dto.vatDeposit}"/>
<!-- 부채총계  -->
<c:set var="asset4" value="${purchase_receivable + vatDeposit}"/>

<!--   Ⅰ. 자      본      금     -->
<!-- 자본금(기초설정이 없어서 100,000,000 임의설정) -->
<c:set var="capital" value="${dto.capital}"/>
<!-- 자본금  -->
<c:set var="asset5" value="${capital}"/>

<!-- 이익잉여금(회사설립후 벌어들인 이익중 주주들에게 배당하지 않고 회사내부적립한 과거이익의 누계) -->
<!-- 법정적립금,임의적립금,미처분이익잉여금으로 구분 -->

<!-- 자    본    총    계(자본금계정 아님) 자본잉여금과 이익잉여금을 포함한 자기자본  -->
<!-- 자본총계 = 자산총계 - 부채총계  --> 
<c:set var="asset6" value="${asset3-asset4}"/>                          
<!--부 채 및 자 본 총 계 (총자본은 자산총계와 동일) -->
<!-- 총자본 = 자본총계 + 부채총계 -->                           
<c:set var="asset7" value="${asset6+asset4}"/>  






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
<c:set var="sales_cost" value="${dto2.sales_cost}"/>
<!-- 제품매출 없음(제조업만 있음) -->

<!-- 기초상품재고액 -->
<!-- 전기이월이 없어서 임의설정  -->
<c:set var="basic_product" value="${dto2.basic_product}"/>

<!-- 당기상품재고액 -->
<!-- 당해년도 총 상품매입액 --> 
<c:set var="current_product" value="${dto2.current_product}"/>

<!-- 기말상품재고액 -->
<!-- 기말상품재고액 = 전기이월된 기초재고액 + 당기상품재고액 -->
<c:set var="end_product" value="${dto2.basic_product + dto2.current_product}"/>

<!-- 매출책, 매출총이익 -->
<!-- 매출총이익 = 상품매출 + 제품매출 -->
<c:set var="income1" value="${sales_cost}"/>


<!-- 판관비(영업활동에 관련된 모든 지출) -->
<!-- 직원급여  -->
<c:set var="employee_salary" value="${dto2.employee_salary}"/>
<!-- 복리후생비 -->
<c:set var="employee_benefits" value="${dto2.employee_benefits}"></c:set>
<!-- 여비교통비 -->
<c:set var="travel_expenses" value="${dto2.travel_expenses}"></c:set>
<!-- 접대비 -->
<c:set var="entertainment" value="${dto2.entertainment}"></c:set>
<!-- 통신비 -->
<c:set var="communication_cost" value="${dto2.communication_cost}"></c:set>
<!-- 수도광열비 -->
<c:set var="water_utility_bill" value="${dto2.water_utility_bill}"></c:set>
<!-- 세금과공과금 -->
<c:set var="taxes_and_duties" value="${dto2.taxes_and_duties}"></c:set>
<!-- 지급임차료 -->
<c:set var="paid_rent" value="${dto2.paid_rent}"></c:set>
<!-- 보험료 -->
<c:set var="premium" value="${dto2.premium}"></c:set>
<!-- 차량유지비 -->
<c:set var="vehicle_maintenance_cost" value="${dto2.vehicle_maintenance_cost}"></c:set>
<!-- 사무용품비 -->
<c:set var="office_supplies" value="${dto2.office_supplies}"></c:set>
<!-- 소모품비 -->
<c:set var="consumables_cost" value="${dto2.consumables_cost}"></c:set>

<!-- 판관비합계(계정과목 추가시 합산) -->

<c:set var="income2" value="${employee_salary + employee_benefits + travel_expenses + entertainment + communication_cost + water_utility_bill + taxes_and_duties + paid_rent + premium + vehicle_maintenance_cost + office_supplies + consumables_cost}"/>

<!-- 영업이익  -->
<!-- 영업이익 = 매출총이익 - 판관리비  -->
<c:set var="income3" value="${income1 - income2}"/>             	

<!-- 영업외수익 non-operating income  -->
<c:set var="interest_income" value="${dto2.interest_income}"/>

<!-- 영업활동외적으로 벌어들인 수입(예) 이자수입,수입임대료,유형자산처분이익등  --> 
<c:set var="income4" value="${dto2.interest_income}"/>             	

<!-- 영업외비용 non-operating expenses -->
<!-- 이자비용  -->
<c:set var="interest_expense" value="${dto2.interest_expense}"/>

<!-- 영업활동외적으로 나간 지출 (예) 이자비용  -->              	
<c:set var="income5" value="${dto2.interest_expense}"/>             	

<!-- 법인세 차감전 순이익  -->
<c:set var="income6" value="${income3 + income4 -income5}"/>             	

<!-- 법인세비용  -->
<c:set var="income7" value="${dto2.corporate_tax}"/>             	

<!-- 당기순이익 -->
<!-- 당기순이익 = 법인세차감전순이익 - 법인세비용  -->
<c:set var="income8" value="${income6 - income7}"/>             	                        
