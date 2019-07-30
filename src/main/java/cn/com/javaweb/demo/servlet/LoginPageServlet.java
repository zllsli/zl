package cn.com.javaweb.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPageServlet
 */
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setAttribute("test", "requestValue");
//		request.getSession().setAttribute("test", "sessionValue");
//		this.getServletContext().setAttribute("test", "contextValue");
//		// 包含头部分
//		RequestDispatcher dis = request.getRequestDispatcher("/headerServlet");
//		dis.include(request, response);
//		// 输出自己的登录form
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<form action=\"loginServlet\" method=\"post\">\r\n" + 
//				"			  <input type=\"text\" name=\"userName\"/><br/>\r\n" + 
//				"			  <input type=\"password\" name=\"password\"/><br/>\r\n" + 
//				"			  <input type=\"submit\" value=\"submit\"/>\r\n" + 
//				"		  </form>");
//		// out.close()
//		// 包含footer信息
//		dis = request.getRequestDispatcher("/footerServlet");
//		dis.include(request, response);
//	}
	
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 输出自己的登录form
		//response.setContentType("text/html;charset=UTF-8");
	   //我的头像: <img src=\" $ut.getImage_path()\" width=\"200\" height=\"200\">   
		PrintWriter out = response.getWriter();
		out.println("<form action=\"loginServlet\" method=\"post\">\r\n" + 
		        "                                                                        "+
				"			 用户名: <input type=\"text\" name=\"userName\"/><br/>\r\n" + 
				"			 密    码:<input type=\"password\" name=\"password\"/><br/>\r\n" + 
				"            验证码: <input type=\"text\" name=\"verifyCode\"/>"+
				"             <img id = \"img\" src=\'dynamicImageServlet?\' onclick=\"refreshImage()\"/><br/>\r\n"+
				"			  <input type=\"submit\" value=\"submit\"/>\r\n" + 
				"		  </form>");
		
		out.flush();
		out.close();
	}

	

}
