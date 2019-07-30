package cn.com.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.javaweb.demo.entity.User;
import cn.com.javaweb.demo.service.IUserService;
import cn.com.javaweb.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");// post(getBytes, new String(bytes,'utf-8'))
		
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(idStr);
		}catch(Exception e) {}
		String userName = request.getParameter("userName");
		String ageStr = request.getParameter("age");
		int age = -1;
		try {
			age = Integer.parseInt(ageStr);
		}catch(Exception e) {}
	    String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		// 解决get方式提交的乱码
//		byte[] bytes = sex.getBytes("iso-8859-1");
//		sex = new String(bytes,"utf-8");
		
		String name = request.getParameter("name");
		User user = new User();
		user.setAge(age);
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setSex(sex);
		user.setUserName(userName);
		user.setPassword(password);
		
		IUserService userService = new UserServiceImpl();
		String msg = "更新成功";
		try {
		    userService.editUser(user);
		}catch(Exception e) {
			msg = "更新失败:" + e.getMessage();
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/editPageServlet").forward(request, response);
	}

}
