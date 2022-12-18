<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
    <nav class="navbar navbar-expand navbar-dark bg-primary">
        <div class="navbar-nav w-100">
            <a class="navbar-brand text-color">Users App</a>
        </div>
        <c:if test="${sessionScope.user != null}">
            <a class="navbar-brand text-color" href="${pageContext.request.contextPath}/users">Users list</a>
            <a class="navbar-brand text-color" href="${pageContext.request.contextPath}/logout">Log out</a>
        </c:if>
    </nav>
    </body>
</html>