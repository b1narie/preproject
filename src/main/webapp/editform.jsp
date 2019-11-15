<%--
  Created by IntelliJ IDEA.
  User: mrx
  Date: 11.11.2019
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<div align="center">
    <form action="/edit" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Id: </th>
                <td><input type="number" name="id" value="<c:out value="${user.id}"/>" readonly></td>
            </tr>
            <tr>
                <th>Name: </th>
                <td><input type="text" name="name" value="<c:out value="${user.name}"/>"></td>
            </tr>
            <tr>
                <th>Login: </th>
                <td><input type="text" name="login" value="<c:out value="${user.login}"/>"></td>
            </tr>
            <tr>
                <th>Password: </th>
                <td><input type="text" name="password" value="<c:out value="${user.password}"/>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="save"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
