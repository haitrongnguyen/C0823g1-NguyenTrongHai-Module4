<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 19/12/2023
  Time: 8:30 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>
            Currency Convert
        </legend>
        <label for="USD" style="display: block;">Nhập USD</label>
        <input type="number" name="usd" id="USD"><br>
        <label for="rate" style="display: block">Tỉ giá</label>
        <input name="rate" type="number" value="22000" id="rate"><br>
        <input type="submit" value="Convert"><br>
        <p>USD: ${usd}</p>
        <p>VND: ${result}</p>
    </fieldset>
</form>
</body>
</html>
