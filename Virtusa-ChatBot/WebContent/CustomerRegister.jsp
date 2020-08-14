	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="style1.css" rel="stylesheet" type="text/css"/>
 

</head>
<body>
 <div class="container">
 
            <div class="regbox box">
                <img class="avatar" src="https://www.icba.org/images/default-source/logos/icons/education-icons/director_blue_people.png?sfvrsn=bb2e9008_4">
                <h1>Register Account</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
 <p>Username</p>
<input type="text" placeholder="Username" name="username" pattern="^[aA-zZ]{5,}$" title="Must conatin atleast 6 characters" required>
                   <p>Useremail</p>
<input type="text" placeholder="Useremail" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                   <p>Password</p>
<input type="password" placeholder="Password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
                   <p>Confirm-Password</p>
<input type="password" placeholder="Confirm-Password" name="password1" required>
   <input type="submit" value="Submit" />
   <a href="CustomerLogin.jsp">Already have Account?</a>
  </form>
  </div>
 </div>
</body>
</html>