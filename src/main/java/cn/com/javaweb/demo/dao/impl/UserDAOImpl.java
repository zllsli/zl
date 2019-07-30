package cn.com.javaweb.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.javaweb.demo.dao.IUserDAO;
import cn.com.javaweb.demo.db.DBConnection;
import cn.com.javaweb.demo.entity.User;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void update(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			String sql = "update dm_user set ur_name=?, ur_sex=?, ur_phone=?, ur_age=?, ur_password=? where ur_id=?";
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getPhone());
			pstmt.setInt(4, user.getAge());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getId());
			

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
	}

	@Override
	public User findUserById(int id) {
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			String sql = "select * from dm_user where ur_id=?";
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()) {
				user = new User();
				user.setAge(rs.getInt("ur_age"));
				user.setId(rs.getInt("ur_id"));
				user.setName(rs.getString("ur_name"));
				user.setPassword(rs.getString("ur_password"));
				user.setPhone(rs.getString("ur_phone"));
				user.setSex(rs.getString("ur_sex"));
				user.setUserName(rs.getString("ur_user_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return user;
	}

	@Override // 重写的方法
	public List<User> findAllUsers() {
		List<User> userList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			String sql = "select * from dm_user";
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs != null) {
				userList = new ArrayList<User>();
				User user = null;
				while (rs.next()) {
					user = new User();
					user.setAge(rs.getInt("ur_age"));
					user.setId(rs.getInt("ur_id"));
					user.setName(rs.getString("ur_name"));
					user.setPassword(rs.getString("ur_password"));
					user.setPhone(rs.getString("ur_phone"));
					user.setSex(rs.getString("ur_sex"));
					user.setUserName(rs.getString("ur_user_name"));

					userList.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		return userList;
	}

	@Override
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			String sql = "insert into dm_user values(?,?,?,?,?,?,?)";
			conn = dbConn.getConnection();
			// 创建向数据库发送sql语句的PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,user.getId());
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getPassword());
				pstmt.setString(5,user.getSex());
				pstmt.setInt(6, user.getAge());
				pstmt.setString(7, user.getPhone());
			   // 通知数据库服务器执行给定的sql语句
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally {
				dbConn.close(conn,pstmt,rs);
			}
		}

	@Override
	public void deleteUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbConn = DBConnection.getInstance();
		try {
			String sql = "delete from dm_user where ur_id = ?";
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dbConn.close(conn, pstmt, rs);
		}
		
	}


}


