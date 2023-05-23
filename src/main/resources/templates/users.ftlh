<!DOCTYPE html>
<html>
<head>
    <title>Shop application</title>
</head>
<body>
<h1>Shop application</h1><hr>
<h4>Список пользователей</h4>

<#list users as user>
    <div>
        <p><b>Имя:${user.firstName}</b> Мыло: ${user.lastName}| <a href="/user/${user.id}">Выбрать</a></p>
    </div>
<#else>
    <h3>Пользователей нет</h3>
</#list>
<hr>
</body>
</html>