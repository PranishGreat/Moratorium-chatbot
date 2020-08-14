<%@page import="java.net.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="style1.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	
	<div class="container">
		<div class="marquee">
			<marquee  direction="left" scrollamount="12" behavior="scroll">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome!!<br>Moratorium Chatbot</marquee>
		</div>
	<div>
	<input class="button1" type="button" value="Banker's Login" onclick="location.href='AdminLogin.jsp';">
	</div>
	</div>
			
       <div class="box">
                <img class="avatar" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKG7JCtMIJ9ROpvqn8G6SHGe2Z_r56b_Xejuq-gES1kzrhYJk&s">
                <h1>Login Account</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<p>Email</p>
			<input type="text" placeholder="Email" name="email" required>
            <p>Password</p>
			<input type="password" placeholder="Password" name="password" required>
                    <input type="submit"  name="check" value="Login">
			<a href="CustomerRegister.jsp">Create New Account</a>
		</form>

	</div>

	<script>
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
  close[i].onclick = function(){
    var div = this.parentElement;
    div.style.opacity = "0";
    setTimeout(function(){ div.style.display = "none"; }, 600);
  }
}
function c(){
	 document.getElementById("a").style.color = "red";
}
</script>
</body>
</html>