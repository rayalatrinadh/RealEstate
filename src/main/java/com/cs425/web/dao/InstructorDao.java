package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Instructor;

public class InstructorDao {
	
	/*
	 * webDesigned
	 * InsertUserDetails.java
	 * InstructorDao.java
	 * PersonDao.java
	 * 
	 */
	
	public static Instructor getInstructor(String iID) throws SQLException {
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		Instructor ob1 = new Instructor();
        String query = "SELECT id, name, dept_name, salary "
        		+ "FROM instructor "
        		+ "WHERE id = ?";
        
        try(Connection conn = jdbcConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(query)){
			conn.setAutoCommit(false);
			pstmt.setString(1, iID.trim());
			System.out.println("query: " + query);
		    ResultSet rs = pstmt.executeQuery(); //executeQuery
            conn.commit();
            
            while (rs.next()) {
            	/* Retrieves the value of the designated column in the current row 
            	   of this ResultSet object as a String in the Java programming language.
            	*/
            	ob1.setID(rs.getString("id"));
            	ob1.setName(rs.getString("name")); 
                ob1.setDept_name(rs.getString("dept_name"));
                ob1.setSalary(rs.getDouble("salary"));
            }
            
		    if(!conn.isClosed()) {
				System.out.println("connect is going to close...");
				conn.close();
				System.out.println("connection closed in InstructorDao.java");
			}
		    System.out.println("Record(s) Fetched successfully");
	        
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return ob1;
	}
	
	public static void main(String args[]) throws SQLException {
		Instructor n = getInstructor("2");
	}
}
