package cn.com.javaweb.demo.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionBindListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("bond.....");

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("unbond....."); 

	}

}
