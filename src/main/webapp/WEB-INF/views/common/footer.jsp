<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Start  Footer -->
<footer class="footer-main"> Copyright &copy; 2021 KU Ultimate Co.,Ltd All Rights Reserved </footer>
<!--End footer -->
<!--End main content -->
<!--Begin core plugin -->
<script src="${RESOURCES_PATH}/assets/js/jquery.min.js"></script>
<script src="${RESOURCES_PATH}/assets/js/bootstrap.min.js"></script>
<script src="${RESOURCES_PATH}/assets/plugins/moment/moment.js"></script>
<script src="${RESOURCES_PATH}/assets/js/jquery.slimscroll.js "></script>
<script src="${RESOURCES_PATH}/assets/js/jquery.nicescroll.js"></script>
<script src="${RESOURCES_PATH}/assets/js/functions.js"></script>
<!-- End core plugin -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${RESOURCES_PATH}/assets/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${RESOURCES_PATH}/assets/pages/validation-custom.js"></script>
<!-- BEGIN PAGE LEVEL SCRIPTS -->

<!--Begin Page Level Plugin-->
<script src="${RESOURCES_PATH}/assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="${RESOURCES_PATH}/assets/pages/table-data.js"></script>

<script src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>
<df-messenger
  intent="WELCOME"
  chat-title="Chatbot"
  agent-id="93c009a0-03a9-4f66-ae86-e30713eaf6b1"
  language-code="ko"
></df-messenger>