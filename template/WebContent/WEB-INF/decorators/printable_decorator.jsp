<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
    
<!DOCTYPE html>
<html>
<head>
    <title><decorator:title /></title>
    <decorator:head />
    
    <style type="text/css">
    .printable { display: block; }
    
    @media print
    {
        .non-printable { display: none; }
        .printable { display: block; }
    }
    </style>
    
     <script>
     function printtest(){
         window.print();
     }
     </script>
</head>
<body>
<div class="non-printable">
     <h1><decorator:title /></h1>     
     <input type="button" name="print" value="列印" onClick="printtest();" />
     <hr />
</div>      

<div class="printable">
     <decorator:body />
</div>

</body>
</html>