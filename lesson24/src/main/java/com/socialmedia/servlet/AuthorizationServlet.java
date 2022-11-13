package com.socialmedia.servlet;

import com.socialmedia.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final String username = req.getParameter("username");
        final String password = req.getParameter("password");

        try (Writer writer = resp.getWriter()){
            if (userService.authentication(username, password)) {
                req.getServletContext().setAttribute("username", username);
                req.getRequestDispatcher("/Output.jsp").forward(req, resp);
            } else {
                writer.write("Authorization Error");
            }
        }
    }
}
