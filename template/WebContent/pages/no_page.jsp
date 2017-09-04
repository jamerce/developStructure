<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>無此頁面</title>
<style type="text/css">
body {
	background-color: #fff;
	color: #666;
	text-align: center;
	font-family: arial, sans-serif;
}

table.dialog {
	width: 700px;
	padding: 0 4em;
	margin: 4em auto 0 auto;
	border: 1px solid #ccc;
	border-right-color: #999;
	border-bottom-color: #999;
}

h1 {
	font-size: 100%;
	color: #f00;
	line-height: 1.5em;
}
</style>
</head>
<body>
    <table class="dialog">
        <tr><td align="center" bgcolor="#DFDFDF">國家晶片中心管理網站訊息</td></tr>
        <tr><td>
            <h1>很抱歉！您所連結的網頁目前並不存在或是此頁面正在維護中…</h1>
          您可以選擇：<br />
            <a href="javascript:history.go(-1)">返回上一頁</a>重新再操作<br />
            <br />
        </td></tr>
    </table>
	
</body>
</html>