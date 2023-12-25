<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 19/12/2023
  Time: 9:14 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
<form method="post">
  <fieldset>
    <legend>
      Dictionary
    </legend>
    <label for="word">Nhập từ cần dịch</label>
    <input id="word" name="word" type="text" required>
    <input type="submit" value="Dịch"><br>
    <h5>Từ cần dịch: <span style="color: blue">${word}</span></h5>
    <h5>Kết quả: <span style="color: blue">${result}</span></h5>
  </fieldset>
</form>
</body>
</html>
