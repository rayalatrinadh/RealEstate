package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PropertyDao {
	public static ArrayList<Long> primaryKeyEmailList = new ArrayList<>();

	public static int propertyIdInsert(long propertyId) throws SQLException {
		int effectedRows = 0;
		String query = "INSERT INTO property(propertyId) VALUES(?)";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		
		
		if(!isPropertyIdExists(propertyId)) {
			try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

				conn.setAutoCommit(false);
				pstmt.setLong(1, propertyId);
				//System.out.println("query: " + query);
				effectedRows = pstmt.executeUpdate();
				conn.commit();

				if (!conn.isClosed()) {
					conn.close();
					pstmt.close();
					
				}
				System.out.println("propertyId : Record(s) updated successfully");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}else {
			System.out.println("propertyId : '" + propertyId + "' already Exists");
		}

		return effectedRows;
	}

	
	public static boolean isPropertyIdExists(long propertyId) throws SQLException {
		propertyIdCheck();
		return primaryKeyEmailList.contains(propertyId) ? true : false;
		
		
	}
	
	public static void propertyIdCheck() throws SQLException {
		String query = "SELECT * FROM property";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			conn.setAutoCommit(false);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while (rs.next()) {
				long propertyId = rs.getLong("propertyId");
				primaryKeyEmailList.add(propertyId);
			}
			if (!conn.isClosed()) {
				// System.out.println("connect is going to close...");
				conn.close();
				// System.out.println("connection closed in InsertUserDetails");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("error in PropertyDao.java -> propertyIdCheck()");
		}
	}
	public static void main(String args[]) throws SQLException {
		//primaryKey
		propertyIdInsert(1237L);
	}

}
