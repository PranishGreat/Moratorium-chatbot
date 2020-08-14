package com.pranish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pranish.model.Admin;
import com.pranish.security.AESEncryption;


public class AdminDao {

	public boolean validate(Admin admin) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try {
			//DataBase Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC", "root", "");
			PreparedStatement preparedStatement = connection.prepareStatement("select ausername,apassword from banker");
			//It is the Private Secret Key
			final String secretKey = "Virtusa@2021#";
			String username=admin.getAdminname();
			String password=admin.getAPassword();
			
			ResultSet rs = preparedStatement.executeQuery();;
		    while(rs.next()) 
		    {
		    	  if(username.equals(rs.getString("ausername")) && password.equals(AESEncryption.decrypt(rs.getString("apassword"), secretKey)))
		    	  {
		    		  status=true;
		    		  break;
		    	  }
		    	  else
		    	  {
		    		  status=false;
		    	  }
		    }		
		} catch (SQLException e) {
			System.err.println("Message: " + e);
		}
		return status;
	}

	
}
