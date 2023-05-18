package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgentRegistrationDao {
	public static final String ANSI_RESET = "\u001B[31m";
	  
    // Declaring the color
    // Custom declaration
    public static final String ANSI_RED = "\u001B[31m";
	public static ArrayList<String> primaryKeyUseridList = new ArrayList<>();
	
	public static int agentRegistration(String email,String userid,String jobtitle,String agencyname,String phonenumber01,String phonenumber02,String agentName) throws SQLException {
		int affectedrows = 0;
		//String query = "INSERT INTO UserInfo(Name,Email) VALUES(?,?)";
		
		String agentInserQuery = "INSERT INTO Agent (email, jobtitle, agencyname, phonenumber01, phonenumber02, userid)"+
		"VALUES (?,?,?,?,?,?);";
		
		String userInsertQuery = "INSERT INTO UserINFO(email,name)"
				+ "values(?,?);";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		
		if(!isUserUseridExists(userid)) {
			try (Connection conn = jdbcConnection.connect(); 
					PreparedStatement pstmt = conn.prepareStatement(agentInserQuery);
					PreparedStatement pstmt2 = conn.prepareStatement(userInsertQuery)) {
				conn.setAutoCommit(false);
				pstmt.setString(1, email);
				pstmt.setString(2, jobtitle);
				pstmt.setString(3, agencyname);
				pstmt.setString(4, phonenumber01);
				pstmt.setString(5, phonenumber02);
				pstmt.setString(6, userid); //primaryKey
				
				affectedrows = pstmt.executeUpdate();
				conn.commit();
				
				pstmt2.setString(1, email); 
				pstmt2.setString(2, agentName);
				
				//updating concurently to the user table 
				affectedrows = pstmt2.executeUpdate();
				conn.commit();
				
				

				if (!conn.isClosed()) {
					conn.close();
					pstmt.close();
					pstmt2.close();
				}
				System.out.println("\n ----------------->>> Record(s) updated successfully");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}else {
			System.out.println(ANSI_RED + "userid : "+userid+" already exists" + ANSI_RESET);
			
		}
		
			
		return affectedrows;
	}

	
	/*
	 * public static void agentDetailsFetch() throws SQLException { String query =
	 * "SELECT * FROM Agent"; JDBC_Connection jdbcConnection = new
	 * JDBC_Connection(); try (Connection conn = jdbcConnection.connect();
	 * PreparedStatement pstmt = conn.prepareStatement(query)) {
	 * conn.setAutoCommit(false); ResultSet rs = pstmt.executeQuery();
	 * conn.commit(); System.out.println("User Record(s) Fetched Successfully\n");
	 * while (rs.next()) {
	 * 
	 * String email = rs.getString("Email"); String jobTitle =
	 * rs.getString("jobtitle"); String agencyname = rs.getString("agencyname");
	 * String phonenumber01 = rs.getString("phonenumber01"); String phonenumber02 =
	 * rs.getString("phonenumber02"); String userid = rs.getString("userid");
	 * 
	 * 
	 * String formattedEmail = String.format("%-30s", "Email: " + email); String
	 * formattedJobTitle = String.format("%-15s", "jobTitle: " + jobTitle); String
	 * formattedAgencyname = String.format("%-30s", "agencyname: " + agencyname);
	 * String formattedPhonenumber01 = String.format("%-30s", "phonenumber01: " +
	 * phonenumber01); String formattedPhonenumber02 = String.format("%-30s",
	 * "phonenumber02: " + phonenumber02); String formattedUserid =
	 * String.format("%-20s", "userid: " + userid);
	 * 
	 * System.out.println(formattedEmail+formattedJobTitle+formattedAgencyname+
	 * formattedPhonenumber01+formattedPhonenumber02+formattedUserid); } if
	 * (!conn.isClosed()) { conn.close(); pstmt.close(); rs.close(); } } catch
	 * (SQLException ex) { ex.printStackTrace(); } }
	 */
	
	public static void agentDetailsFetch() throws SQLException {
	    String query = "SELECT * FROM Agent";
	    JDBC_Connection jdbcConnection = new JDBC_Connection();

	    try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
	        conn.setAutoCommit(false);
	        ResultSet rs = pstmt.executeQuery();
	        conn.commit();
	        System.out.println("Agent Record(s) Fetched Successfully\n");

	        // Print headers
	        System.out.println(String.format("%-30s | %-15s | %-30s | %-30s | %-30s | %-20s",
	            "Email", "Job Title", "Agency Name", "Phone Number 01", "Phone Number 02", "User ID"));
	        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

	        while (rs.next()) {
	            String email = rs.getString("Email");
	            String jobTitle = rs.getString("jobtitle");
	            String agencyname = rs.getString("agencyname");
	            String phonenumber01 = rs.getString("phonenumber01");
	            String phonenumber02 = rs.getString("phonenumber02");
	            String userid = rs.getString("userid");

	            String formattedEmail = String.format("%-30s", email);
	            String formattedJobTitle = String.format("%-15s", jobTitle);
	            String formattedAgencyname = String.format("%-30s", agencyname);
	            String formattedPhonenumber01 = String.format("%-30s", phonenumber01);
	            String formattedPhonenumber02 = String.format("%-30s", phonenumber02);
	            String formattedUserid = String.format("%-20s", userid);

	            System.out.println(formattedEmail + " | " + formattedJobTitle + " | " + formattedAgencyname + " | " +
	                formattedPhonenumber01 + " | " + formattedPhonenumber02 + " | " + formattedUserid);
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

	
	
	public static void agentDetailsDelete(String userID) throws SQLException {
		
		
	}
	
	public static void main(String args[]) throws SQLException {
		
		/*
		 * agentRegistration(
		 * String email,String jobTitle,String agencyName,String phonenumber01,
		 * String phonenumber02,String userId,String agentName)
		 * 
		 * NOTE : 1 email is primaryKEy in userInfoEntity
		 *        2 userId is primaryKEY  in agentEntity
		 *        
		 */
		
		int rowsEffect = agentRegistration("3nadhmail@gmail6.com", "AG_8983","agent", "PRAIRE_SHORES", "9666089277", "7896541237","TRINADH");
		System.out.println(rowsEffect);
		
		System.out.println("Agent Details...\n");
		agentDetailsFetch();
	}
	
	
	public static boolean isUserUseridExists(String userid) throws SQLException {
		agentDetailsCheck();
		return primaryKeyUseridList.contains(userid) ? true : false;
	}
	
	public static void agentDetailsCheck() throws SQLException {
		String query = "SELECT * FROM Agent";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			conn.setAutoCommit(false);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while (rs.next()) {
				String userid = rs.getString("userid");
				primaryKeyUseridList.add(userid);
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
