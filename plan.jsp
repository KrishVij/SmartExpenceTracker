<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Budget and Goals</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="container">
    <header>
        <div><h1>Budget & Goals</h1><p class="muted">Set a limit and keep an eye on a goal</p></div>
        <nav><a href="/">Dashboard</a><a href="/expenses">Expenses</a><a href="/plan">Budget & Goals</a></nav>
    </header>

    <section class="panel">
        <h2>Your plan</h2>
        <form action="/plan/save" method="post" class="form-grid">
            <label>Monthly budget (₹)
                <input type="number" name="monthlyBudget" min="0" step="0.01"
                       value="${plan.monthlyBudget}" required>
            </label>
            <label>Goal name
                <input type="text" name="goalName" value="${plan.goalName}" required>
            </label>
            <label>Goal target (₹)
                <input type="number" name="goalTarget" min="0" step="0.01"
                       value="${plan.goalTarget}" required>
            </label>
            <label>Amount saved so far (₹)
                <input type="number" name="goalSaved" min="0" step="0.01"
                       value="${plan.goalSaved}" required>
            </label>
            <button type="submit">Save plan</button>
        </form>
    </section>

    <section class="panel">
        <h2>Goal progress</h2>
        <p><strong><c:out value="${plan.goalName}"/></strong></p>
        <p>₹ <c:out value="${plan.goalSaved}"/> saved out of
           ₹ <c:out value="${plan.goalTarget}"/></p>
        <c:choose>
            <c:when test="${plan.goalTarget > 0}">
                <div class="progress">
                    <div class="progress-fill"
                         style="width:${plan.goalSaved * 100 / plan.goalTarget > 100 ? 100 : plan.goalSaved * 100 / plan.goalTarget}%"></div>
                </div>
            </c:when>
            <c:otherwise><p class="muted">Set a target greater than zero to see progress.</p></c:otherwise>
        </c:choose>
    </section>
</div>
</body>
</html>
