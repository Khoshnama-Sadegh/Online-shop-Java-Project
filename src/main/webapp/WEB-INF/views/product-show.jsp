<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 9/2/22
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<%--        <form action="/product/save" method="post">--%>
<%--            Name:<input name="name" type="text"/> <br><br>--%>
<%--            Price: <input name="price" type="text"/><br>--%>
<%--            Type: --%>
<%--            <input type="submit" value="add product"/>--%>

<%--        </form>--%>

<h2><mvc:message code="product.add"/> </h2>

<a href="?lang=en">EN</a>
<a href="?lang=fa">FA</a>

<form:form action="/product/save" method="post" modelAttribute="dto">
    Name: <form:input path="name"/><br><br>
            <form:errors path="name" cssStyle="color: red"/>
    Price:<form:input path="price"/><br><br>
    <form:errors path="price" cssStyle="color: red"/>
    <br>
    Type:<form:select path="type" cssStyle="width: fit-content">
        <form:option value="---Please Select one Item---"/>
            <form:options items="${dto.validTypes}"/>
        </form:select>

    <br>
    <br>
    Color:
    Black <form:radiobutton path="color" value="black"/>
    Green <form:radiobutton path="color" value="green"/>
    Blue <form:radiobutton path="color" value="blue"/>
    <br>

    Sizes:
    XL <form:checkbox path="sizes" value="4"/>
    L <form:checkbox path="sizes" value="3"/>
    M <form:checkbox path="sizes" value="2"/>
    S <form:checkbox path="sizes" value="1"/>
    <input type="submit" value="add product"/>



</form:form>
</body>
</html>
