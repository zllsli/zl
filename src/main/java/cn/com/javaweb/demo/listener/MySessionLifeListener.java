package cn.com.javaweb.demo.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.com.javaweb.demo.entity.User;

public class MySessionLifeListener implements HttpSessionListener {
	// 当前用户数
	private int userCounts = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// sessionCreated 用户数+1
		userCounts++;
		// 重新在servletContext中保存userCounts
		se.getSession().getServletContext().setAttribute("userCounts", userCounts);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// sessionDestroyed 用户数-1
		  userCounts--;
		// 重新在servletContext中保存userCounts
		se.getSession().getServletContext().setAttribute("userCounts", userCounts);
	}

}
