<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>All Expenses</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="expense" items="${expenses}">
        <tr>
            <td><c:out value="${expense.id}"></c:out></td>
            <td>
                <a href="/expenses/${expense.id}">
                    <c:out value="${expense.name}"></c:out>
                </a>
            </td>
            <td><c:out value="${expense.vendor}"></c:out></td>
            <td>$<c:out value="${expense.amount}"></c:out></td>
            <td>
                <a href="/expenses/edit/${expense.id}">edit</a>
            </td>
            <td>
                <form action="/expenses/${expense.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>New Language</h2>
<form:form class="form" action="/languages" method="post" modelAttribute="language">
    <div class="form-control">
    <form:label path="name">Name</form:label>
    <form:errors path="name"/>
    <form:input path="name"/>
    </div>
    <div class="form-control">
    <form:label path="creator">Creator</form:label>
    <form:errors path="creator"/>
    <form:input path="creator"/>
    </div>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>

