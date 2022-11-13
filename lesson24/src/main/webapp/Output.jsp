<%@ page import="com.socialmedia.service.OutputService" %>
<%@ page import="com.socialmedia.model.User" %>
<%@ page import="java.io.Writer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: vityacasf
  Date: 9.11.22
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Output</title>
</head>
<body>
<table>
  <tr>
    <%
      OutputService outputService =
              (OutputService) request.getServletContext().getAttribute("outputService");
      String queryParameter = request.getParameter("parameter");
      List<User> users = outputService.getAllUsers(queryParameter);

      try (Writer writer = response.getWriter()) {
        users.stream().forEach(user -> {
          try {
            writer.write("<h1>" + user.getLogin() + "</h1>");
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
      }
    %>
  </tr>
</table>
</body>
</html>
