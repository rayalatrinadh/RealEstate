package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditCardDetailsDao {



	public static int creditCardInsertDetails(int userid,int ccid,int addressid) {
		String query = "INSERT INTO credit (userid,ccid,addressid)"
		 		+ "VALUES (?,?,?);";
		int affectedrows = 0;
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			
			 pstmt.setInt(1, userid);     
		     pstmt.setInt(2, ccid);
		     pstmt.setInt(3, addressid);  

			
			affectedrows = pstmt.executeUpdate();
			if (!conn.isClosed()) {
				conn.close();
				pstmt.close();
			}
			System.out.println("Credit Record(s) updated successfully");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return affectedrows;
	}
	
	
	public static int creditCardUpdateDetails(int addressid,int ccid) {
		String query = "UPDATE credit "
                + "SET addressid = ? "
                + "WHERE ccid = ?";
		int affectedrows = 0;
		JDBC_Connection jdbcConnection = new JDBC_Connection();

		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, addressid);
            pstmt.setInt(2, ccid);
            affectedrows = pstmt.executeUpdate();
			if (!conn.isClosed()) {
				conn.close();
			}
			System.out.println("Credit Record(s) Modify successfully");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return affectedrows;
	}
	
	public static int deleteCardDetails(int ccid) {

		 String query = "DELETE FROM credit WHERE ccid = ?";
		 int affectedRows = 0;
		 JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			 pstmt.setInt(1, ccid);
		     affectedRows = pstmt.executeUpdate();
			
			if (!conn.isClosed()) {
				conn.close();
			}
			System.out.println("Credit Record(s) updated successfully");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return affectedRows;
	}
	
	public static void main(String args[]) {
		//int ans = creditCardInsertDetails(7,8,9);
		int ans = creditCardUpdateDetails(5,189);
		//int ans = deleteCardDetails(8);
		System.out.println(ans);
		
		
	}

}
