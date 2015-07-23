<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>TPWatcher</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="${context}/css/main.css" />
	<link rel="stylesheet" href="${context}/css/angular-backtop.css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->
	<script src="/js/angular/angular.js"></script>
	<script src="/js/angular/angular-route.js"></script>
	<script src="/js/Controller.js"></script>
</head>
<body class="loading" ng-app = "socialStat" ng-controller="UsersController">
<div id="wrapper">
	<div id="bg"></div>
	<div id="overlay"></div>
	<div id="main" >
		<header id="header">
			<tiles:insertAttribute name = "profile" />
			<nav>
				<ul>
					<li><a href="/profile.tiles" ng-click="refresh()"><span class="label"></span>Profile</a></li>
					<li><a href="" ng-click="getUsers('/watch/follow')" ><span class="label"></span>Followers</a></li>
					<li><a href="" ng-click="getUsers('/watch/followed-by')"><span class="label"></span>Followed by</a></li>
					<li><a href="/watch/statistic"><span class="label"></span>Statistic</a>
					<li><a href="#"><span class="label"></span>Feed</a></li>
				</ul>
			</nav>
		</header>

		<div id="scroll">
		<div ng-show="isUserShow">
			<div ng-repeat="user in users"><br><img src="{{user.profilePicture}}"><br>{{user.username}}</div>
		</div>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>

</div>
<!--[if lte IE 8]><script src="/js/ie/respond.min.js"></script><![endif]-->
<script>
	window.onload = function() { document.body.className = ''; };
	window.ontouchmove = function() { return false; };
	window.onorientationchange = function() { document.body.scrollTop = 0; }
</script>
</body>
</html>