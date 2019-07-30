package cn.com.javaweb.demo.service;

import java.util.List;

import cn.com.javaweb.demo.entity.User;

public interface IUserService {
    public List<User> findAllUsers();
    public User findById(int id);
    public User findByUserName(String userName);
    public void editUser(User user);
    public void addUser(User user);
	public void deleteUser(User user);
}
