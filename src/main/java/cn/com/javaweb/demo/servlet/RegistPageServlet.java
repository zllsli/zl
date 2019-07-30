package cn.com.javaweb.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.javaweb.demo.entity.User;
import cn.com.javaweb.demo.service.IUserService;
import cn.com.javaweb.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServletPageServlet
 */
public class RegistPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		// 用表单形式注册用户信息
		out.println("<a href='loginPageServlet'>登录</a>");
		out.println("<form action='registServlet' method='post' enctype='multipart/form-data'>");
		out.println("<input type='hidden' name='id' value='0'/><br/>");
		out.println("UserName:<input type='text' name='userName'/><br/>");
		out.println("Age:<input type='text' name='age'/><br/>");
		out.println("Name:<input type='text' name='name'/><br/>");
		out.println("Phone:<input type='text' name='phone' /><br/>");
		out.println("Sex:<input type='text' name='sex'/><br/>");
		out.println("Password:<input type='password' name='password'/><br/>");
		out.println("photo:<input type=\"file\" name=\"photo\"><br/>");
		out.println("<input type='submit' name='submit' value='添加'/><br/>");
		out.println("</form>");
		String msg = (String)request.getAttribute("msg");
		out.println(msg);
		if(msg != null && !"".equals(msg)) {
		out.println("<script type='text/javascript'>\r\n" + 
				"		   alert('"+msg+"');\r\n" + 
				"		</script>");
	     }

}
}