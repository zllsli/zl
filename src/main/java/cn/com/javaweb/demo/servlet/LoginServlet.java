package cn.com.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 获取页面上的用户名和密码
//		// 根据用户名，从数据库中找到它注册时的密码
//		// 比对DBPassword和page password
//		// 根据比对后的结果，转向LoginPageServlet or WelcomeServlet
//		
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		// db password
//		String dbPassword = "123456";
//		// 比对
//		boolean bool = dbPassword.equals(password);
//		String forwardServlet = "/welcomeServlet";
//		if(!bool) {
//			forwardServlet = "/loginPageServlet";
//		}
//		request.setAttribute("userName", userName);
//		request.getRequestDispatcher(forwardServlet).forward(request, response);
//	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取页面上的用户名和密码
		// 根据用户名，从数据库中找到它注册时的密码
		// 比对DBPassword和page password
		// 根据比对后的结果，转向LoginPageServlet or WelcomeServlet
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("password:" + password);
		// db password
		String dbPassword = "123456";
		// 比对
		boolean bool = dbPassword.equals(password);
		String forwardServlet = "/welcomeServlet.do";
		if(!bool) {
			forwardServlet = "/loginPageServlet";
		}else {
			// 保存标记
			request.getSession().setAttribute("LOGIN_FLAG", userName);
			Cookie cookie = new Cookie("loginFlag", userName);
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
		}
		request.setAttribute("userName", userName);
		request.getRequestDispatcher(forwardServlet).forward(request, response);
	}

}
