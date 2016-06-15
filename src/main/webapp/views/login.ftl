<#assign base=rc.contextPath />
<!DOCTYPE html>
<html>
<head>
	<base id="base" href="${base}">
    <meta charset="utf-8">
    <title>login</title>
    <script src="${base}/js/login.js"></script>
</head>
<body>
<form>
<p>请登录</p>
<p>姓名:<input type="text" name="name"></p>
<p>密码:<input type="text" name="password"></p>
</form>
<button id="submit" onclick="login()">登录</button>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
</body>
</html>