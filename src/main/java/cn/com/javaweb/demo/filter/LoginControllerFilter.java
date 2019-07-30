package cn.com.javaweb.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginControllerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("controller init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 是否登录的控制
		// 判断当前的请求，是否是登录后的用户发来的？
		//  如果是，继续执行
		//  否则：转向登录页面
		System.out.println("controller request");
		//chain.doFilter(request, response);
		
		
		// 1 获取Session对象
		// 2 从Session对象中获取登录标记
		// 3 基于登录标记判断是否有登录，在实现继续执行 或 转向
		HttpSession session = ((HttpServletRequest)request).getSession();
		String userName = (String)session.getAttribute("LOGIN_USER_NAME");
		if(userName != null && !"".equals(userName)) {
			chain.doFilter(request, response);
			System.out.println("controller response");
		}else {
			request.getRequestDispatcher("/loginPageServlet").forward(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
