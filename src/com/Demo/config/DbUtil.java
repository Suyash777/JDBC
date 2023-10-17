package com.Demo.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {
	private BasicDataSource dataSource;
	//private Connection connection;
	
	public DbUtil(String username, String password, String url) {
		this.dataSource = new BasicDataSource();
		this.dataSource.setUsername(username);
		this.dataSource.setPassword(password);
		this.dataSource.setUrl(url);
	}

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
	
	public void closeConnection(Connection conn) throws SQLException {
		if(conn!=null)
			conn.close();
	}
}
