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
 * Servlet implementation class EditPageServlet
 */
public class EditPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取id
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		}catch(Exception e) {}
		// 创建UserService
		IUserService userService = new UserServiceImpl();
		// 获取User
		User user = userService.findById(id);
		// 用表单形式显示用户信息
		// 修改按钮
		out.println("<form action='editServlet' method='post'>");
		out.println("<input type='hidden' name='id' value='"+user.getId()+"'/><br/>");
		out.println("UserName:<input type='text' name='userName' value='"+user.getUserName()+"' readonly='readonly'/><br/>");
		out.println("Age:<input type='text' name='age' value='"+user.getAge()+"'/><br/>");
		out.println("Name:<input type='text' name='name' value='"+user.getName()+"'/><br/>");
		out.println("Phone:<input type='text' name='phone' value='"+user.getPhone()+"'/><br/>");
		out.println("Sex:<input type='text' name='sex' value='"+user.getSex()+"'/><br/>");
		out.println("Password:<input type='password' name='password' value='"+user.getPassword()+"'/><br/>");
		out.println("<input type='submit' name='submit' value='修改'/><br/>");
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
