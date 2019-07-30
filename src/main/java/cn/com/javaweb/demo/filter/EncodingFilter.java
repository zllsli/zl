package cn.com.javaweb.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {
    private String fromEncoding = "iso-8859-1";
    private String destEncoding = "utf-8";
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("encoding  request");
		response.setContentType("text/html;charset=" + this.destEncoding);
		chain.doFilter(new MyServletRequestWrapper((HttpServletRequest)request), response);
		System.out.println("encoding response");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("encoding init");
		String from = fConfig.getInitParameter("fromEncoding");
		String dest = fConfig.getInitParameter("destEncoding");
		if(from != null) {
			this.fromEncoding = from; 
		}
		if(dest != null) {
			this.destEncoding = dest;
		}
	}
	
	private class MyServletRequestWrapper extends HttpServletRequestWrapper{// 不支持http协议
		public MyServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}
		public String getParameter(String name) {
			String value = super.getParameter(name);
			if(value != null) {
				value = convertToOk(value);
			}
			return value;
		}
		
		public String[] getParameterValues(String name) {
			String[] values = super.getParameterValues(name);
			if(values != null) {
				for(int i=0;i<values.length;i++) {
					values[i] = convertToOk(values[i]);
				}
			}
			return values;
		}
		
		private String convertToOk(String value) {
			if (value != null) {
				try {
					byte[] bytes = value.getBytes(fromEncoding);
					value = new String(bytes, destEncoding);
				} catch (Exception e) {
				}
			}
			return value;
		}
	}

}
