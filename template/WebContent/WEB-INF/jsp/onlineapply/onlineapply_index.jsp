<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page
	import="java.util.*, 
	javax.servlet.http.HttpServletRequest ,com.opensymphony.xwork2.ognl.OgnlValueStack "%>
<%@page
	import="org.springframework.context.ApplicationContext, 
	org.springframework.transaction.annotation.Transactional, 
	org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	ServletConfig servletConfig = getServletConfig();
	ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
	
	//ICommonCodeService commonCodeService = (ICommonCodeService)context.getBean("commonCodeService");
	//OgnlValueStack stack = (OgnlValueStack) request.getAttribute("struts.valueStack");
%>
<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="decorator" content="menu"/>
	<title>線上申請功能</title>
	 
	<!-- jquery lib -->
	<script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
	
	<!-- blockUI lib -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-blockUI-2.7/jquery.blockUI-2.7.js"></script>
	
	<!-- fancybox lib -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/fancybox-2.16/jquery.fancybox.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery/plugin/fancybox-2.16/jquery.fancybox.css" type="text/css" media="screen" />
</head>

<style type="text/css">
    /* change table hover color */
    .table-hover tbody tr:hover td{
        background-color: yellow;
        color: red; 
    }
    
    .row{
	    margin-top:40px;
	    padding: 0 10px;
	}
	
	.clickable{
	    cursor: pointer;   
	}
	
	.panel-heading span {
	    margin-top: -20px;
	    font-size: 15px;
	}
</style>
 
<script type="text/javascript">

	var contextPath = "${pageContext.request.contextPath}";

	$(document).ready(function() {

	    $("#queryBt").click(function() {
            
            //設定為第一頁
            $("#number").val(1);
            
            $.blockUI({ message: '<div>查詢中...</div>'});
            
            $("#dataForm").attr("action", contextPath + "/onlineapply/query.action");
            $("#dataForm").submit();
        });
	});

	function pageSubmit(){

		$.blockUI({ 
			message: '<div>處理中...</div>',
			css: {	 
	            border: 'none',
	            padding: '15px',
	            backgroundColor: '#000',
	              '-webkit-border-radius': '10px',
	              '-moz-border-radius': '10px',
	            opacity: .5,
	            color: '#fff'
			}
        });

		setTimeout(function () {  
		    $.ajax({
		        url : contextPath + "/onlineapply/doModify.action",
		        type : 'post',
		        data : $("#dataForm").serialize(),
		        dataType : "json",
		        async: false,
		        cache: false,
		        success : function(response) {
		            $.unblockUI();
	  
		            if(response.isSuccess == "Y"){
		                alert("修改成功");
		                //parent.$.fancybox.close();
		                
		            } else{
		                alert(response.msg);
		            }
		        },
		        error : function(xhr, ajaxOptions, thrownError) {
		            $.unblockUI();
		            alert('請求發生錯誤:' + thrownError);
		        },
		        complete : function (){
	                $.unblockUI();
	            }
		    });
		},100);  
	}

    /*
     * 編輯
     */
    function editData(id){
    	
        var param = "&queryVo.id=" + id;
        $.fancybox.open({
            'width'             : 800,
            'height'            : 250,
            //'padding'           : 0,
            'autoScale'         : false,
            'autoSize'          : false,
            'autoDimensions'    : false,
            'transitionIn'      : 'none',
            'transitionOut'     : 'none',
            'centerOnScroll'    : true,
            'hideOnOverlayClick': false,
            //'href'              : "http://tw.yahoo.com",
            'href'              : contextPath + "/onlineapply/initModifyPage.action?1=1" + param,
            'type'              : 'iframe',
            'afterClose'        : function() {
            //                         refreshPage();
                                  }
        });
    }
    
	function refreshPage(){
        //$.blockUI({ message: '<div>網頁資訊重新整理中...</div>'});
        $("#dataForm").attr("action", "${pageContext.request.contextPath}/onlineapply/query.action");
        $("#dataForm").submit();
    }
    //===============================分頁method=================================
    function goFirstPage() {
        $("#number").val(1);

        $("#dataForm").attr("action", "${pageContext.request.contextPath}/onlineapply/query.action");
        $("#dataForm").submit();
    }

    function goPage() {
        $("#dataForm").attr("action", "${pageContext.request.contextPath}/onlineapply/query.action");
        $("#dataForm").submit();
    }

    function goPrePage() {
        $("#number").val(parseInt($("#number").val()) - 1);

        $("#dataForm").attr("action", "${pageContext.request.contextPath}/onlineapply/query.action");
        $("#dataForm").submit();
    }

    function goNextPage() {
        $("#number").val(parseInt($("#number").val()) + 1);
        $("#dataForm").attr("action", "${pageContext.request.contextPath}/onlineapply/query.action");
        $("#dataForm").submit();
    }

    function goLastPage() {
        $("#number").val("${pagingVo.totalPage}");
        $("#dataForm").attr("action", "${pageContext.request.contextPath}/onlineapply/query.action");
        $("#dataForm").submit();
    }
    
    function enterPageSize(myfield,e){
        var keycode;
        if (window.event) keycode = window.event.keyCode;
        else if (e) keycode = e.which;
        else return true;
    
        if (keycode == 13){
           goFirstPage();
           return false;
        }else{
           return true;
        }
    }
    //===============================分頁method=================================
    //-->  
