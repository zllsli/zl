package cn.com.javaweb.demo.dao;

import java.util.List;

import cn.com.javaweb.demo.entity.User;

public interface IUserDAO {
    public List<User> findAllUsers();
    public User findUserById(int id);
    public void update(User user);
    public void addUser(User user);
    public void deleteUser(User user);
}
