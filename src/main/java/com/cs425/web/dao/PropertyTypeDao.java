package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class PropertyTypeDao {
	
	public static int propertyHouseInsertion(long propertyID,int noOfRooms,int SquareFoot,
			String Address,boolean Availability,String HouseLocation,String HouseType,
			int crimeRate,boolean nearBySchools,String Neighbourhood,String city,
			String Street,String State,int Zipcode) throws SQLException {
		
			JDBC_Connection jdbcConnection = new JDBC_Connection();
		
			int effectedRows = 0;
			
			String insertHouseProperty = "INSERT INTO House (propertyID, noOfRooms, SquareFoot, Address, Availability,"
					+ "HouseLocation,HouseType,crimeRate,nearBySchools,Neighbourhood,city,Street,State,Zipcode)"+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			try (Connection conn = jdbcConnection.connect(); 
					PreparedStatement pstmt = conn.prepareStatement(insertHouseProperty)) {
				
				conn.setAutoCommit(false);
				
				pstmt.setLong(1,propertyID);
				pstmt.setInt(2,noOfRooms);
				pstmt.setInt(3,SquareFoot);
				pstmt.setString(4,Address);
				pstmt.setBoolean(5,Availability);
				pstmt.setString(6,HouseLocation);
				pstmt.setString(7,HouseType);
				pstmt.setInt(8,crimeRate);
				pstmt.setBoolean(9,nearBySchools);
				pstmt.setString(10,Neighbourhood);
				pstmt.setString(11,city);
				pstmt.setString(12,Street);
				pstmt.setString(13,State);
				pstmt.setInt(14,Zipcode);
				
				effectedRows = pstmt.executeUpdate();
				conn.commit();
				if (!conn.isClosed()) {
					conn.close();
					pstmt.close();
				}
				System.out.println("propertyHouseInsertion :: Record(s) updated successfully");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
		
			return effectedRows;
	}
	
	
	
	
	public static int propertyApartmentInsertion(long propertyID,int noOfRooms,int SquareFoot,
			String Address,int Price,String apartmentLocation,String apartmentType,
			int crimeRate,boolean nearBySchools,String Neighbourhood,String city,
			String Street,String State,int Zipcode) throws SQLException {
		
			JDBC_Connection jdbcConnection = new JDBC_Connection();
		
			int effectedRows = 0;
			
			String insertApartmentProperty = "INSERT INTO apartment (propertyID, noOfRooms, SquareFoot, Address, Price,"
					+ "apartmentLocation,apartmentType,crimeRate,nearBySchools,Neighbourhood,city,Street,State,Zipcode)"+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			try (Connection conn = jdbcConnection.connect(); 
					PreparedStatement pstmt = conn.prepareStatement(insertApartmentProperty)) {
				
				conn.setAutoCommit(false);
				
				pstmt.setLong(1,propertyID);
				pstmt.setInt(2,noOfRooms);
				pstmt.setInt(3,SquareFoot);
				pstmt.setString(4,Address);
				pstmt.setInt(5,Price);
				pstmt.setString(6,apartmentLocation);
				pstmt.setString(7,apartmentType);
				pstmt.setInt(8,crimeRate);
				pstmt.setBoolean(9,nearBySchools);
				pstmt.setString(10,Neighbourhood);
				pstmt.setString(11,city);
				pstmt.setString(12,Street);
				pstmt.setString(13,State);
				pstmt.setInt(14,Zipcode);
				
				effectedRows = pstmt.executeUpdate();
				conn.commit();
				if (!conn.isClosed()) {
					conn.close();
					pstmt.close();
				}
				System.out.println("propertyApartmentInsertion :: Record(s) updated successfully");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
		
			return effectedRows;
	}
	
	public static int propertyCommercialInsertion(long propertyID,int noOfRooms,int SquareFoot,
			String Address,int Price,String Location,String CommercialType,
			int crimeRate,boolean nearBySchools,String Neighbourhood,String city,
			String Street,String State,int Zipcode) throws SQLException {
		
			JDBC_Connection jdbcConnection = new JDBC_Connection();
		
			int effectedRows = 0;
			
			String insertApartmentProperty = "INSERT INTO commercial (propertyID, noOfRooms, SquareFoot, Address, Price,"
					+ "location,commercialType,crimeRate,nearBySchools,Neighbourhood,city,Street,State,Zipcode)"+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			try (Connection conn = jdbcConnection.connect(); 
					PreparedStatement pstmt = conn.prepareStatement(insertApartmentProperty)) {
				
				conn.setAutoCommit(false);
				
				pstmt.setLong(1,propertyID);
				pstmt.setInt(2,noOfRooms);
				pstmt.setInt(3,SquareFoot);
				pstmt.setString(4,Address);
				pstmt.setInt(5,Price);
				pstmt.setString(6,Location);
				pstmt.setString(7,CommercialType);
				pstmt.setInt(8,crimeRate);
				pstmt.setBoolean(9,nearBySchools);
				pstmt.setString(10,Neighbourhood);
				pstmt.setString(11,city);
				pstmt.setString(12,Street);
				pstmt.setString(13,State);
				pstmt.setInt(14,Zipcode);
				
				effectedRows = pstmt.executeUpdate();
				conn.commit();
				if (!conn.isClosed()) {
					conn.close();
					pstmt.close();
				}
				System.out.println("propertyCommercialInsertion :: Record(s) updated successfully");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
		
			return effectedRows;
	}
	
	public static void main(String args[]) throws SQLException {
		int rowsEffected = 0;
		
		
		  rowsEffected = propertyHouseInsertion(12345,5,10,
		  "address:dr.martinLutherKing",true, "chicago", "2bhkIndividualHouse", 00,
		  true,"neighbourhood", "chicago", "martinLutherKingStreet","chicago",60616);
		 
		 rowsEffected = propertyApartmentInsertion(123115L,12,23,"MartinLutherKing",5000,"chicago","apartment",0,true,"neighbourhood",
					"chicago","illinois","martinStreet",60616);
		
		
		rowsEffected = propertyCommercialInsertion(123115L,12,23,"MartinLutherKing",5000,"chicago","apartment",0,true,"neighbourhood",
				"chicago","illinois","martinStreet",60616);
		
		
		System.out.println(rowsEffected);
		
	}

}
