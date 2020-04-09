<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 10499
  Date: 2020/4/3
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Pizza</title>
</head>
<body>
    <h2>Create Pizza</h2>
    <form:form commandName="pizza">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <b>Size: </b><br/>
        <form:radiobutton path="size" label="小号" value="SMALL" /><br/>
        <form:radiobutton path="size" label="中号" value="MEDIUM" /><br/>
        <form:radiobutton path="size" label="大号" value="LARGE" /><br/>
        <form:radiobutton path="size" label="特大号" value="GINORMOUS" /><br/>
        <br/>
        <b>Toppings: </b>
        <form:checkboxes path="toppings" items="${toppingsList}" delimiter="&lt;br/&gt;" /><br/><br/>
        <input type="submit" class="button" name="_eventId_addPizza" value="Continue" />
        <input type="submit" class="button" name="_eventId_cancel" value="Cancel" />
    </form:form>
</body>
</html>
