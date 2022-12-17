package com.socialmedia.servlet;

import com.socialmedia.model.User;
import com.socialmedia.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;


@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    userService = (UserService) config.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    Map<String, String[]> parameterMap = req.getParameterMap();
    if (parameterMap.containsKey("login")) {
      String loginParameter = req.getParameter("login");
      List<User> users = userService.findUsersStartWith(loginParameter);
      req.setAttribute("users", users);
    } else {
      final List<User> users = userService.findUsers();
      req.setAttribute("users", users);
    }
    getServletContext().getRequestDispatcher("/main").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");

    String username = req.getParameter("inputLogin");


    try (Writer writer = resp.getWriter()) {
      if (userService.isExists(username)) {
        req.getServletContext().setAttribute("username", username);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
      } else {
        writer.write("Authorization Error");
      }
    }
  }
}
