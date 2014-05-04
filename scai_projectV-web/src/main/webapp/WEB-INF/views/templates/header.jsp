<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<meta charset="UTF-8">
<title>AdminLTE | Dashboard</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link href="<c:url value="/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="<c:url value="/css/ionicons.min.css" />" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="<c:url value="/css/AdminLTE.css" />" rel="stylesheet" type="text/css" />
<!-- jQuery 2.0.2 -->
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js" />"></script>
<!-- Bootstrap -->
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<!-- AdminLTE App -->
<script src="<c:url value="/js/AdminLTE/app.js"/>"></script>
<!-- DatePicker Bootstrap -->
<script src="<c:url value="/js/bootstrap-datepicker.js"/>"></script>
<link href="<c:url value="/css/datepicker.css" />" rel="stylesheet" type="text/css" />
<!-- Jquery Mask -->
<script src="<c:url value="/js/jquery.mask.js"/>"></script>
<script src="<c:url value="/js/mask.js"/>"></script>
