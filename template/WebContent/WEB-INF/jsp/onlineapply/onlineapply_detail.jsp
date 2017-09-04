<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="decorator" content="none" />
<title>報名系統</title>

<!-- jquery lib -->
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>

<!-- blockUI lib -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-blockUI-2.7/jquery.blockUI-2.7.js"></script>
</head>

<style>
</style>

<s:if test="hasActionMessages()">
	<s:iterator value="actionMessages">
		<script language="JavaScript">
			alert("<s:property escape="false"/>");
		</script>
	</s:iterator>
</s:if>

<s:if test="hasActionErrors()">
	<div class="errors">
		<s:actionerror />
	</div>
</s:if>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(document).ready(function() {
		//$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);

	});

	function pageSubmit() {

		callAjax();
		
		/* alertify.set({ buttonReverse: true }); // true, false
		alertify.confirm("是否要儲存?", function (e) {
		    if (e) {

		    	callAjax();
		        
		    } else {
		        return false;
		    }
		}); */
	}
	
	function callAjax(){
		$.blockUI({
            message : '<div>處理中...</div>',
            css : {
                border : 'none',
                padding : '15px',
                backgroundColor : '#000',
                '-webkit-border-radius' : '10px',
                '-moz-border-radius' : '10px',
                opacity : .9,
                color : '#fff'
            }
        });

        setTimeout(function() {
            $.ajax({
                url : contextPath + "/onlineapply/doModify.action",
                type : 'post',
                data : $("#dataForm").serialize(),
                dataType : "json",
                async : false,
                cache : false,
                success : function(response) {
                    $.unblockUI();

                    if (response.isSuccess == "Y") {
                        alert("修改成功");
                        //parent.$.fancybox.close();

                    } else {
                        alert(response.msg);
                    }
                },
                error : function(xhr, ajaxOptions, thrownError) {
                    $.unblockUI();
                    alert('請求發生錯誤:' + thrownError);
                },
                complete : function() {
                    $.unblockUI();
                }
            });
        }, 100);
	}
//-->
</script>

<body id="bodyId">
    <div class="container">
        <div class="panel panel-primary">
		    <div class="panel-heading">
		        <h3 class="panel-title">
		            處理資料
		        </h3>
		    </div>
		    <div class="panel-body">
		        
                <form method="post" name="dataForm" id="dataForm" class="form-horizontal" role="form">          
		            <div class="form-group">
		                 <input type="hidden" id="id" name="detailVo.id" value="${logPo.id}">
		                 <label for="nvno" class="control-label col-sm-2">主鍵：</label> 
		                 <div class="col-sm-10">
		                    <input type="text" id="nvno" name="detailVo.nvno" class="form-control" placeholder="Enter nvno" value="${logPo.nvno}" >
		                 </div>
		            </div>
		            <div class="form-group">
		                 <label for="msg" class="control-label col-sm-2">訊息：</label> 
		                 <div class="col-sm-10">
		                   <input type="text" id="msg" name="detailVo.msg" class="form-control" size="50" value="${logPo.msg}">
		                 </div>
		            </div>
		            <div class="form-group">        
		                <div class="col-sm-offset-2 col-sm-10">
		                    <button type="button" class="btn btn-default" onclick="pageSubmit()">Submit</button>
		                </div>
		            </div>
		        </form>

		    </div>
		</div>
		
	</div>
</body>
</html>