package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
	
	final String url = "jdbc:postgresql://localhost:5432/RealEstateApp";
	final String user = "postgres";
	final String password = "password";//"<add your password>";
 
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws SQLException 
     */
    public Connection connect() throws SQLException {
        Connection conn = null;
        try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
        	//Attempts to establish a connection to the given database URL
        	//System.out.println("Establising a connection to the driver : " + url);
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to the PostgreSQL server successfully in JDBC_Connection.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception in JDBC_Connection.java");
        }
        return conn;
    }

}
