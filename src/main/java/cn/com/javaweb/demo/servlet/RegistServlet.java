package cn.com.javaweb.demo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.com.javaweb.demo.entity.User;
import cn.com.javaweb.demo.service.IUserService;
import cn.com.javaweb.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(); 
		// fileItem的工厂
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				// 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹
				ServletContext servletContext = this.getServletConfig().getServletContext();
				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);
				// 创建ServletFileUpload请求解析对象,并设置上传文件的大小限制
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不超过10M
				sfu.setHeaderEncoding("utf-8");
				// 解析request请求,得到一个保存了所有上传内容的List对象
				try {
					User user = new User();
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						// 普通的表单数据
						if (item.isFormField()) {
							String filename = item.getFieldName();
							String value = item.getString("utf-8");
							if (filename.equals("id")) {
								user.setId(Integer.parseInt(value));
							} else if (filename.equals("age")) {
								user.setAge(Integer.parseInt(value));
							} else if (filename.equals("name")) {
								user.setName(value);
							} else if (filename.equals("pwd")) {
								user.setPassword(value);
							} else if (filename.equals("phone")) {
								user.setPhone(value);
							} else if (filename.equals("sex")) {
								user.setSex(value);
							} else if (filename.equals("userName")) {
								user.setUserName(value);
							}
						} else {
							// 获取文件名
							String fileName = item.getName();
							System.out.println("原文件 名:" + fileName);
							// 获取文件名的后缀
							String suffix = fileName.substring(fileName.lastIndexOf('.'));
							System.out.println("扩展名:" + suffix);
							// 为了防止上传到服务器中的文件重名，所以在上传的时候我们可以将文件进行自动生成前缀，只保留后缀，再拼接到一块
							UUID uuid = UUID.randomUUID();
							String prefix = uuid.toString();
							// 拼接后的文件名
							String savefilename = prefix + suffix;
							savefilename = savefilename.replace("-", "");
							// 新文件名(唯一)
							System.out.println("新文件名:" + savefilename);
							// 调用FileItem的write()方法，写入文件
							File file = new File("D:/Images/" + savefilename);
//							session.setAttribute("image_name", fileName);
//							session.setAttribute("image_path","Images/"+savefilename);
							System.out.println(file.getAbsolutePath());
							item.write(file);
							// 6. 调用FileItem的delete()方法，删除临时文件
							item.delete();
						}
						IUserService userService = new UserServiceImpl();
						String msg = "添加成功";
						try {
							userService.addUser(user);
						} catch (Exception e) {
							msg = "添加失败:" + e.getMessage();
							e.printStackTrace();
						}
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("/loginPageServlet").forward(request, response);
					}
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
}
