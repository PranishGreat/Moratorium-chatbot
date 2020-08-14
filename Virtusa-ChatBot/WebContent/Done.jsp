
<%@page import="java.sql.*"%>
<%
String ide=request.getParameter("id");
try{
Connection conn = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC","root", "");
Statement st=null;
st=conn.createStatement();
st.executeUpdate("update details set status='Done' where id='"+ide+"'");
response.sendRedirect("Display.jsp");
}
catch(Exception e){
System.out.println(e);
}
%>