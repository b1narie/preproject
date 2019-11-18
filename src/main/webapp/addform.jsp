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
    <title>Add user</title>
</head>
<body>
<div align="center">
    <form action="add" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Name: </th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>Login: </th>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <th>Password: </th>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <th>Role: </th>
                <td>
                    <input type="radio" name="role" value="user" id="userRadio" checked>
                    <label for="userRadio">User</label>
                    &nbsp;
                    <input type="radio" name="role" value="admin" id="adminRadio">
                    <label for="adminRadio">Admin</label>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="add"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
