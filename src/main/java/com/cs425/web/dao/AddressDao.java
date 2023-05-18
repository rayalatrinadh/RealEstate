package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//FK email.
public class AddressDao {
	
	
	public static int addressRegistration(String AddressID,String userID,String city, String state,String street,String zipcode){
		int effectedRows = 0;
		
		String addressInserrQuery = "INSERT INTO Address (AddressID, UserID, City, state, street, ZIPcode)"+
				"VALUES (?,?,?,?,?,?);";
				
		JDBC_Connection jdbcConnection = new JDBC_Connection();				
		try (Connection conn = jdbcConnection.connect(); 
				PreparedStatement pstmt = conn.prepareStatement(addressInserrQuery)) {
			
			conn.setAutoCommit(false);
			pstmt.setString(1, AddressID);
			pstmt.setString(2, userID);
			pstmt.setString(3, city);
			pstmt.setString(4, state);
			pstmt.setString(5, street);
			pstmt.setString(6, zipcode);
			
			effectedRows = pstmt.executeUpdate();
			conn.commit();
			
			if (!conn.isClosed()) {
				conn.close();
				pstmt.close();
			}
			System.out.println("Record(s) updated successfully");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return effectedRows;
	}
	
	
	
	/*
	 * (String AddressID,String userID,String city, String state,String street,String zipcode)
	 * NOTE 1 : AddressID -> primaryKey
	 *      2 : email     -> foreignKey
	 * 
	 */
	
	public static void main(String args[]) {
		//int rowsEffected = addressRegistration();
		//System.out.println(rowsEffected);
		
	}

}
