<!DOCTYPE html>
<html>
<head>
    <title>Shop application</title>
</head>
<body>
<h1>Shop application</h1><hr>
<h4>Существующие пользователи</h4>
<b>Имя: </b>${user.first_name}<br>
<b>Фамилия: </b>${user.last_name}<br>
<b>Почта: </b>${user.e_mail}<br>

<hr>
<form action="/user/delete/${user.id}" method="post">
    <input type="submit" value="Удалить пользователя"/>
</form>
</body>
</html>