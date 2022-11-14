<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: vityacasf
  Date: 9.11.22
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Info</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"/>
    <link rel="icon" href="./icons/icon.jpg">
</head>
<body>
<jsp:include page="/users"/>
<div class="container">
  <div class="row" style="margin-top: 25px">
    <div class="card">
      <div class="card-body">
        <div class="card-title">
          <h3>USERS</h3>
        </div>
        <div class="card-text">
          <table class="table">
            <tr>
              <th>Login</th>
              <th>Password</th>
            </tr>
            <tbody>
            <c:forEach items="${users}" var="user">
              <tr>
                <td>
                  <c:out value="${user.login}"/>
                </td>
                <td>
                  <c:out value="${user.password}"/>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<c:if test="${queryError != null }">
  <div class="row" style="margin-top: 25px">
    <div class="alert alert-danger" role="alert">
        ${queryError}
    </div>
  </div>
</c:if>
</body>
</html>
