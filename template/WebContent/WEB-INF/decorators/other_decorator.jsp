<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page
    import="java.util.*, java.math.BigDecimal,
    javax.servlet.http.HttpServletRequest,
    com.opensymphony.xwork2.ognl.OgnlValueStack "%>
<%@page
    import="org.springframework.context.ApplicationContext, 
    org.springframework.web.context.support.WebApplicationContextUtils"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%!
    private String currFunctionId;
    private String currFunctionName;
    private String CurrentDir;
    private String cicRootUrl;
    private String cicFabServiceUrl;
    private String measureUrl;
    
    private void initPage(HttpServletRequest request){
        try{
            
           /*  ServletConfig servletConfig = getServletConfig();
            ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
            OgnlValueStack stack = (OgnlValueStack) request.getAttribute("struts.valueStack");
        
            cicPortalUrl = "";
            //路徑位置
            this.CurrentDir = cicPortalUrl;
            this.cicRootUrl = cicPortalUrl + "/main.jsp";
            this.cicFabServiceUrl = CurrentDir + "/fab_services/";
            this.measureUrl = CurrentDir + "/measure/index.jsp";
            
            this.currFunctionId = ((String)stack.findValue("programId")) == null? "": ((String)stack.findValue("programId"));
            this.currFunctionName = (String)stack.findValue("programName"); */
            
        } catch(Exception e){
            System.out.println(e);  
        }
        
    }

    private List<Map<String, String>> getChipApplyMenuList(String seqno, String serialno){
    
        String urlParam = "";
        if(seqno != null){
            urlParam = "?seqno=" + seqno + "&serialno=" + serialno;
        }
    
        List<Map<String, String>> functionList = new ArrayList<Map<String, String>>();
    
        /* Map<String, String> funcitionMap = new HashMap<String, String>();
        funcitionMap.put("functionId", ConstantValue.CHIPAPPLY_SCHEDULE_PROGRAM_ID);
        funcitionMap.put("functionName", ConstantValue.CHIPAPPLY_SCHEDULE_PROGRAM_NAME); 
        funcitionMap.put("functionUrl", "chipapply/schedule/init.action" + urlParam); 
        functionList.add(funcitionMap);*/
        
        return functionList;
    }

%>
<%

    /* LoginUserVo loginVo = (LoginUserVo)session.getAttribute(ConstantValue.SESSION_MEMBER);
    String loginType = "";
    if(loginVo != null){
        loginType = loginVo.getUserType();
    } */
    
    String seqno = (String)session.getAttribute("seqno");
    String serialno = (String)session.getAttribute("serialno");

    String s_user_cname = "";
   
    this.initPage(request);
    List functionList = this.getChipApplyMenuList(seqno, serialno);
    
    request.setAttribute("currFunctionId", currFunctionId);
    request.setAttribute("currFunctionName", currFunctionName);
    request.setAttribute("functionList", functionList);
    
    ServletConfig servletConfig = getServletConfig();
    ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
    
%>

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
    

    <!-- HTML5 Shim 和 Respond.js 用於讓 IE8 支持 HTML5元素和媒體查詢 -->
      <!-- 注意： 如果通過 file://  引入 Respond.js 文件，則該文件無法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
      
      <%-- <decorator:head /> --%>
</head>

<script type="text/JavaScript">
	var contextPath = '${pageContext.request.contextPath}';
	
	function onlineApply(){
	    var url = contextPath + "/onlineapply/init.action";
	    window.location = url;
	}
	
	function toSummaryPage(){
	    window.location = contextPath + "/papercredit/summary/init.action";
	}
	
    function redirectUrl(funId, url) {
        window.location = url;
    }
</script>

<body id="bodyId"  onload="">

    <table width="50%" align="center" border="0" cellpadding="0" cellspacing="0">
        <thead>
           <tr>
               <td>
                   <table width="100%" border="1" cellpadding="0" cellspacing="0">
                       <tr> 
                           <td height="50px" align="center">
                           logo
                           </td>
                        </tr>
                   </table>
               </td>
           </tr>
        </thead>
        <tbody>
            <tr>
                <td width="100%" height="100%">
                    <!-- 加這個table是為了讓tab與資料有點距離 === start -->
                    <table width="100%" border="0" cellpadding="2" cellspacing="2"> 
                        <tbody>
                            <tr>  
                                <td valign="top">
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                        <tbody>
                                            <tr>
                                                 <td align="left"><img src="${pageContext.request.contextPath}/images/link3.jpg"  /></td>
                                            </tr>                                           
                                            <tr>
                                                <td>
                                                  
                                                    <font size=3>
                                                    <!-- ●<a href="javascript: void 0" onclick="toPackageHome();return false;">封裝首頁</a><br/> -->
                                                    ●<a href="javascript: void 0" onclick="onlineApply();return false;">我要報名</a><br/> 
                                                    <!-- ●<a href="javascript: void 0" onclick="toSummaryPage();return false;">論文成果總表</a><br/>
                                                    ●<a href="javascript: void 0" onclick="downloadPaperCredit();return false;">加總積點</a><br/> -->
                                                    </font>
                                              </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>                  
                                <td valign="top" width="100%">
                                    <!-- 內容開始 --> <decorator:body /> <!-- 內容結束 -->
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <!-- 加這個table是為了讓tab與資料有點距離 === end  -->
                </td>               
            </tr>
        </tbody>
        <tfoot>
           <tr>
               <td>
                   <table width="100%" border="1" cellpadding="0" cellspacing="0">
                       <tr> 
                           <td height="50px" align="center">
                           foot
                           </td>
                        </tr>
                   </table>
               </td>
           </tr>
        </tfoot>
    </table>


</body>
</html>
