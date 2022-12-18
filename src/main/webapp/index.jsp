<%@ page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Users App</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <%@include file="fragments/header.jsp" %>
    <div class="container" style="padding-top: 10vh; display: flex; flex-direction: column; align-items: center;">
        <h3>Please login to continue</h3>
        <form action="login" method="post">
            <div class="form-group row">
                <label for="username" class="col-2 col-form-label">Username:</label>
                <input name="username" class="form-control" />
            </div>
            <div class="form-group row">
                <label for="password" class="col-2 col-form-label">Password:</label>
                <input type="password" name="password" class="form-control" />
            </div>
            <div class="text-center">
                <p>${message}</p>
            </div>
            <button type="submit" class="btn btn-primary" >Login</button>
        </form>
    </div>
</body>
</html>
