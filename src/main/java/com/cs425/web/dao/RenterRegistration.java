package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	
	/*
	 * public static void renterDetailsFetch() throws SQLException { String query =
	 * "SELECT * FROM RENTER"; JDBC_Connection jdbcConnection = new
	 * JDBC_Connection(); try (Connection conn = jdbcConnection.connect();
	 * PreparedStatement pstmt = conn.prepareStatement(query)) {
	 * conn.setAutoCommit(false); ResultSet rs = pstmt.executeQuery();
	 * conn.commit(); System.out.println("User Record(s) Fetched Successfully\n");
	 * while (rs.next()) {
	 * 
	 * String email = rs.getString("Email"); Date date = rs.getDate("moveindate");
	 * String location = rs.getString("location"); int budget = rs.getInt("budget");
	 * int rewards = rs.getInt("rewards"); String userid = rs.getString("userID");
	 * 
	 * 
	 * String formattedEmail = String.format("%-30s", "Email: " + email); String
	 * formattedDate = String.format("%-30s", "Date: " + date); String
	 * formattedLocation = String.format("%-30s", "location: " + location); String
	 * formattedBudget = String.format("%-30s", "budget: " + budget); String
	 * formattedRewards = String.format("%-30s", "rewards: " + rewards); String
	 * formattedUserid = String.format("%-20s", "userid: " + userid);
	 * 
	 * System.out.println(formattedEmail+formattedDate+formattedLocation+
	 * formattedBudget+formattedRewards+formattedUserid); }
	 * 
	 * if (!conn.isClosed()) { conn.close(); pstmt.close(); rs.close(); } } catch
	 * (SQLException ex) { ex.printStackTrace(); } }
	 */
	
	public static void renterDetailsFetch() throws SQLException {
		String query = "SELECT * FROM RENTER";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			conn.setAutoCommit(false);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();

			// Print headers
			System.out.println("SELECT Email AS 'Email', moveindate AS 'Date', location AS 'Location', budget AS 'Budget', rewards AS 'Rewards', userID AS 'Userid' FROM RENTER;");
			System.out.println("+-----------------------------+--------------+----------------------+--------+---------+---------------------+");

			while (rs.next()) {
				String email = rs.getString("Email");
				Date date = rs.getDate("moveindate");
				String location = rs.getString("location");
				int budget = rs.getInt("budget");
				int rewards = rs.getInt("rewards");
				String userid = rs.getString("userID");

				String formattedEmail = String.format("| %-28s", email);
				String formattedDate = String.format(" | %-12s", date);
				String formattedLocation = String.format(" | %-20s", location);
				String formattedBudget = String.format(" | %-6d", budget);
				String formattedRewards = String.format(" | %-7d", rewards);
				String formattedUserid = String.format(" | %-19s|", userid);

				System.out.println(formattedEmail + formattedDate + formattedLocation + formattedBudget + formattedRewards + formattedUserid);
				System.out.println("+-----------------------------+--------------+----------------------+--------+---------+---------------------+");
			}

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
