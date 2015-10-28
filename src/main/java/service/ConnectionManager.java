package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private Connection connect;
	private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
	
	public ConnectionManager() {
		try {
			connect = DriverManager.getConnection(URL);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connect;
	}
}