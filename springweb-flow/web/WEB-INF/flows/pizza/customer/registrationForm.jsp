<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spizza</title>
</head>
<body>
    <h2>Customer Registration</h2>
    <%--@elvariable id="customer" type="com.com.hph.domain.Customer"--%>
    <form:form commandName="customer">
        <!-- flowExecutionKey：当进入视图时，流程暂停并等待用户采取一些行为；当提交表单时，会返回流程，flowExecutionKey相当于一种返回流程的 “回程票” -->
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
        <b>Phone number: </b><form:input path="phoneNumber" /><br/>
        <b>Name: </b><form:input path="name" /><br/>
        <b>Address: </b><form:input path="address" /><br/>
        <b>City: </b><form:input path="city" /><br/>
        <b>State: </b><form:input path="state" /><br/>
        <b>Zip code: </b><form:input path="zipCode" /><br/>
        <input type="submit" name="_eventId_submit" value="Submit" />
        <input type="submit" name="_eventId_cancel" value="Cancel" />
    </form:form>
</body>
</html>
