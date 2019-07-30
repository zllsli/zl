package cn.com.test;

import java.sql.Connection;

import cn.com.javaweb.demo.db.DBConnection;

public class TestDBConnection {

	public static void main(String[] args) {
		Connection conn = DBConnection.getInstance().getConnection();
		System.out.println(conn);
	}

}
