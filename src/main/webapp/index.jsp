<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Новини, що ми заслужили</title>
</head>
<body>
    <div align="center">
        <a href="index.jsp"><h1>Новини, що ми заслужили</h1></a>
        <form action="NewsSearchServlet" method = "post">
            <input type="text" name="searchedText" value="${text}" />
            <input type="submit" value="Пошук"/>
        </form>
    </div>
    <table width="80%" align="center">
        <tr><td>&nbsp;</td></tr>
        <tr valign="bottom">
            <td></td>
            <td><h3>Новини:</h3></td></tr>
        <tr valign="top">
            <td>
                <li><a href="NewsByCategoryServlet?id=1">COVID-19</a></li>
                <li><a href="NewsByCategoryServlet?id=2">Політика</a></li>
                <li><a href="NewsByCategoryServlet?id=3">Мистецтво</a></li>
                <li><a href="NewsByCategoryServlet?id=4">Наука і технології</a></li>
                <li><a href="NewsByCategoryServlet?id=5">Спорт</a></li>
                <p><a href="adminPage.jsp">Увійти як адміністратор</a></p>
            </td>
            <td>
                <c:forEach var="news" items="${viewedNews}">
                    <a href="OpenNewsServlet?open=${news.getId()}"><c:out value="${news.getName()}"/></a><br>
                </c:forEach>
            </td>
        </tr></table>
</body>
</html>
