package com.isumi.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import com.isumi.config.JDBCConnectionConfig;

public class ConnectionFactory {
	
	private static ConnectionFactory instance = new ConnectionFactory();
	
	
	private ConnectionFactory(){}
	
	public static ConnectionFactory getInstance(){
		return instance;
	}
	
	public static Connection getConnection(JDBCConnectionConfig config){
		Driver driver = null;
		try {
			driver = (Driver) Class.forName(config.getDriver()).newInstance();
		} catch (Exception e) {
			new RuntimeException("create jdbcDriver fail! check your config");
		}
		Properties properties = new Properties();
		properties.setProperty("user", config.getUserName());
		properties.setProperty("password", config.getPassword());
		properties.setProperty("url", config.getUrl());
		
		try {
			Connection connection = driver.connect(config.getUrl(),properties );
			return connection;
		} catch (SQLException e) {
			new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	public Connection getConnection(){
		return null;
	}

}
