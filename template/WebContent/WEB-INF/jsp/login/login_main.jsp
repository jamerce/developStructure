<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>

<%@taglib prefix="s" uri="/struts-tags"%>

<s:set name='contextPath' value="#request.get('javax.servlet.forward.context_path')" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>晶片中心-報名系統</title>

    <!-- jQuery lib -->
    <script language="javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.1.1.min.js"></script>
    
    <!-- blockUI lib -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/plugin/jquery-blockUI-2.7/jquery.blockUI-2.7.js"></script>
    
</head>
<style type="text/css">
    #middle {
        position: absolute;
        height: 500px;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
    }
</style>


<!-- to avoid XFS -->
<script> if (top != self) top.location=location </script>

<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";

    
    function loginSubmit() {

        if($("#userId").val() == ""){
            alert("請輸入帳號");
            return false;
        }
        
        if($("#userPw").val() == ""){
            alert("請輸入密碼");
            return false;
        }
        
        showLoading("處理中");
        setTimeout(function () {  
            $.ajax({
                url: contextPath + "/login/doLogin.action",
                type: 'post',
                data: $("#loginForm").serialize(),
                dataType: "json",
                success: function(result) {
                    window.location = contextPath + "/home/init.action";
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
    
    function logout() {

        $.ajax({
            url : contextPath + "/loginSimu/ajaxLogout.action",
            type : 'post',
            dataType : "json",
            success : function(data) {
                //var dataObj = eval(data);//轉換為json對象 

                alert(data);
            },
            error : function(xhr) {
                alert('Ajax request 發生錯誤');
            }
        });
    }
    
    function showLoading(msg){
        $.blockUI({ 
            message: '<div>'+msg+'...</div>',
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
    }
</script>

<body>


    <div class="container">
       <div id="middle" class="col-md-4 col-md-offset-4">
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <h3 class="panel-title text-center">
                       晶片中心-歡迎登錄
                    </h3>  
                </div>  
                <div class="panel-body">
                
                    <form id="loginForm" name="loginForm" role="form" method="post">
                        <div class="form-group">
                            <div class="form-group row">  
                                <label class="control-label col-md-2" for="userId" for="userId">帳號：</label>
                                <div class="col-md-10">
                                  <input type="text" class="form-control" id="userId" name="loginVo.userId" maxlength="10" placeholder="請輸入用戶ID" />  
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-md-2" for="userPw">密碼：</label>
                                <div class="col-md-10">
									<input type="password" class="form-control" id="userPw" name="loginVo.userPw" maxlength="12" placeholder="請輸入密碼" aria-describedby="passwordDesc" />
									<p id="passwordDesc" class="form-text text-muted">
									  請輸入長度為8~12的字母...
									</p>
									
                                </div>                 
                            </div>
                            
                            <button type="button" class="btn btn-lg btn-block" onclick="loginSubmit()">登錄</button>
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>     
       
    </div>


    
        
    
</body>
</html>