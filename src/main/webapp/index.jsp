<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<input type="submit" value="Add Task" onclick="window.location='jsp/new_task.jsp'"><br>

Things to do:
<br>

<c:forEach items="${taskList}" var="item">

    &nbsp ${item.getTitle()} &nbsp <a href="/task_page?task=${item.getId()}"> details </a>
    <br>

</c:forEach>

Already done:
<br>

<c:forEach items="${doneTasks}" var="item">

    &nbsp ${item.getTitle()} &nbsp <a href="/task_page?task=${item.getId()}"> details </a>
    <br>

</c:forEach>


</body>
</html>