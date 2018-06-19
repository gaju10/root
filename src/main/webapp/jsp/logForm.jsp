<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/login.css" type="text/css">
    <meta charset="UTF-8">
    <title>ASDF</title>
</head>
<body>
<div class="container">
    <img src="../img/man.png">
    <form method="post" action="${pageContext.request.contextPath}/MyServlet">
        <div class="dws-input">
            <input type="text" name="username" placeholder="Введите логин">
        </div>
        <div class="dws-input">
            <input type="password" name="password" placeholder="Введите пароль">
        </div>
        <input class="dws-submit" type="submit" name="submit" value="ВОЙТИ"><br/>
        <a href="#">Восстановить пароль</a>
    </form>
</div>
</body>
</html>

