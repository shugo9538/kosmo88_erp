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

<!-- 매입매출전표페이지 salesSlipList.jsp  -->
<script type="text/javascript">
/* datepicker */
$(function(){
	// 매입매출장 목록
    $("#statd_date").datepicker(); // 검색시작일
    $("#end_date").datepicker(); // 검색 마지마막일
    $("#date1").datepicker();
});
</script>


<!-- 통장추가페이지 accountNewDetail.jsp -->
<script type="text/javascript">
//input 요소의 name을 키로 그 요소에 체크할 항목들로 작성된다.
$(function({
	$('#account_insert_from').validate({
		//신규통장추가 페이지
		rules:{  /*체크할 validation 항목*/
			account_number : {
				required:true,
				rangelength:[5,20]
			}
		},
		messages:{  //validation실패시 보여줄 메세지
			
			account_number : {
				required: "계좌번호는 필수 입력 입니다.",
				rangelength:"계좌번호는 {10}에서{20}자리까지 사용 가능합니다."
			}
		}
		
	});
	
});
</script>




