<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Expense Details</h1>
		<a href="/expenses">Go back</a>
		<h1>View Expense</h1>
		<h2>Expense: <c:out value="${expense.expense}" /> </h2>
		<h2>Vendor: <c:out value="${expense.vendor}" /> </h2>
		<h2>Amount: <c:out value="${expense.amount}" /> </h2>
		<h2>Description: <c:out value="${expense.description}" /> </h2>
</body>
</html>