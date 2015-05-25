<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body class="account-background">

<table class="general_table">

    <tr>
        <td><img src="${user.profilePicture}" border="2"></td>
        <td>
            <div>id:${user.id}</div>
            <div>Nick name:${user.userName}</div>
        </td>
        <td>
            <button class="btn btn-lg btn-info">Log out</button>
                <button class="btn btn-lg btn-info">My photo</button>
        </td>
    </tr>
</table>
<c:forEach var="im" items="${media}">
<table class="general_table">
        <tr>
            <td><img src="${im.user.profilePicture}"><p align="center">${im.user.userName}</p></td>
        </tr>
        <tr>
            <td><img src="${im.mediaContent.url}" width="${im.mediaContent.width}" height="${im.mediaContent.height}"></td>
        </tr>
        <tr>
            <td>
                <div>Likes: ${im.numberLikes}</div>
                <div>Comments: ${im.numberComments}</div>
                <c:forEach var="comment" items="${im.comments}">
                    <div>${comment.user.userName}: ${comment.text}</div>
                </c:forEach>
            </td>
        </tr>
</table>
</c:forEach>
</body>
</html>
