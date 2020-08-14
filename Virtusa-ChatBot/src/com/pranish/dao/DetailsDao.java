package com.pranish.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pranish.model.Details;


public class DetailsDao {

	    public int registerDetails(Details details) throws ClassNotFoundException {
	    	String INSERT_USERS_SQL = "INSERT INTO details" + "  (id,time,name, mobile, loan, income_source, month_income, month_emi,wagecut, affect, zone, rent, terms, repay, adhar, account_no, status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	        int result = 0;
	        
	        Class.forName("com.mysql.jdbc.Driver");

	        int i = 0;
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC", "root", "");
	        	

	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, i);
	            preparedStatement.setString(2, details.getTime());
	            preparedStatement.setString(3, details.getName());
	            preparedStatement.setString(4, details.getMobile());
				preparedStatement.setString(5, details.getLoan());
				preparedStatement.setString(6, details.getIncomesource());
				preparedStatement.setString(7, details.getMonthincome());
	            preparedStatement.setString(8, details.getMonthemi());
				preparedStatement.setString(9, details.getWagecut());
				preparedStatement.setString(10, details.getAffect());
				preparedStatement.setString(11, details.getZone());
				preparedStatement.setString(12, details.getRent());
	            preparedStatement.setString(13, details.getTerms());
				preparedStatement.setString(14, details.getRepay());
				preparedStatement.setString(15, details.getAdhar());
				preparedStatement.setString(16, details.getAccount());
				preparedStatement.setString(17, details.getStatus());
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        i++;
	        return result;
	    }
	}