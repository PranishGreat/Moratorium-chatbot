package com.pranish.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pranish.dao.DetailsDao;
import com.pranish.model.Details;


@WebServlet("/save")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetailsDao detailsDao;
	
	public void init() {
		detailsDao = new DetailsDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String time =request.getParameter("time");
		String mobile = request.getParameter("mobile");
		String loan = request.getParameter("loan");
		String incomesource = request.getParameter("incomesource");
		String monthincome = request.getParameter("monthincome");
		String monthemi = request.getParameter("monthemi");
		String wagecut = request.getParameter("wagecut");
		String affect = request.getParameter("affect");
		String zone = request.getParameter("zone");
		String rent = request.getParameter("rent");
		String terms = request.getParameter("terms");
		String repay = request.getParameter("repay");
		String adhar = request.getParameter("adhar");
		
		Details details = new Details();

		details.setName(name);
		details.setTime(time);
		details.setMobile(mobile);
		details.setLoan(loan);
		details.setIncomesource(incomesource);
		details.setMonthincome(monthincome);
		details.setMonthemi(monthemi);
		details.setWagecut(wagecut);
		details.setAffect(affect);
		details.setZone(zone);
		details.setRent(rent);
		details.setTerms(terms);
		details.setRepay(repay);
		details.setAdhar(adhar);
	
		try {
			 	Class.forName("com.mysql.jdbc.Driver");
			 	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC", "root", "");

			 	PreparedStatement st = connection.prepareStatement("select adhar_name,adhar_no,acc_no from adhar");
			 	ResultSet rs = st.executeQuery();
			 	RequestDispatcher rd= request.getRequestDispatcher("ChatBot.jsp");
		    	rd.include(request, response);
		    	
			 	while(rs.next()) 
			    {
			 		  
			    	  if(name.equals(rs.getString("adhar_name")) && adhar.equals(rs.getString("adhar_no")))
			    	  {
			    		  String account_no=rs.getString("acc_no");
				 		  details.setAccount(account_no);
			    		  detailsDao.registerDetails(details);
			    		  
			    		  
			    		  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			    		  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			    		  out.println("<script>");
			    		  out.println("$(document).ready(function(){");
			    		  out.println("swal ('Submitted Successful','','success');");
			    		  out.println("});"); 
			    		  out.println("</script>");
			    		  out.println("<script>download();</script>");
			    		 
			    		 break;
			    	  }
			    	  else
			    	  {
			    		  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			    		  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			    		  out.println("<script>");
			    		  out.println("$(document).ready(function(){");
			    		  out.println("swal ('Wrong Adhar or Name','','error');");
			    		  out.println("});");
			    		  out.println("</script>");  
			    	  }
			    	  
			    }
			    
			
			} catch (Exception e) {

			e.printStackTrace();
		}
		
		}
}