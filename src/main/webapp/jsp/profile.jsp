<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body class="account-background">
<div class="container">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4"></div>
        <div class="col-lg-4"></div>
    </div>
</div>
<table class="general_table">

    <tr>
        <td><img src="${user.profilePicture}" border="2"></td>
        <td>
            <div>id:${user.id}</div>
            <div>full name:${user.fullName}</div>
            <div>bio:${user.bio}</div>
        </td>
        <td>
            <button class="btn btn-lg btn-info">Log out</button>
        </td>
    </tr>
</table>

<table class="general_table">

</table>
</body>
</html>
