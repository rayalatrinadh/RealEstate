package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cs425.web.model.Person;

public class PersonDao {
	
	/*
	 * webDesigned
	 * InsertUserDetails.java
	 * InstructorDao.java
	 * PersonDao.java
	 * 
	 */
	
	 public static  List<Person> getPersonDetailsFromDB() throws SQLException {
		    List<Person> personsList = new ArrayList<Person>();
		    int recordsCount = 0;
	    	String query = "SELECT * FROM PERSON";
	    	JDBC_Connection jdbcConnection = new JDBC_Connection();
			
			try(Connection conn = jdbcConnection.connect();
					PreparedStatement pstmt = conn.prepareStatement(query);
		 			ResultSet rs = pstmt.executeQuery();
							){
				
				while (rs.next()) {
					System.out.println("\n name : "+rs.getString("name") + " , emailID : " + rs.getString("emailID"));
					String name = rs.getString("name");
					String emailID = rs.getString("emailID");

//					temp.put("name", rs.getString("name"));
//					temp.put("emailID", rs.getString("emailID"));
//	                personObj.setName(rs.getString("name"));
//	                personObj.setEmailID(rs.getString("emailID"));
					
					Person personObj = new Person(name,emailID);
	                recordsCount++;
	                personsList.add(personObj);
	            }
				
				 System.out.println("FormedList : " + personsList);
			    System.out.println("query: " + query);
			    System.out.println("=======> Fetched : "+recordsCount+" Details successfully in PersonDao.java");	
			    
			   
			    
			    if(!conn.isClosed()) {
					System.out.println("connect is going to close...");
					conn.close();
					System.out.println("connection closed in InsertUserDetails");
				}
			    System.out.println("Record(s) Fetched successfully InsertUserDetails");
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return personsList;
	    }
	 
	 public static void main(String args[]) throws SQLException {
		 List<Person> asn = getPersonDetailsFromDB();
		 System.out.println(asn);
	 }

}
