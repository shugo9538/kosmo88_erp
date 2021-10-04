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
<c:set var="asset4" value="${accounts_receivable + vatDeposit}"/>

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
