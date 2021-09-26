<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 금융/자금관리(계좌별 상세페이지)  -->
<script src="/logistics_erp/resources/accounting/js/account.js"></script>


<!--  jQuery cdns
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
-->

<!-- jQuery 기본 js -->
<script src="/logistics_erp/resources/assets/js/jquery.min.js"></script>
<!-- jQuery UI 라이브러리 --> 
<script src="/logistics_erp/resources/assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- jQuery datepicker 한국어 전환 --> 
<script src="/logistics_erp/resources/accounting/js/datepicker-ko.js"></script>

<script type="text/javascript">
/* datepicker */
$(function(){
	// 매입매출장 목록
    $("#statd_date").datepicker(); // 검색시작일
    $("#end_date").datepicker(); // 검색 마지마막일
    $("#date1").datepicker();
});
</script>
