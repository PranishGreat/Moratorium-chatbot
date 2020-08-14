package com.pranish.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pranish.dao.AdminDao;
import com.pranish.model.Admin;

@WebServlet("/login1")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao;
	
	//Initialize the AdminDAO
	public void init() {
		
		adminDao = new AdminDao();
	}
	
	//Handle POST Requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//Taken Parameter from JSP form Fields
		String ausername = request.getParameter("ausername");
		String apassword = request.getParameter("apassword");
		//Admin Model Class
		Admin adminBean = new Admin();
		//Setter
		adminBean.setAdminname(ausername);
		adminBean.setAPassword(apassword);

		try {
			//Check if Bankers Credentials in DataBase
			if (adminDao.validate(adminBean)) {
				//This is SweetAlert Code Template
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ('Correct !!!','Admin Login Successful','success');");
				out.println("});");				
				out.println("</script>");
				//Redirect to Display after login successful
				RequestDispatcher rd= request.getRequestDispatcher("Display.jsp");
				rd.include(request, response);
			} else {
				//This is SweetAlert Code Template
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ('Incorrect !!','','error');");
				out.println("});");			
				out.println("</script>");
				//Redirect to AdminLogin after login unsuccessful
				RequestDispatcher rd= request.getRequestDispatcher("AdminLogin.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			//Exceptions
			e.printStackTrace();
		}
	}
}
