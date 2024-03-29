<%--
  Created by IntelliJ IDEA.
  User: mrx
  Date: 11.11.2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div align="center">
    <table border="1px" cellpadding="5">
        <caption><h2>List of all users</h2></caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>login</th>
            <th>password</th>
        </tr>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.role}"/></td>
                <form method="get" action="/admin/edit">
                    <td>
                        <button type="submit" name="id" value="${user.id}">Edit</button>
                    </td>
                </form>
                <form method="get" action="/admin/delete">
                    <td>
                        <button type="submit" name="id" value="${user.id}">Delete</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
    <div align="center">
        <h2><a href="/admin/add">Add user</a></h2>
    </div>
    <form action="/logout">
        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>