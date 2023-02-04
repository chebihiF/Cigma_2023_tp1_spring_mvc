<%--
  Created by IntelliJ IDEA.
  User: chebihi
  Date: 2/4/2023
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Peoples</title>
</head>
<body>
    <table>
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Age</td>
        </tr>
        ${peoples.size()}
        <c:forEach items="${peoples}" var="p">
            <tr>
                <td> <c:out value="${p.name}"/> </td>
                <td>${p.email}</td>
                <td>${p.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
