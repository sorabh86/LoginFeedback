<%-- 
    Document   : index
    Created on : Sep 11, 2018, 12:40:33 AM
    Author     : Sorabh86 <ssorabh.ssharma@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
            form{width:400px;margin:30px auto;background:#ddd;padding:20px;border-radius:8px;}
            form h1{margin:0 0 20px;padding-bottom:10px;border-bottom:1px solid #fff;}
            label,input{display:inline-block;box-sizing:border-box;padding:5px}
            label{width:35%;float:left;text-align:right;}
            input[type=text],input[type=password]{width:65%;box-sizing:border-box;float:left;}
            input[type=submit]{margin-left:110px;padding:10px 20px}
        </style>
    </head>
    <body>
        <%@include file="templates/navigation.html" %>
        <form action="/LoginFeedback/site" method="post">
            <h1>Login</h1>
            <input type="hidden" name="action" value="dologin">
            <% if(session.getAttribute("error") != null) { %>
                <h6 class="error"><%= request.getAttribute("error") %></h6>
            <% } %>
            <div class="form-group">
                <label>Customer ID : </label> 
                <input type="text" name="email" value="<%= request.getAttribute("email") %>">
            </div>
            <div class="form-group">
                <label>Password : </label>
                <input type="password" name="password">
            </div>
            <input class="btn" type="submit" value="login">
        </form>
    </body>
</html>

