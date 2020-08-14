<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String driver = "com.mysql.jdbc.Driver";

try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<script language="javascript">
function doneRecord(id){
    var f=document.form1;
    f.method="post";
    f.action='Done.jsp?id='+id;
    f.submit();
}
function pendingRecord(id){
    var f=document.form2;
    f.method="post";
    f.action='Pending.jsp?id='+id;
    f.submit();
}
</script>
<style>
.d1{
  width: 106%;
    height: 10%;
    margin: 0 auto;
    background-color: #708090;
}
 .button{
 line-height: 12px;
     width: 150px;

     font-family: tahoma;
     margin-top: 25px;
     margin-right: 40px;
     position:absolute;
     top:0;
     right:0;
     display: block;
    border: none;
    outline: none;
    height: 35px;
    background: #eccc68;
    color: #000;
    font-size: 20px;
    border-radius: 20px;
 
 
 }
 .button:hover{
    border: none;
    outline: none;
    height: 35px;
    background: #ff6348;
    color: #fff;
    font-size: 20px;
    border-radius: 20px;
    cursor: pointer;
    transition: .3s ease-out;
 }
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 95%;
  
}

td, th {
  border: 1px solid black;
  text-align: center;
  padding: 8px;
  width:100%;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
/* Set height of body and the document to 100% to enable "full page tabs" */
body, html {
  height: 100%;
  margin: 0;
  font-family: Arial;
  width:100%;
}

/* Style tab links */
.tablink {
  background-color: #555;
  color: white;
  float: left;
  border: 2px solid black;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 50%;
}
.tab{
	width: 100%;
}
.tablink:hover {
  background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
  color: black;
  display: none;
  padding: 100px 20px;
  height: 100%;
  width: 103%;
}

#Pending {background-color: #708090;}
#Done {background-color: #708090;}

</style>

</head>
<body>

<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
<script>
function alert()
{	
	swal ('Logout Suceesfully!!!','','success').then(() => {	
		var delayInMilliseconds = 1000; //1 second
		setTimeout(function() {
			
			location='AdminLogin.jsp';
			
		}, delayInMilliseconds);
	});
	
}

</script>
<div class="d1"><Button  class="button" type="button"  onclick="alert()">Logout</Button>
<div id="cust_head" >
<h1 style="text-align:center;">Customer Data</h1>
</div>
</div>

<div class="tab">
  <button class="tablink" onclick="openPage('Pending', this,'green')" id="defaultOpen">Pending</button>
<button class="tablink" onclick="openPage('Done', this,'green')">Done</button>
</div>
<div id="Pending" class="tabcontent">
<form method="post" name="form1">
<table border="1">
<tr>
<th>Query No.</th>
<th>Time</th>
<th>Name</th>
<th>Adhar</th>
<th>Account No</th>
<th>Mobile</th>
<th>Loan</th>
<th>Income-Src</th>
<th>Monthly-Src</th>
<th>EMI</th>
<th>Wage-Cut</th>
<th>Affect</th>
<th>Covid-Zone</th>
<th>Rent</th>
<th>Terms</th>
<th>Repay-Month</th>
<th>Change Status</th>
</tr>
<tr>
	<%
	try{
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC", "root", "");
	statement=connection.createStatement();
	String sql ="select * from details where status='Pending'";
	resultSet = statement.executeQuery(sql);
	%>
	<%
	while(resultSet.next()){
	%>
	<tr>
	<td><%=resultSet.getString("id") %></td>
	<td><%=resultSet.getString("time") %></td>
	<td><%=resultSet.getString("name") %></td>
	<td><%=resultSet.getString("adhar") %></td>
	<td><%=resultSet.getString("account_no") %></td>
	<td><%=resultSet.getString("mobile") %></td>
	<td><%=resultSet.getString("loan") %></td>
	<td><%=resultSet.getString("income_source") %></td>
	<td><%=resultSet.getString("month_income") %></td>
	<td><%=resultSet.getString("month_emi") %></td>
	<td><%=resultSet.getString("wagecut") %></td>
	<td><%=resultSet.getString("affect") %></td>
	<td><%=resultSet.getString("zone") %></td>
	<td><%=resultSet.getString("rent") %></td>
	<td><%=resultSet.getString("terms") %></td>
	<td><%=resultSet.getString("repay") %></td>
	<td><input type="button" name="done" value="Done" style="background-color:green;font-weight:bold;color:white;" onclick="doneRecord(<%=resultSet.getString("id")%>);" ></td>
	</tr>
	<% }

	}
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	%>
</table>
</form>
</div>
<div id="Done" class="tabcontent">
<form method="post" name="form2">
  <table border="1">
<tr>
<th>Query No.</th>
<th>Time</th>
<th>Name</th>
<th>Adhar</th>
<th>Account No</th>
<th>Mobile</th>
<th>Loan</th>
<th>Income-Src</th>
<th>Monthly-Src</th>
<th>EMI</th>
<th>Wage-Cut</th>
<th>Affect</th>
<th>Covid-Zone</th>
<th>Rent</th>
<th>Terms</th>
<th>Repay-Month</th>
<th>Change Status</th>
</tr>
<tr>
	<%
	try{
	String sql ="select * from details where status='Done'";
	resultSet = statement.executeQuery(sql);
	%>
	<%
	while(resultSet.next()){
	%>
	<tr>
	<td><%=resultSet.getString("id") %></td>
	<td><%=resultSet.getString("time") %></td>
	<td><%=resultSet.getString("name") %></td>
	<td><%=resultSet.getString("adhar") %></td>
	<td><%=resultSet.getString("account_no") %></td>
	<td><%=resultSet.getString("mobile") %></td>
	<td><%=resultSet.getString("loan") %></td>
	<td><%=resultSet.getString("income_source") %></td>
	<td><%=resultSet.getString("month_income") %></td>
	<td><%=resultSet.getString("month_emi") %></td>
	<td><%=resultSet.getString("wagecut") %></td>
	<td><%=resultSet.getString("affect") %></td>
	<td><%=resultSet.getString("zone") %></td>
	<td><%=resultSet.getString("rent") %></td>
	<td><%=resultSet.getString("terms") %></td>
	<td><%=resultSet.getString("repay") %></td>
	<td><input type="button" name="pending" value="Pending" style="background-color:red;font-weight:bold;color:white;" onclick="pendingRecord(<%=resultSet.getString("id")%>);" ></td>
	</tr>
	<% }

	}
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	%>
</table>
</form>
</div>


<script>
function openPage(pageName, elmnt,color) {
	  // Hide all elements with class="tabcontent" by default */
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }

	  // Remove the background color of all tablinks/buttons
	  tablinks = document.getElementsByClassName("tablink");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].style.backgroundColor = "";
	  }

	  // Show the specific tab content
	  document.getElementById(pageName).style.display = "block";

	  // Add the specific color to the button used to open the tab content
	  elmnt.style.backgroundColor = color;
	}

	//Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
</script>

</body>
</html>