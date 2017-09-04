<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>期刊查詢</title>
</head>

<!-- jQuery API -->
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>

<!-- ginger's css -->
<link href="${pageContext.request.contextPath}/style/ginger_main.css" rel="stylesheet"  type="text/css" />

<!-- loadmask lib -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/plugin/jquery-loadmask-0.4/jquery.loadmask.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-loadmask-0.4/jquery.loadmask.min.js"></script>
    
<script language="javascript">
<!-- 
	var contextPath = "${pageContext.request.contextPath}";
	
	$(document).ready(function() {
		
		window.focus();

	});

	function pageSubmit() {
		
		/* if(jQuery.trim($('#periName').val()) == ""){
			alert('請輸入查詢條件');
			return false;
		} */
		
		$("#bodyId").mask("處理中...");
		document.searchForm.submit();
	}
	
    function returnData(name){

        
        var periodicalObj = {
        	'periodicalName': name
        };
        opener.setPeriodical(periodicalObj);

    	window.close();
    }
//-->	
</script>


<body>
  
	<form method="post" name="searchForm" id="searchForm" action="${pageContext.request.contextPath}/common/queryPeri.action?decorator=noneDecorator&confirm=true">
		<table class="serachtb" border="1" cellpadding="3" cellspacing="0" width="100%">						
			<tr>
                <td width="120">期刊名稱:</td>
                <td>
                    <input type="text" name="commonCodeVo.periName" id="periName" value='<s:property value="commonCodeVo.periName" />' />
                    (請輸入要搜尋的期刊關鍵字)
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                     <input type="button" id="queryBt" name="queryBt" value="查詢" onClick="pageSubmit();" />
                </td>
            </tr>
		</table>
	<br/>

	<table class="gridtb" width="100%" align="center" border="1" cellpadding="3" cellspacing="0">
		<thead>
			<tr>
				<th class="title" align="center" colspan="2">查詢結果</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th width="2%">&nbsp;</th>
				<th width="20%">期 刊 名 稱</th>		
			</tr>
			<s:if test="null!=periList && !periList.isEmpty()">
				<s:iterator value="periList" var="resultVo" status="st">
					
					<tr>
			           <td>						
			             <s:property value="#st.count" />
			           </td>			           
			           <td><a href="#" onclick="returnData('${resultVo.pName}');" >${resultVo.pName}</a>&nbsp;</td>
					</tr>
				</s:iterator>
		  </s:if>
		  <s:elseif test="null != periList && periList.isEmpty()">
                <tr>
                    <td colspan="2" align="center">查無資料</td>
                </tr>
          </s:elseif> 
		</tbody>
	</table>
</form>
</body>
</html>