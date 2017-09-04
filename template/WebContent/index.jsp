<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>國家晶片中心-報名系統</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="報名系統,keyword2,keyword3">
<meta http-equiv="description" content="國家晶片中心-報名系統">

</head>

<script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>

<script language="javascript">
	var contextPath = "${pageContext.request.contextPath}";
	window.location = contextPath + "/login/init.action";
</script>

<body>
網址正在轉向中…
</body>

</html>
