package com.us.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTransaction {
	private String url;
	private Connection connection;
	
	public DBTransaction() {
		super();
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Connection getConnection () {
		try{
			closeConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@inchnilpdb03.India.TCS.com:1521:JavaDB03","E987800" , "E987800");
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection() {
		try{
			if(connection!=null && connection.isClosed() == false)
				connection.close();
			connection=null;
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}