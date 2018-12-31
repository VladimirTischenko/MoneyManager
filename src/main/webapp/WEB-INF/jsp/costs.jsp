<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://moneymanager/functions" %>
<html>
<head>
    <title>Cost list</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3>Cost list</h3>
    <form method="post" action="costs?action=filter">
        <dl>
            <dt>From Date:</dt>
            <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
        </dl>
        <dl>
            <dt>To Date:</dt>
            <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
        </dl>
        <dl>
            <dt>From Time:</dt>
            <dd><input type="time" name="startTime" value="${param.startTime}"></dd>
        </dl>
        <dl>
            <dt>To Time:</dt>
            <dd><input type="time" name="endTime" value="${param.endTime}"></dd>
        </dl>
        <button type="submit">Filter</button>
    </form>
    <hr>
    <a href="costs?action=create">Add Cost</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${costs}" var="cost">
            <jsp:useBean id="cost" scope="page" type="moneyManager.to.CostWithExceed"/>
            <tr class="${cost.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--${cost.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(cost.getDateTime())%>--%>
                        ${fn:formatDateTime(cost.dateTime)}
                </td>
                <td>${cost.description}</td>
                <td>${cost.price}</td>
                <td><a href="costs?action=update&id=${cost.id}">Update</a></td>
                <td><a href="costs?action=delete&id=${cost.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>