<%-- 
    Document   : feedback
    Created on : Sep 11, 2018, 1:15:15 AM
    Author     : Sorabh86 <ssorabh.ssharma@gmail.com>
--%>
<% if(null == session.getAttribute("user")) {
    response.sendRedirect("/LoginFeedback");
} %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <header>
            <h1 class="brand"><a href="/LoginFeedback/site">Feedback HUB</a></h1>
            <nav>
                <ul>
                    <li><a href="/LoginFeedback/site?action=logout">logout</a></li>
                </ul>
            </nav>
        </header>
        <div class="container">
            <div class="content">
                <form action="site" method="post">
                    <input type="hidden" name="action" value="dofeedback">
                    <% String error = (String)session.getAttribute("error");
                    if(error != null) {%>
                        <p class="error"><%= error %></p>
                    <% session.setAttribute("error", null); 
                    }
                    String success = (String)session.getAttribute("success");
                    if(success != null) { %>
                        <p class="success"><%= success %></p>
                    <% session.setAttribute("success", null);
                    } %>
                    <div class="form-group">
                        <label>Your Feedback :</label>
                        <textarea name="message" class="form-control" rows="5" placeholder="Write your feedback here"></textarea>
                    </div>
                    <button class="btn" type="submit">submit</button>

                </form>
            </div>
        </div>
    </body>
</html>
