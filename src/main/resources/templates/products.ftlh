<!DOCTYPE html>
<html>
<head>
    <title>Shop application</title>
</head>
<body>
<h1>Shop application</h1><hr>
<h4>Список товаров</h4>
<form action="/" method="get">
    Поиск по товарам: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Выбрать</a></p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
</body>
</html>