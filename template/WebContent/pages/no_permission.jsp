<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="org.springframework.context.ApplicationContext, org.springframework.transaction.annotation.Transactional, org.springframework.web.context.support.WebApplicationContextUtils" %>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
    ServletConfig servletConfig = getServletConfig();
    ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>晶片中心-報名系統</title>
</head>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	    
	});
	
</script>

<body>
<table class="serachtb" border="1" cellpadding="3" cellspacing="0" width="100%">
<tr>
    <td>
    <p>
	很抱歉，此功能限老師身份使用!
	</p>
	</td>
</tr></table>
</body>

</html>