package cn.com.javaweb.demo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 1 单例模式
 */
public class DAOFactory {
	private static DAOFactory factory;
	private Properties props = new Properties();

	private DAOFactory() {
		this.init();
	}

	public static DAOFactory getInstance() {
		if (factory == null) {
			factory = new DAOFactory();
		}
		return factory;
	}

	public IUserDAO createUserDAO() {
		IUserDAO userDAO = null;
		try {
			// 获取实现类的类名
			String clsName = this.props.getProperty("userDAO");
			Class cls = Class.forName(clsName);
			userDAO = (IUserDAO)cls.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return userDAO;
	}

	/**
	 * 读dao.properties
	 */
	private void init() {
		// xxx一定要指定绝对路径
		// FileInputStream fileIn = new FileInputStream("xxx");
		ClassLoader clsLoader = DAOFactory.class.getClassLoader();
		InputStream in = clsLoader.getResourceAsStream("dao.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
