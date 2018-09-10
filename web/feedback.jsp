<%-- 
    Document   : feedback
    Created on : Sep 11, 2018, 1:15:15 AM
    Author     : Sorabh86 <ssorabh.ssharma@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <%
            Object customer = session.getAttribute("user");
            
            if(null == customer) {
                response.sendRedirect("/LoginFeedback");
            }
        %>
        <%@include file="templates/navigation.html" %>
        <div class="container">
            <form action="site" method="post">
                <input type="hidden" name="action" value="dofeedback">
                <% String error = (String)request.getAttribute("error");
                if(error != null) {%>
                    <p class="error"><%= error %></p>
                <% } 
                String success = (String)request.getAttribute("success");
                if(success != null) { %>
                    <p class="success"><%= success %></p>
                <% } %>
                <div class="form-group">
                    <label>Your Feedback :</label>
                    <textarea name="feedback" class="form-control" rows="5" placeholder="Write your feedback here"></textarea>
                </div>
                <button class="btn" type="submit">submit</button>

            </form>
        </div>
    </body>
</html>
