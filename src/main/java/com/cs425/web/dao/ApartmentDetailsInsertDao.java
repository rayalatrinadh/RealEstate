package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ApartmentDetailsInsertDao {
	
	public static int apartmentInsertion(String query) throws SQLException {
		int affectedrows = 0;
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			conn.setAutoCommit(false);
			affectedrows = pstmt.executeUpdate();
			conn.commit();
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return affectedrows;
	}
	
	
	public static void main(String args[]) throws SQLException {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter query to insert details into Apartment : ");
		String query = input.next()+input.nextLine();
		System.out.println("\ngiven Query : \n" + query);
		if(apartmentInsertion(query) == 1)
			System.out.println("Address Record(s) updated successfully");
		else
			System.out.println("Address Record(s) not updated");
	}
}

