<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>expenses</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneExpense" items="${expenses}">
				<tr>
					<td>
						<a href="/expenses/${oneExpense.id}">
							<c:out value="${oneExpense.expense}"></c:out>
						</a>
					</td>
					<td>
						<c:out value="${oneExpense.vendor}"></c:out>
					</td>
					<td>
						<c:out value="${oneExpense.amount}"></c:out>
					</td>
					<td>
						<a href="/expenses/${oneExpense.id}/edit">Edit</a>
					</td>
					<td>
						<form action="/expenses/${oneExpense.id}" method="POST">
							<input type="hidden" name="_method" value="delete">
							<button>Delete</button>
						</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form modelAttribute="expenseObj" method="POST" action="/expenses/new">
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