package cn.com.javaweb.demo.service.impl;

import java.util.List;

import cn.com.javaweb.demo.dao.DAOFactory;
import cn.com.javaweb.demo.dao.IUserDAO;
import cn.com.javaweb.demo.dao.impl.UserDAOImpl;
import cn.com.javaweb.demo.entity.User;
import cn.com.javaweb.demo.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDAO userDAO = null;
    {
    	DAOFactory factory = DAOFactory.getInstance();
    	userDAO = factory.createUserDAO();
    }
	@Override
	public List<User> findAllUsers() {
		// 从数据库中查询出所有的用户对象（集合）
		return userDAO.findAllUsers();
	}

	@Override
	public User findById(int id) {
		return userDAO.findUserById(id);
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editUser(User user) {
		userDAO.update(user);
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);	
	}

	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
		
	}

}
