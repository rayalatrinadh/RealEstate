package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RenterRegistration {
	
	public static int renterRegistration(String email,String userID, Date moveindate,String location,int budget, int rewards,String renterName) {
		int effectedRows = 0;
		
		String renterInserQuery = "INSERT INTO Agent (email, jobtitle, agencyname, phonenumber01, phonenumber02, userid)"+
				"VALUES (?,?,?,?,?,?);";
		
		String userInsertQuery = "INSERT INTO UserINFO(email,name)"
				+ "values(?,?);";
		
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(renterInserQuery);
				PreparedStatement pstmt2 = conn.prepareStatement(userInsertQuery)) {
			conn.setAutoCommit(false);
			
			pstmt.setString(1, email);
			pstmt.setDate(2, moveindate);
			pstmt.setString(3, location);
			pstmt.setInt(4, budget);
			pstmt.setInt(5, rewards);
			pstmt.setString(6, userID);
			
			effectedRows = pstmt.executeUpdate();
			conn.commit();
			
			
			//updating concurently to the user table 
			pstmt2.setString(1, email); 
			pstmt2.setString(2, renterName);
			effectedRows = pstmt2.executeUpdate();
			conn.commit();
			

			if (!conn.isClosed()) {
				System.out.println("\n\n");
				conn.close();
				pstmt.close();
				pstmt2.close();
			}
			System.out.println("\n -------------------->>> Record(s) updated successfully\n");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return effectedRows;
	}
	
	
	
	

	public static void renterDetailsFetch() throws SQLException {
	    String query = "SELECT * FROM RENTER";
	    JDBC_Connection jdbcConnection = new JDBC_Connection();
	    try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
	        conn.setAutoCommit(false);
	        ResultSet rs = pstmt.executeQuery();
	        conn.commit();

	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnCount = rsmd.getColumnCount();

	        // Print headers
	        System.out.print("| ");
	        for (int i = 1; i <= columnCount; i++) {
	            String columnName = rsmd.getColumnName(i);
	            System.out.printf("%-20s| ", columnName);
	        }
	        System.out.println();

	        // Print separator line
	        for (int i = 1; i <= columnCount; i++) {
	            System.out.print("+");
	            for (int j = 0; j < 22; j++) {
	                System.out.print("-");
	            }
	        }
	        System.out.println("+");

	        // Print rows
	        while (rs.next()) {
	            for (int i = 1; i <= columnCount; i++) {
	                String columnValue = rs.getString(i);
	                System.out.printf("| %-20s| ", columnValue);
	            }
	            System.out.println();
	        }

	        // Print separator line
	        for (int i = 1; i <= columnCount; i++) {
	            System.out.print("+");
	            for (int j = 0; j < 22; j++) {
	                System.out.print("-");
	            }
	        }
	        System.out.println("+");

	        if (!conn.isClosed()) {
	            conn.close();
	            pstmt.close();
	            rs.close();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}


	
	
	
	/*
	 * (String email,String userID, Date moveindate,String location,int budget, int rewards,String renterName)
	 * NOTE 1 : email is PrimaryKey in UserInfo
	 *      2 : userID is primaryKey in renter
	 */
	public static void main(String args[]) throws SQLException {
		//int effectedRows = renterRegistratino("chanduk1@gmail.com","ren_124",new Date(2023-1-23),"newYork",10000,10,"chandRenter");
		//System.out.println(effectedRows);
		
		renterDetailsFetch();
	}

}
