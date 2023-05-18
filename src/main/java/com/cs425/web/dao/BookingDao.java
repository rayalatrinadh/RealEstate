package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDao {
	public static ArrayList<Long> primaryKeyEmailList = new ArrayList<>();

	public static int insertBookingDetails(long BookingID, String UserID_R, String UserID_Agnt, long CCID,
			long PropertyID, Date Start_Date, Date End_Date) throws SQLException {
		int rowsEffected = 0;

		String query = "INSERT INTO Booking (BookingID,UserID_R,UserID_Agnt,CCID,PropertyID,Start_Date,End_Date)"
				+ "VALUES (?,?,?,?,?,?,?);";

		if (!isBookingExists(BookingID)) {
			JDBC_Connection jdbcConnection = new JDBC_Connection();
			try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

				pstmt.setLong(1, BookingID);
				pstmt.setString(2, UserID_R);
				pstmt.setString(3, UserID_Agnt);
				pstmt.setLong(4, CCID);
				pstmt.setLong(5, PropertyID);
				pstmt.setDate(6, Start_Date);
				pstmt.setDate(7, End_Date);

				rowsEffected = pstmt.executeUpdate();
				if (!conn.isClosed()) {
					conn.close();
					pstmt.close();
				}
				System.out.println("Booking Record(s) updated successfully");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("BookingID  '" + BookingID + "' already Registered");
		}
		return rowsEffected;
	}

	public static void main(String args[]) throws SQLException {

		// bookingId id primaryKey
		int rowsEffected = insertBookingDetails(12345L, "user_123", "agent_123", 123L, 456l, new Date(2023 - 04 - 02),
				new Date(2022 - 04 - 2));
		System.out.println(rowsEffected);

	}

	public static boolean isBookingExists(Long BookingID) throws SQLException {
		bookingDetailsCheck();
		return primaryKeyEmailList.contains(BookingID) ? true : false;
	}

	// bookingId is a primary so we need to check it before inserting.
	public static void bookingDetailsCheck() throws SQLException {
		String query = "SELECT * FROM booking";
		JDBC_Connection jdbcConnection = new JDBC_Connection();
		try (Connection conn = jdbcConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			conn.setAutoCommit(false);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while (rs.next()) {
				Long bookingId = rs.getLong("BookingID");
				primaryKeyEmailList.add(bookingId);
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
