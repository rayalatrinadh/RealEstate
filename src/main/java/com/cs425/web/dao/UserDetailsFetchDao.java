package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDetailsFetchDao {

	public static ArrayList<String> primaryKeyEmailList = new ArrayList<>();
	public static String query = null;

	
	
	public static void userDetailsFetch() throws SQLException {
	    String query = "SELECT * FROM UserInfo";

	    JDBC_Connection jdbcConnection = new JDBC_Connection();

	    try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
	        conn.setAutoCommit(false);
	        ResultSet rs = pstmt.executeQuery();
	        conn.commit();
	        
	        System.out.println("+----------------------------------------------+----------------------------------------------+");
	        System.out.println("|                    Name                      |                     Email                    |");
	        System.out.println("+----------------------------------------------+----------------------------------------------+");

	        while (rs.next()) {
	            String name = rs.getString("Name");
	            String email = rs.getString("Email");

	            String formattedName = String.format("| %-45s", name);
	            String formattedEmail = String.format("| %-45s", email);

	            System.out.println(formattedName + formattedEmail + "|");
	            System.out.println("+----------------------------------------------+----------------------------------------------+");
	        }

	        if (!conn.isClosed()) {
	        	System.out.println("\n\n");
	            conn.close();
	            pstmt.close();
	            rs.close();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}



	public static void main(String args[]) throws SQLException {
		userDetailsFetch();
	}

	// check whether the primariy key constraints are exists or not ...
	public static boolean isUserEmailExists(String checkEmailExists) throws SQLException {
		userDetailsCheck();
		return primaryKeyEmailList.contains(checkEmailExists) ? true : false;
	}

	public static void userDetailsCheck() throws SQLException {
		query = "SELECT * FROM UserInfo";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			conn.setAutoCommit(false);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while (rs.next()) {
				String email = rs.getString("Email");
				primaryKeyEmailList.add(email);
			}
			if (!conn.isClosed()) {
				// System.out.println("connect is going to close...");
				conn.close();
				// System.out.println("connection closed in InsertUserDetails");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("error in UserDetailsFetchDao.java -> userDetailsCheck()");
		}
	}

}
