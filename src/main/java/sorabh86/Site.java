/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorabh86;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
@WebServlet(name = "Site", urlPatterns = {"/site"})
public class Site extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if(action.equals("logout")) {
            session.setAttribute("user", null);
            response.sendRedirect("/LoginFeedback/feedback.jsp");
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if(action.equals("dologin")) {
            
            String customer = request.getParameter("username");
            String password = request.getParameter("password");
            
            if(DBConnect.connect()) {
                try {
                    String sql = "SELECT id FROM users WHERE username=? AND password=?";
                    PreparedStatement stmt = DBConnect.getConnection()
                            .prepareStatement(sql);
                    
                    stmt.setString(1, customer);
                    stmt.setString(2, password);
                    
                    ResultSet rs = stmt.executeQuery();
                    
                    int id = 0;
                    if(rs.next()) {
                        id = rs.getInt("id");
                    }
    
                    rs.close();
                    
                    DBConnect.disconnect();
                    
                    if(id == 0) {
                        session.setAttribute("error", "Invalid CustomerId OR Password.");
                        response.sendRedirect("/LoginFeedback/");
                    } else {
                        session.setAttribute("user", id);
                        response.sendRedirect("/LoginFeedback/feedback.jsp");
                    }
                } catch (SQLException ext) {
                    session.setAttribute("error", ext.getMessage());
                    response.sendRedirect("/LoginFeedback/");
                }
            } else {
                session.setAttribute("error", "Problem connecting database.");
                response.sendRedirect("/LoginFeedback/");
            }
        } else if(action.matches("dofeedback")) {
            
            int userId = (int)session.getAttribute("user");
            String message = request.getParameter("message");
            
            if(DBConnect.connect()) {
                
                try {
                    String sql = "INSERT INTO feedback (user_id, message) VALUES(?, ?)";
                    PreparedStatement stmt = DBConnect.getConnection()
                            .prepareStatement(sql);
                    
                    stmt.setInt(1, userId);
                    stmt.setString(2, message);
                    
                    stmt.executeQuery();
                    stmt.close();
                    
                    session.setAttribute("success", "Your feedback is submited.");
                    response.sendRedirect("/LoginFeedback/feedback.jsp");
                    
                } catch (SQLException ex) {
                    session.setAttribute("error", "Error on submiting, try again later.");
                    response.sendRedirect("/LoginFeedback/feedback.jsp");
                }
                
                DBConnect.disconnect();
            } else {
                session.setAttribute("error", "Problem Connecting to Database.");
                response.sendRedirect("/LoginFeedback/feedback.jsp");
            }
        }
    }

}
