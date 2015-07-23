<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>TPWatcher</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="${context}/css/main.css" />
    <!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->
</head>
<body class="loading">
<div id="wrapper">
    <div id="bg"></div>
    <div id="overlay"></div>
    <div id="main">
        <header id="header">
            <h2>Welcome to TPWatcher. Click to start!</h2>

            <a href="/getcode" class="welcomeButton">GO!</a>
        </header>

        <tiles:insertAttribute name="footer" />
    </div>
</div>
<!--[if lte IE 8]><script src="/js/ie/respond.min.js"></script><![endif]-->
<script>
    window.onload = function() { document.body.className = ''; }
    window.ontouchmove = function() { return false; }
    window.onorientationchange = function() { document.body.scrollTop = 0; }
</script>
</body>
</html>