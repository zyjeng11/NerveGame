
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Questions</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./nervegame.css">
    </head>
    <body class="fin-page">
        <div>恭喜你過關了!!</div>
        <p>↓ 再玩一次 ↓</p>
        <ol>
            <c:forEach items="${questions}" var="q" varStatus="st">
                <li><a href="QuestionServlet?id=${q.id}">${q.question}</a></li>
            </c:forEach>
        </ol>
    </body>
</html>

