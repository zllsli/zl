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
 * Servlet implementation class UserDetailServlet
 */
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
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
		// 输出所有信息
		out.println(user.getAge() + "<br/>");
		out.println(user.getId() + "<br/>");
		out.println(user.getName() + "<br/>");
		out.println(user.getPhone() + "<br/>");
		out.println(user.getSex() + "<br/>");
		out.println(user.getUserName() + "<br/>");
		
		out.flush();
		out.close();
	}

}
