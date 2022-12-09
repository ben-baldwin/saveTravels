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
<h1>Edit Expense</h1>
<a href="/expenses">Go back</a>
	<form:form modelAttribute="expenseObj" method="POST" action="/expenses/${expenseObj.id}/edit">
		<input type="hidden" name="_method" value="put">
		<p>
			Expense:
			<form:input type="text" path="expense" />
			<form:errors path="expense" />
		</p>
		<p>
			Vendor:
			<form:input type="vendor" path="vendor" />
			<form:errors path="vendor" />
		</p>
		<p>
			Amount:
			<form:input type="number" step="0.01" path="amount" />
			<form:errors path="amount" />
		</p>
		<p>
			Description:
			<form:input type="description" path="description" />
			<form:errors path="description" />
		</p>
		<button>Submit</button>
	</form:form>
</body>
</html>