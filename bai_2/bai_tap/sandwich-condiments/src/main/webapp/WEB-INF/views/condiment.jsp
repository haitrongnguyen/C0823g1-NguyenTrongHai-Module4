<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 19/12/2023
  Time: 8:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiment</title>
</head>
<body>
<form method="post">
  <fieldset>
    <legend>
      Sandwich Condiments
    </legend>

    <input id="lettuce" type="checkbox" name="condiment" value="Lettuce">
    <label for="lettuce">Lettuce</label>

    <input id="tomato" type="checkbox" name="condiment" value="Tomato">
    <label for="tomato">Tomato</label>

    <input id="mustard" type="checkbox" name="condiment" value="Mustard">
    <label for="mustard">Mustard</label>

    <input id="sprouts" type="checkbox" name="condiment" value="Sprouts">
    <label for="sprouts">Sprouts</label><br>
    <hr>
    <input type="submit" value="Save">
  </fieldset>
</form>

<h5>Sandwich Condiments:
<c:forEach items="${condiment}" var="condiment" varStatus="loop">
  <span>${condiment}</span>
</c:forEach>
</h5>
</body>
</html>
