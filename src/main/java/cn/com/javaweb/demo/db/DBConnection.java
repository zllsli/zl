package cn.com.javaweb.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	private static DBConnection dbCon = null;
	private DBConnection() {}
	public static DBConnection getInstance() {
		if(dbCon == null)
			dbCon = new DBConnection();
		return dbCon;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/demo_db?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "zl980108");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
