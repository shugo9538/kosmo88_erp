<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ROOT_PATH" value="${pageContext.request.contextPath}" />
<c:set var="RESOURCES_PATH" value="${ROOT_PATH}/resources" />
<c:set var="IMG_PATH" value="${RESOURCES_PATH}/common/img" />
<c:set var="UPLOAD_PATH" value="${style_path}/common/img" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<sec:csrfMetaTags/>
<link rel="icon" href="${RESOURCES_PATH}/assets/images/favicon.png" type="image/png">
<title>우여곡절 ERP</title>
<!--Begin  Page Level  CSS -->
<link href="${RESOURCES_PATH}/assets/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet" />
<link href="${RESOURCES_PATH}/assets/plugins/datatables/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
<link href="${RESOURCES_PATH}/assets/plugins/datatables/css/jquery.dataTables-custom.css" rel="stylesheet" type="text/css"/>

  
<!--End  Page Level  CSS -->
<link href="${RESOURCES_PATH}/assets/css/icons.css" rel="stylesheet">
<link href="${RESOURCES_PATH}/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="${RESOURCES_PATH}/assets/css/temp_bootstrap.css" rel="stylesheet">
<%-- <link href="${RESOURCES_PATH}/assets/css/style.css" rel="stylesheet"> --%>
<link href="${RESOURCES_PATH}/assets/css/responsive.css" rel="stylesheet">
</head>

<!-- accountDetail.jsp -->
<link href="/logistics_erp/resources/accounting/css/accountDetail_style.css" rel="stylesheet">