</script>
 
<body id="bodyId">
	<div class="panel panel-primary">
         <div class="panel-heading">
             <h1 class="panel-title text-center">查詢條件</h1>
             <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
         </div>
         <div class="panel-body">
             <table class="table table-striped table-bordered table-condensed table-sm" width="100%" >
                 <tbody class="thead-inverse">
                     <tr align="center">    
                          <td align="left">教授名稱：</td>     
                          <td align="left">
                             <input type="text" id="" name="">
                          </td>            
                      </tr>
                      <tr align="center">    
                          <td align="left">學校名稱：</td>     
                          <td align="left">
                             <input type="text" id="" name="">
                          </td>            
                      </tr>
                 </tbody>
                 <tfoot>
                     <tr align="center">    
                          <td align="center" colspan="2">
                             <div class="btn-group">
                                 <button type="button" id="editBt" name="editBt" class="btn btn-default" onclick="editData('<s:property value="id"/>')" >
                                  <span class="glyphicon glyphicon-search"></span> 查詢
                                 </button>
                             </div>
                          </td>                
                      </tr>
                 </tfoot>
             </table>            
         </div>
     </div>
     <div class="panel panel-primary">
         <div class="panel-heading">
             <h1 class="panel-title text-center">查詢結果</h1>
             <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
         </div>
         <div class="panel-body">
	         <table class="table table-striped table-bordered table-hover table-condensed table-sm" width="100%" >
	             <thead>
	                <tr class="bg-info">
	                   <th>編號</th>
	                   <th>訊息</th>
	                   <th>修改</th>
	                </tr>
	             </thead>
	             <tbody class="thead-inverse">
	                 <s:if test="null != pagingVo.dataList && !pagingVo.dataList.isEmpty()">
	                     <s:iterator value="pagingVo.dataList" var="model" status="st">
	                         <tr align="center">    
	                             <td align="left" scope="row">
	                                 <s:property value="nvno"/>
	                             </td>     
	                             <td align="left" scope="row">
	                                 <s:property value="msg"/>
	                             </td>
	                             <td align="left">                                    
	                                   <button type="button" id="editBt" name="editBt" class="btn btn-default" onclick="editData('<s:property value="id"/>')" >
	                                   <span class="glyphicon glyphicon-edit"></span> 修改
	                                   </button> 
	                                   <button type="button" id="editBt" name="editBt" class="btn btn-default" onclick="editData('<s:property value="id"/>')" >
	                                   <span class="glyphicon glyphicon-minus"></span> 刪除
	                                   </button>
	                                   <button type="button" id="editBt" name="editBt" class="btn btn-default" onclick="editData('<s:property value="id"/>')" >
	                                   <span class="glyphicon glyphicon-minus"></span> 刪除
	                                   </button>                            
	                             </td>                
	                         </tr>
	                     </s:iterator>
	                </s:if>
	             </tbody>
	         </table>
	         <s:if test="null!=pagingVo.dataList && !pagingVo.dataList.isEmpty()">
	             <ul class="pager">
	                 <li><a href="#" onclick="Javascript:goFirstPage();return false;" class="pagejumpcurr">最前頁</a></li> 
	                 <s:if test="pagingVo.number != 1">
	                     <li><a href="#" onclick="Javascript:goPrePage();return false;" class="pagejumpcurr">上一頁</a></li>                     
	                 </s:if>
	                 <li><s:select id="number" name="pagingVo.number" value="pagingVo.number" list="pagingVo.pageList" onchange="goPage();"></s:select></li>
	                 <s:if test="pagingVo.number != pagingVo.totalPage">
	                     <li><a href="#" onclick="Javascript:goNextPage();return false;" class="pagejumpcurr">下一頁</a>  </li>                     
	                 </s:if>
	                 <li><a href="#" onclick="Javascript:goLastPage();return false;" class="pagejumpcurr">最後頁</a></li>
	                 &nbsp;&nbsp;每頁顯示<input type="text" id="size" name="pagingVo.size" value="<s:property value="pagingVo.size"/>" size="3" onKeyPress="enterPageSize(this,event);"  />筆 
	                 &nbsp;&nbsp;共&nbsp;<s:property value="pagingVo.total"/>&nbsp;筆資料                   
	             </ul> 
	         </s:if>
        </div>	         
     </div>
</body>
</html>