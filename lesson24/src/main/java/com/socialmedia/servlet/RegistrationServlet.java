package com.socialmedia.servlet;


import com.socialmedia.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    userService = (UserService) config.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
      throws ServletException, IOException {

    String login = req.getParameter("inputLogin");
    String password = req.getParameter("inputPassword");

    if (userService.createUser(login, password)) {
      req.getServletContext().getRequestDispatcher("/authorization").forward(req, resp);
    } else {
      req.getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
    }

  }
}
