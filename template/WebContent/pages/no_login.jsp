<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>晶片中心</title>

</head>

<style type="text/css">

    #middle {
	    position:absolute; height:500px;  
	    top:0; bottom:0; left:0; right:0; margin:auto;
	}
</style>

<script type="text/javascript">

    var contextPath = "${pageContext.request.contextPath}";
    $(document).ready(function() {
    	
        setTimeout(toLoginPage, 5000); //10秒刷新頁面
    });
    
    function toLoginPage(){
    	window.location = contextPath + "/login/init.action";
    }
</script>

<body>

    <div class="container">  
        <div id="middle" class="col-md-4 col-md-offset-4">
            <div class="panel panel-warning" >
	            <div class="panel-heading">
	                <h3 class="panel-title text-center">
	                   國家晶片提醒您
	                </h3>
	            </div>
	            <div class="panel-body">
	                您尚未登入, 十秒後系統將自動轉到登入頁....
	
	            </div>
            </div>
        </div>     
    </div>
    
</body>

</html>