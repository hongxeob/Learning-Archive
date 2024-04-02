package com.hongxeob.ch1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Deprecated
public class SimpleConnectionMaker {

	public Connection makeNewConnection() throws SQLException, ClassNotFoundException {
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(
				"jdbc:/mysql://localhost/springbook", "spring", "book"
			);

			return c;
		}
	}
}
