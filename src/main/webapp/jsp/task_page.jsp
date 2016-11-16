<html>
<head>

</head>
<body>

<a href="/home"> <input type="submit" value="back"> </a>
<br>

<br>

Task: &nbsp     ${task.getTitle()}
<br>
Description: &nbsp ${task.getDescription()}
<br>

<a href="/delete?task=${task.getId()}">
    <input type="submit" value="delete">
</a>
<form action="/marker?task=${task.getId()}" method="post">
<input type = "submit" value="mark as done">
</form>

</body>
</html>