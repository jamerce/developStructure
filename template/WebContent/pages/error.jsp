<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>錯誤頁</title>
</head>
<body>
	<table class="serachtb" border="1" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
			    <s:if test="hasActionErrors()">
					<div class="errors">
						<s:actionerror />
					</div>
				</s:if>
				<s:fielderror />
			</td>
		</tr>
	</table>

</body>
</html>