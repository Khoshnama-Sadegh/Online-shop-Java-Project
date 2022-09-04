<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 9/1/22
  Time: 2:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><mvc:message code="index.page.home" text="Home ALT"/></title>
</head>
<body>
        <a href="/product/show"><mvc:message code="add.product" /></a><br>
        <a href="/product/get-All"><mvc:message code="show.product"/> </a>
</body>
</html>
