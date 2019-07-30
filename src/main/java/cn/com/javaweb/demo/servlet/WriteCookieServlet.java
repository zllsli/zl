package cn.com.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteCookieServlet
 */
public class WriteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ageCookie = new Cookie("age","21");
		Cookie userNameCookie = new Cookie("name","zhangsan");
	    userNameCookie.setMaxAge(60*60);// 秒
		response.addCookie(ageCookie);
		response.addCookie(userNameCookie);
		
		Cookie age2Cookie = new Cookie("age","23");
		response.addCookie(age2Cookie);
	}

}
