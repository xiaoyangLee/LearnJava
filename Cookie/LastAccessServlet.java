package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessServlet
 */
@WebServlet("/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LastAccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("Hello World");
		//禁止浏览器缓存页面
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		// 设定cookie值lastAccessTime,用于记录用户上次登录的时间
		String lastAccessTime = null;
		// 获取所有的cookie，将值存入到数组中
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		// 判断是否存在名称为lastAccess的cookie
		if (lastAccessTime == null) {
			response.getWriter().print("您是首次访问本站！");
		} else {
			response.getWriter().print("您上次访问的时间是:" + lastAccessTime);
		}
		//创建cookie，将当前的时间作为cookie的值发送到客户端
		String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	
		Cookie cookie  = new Cookie("lastAccess",currentTime);
		//将cookie的有效时间设置为1小时
		cookie.setMaxAge(60*60);
		//发送cookie
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
