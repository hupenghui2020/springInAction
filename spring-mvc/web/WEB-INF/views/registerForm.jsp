<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">

    span.error {
        color: red;
    }
</style>

<head>
    <title>registerForm</title>
</head>
<body>
    <h1>Register</h1>

    <%--@elvariable id="spitter" type="com.hph.model.Spitter"--%>
    <sf:form method="post" commandName="spitter">
        First Name: <sf:input path="firstName"/><br/>
        <sf:errors path="firstName" cssClass="error"/>

        Last Name: <sf:input path="lastName"/><br/>

        Email: <sf:input path="email" /><br/>

        Username: <sf:input path="username"/><br/>

        Password: <sf:password path="password"/><br/>

        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
