package com.isumi.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class JDBCConnectionConfig {
	
//	public static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//	
//	private static JDBCConnectionConfig defaultInstance = new JDBCConnectionConfig();
//	
//	public static JDBCConnectionConfig getDefaultInstance(){
//		DruidDataSource dataSource = (DruidDataSource) ac.getBean("dataSource");
//		defaultInstance.setUrl(dataSource.getUrl());
//		defaultInstance.setUserName(dataSource.getUsername());
//		defaultInstance.setPassword(dataSource.getPassword());
//		defaultInstance.setDriver(dataSource.getDriverClassName());
//		return defaultInstance;
//	}
	
	
	public JDBCConnectionConfig(String userName, String password, String url, String driver) {
		super();
		this.userName = userName;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}
	

	private String userName;

	private String password;

	private String url;

	private String driver;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
