<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Khn</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</head>
<body>
    <h1>Hello world!</h1>
<%--    <p>The time on the server is ${serverTime}.</p>--%>
    <form action="user" method="post">
    <input type="text" name="userName"><br> <input type="submit" value="Login">
</form>
    <img src="<%=request.getContextPath()%>/resources/images/icon.png" alt="icon">
</body>
</html>