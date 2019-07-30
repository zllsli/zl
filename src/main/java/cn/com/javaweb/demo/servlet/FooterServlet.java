package cn.com.javaweb.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FooterServlet
 */
public class FooterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<br/>footer message !!!!!!!!!!!!!!!!!!!!!!!!");
		String reqValue = (String)request.getAttribute("test");
		String session = (String)request.getSession().getAttribute("test");
		String ctxValue = (String)this.getServletContext().getAttribute("test");
		out.println("req:" + reqValue + "<br/>session:" + session + "<br/>ctxV:" + ctxValue + "<br/>");
		out.println("	</body>\r\n" + 
				"</html>");
	}

}
