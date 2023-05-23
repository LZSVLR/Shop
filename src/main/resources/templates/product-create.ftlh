<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Создать новый товар</title>
</head>
<body>
<h1>Создать новый товар</h1>
<form action="/product/create" method="post">
  Название объявления: <input type="text" name="title"/><br><br>
  Описание объявления: <input type="text" name="description"/><br><br>
  Цена: <input type="number" name="price"/><br><br>
  Кол-во: <input type="number" name="value"/><br><br>
  <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>