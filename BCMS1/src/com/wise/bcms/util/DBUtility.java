package com.wise.bcms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtility {
	static Connection connection = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bcms?useSSL = true","root","ROOT");
		}
		catch(SQLException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		return connection;
	}
	public static void close(Object ...args) {
		for(Object arg : args) {
			if(arg instanceof ResultSet) {
				try {
					((ResultSet) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(arg instanceof Statement) {
				try {
					((Statement) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(arg instanceof PreparedStatement) {
				try {
					((PreparedStatement) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(arg instanceof Connection) {
				try {
					((Connection) arg).close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
		}
	}
	public static Date convertStringDateToUtilDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date convertedDate = null;
		try {
			convertedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertedDate;
	}
	public static java.util.Date convertFromSQLDateToUTILDate(java.sql.Date sqlDate) {
		java.util.Date javaDate = new Date(sqlDate.getTime());
		return javaDate;
	}
	public static java.sql.Date convertFromUTILDateToSQLDate(java.util.Date javaDate) {
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}

}
