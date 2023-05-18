package com.cs425.web.dao;


import java.sql.*;
import java.util.Scanner;

public class InsertUserDetails {
	
	/*
	 * webDesigned
	 * InsertUserDetails.java
	 * InstructorDao.java
	 * PersonDao.java
	 * 
	 */
	
	public static String query = null;

	    public static int insertUserInfo(String email, String name) throws SQLException {
	    	int affectedrows = 0;
	    	//Connection conn =null;	    	
	    	 query = "INSERT INTO UserINFO(email,name) VALUES(?,?)";
	    	JDBC_Connection jdbcConnection = new JDBC_Connection();
			
			try(Connection conn = jdbcConnection.connect();
					PreparedStatement pstmt = conn.prepareStatement(query)){
				conn.setAutoCommit(false);
				pstmt.setString(1,email);
			    pstmt.setString(2, name);
			    
			    //System.out.println("query: " + query);
			    affectedrows = pstmt.executeUpdate();
			    conn.commit();
			    //System.out.println("pstmt in InsertUserDetails");	
			    
			    if(!conn.isClosed()) {
					//System.out.println("connect is going to close...");
					conn.close();
					//System.out.println("connection closed in InsertUserDetails");
				}
			    //System.out.println("Record(s) updated successfully");
		        //System.out.println("affectedRows : " + affectedrows);
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
	        
	        
	        

	        return affectedrows;
	    }
	    public static void main(String args[]) throws SQLException {
	    	Scanner input = new Scanner(System.in);
	    	System.out.println("Please enter name : ");
	    	String name = input.nextLine();
	    	System.out.println("Please enter emailID : ");
	    	String email = input.next() + input.nextLine();
	    	int rowsEffect = insertUserInfo(name,email);
	    	System.out.println("--------> yet to run Query : " + query);
	    	System.out.println("rowsEffect : " + rowsEffect);
	    	
	    }
    }

