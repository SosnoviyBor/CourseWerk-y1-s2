<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сторінка адміністратора</title>
</head>
    <body>
        <a href="index.jsp"><h1 align="center">Новини, що ми заслужили</h1></a>
        <c:if test="${admin != null}">
            <form action="AdminLogoutServlet" method="POST">
                <p>
                    Ви авторизовані як користувач <b><c:out value="${admin.getName()}"/>&nbsp;</b>
                    <input type="submit" value="Вийти"/>
                </p>
            </form>
            <p style="color: red">${message}</p>
            <p>
                Категорію вказувати номером, а саме:<br>
                <b>1</b> - для "COVID-19"<br>
                <b>2</b> - для "Політики"<br>
                <b>3</b> - для "Мистецтва"<br>
                <b>4</b> - для "Науки і технологій"<br>
                <b>5</b> - для "Спорту"
            </p>
            <form action="AdminNewsServlet" method="POST">
                <input type="text" name="name" placeholder="Заголовок" value="${nameVal}"/><br>
                <input type="text" name="desc" placeholder="Текст новини" value="${descVal}"/><br>
                <input type="text" name="date" placeholder="Дата" value="${dateVal}"/><br>
                <input type="number" name="category" placeholder="Катег." value="${categoryVal}" min="1" max="5"/><br>
                <input type="submit" value="Додати новину"/>
            </form>
        </c:if>
        <c:if test="${admin == null}">
            <div align="center">
                <h2>Авторизуйтесь, будь ласка</h2>
                <h3>${message}</h3>
                <form action="AdminLoginServlet" method="POST">
                    <input type="text" name="login" size="30" placeholder="Логін"/><br>
                    <input type="password" name="password" size="30" placeholder="Пароль"/><br>
                    <input type="submit" value="Увійти"/>
                </form>
            </div>
        </c:if>
    </body>
</html>


