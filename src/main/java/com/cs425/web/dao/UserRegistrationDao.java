package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistrationDao {

	public static String query = null;

	public static int userRegistration(String name, String emailID) throws SQLException {
		int affectedrows = 0;
		query = "INSERT INTO UserInfo(Name,Email) VALUES(?,?)";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		
		if(!UserDetailsFetchDao.isUserEmailExists(emailID)) {
			try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
				conn.setAutoCommit(false);
				
				pstmt.setString(1, name);
				pstmt.setString(2, emailID);

				//System.out.println("query: " + query);
				//before going to executeUpdate we need to check whether the primariy key
				//constraints are exists or not ...
				affectedrows = pstmt.executeUpdate();

				conn.commit();
				//System.out.println("pstmt in InsertUserDetails");

				if (!conn.isClosed()) {
					//System.out.println("connect is going to close...");
					conn.close();
					pstmt.close();
					//System.out.println("connection closed in InsertUserDetails");
				}
				System.out.println("Record(s) updated successfully");
				//System.out.println("affectedRows : " + affectedrows);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}else {
			System.out.println("User with email : '" + emailID + "' already Registered");
		}
		return affectedrows;
	}

	public static void main(String args[]) throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter user registration Details : ");
		System.out.println("Please enter User name : ");
		String name = input.nextLine();
		System.out.println("Please enter User emailID : ");
		String email = input.next() + input.nextLine();
		int rowsEffect = userRegistration(name, email);
		// System.out.println("--------> yet to run Query : " + query);
		// System.out.println("rowsEffect : " + rowsEffect);

	}

	

}
