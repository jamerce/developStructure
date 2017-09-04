<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="decorator" content="home" />
	
	<title>報名系統</title>
	 
	<!-- jquery lib -->
	<script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
	
	<!-- blockUI lib -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-blockUI-2.7/jquery.blockUI-2.7.js"></script>
	
	<!-- fancybox lib -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/fancybox-2.16/jquery.fancybox.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery/plugin/fancybox-2.16/jquery.fancybox.css" type="text/css" media="screen" />
</head>

<style type="text/css">

</style>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(document).ready(function() {

	    
	});
</script>
 
<body id="bodyId">
	<div class="panel panel-primary">
            <div class="panel-heading">
                <h1 class="panel-title text-center">歡迎光臨</h1>
            </div>
            <div class="panel-body">
                
            </div>
        </div>
</body>
</html>