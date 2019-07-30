package cn.com.javaweb.demo.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 判断是不是上传的form
		boolean bool = ServletFileUpload.isMultipartContent(request);
		if(bool) {
			// fileItem的工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 指定临时目录
			factory.setRepository(new File("e:/temp"));
			// 创建请求解析对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 解析请求
				List<FileItem> items = upload.parseRequest(request);
				for(FileItem item:items) {
					// 判断是否是普通的表单field
					if(item.isFormField()) {
						// 普通的表单数据
						System.out.println(item.getFieldName() + "-->>" + item.getString());
					}else {
						// 文件
						// 获取文件名
						String fileName = item.getName();
						
						System.out.println(fileName+"***********");
						// 写目标文件
					   item.write(new File("e:/temp/upload/" + fileName));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
		    System.out.println("不是上传文件的form");
		}
	}

}
