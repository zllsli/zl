package cn.com.javaweb.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("!!!!!!!销毁!!!!!!!!!!!!!!!!");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("****初始化**********");

	}

}
