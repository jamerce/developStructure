<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Sidebar Holder -->
<nav id="sidebar">
    <div class="sidebar-header">
        <h3>Bootstrap Sidebar</h3>
        <div><span class="glyphicon glyphicon glyphicon-globe"></span> 部門別：<s:property value="#session._LOGIN_USER_.companyDeptName" /></div>
        <div><span class="glyphicon glyphicon-user"></span> 登入者：<s:property value="#session._LOGIN_USER_.memberName" /> 您好</div>
    </div>

    <ul class="list-unstyled components">
        <p>功能清單</p>
        
        <s:iterator value="#session._MENU_" var="model" status="st">
        	<!-- 當要顯示目前所點的menu時，要將 li class=active, 還要設定 aria-expanded=true, ul class=collapse in -->
        	<li class="active">  
        		
	            <a href="#<s:property value="#st.index"/>Submenu" data-toggle="collapse" aria-expanded="true"><span class="glyphicon glyphicon-leaf"></span>&nbsp;<s:property value="#model.nodeName"/></a>
	            <ul class="collapse in list-unstyled" id="<s:property value="#st.index"/>Submenu">
	            	<s:iterator value="#model.subNodeList" var="subNodeModel">
	                	<li><a href="${pageContext.request.contextPath}<s:property value="#subNodeModel.url"/>"><span class="glyphicon glyphicon-chevron-right"></span>&nbsp;<s:property value="#subNodeModel.nodeName"/></a></li>
	                </s:iterator>
	            </ul>
	        </li>
        </s:iterator>
        <li>
            <a href="#"><span class="glyphicon glyphicon-leaf"></span>&nbsp;Contact</a>
        </li>
    </ul>
    <ul class="list-unstyled CTAs">
        <li>
            <a href="${pageContext.request.contextPath}/login/doLogout.action" class="article">登出</a>
        </li>
    </ul>
</nav>