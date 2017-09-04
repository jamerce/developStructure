<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String decorator = request.getParameter("decorator");
%>
<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>檔案下載失敗</title>
</head>

<body>
	<table class="dtltb" border="1" cellpadding="3" cellspacing="0"	width="100%">
		<tr>
			<th class="title">檔案下載失敗</th>
		</tr>
		<tr>
			<td><div id="test">
                <s:if test="hasActionMessages()">
				    <s:iterator value="actionMessages">
				        <script language="JavaScript">
				            alert("<s:property escape="false"/>");
				        </script>
				    </s:iterator>
				</s:if>
				<s:set var="errorMsg" value="" />
				<s:if test="hasActionErrors()">
				    <s:set var="errorMsg"><s:actionerror /></s:set>
				</s:if>
				<s:property value="#errorMsg.replace('/r/n', '<br/>')" />
			    <script language="JavaScript">
			        alert('<s:property value="errorMsg" escape="false" />');
                </script>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>