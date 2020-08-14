package com.pranish.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pranish.dao.CustomerRegisterDao;
import com.pranish.model.CustomerRegister;


@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private CustomerRegisterDao custRegdao;

  //Initialize the CustomerRegisterDAO
    public void init() {
        custRegdao = new CustomerRegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 PrintWriter out=response.getWriter();
    	 //Taken Parameter from JSP form Fields
	     String username1 = request.getParameter("username");
	     String password = request.getParameter("password");
	     String password1=request.getParameter("password1");
	     String email = request.getParameter("email");
	     //CustomerRegister Model Class	
	     CustomerRegister custreg = new CustomerRegister();
	     
	     custreg.setUsername(username1);
	     custreg.setPassword(password);
	     custreg.setEmail(email);
     try {
    	 //MYSQL Connection
    	 Class.forName("com.mysql.jdbc.Driver");
    	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC", "root", "");

         PreparedStatement st = connection.prepareStatement("select * from customer where username = ?");
         st.setString(1, username1);
         
         ResultSet r1=st.executeQuery();
         //checking Username already exist
         if(r1.next()) 
          {
				//This is SweetAlert Code Template
        	  	out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
        		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
        		out.println("<script>");
        		out.println("$(document).ready(function(){");
        		out.println("swal ('Username already exist','','error');");
        		out.println("});");
        		out.println("</script>");
        		//Redirect to CustomerRegister after Username already exist
        		RequestDispatcher rd= request.getRequestDispatcher("CustomerRegister.jsp");
    			rd.include(request, response);

          }
          else
          {
        	PreparedStatement st1 = connection.prepareStatement("select * from customer where email = ?");
      	  	st1.setString(1, email);
      	  	ResultSet r2=st1.executeQuery();
      	  	//checking Email already exist
  			if(r2.next())
      	  	{	//This is SweetAlert Code Template
      	  		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
          		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
          		out.println("<script>");
          		out.println("$(document).ready(function(){");
          		out.println("swal ('Email already exist','','error');");
          		out.println("});");
          		out.println("</script>");
        		//Redirect to CustomerRegister after Email already exist         		
          		RequestDispatcher rd= request.getRequestDispatcher("CustomerRegister.jsp");
      			rd.include(request, response);
      	  	}
      	  	else
      	  	{
      	  		//checking the password is matched
      	  	if(password.equals(password1)) {
      			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
      			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
      			out.println("<script>");
      			out.println("$(document).ready(function(){");
      			out.println("swal ('Submitted Successful','','success');");
      			out.println("});");
      			out.println("</script>");
      			try {
      				custRegdao.registerEmployee(custreg);		
      			} catch (ClassNotFoundException e) {
      				e.printStackTrace();
      			}
      			
      			RequestDispatcher rd= request.getRequestDispatcher("CustomerLogin.jsp");
      			rd.include(request, response);

      			}
      	  	else {
      				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
      				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
      				out.println("<script>");
      				out.println("$(document).ready(function(){");
      				out.println("swal ('Wrong Password !!','','error');");
      				out.println("});");
      				out.println("</script>");
      				RequestDispatcher rd= request.getRequestDispatcher("CustomerRegister.jsp");
      				rd.include(request, response);
      			}
      	  	}
          }
     }
     catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
     catch (ClassNotFoundException cE) 
     {
        System.out.println("Class Not Found Exception: "+ cE.toString());
     }

    }
}
