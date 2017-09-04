<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.opensymphony.xwork2.ognl.OgnlValueStack "%>
<%@page import="org.springframework.context.ApplicationContext, org.springframework.web.context.support.WebApplicationContextUtils"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>


<!DOCTYPE html>
<html>
<head>
	<title><decorator:title default="國研院晶片中心" /></title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="國研院晶片中心" />
	<meta name="keywords" content="國研院晶片中心" />
	<meta name="Robots" content="all" />

    <!-- jQuery lib -->
    <script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
    
    <!-- jQuery UI lib -->
    <script language="javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery/plugin/jquery-ui-1.12.1/jquery-ui.css" type="text/css" media="screen" />
     
    <!-- jQuery timepicker lib -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery/plugin/jquery-ui-timepicker/jquery-ui-timepicker-addon.min.css" type="text/css" />
    <script language="javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-ui-timepicker/jquery-ui-timepicker-addon.min.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-ui-timepicker/jquery-ui-sliderAccess.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-ui-timepicker/jquery-ui-timepicker-zh-TW.js"></script>
    
    <!-- blockUI lib -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-blockUI-2.7/jquery.blockUI-2.7.js"></script>
    
    <!-- calandar -->
    <script language="javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    
    <!-- fancybox lib --> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/fancybox-2.16/jquery.fancybox.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery/plugin/fancybox-2.16/jquery.fancybox.css" type="text/css" media="screen" />

    <!-- ginger's css -->
    <%-- <link href="${pageContext.request.contextPath}/css/pflag_main.css" rel="stylesheet" type="text/css" /> --%>
    
    <!-- bootstrap lib -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-3.3.7/css/bootstrap.min.css" type="text/css" />
    
    <!-- jQuery Nicescroll CDN -->
    <script src="${pageContext.request.contextPath}/js/jquery/plugin/jquery.nicescroll-3.7.6/jquery.nicescroll.min.js"></script>
           
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css">
    <!-- HTML5 Shim 和 Respond.js 用於讓 IE8 支持 HTML5元素和媒體查詢 -->
      <!-- 注意： 如果通過 file://  引入 Respond.js 文件，則該文件無法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
      
      <decorator:head />
</head>

<style type="text/css">
</style>

<script type="text/JavaScript">
	var contextPath = '${pageContext.request.contextPath}';

	$(document).on('click', '.panel-heading span.clickable', function(e){
        var $this = $(this);
        if(!$this.hasClass('panel-collapsed')) {
            $this.closest('.panel').find('.panel-body').slideUp();
            $this.addClass('panel-collapsed');
            $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
        } else {
            $this.closest('.panel').find('.panel-body').slideDown();
            $this.removeClass('panel-collapsed');
            $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
        }
    })
    
	$(document).ready(function () {

        $("#sidebar").niceScroll({
            cursorcolor: '#53619d',
            cursorwidth: 4,
            cursorborder: 'none'
        });

        $('#sidebarCollapse').on('click', function () {
            $('#sidebar, #content').toggleClass('active');
            $('.collapse.in').toggleClass('in');
            $('a[aria-expanded=true]').attr('aria-expanded', 'false');
        });
    });

</script>

<body id="bodyId">

	<div class="wrapper">
	    <jsp:include page="menu.jsp"></jsp:include>
	    <!-- Page Content Holder -->
	    <div id="content">
	        <!-- 內容開始 --> <decorator:body /> <!-- 內容結束 -->
	    </div>
	</div>
</body>
</html>
