<%--
  Created by IntelliJ IDEA.
  User: mrx
  Date: 16.11.2019
  Time: 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div align="center">
        <form action="login" method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Login: </th>
                    <td><input type="text" name="login"></td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
