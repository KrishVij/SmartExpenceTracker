<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Expenses</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="container">
    <header>
        <div><h1>Expenses</h1><p class="muted">Add and review your spending</p></div>
        <nav><a href="/">Dashboard</a><a href="/expenses">Expenses</a><a href="/plan">Budget & Goals</a></nav>
    </header>

    <section class="panel">
        <h2>Add an expense</h2>
        <form action="/expenses/save" method="post" class="form-grid">
            <label>Expense name
                <input type="text" name="title" placeholder="e.g. Groceries" required>
            </label>
            <label>Category
                <select name="category" required>
                    <option value="Food">Food</option>
                    <option value="Travel">Travel</option>
                    <option value="Shopping">Shopping</option>
                    <option value="Bills">Bills</option>
                    <option value="Other">Other</option>
                </select>
            </label>
            <label>Amount (₹)
                <input type="number" name="amount" min="0.01" step="0.01" required>
            </label>
            <label>Date
                <input type="date" name="expenseDate" required>
            </label>
            <button type="submit">Save expense</button>
        </form>
    </section>

    <section class="panel">
        <h2>All expenses</h2>
        <table>
            <tr><th>Name</th><th>Category</th><th>Date</th><th>Amount</th><th></th></tr>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td><c:out value="${expense.title}"/></td>
                    <td><c:out value="${expense.category}"/></td>
                    <td><c:out value="${expense.expenseDate}"/></td>
                    <td>₹ <c:out value="${expense.amount}"/></td>
                    <td><a class="delete" href="/expenses/delete?id=${expense.expenseId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </section>
</div>
</body>
</html>
