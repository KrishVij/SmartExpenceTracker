<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Smart Expense Tracker</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="container">
    <header>
        <div>
            <h1>Expense Tracker</h1>
            <p class="muted">A simple view of your money</p>
        </div>
        <nav>
            <a href="/">Dashboard</a>
            <a href="/expenses">Expenses</a>
            <a href="/plan">Budget & Goals</a>
        </nav>
    </header>

    <h2>This month's overview</h2>
    <section class="cards">
        <div class="card">
            <p class="muted">Money spent</p>
            <h2>₹ <c:out value="${monthlySpent}"/></h2>
        </div>
        <div class="card">
            <p class="muted">Monthly budget</p>
            <h2>₹ <c:out value="${plan.monthlyBudget}"/></h2>
        </div>
        <div class="card">
            <p class="muted">Budget remaining</p>
            <h2>₹ <c:out value="${remainingBudget}"/></h2>
        </div>
    </section>

    <section class="panel">
        <h2>Spending by category</h2>
        <c:if test="${empty categoryTotals}">
            <p class="muted">No expenses recorded this month yet.</p>
        </c:if>
        <c:forEach var="entry" items="${categoryTotals}">
            <div class="category-row">
                <span><c:out value="${entry.key}"/></span>
                <strong>₹ <c:out value="${entry.value}"/></strong>
            </div>
        </c:forEach>
    </section>

    <section class="panel">
        <h2>Recent expenses</h2>
        <c:if test="${empty expenses}">
            <p class="muted">Your expenses will appear here.</p>
        </c:if>
        <table>
            <tr><th>Name</th><th>Category</th><th>Date</th><th>Amount</th></tr>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td><c:out value="${expense.title}"/></td>
                    <td><c:out value="${expense.category}"/></td>
                    <td><c:out value="${expense.expenseDate}"/></td>
                    <td>₹ <c:out value="${expense.amount}"/></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="/expenses">Manage expenses →</a></p>
    </section>
</div>
</body>
</html>
