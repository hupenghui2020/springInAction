<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>registerForm</title>
</head>
<body>
    <h1>Your Profile</h1>

    <c:out value="${spitter.username}" /><br/>

    <c:out value="${spitter.firstName}" /><br/>
</body>
</html>
