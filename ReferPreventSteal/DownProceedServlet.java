package com.lxy.referpreventsteal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownProceedServlet
 */
@WebServlet("/DownProceedServlet")
public class DownProceedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownProceedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
//		out.println("Refer信息为:");
//		out.write(request.getHeader("referer"));
		//获得Refer的信息
		String referer=request.getHeader("referer");
		//获取访问地址,例如127.0.0.1
		String sitePart="http://"+request.getServerName();
		
		//判断referer头是否为空，这个头的首地址是否以sitePart开始的
		if (referer!=null&&referer.startsWith(sitePart)) {
			//合法链接，处理正在下载的请求
			out.print("正在处理下载...");
		}else {
			//非法下载请求先跳转到下载的html页面，使用RequestDispatcher转向
			RequestDispatcher dispatcher=request.getRequestDispatcher("download.html");
			dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
