<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 19/12/2023
  Time: 7:42 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
<div>
    <p>There are ${list.size()} customer</p>
</div>
<div>
    <table style="width: 50%;">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <c:forEach items="${list}" var="customer" varStatus="loop">
            <tr>
                <td>${customer.id}</td>
                <td>
                    <a href="info.jsp?id=${customer.id}">${customer.name}</a>
                </td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
