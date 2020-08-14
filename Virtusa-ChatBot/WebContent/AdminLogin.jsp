<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="style1.css" rel="stylesheet" type="text/css"/>
<title>Admin Login</title>
</head>
<body>
	<div class="container">
	<div>
	<input class="button1" type="button" value="Home Page" onclick="location.href='CustomerLogin.jsp';">
	</div>
       <div class="box">
                <img class="avatar" src="https://www.pngfind.com/pngs/m/528-5286002_forum-admin-icon-png-nitzer-ebb-that-total.png">
                <h1>Banker Login</h1>
		<form action="<%=request.getContextPath()%>/login1" method="post">
			<p>Banker User-ID</p>
			<input type="text" placeholder="Banker User-ID" name="ausername" required>
            <p>Password</p>
			<input type="password" placeholder="Password" name="apassword" required>
            <input type="submit" value="Login">
			
		</form>
		</div>
	</div>
</body>
</html>