
package com.pranish.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pranish.dao.CustomerLoginDao;
import com.pranish.model.CustomerLogin;


@WebServlet("/login")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerLoginDao loginDao;

	//Initialize the CustomerLoginDAO
	public void init() {
		loginDao = new CustomerLoginDao();
	}
	
	//Handle POST Requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//Taken Parameter from JSP form Fields
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//CustomerLogin Model Class		
		CustomerLogin loginBean = new CustomerLogin();
		//Setters
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		
		try {
			//Check if Customer Credentials in DataBase
			if (loginDao.validate(loginBean)) {
				//This is SweetAlert Code Template
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ('Welcome To Chatbot','','success');");
				out.println("});");	
				out.println("</script>");
				//Redirect to ChatBot after login successful
				RequestDispatcher rd= request.getRequestDispatcher("ChatBot.jsp");
				rd.include(request, response);
			} else {
				//This is SweetAlert Code Template
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ('InValid Username or Password','','error');");
				out.println("});");	
				out.println("</script>");
				//Redirect to CustomerLogin after login unsuccessful
				RequestDispatcher rd= request.getRequestDispatcher("CustomerLogin.jsp");
				rd.include(request, response);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
