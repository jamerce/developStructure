<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>檔案上傳失敗</title>
</head>

<body>
	<table class="dtltb" border="1" cellpadding="3" cellspacing="0"	width="100%">
		<tr>
			<th class="title">檔案上傳失敗</th>
		</tr>
		<tr>
			<td>
                <s:fielderror />
			</td>
		</tr>
		<tr>
            <td align="center">
                <input type="button" name="returnBt" value="回上一頁" onclick="history.go(-1);">
            </td>
        </tr>
	</table>
</body>
</html>