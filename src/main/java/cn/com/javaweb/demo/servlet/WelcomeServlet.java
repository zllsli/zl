package cn.com.javaweb.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.javaweb.demo.entity.User;
import cn.com.javaweb.demo.listener.MySessionLifeListener;
import cn.com.javaweb.demo.service.IUserService;
import cn.com.javaweb.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 包含头部分
//				RequestDispatcher dis = request.getRequestDispatcher("/headerServlet");
//				dis.include(request, response);
//				
//				String userName = (String)request.getAttribute("userName");
//				// 输出自己的登录form
//				response.setContentType("text/html;charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				out.println(userName + "你好，恭喜登录成功，欢迎光临！！！！");
//				// out.close()
//				// 包含footer信息
//				dis = request.getRequestDispatcher("/footerServlet");
//				dis.include(request, response);
//	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getSession().getId());
		// 判断是否登录过？
		boolean hasLogined = false;
		String userName = (String) request.getSession().getAttribute("LOGIN_FLAG");
		if (userName == null || "".equals(userName)) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("loginFlag")) {
						userName = cookie.getValue();
						hasLogined = true;
					}
				}
			}
		} else {
			hasLogined = true;
		}
		if (hasLogined) {
			// 创建UserSErvice
			IUserService userService = new UserServiceImpl();//工厂产生IUserService对象
			// 调用UserService的方法，获取用户列表
			List<User> userList = userService.findAllUsers();
			// 输出用户列表页面

			// 输出自己的登录form
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("		  <table width=\"400px\">\r\n" + 
					"			  <tr>\r\n" + 
					"				  <td>序号</td>\r\n" + 
					"				  <td>用户名</td>\r\n" + 
					"				  <td>姓名</td>\r\n" + 
					"				  <td>电话</td>\r\n" + 
					"				  <td>操作</td>\r\n" + 
					"			  </tr>");
			if(userList != null) {
				for(int i=0;i<userList.size();i++) {
					User u = userList.get(i);
					String url = "userDetailServlet?id="+u.getId();
					url = response.encodeRedirectURL(url);
					System.out.println(url);
			out.print("			  <tr>\r\n" + 
					"			  				  <td>"+(i+1)+"</td>\r\n" + 
					"			  				  <td><a href='"+url+"'>"+u.getUserName()+"</a></td>\r\n" + 
					"			  				  <td>"+u.getName()+"</td>\r\n" + 
					"			  				  <td>"+u.getPhone()+"</td>\r\n" + 
					"			  				  <td><input type='button' onclick='location.href=\"editPageServlet?id="+u.getId()+"\"' value='修改'/></td>\r\n" + 
					"                             <td><input type='button' onclick='location.href=\"deleteServlet?id="+u.getId()+"\"'value ='删除'/></td>\r\n"+
					"			  </tr>");
				}
			}
			out.println("</table>");
			out.flush();
			out.close();
		} else {
			request.getRequestDispatcher("/loginPageServlet").forward(request, response);
		}
	}

}
