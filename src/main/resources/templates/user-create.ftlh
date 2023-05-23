<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создать нового пользователя</title>
</head>
<body>
<h1>Создать пользователя</h1>
<form action="/user/create" method="post">
    Имя: <input type="text" name="first_name"/><br><br>
    Фамилия: <input type="text" name="last_name"/><br><br>
    Почта: <input type="text" name="e_mail"/><br><br>
    <input type="submit" value="Добавить юзера"/>
</form>
</body>
</html>