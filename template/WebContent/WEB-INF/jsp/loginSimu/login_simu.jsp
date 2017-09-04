<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.*" %>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" /> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>晶片中心-報名系統</title>
</head>

<script language="javascript"  src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
    
    function loginSubmit(){
    	 
        $.ajax({
            url: contextPath + "/loginSimu/login.action",
            type: 'post',
            data: {
                'loginId': jQuery.trim($('#loginId').val())
            },
            dataType: "json",
            success: function(data) {
                //var dataObj = eval(data);//轉換為json對象 
                
                alert(data);
            },
            error: function(xhr) {
                alert('Ajax request 發生錯誤');
            }
        });
    }
    function logout(){
        
        $.ajax({
            url: contextPath + "/loginSimu/ajaxLogout.action",
            type: 'post',
            dataType: "json",
            success: function(data) {
                //var dataObj = eval(data);//轉換為json對象 
                
                alert(data);
            },
            error: function(xhr) {
                alert('Ajax request 發生錯誤');
            }
        });
    }
    
</script>

<body>
<form id="form1" name="form1" method="post" action="">
	<p/>
  <table width="40%" height="104" border="1" align="center" cellpadding="0" cellspacing="0">
  	<tr>
  		<td colspan="2" align="center" style="font-size: 14pt">報名系統</td>
  	</tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#6699FF"><font color="#FFFFFF"><strong>使用者登入</strong></font></td>
    </tr>
    <tr>
      <td width="28%">登入類型：</td>
      <td width="72%">
      PM003628 - 乙教授
      <br/>
      PM003627 - 甲教授
      <br/>
      PM003748 - 丙老師
      <br/>
      SM003634 - 學生六
      <br/>
      SM003635 - 學生七
      <br/>
      SM003630 - 學生二
      <br/>
      SM003884 - 曾小文
      <br/>
      IN003924 - 廠商一
      <br/>
      SM003782 - 學生一
      <br/>
      EM0704123 - CIC成員 
      <%-- <select name="loginId" id="loginId">
        <option value="PM003628" selected="selected">乙教授</option>
        <option value="SM003634">學生六</option>
        <option value="SM003635">學生七</option>
        <option value="LM004567">廠商一</option>
      </select> --%></td>
    </tr> 
    <tr>
      <td width="17%">帳號：</td>
      <td width="83%"><input type="text" name="loginId" id="loginId" /></td>
    </tr>
    <tr>
      <td colspan="2">
      <input type="button" name="button" id="button" onClick="loginSubmit()" value="送出" />
      <input type="button" name="button" id="button" onClick="logout()" value="「登出」" />
      </td>
    </tr>
  </table>
  <br/>
</form>
</body>
</html>