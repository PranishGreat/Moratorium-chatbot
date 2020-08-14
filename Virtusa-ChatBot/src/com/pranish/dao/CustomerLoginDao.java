package com.pranish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pranish.model.CustomerLogin;
import com.pranish.security.AESEncryption;

public class CustomerLoginDao {

	public boolean validate(CustomerLogin custlogin) throws ClassNotFoundException 
	{
		boolean status = false;
		Class.forName("com.mysql.jdbc.Driver");
		try 
		{
			//DataBase Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC", "root", "");
			PreparedStatement preparedStatement = connection.prepareStatement("select email,password from customer"); 
			//It is the Private Secret Key
			final String secretKey = "Virtusa@2021#";
			
			String email=custlogin.getEmail();
			String password=custlogin.getPassword();
			ResultSet rs = preparedStatement.executeQuery();;

		    while(rs.next()) 
		    {
		    	  if(email.equals(rs.getString("email")) && password.equals(AESEncryption.decrypt(rs.getString("password"), secretKey)))
		    	  {
		    		  status=true;
		    		  break;
		    	  }
		    	  else
		    	  {
		    		  status=false;
		    	  }
		    }
		} 
		catch (SQLException e) 
		{
			System.err.println(e);
		}
		return status;
	}

}