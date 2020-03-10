<%@ page session="false" %><!-- 勝手にSessionオブジェクトを生成しないようにする -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>userinfo</title></head>
<body>
<div id="container">
    <div id="content">
        <h1>User info:</h1>
        <table style="border: 1px black solid;">
        <c:forEach var="info" items="${informations}">
            <tr><td><c:out value="${info.key}"/></td><td><c:out value="${info.value}"/></td></tr>
        </c:forEach>
        </table>
    </div>
    <form action="/SpringMVCMbaits/logout" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input name="login" value="Logout" type="submit"/>
    </form>
</div>
</body>
</html>