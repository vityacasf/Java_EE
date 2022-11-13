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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Writer writer = resp.getWriter()){
            if (userService.registration(username, password)) {
                writer.write("This login is already registered");
                req.getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
            } else {
                req.getServletContext().getRequestDispatcher("/Registration.jsp").forward(req, resp);
            }
        }

    }
}
