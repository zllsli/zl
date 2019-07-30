package cn.com.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.javaweb.demo.listener.MySessionBindListener;

/**
 * Servlet implementation class TestRequestAttributeServlet
 */
public class TestRequestAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("set attribute....1");
		request.setAttribute("test", "1234");
		System.out.println("-------------------2");
		request.setAttribute("test", "1234");
		System.out.println("-------------------3");
		request.setAttribute("test", "abcd");
		System.out.println("-------------------4");
		request.removeAttribute("test");*/
		HttpSession session = request.getSession();
		System.out.println("--------------------------1");
		session.setAttribute("abc", "123");
	    System.out.println("---------------------------2");
		session.setAttribute("test", new MySessionBindListener());
		System.out.println("---------------------------3");
	    session.setAttribute("test","aaaa");
	    System.out.println("---------------------------4");
	    session.setAttribute("test","bbbb");
	    System.out.println("---------------------------5");
	}

}
