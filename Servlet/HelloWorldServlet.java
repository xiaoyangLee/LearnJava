package com.lxy.Servlet.HelloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class HelloWorldSevlet
 */
@WebServlet("/HelloWorldSevlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		out.write("you use the GET \r\n");
		out.println("username:"+userName+"  passworld:"+password);
		out.write("use this function is not safe,because the password can be seen ");
		//out.write("username:"+userName+"  passworld:"+password);
		out.write("\r\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out=response.getWriter();
		out.write("you use the Post \r\n");
		out.println("username:"+userName+"  passworld:"+password);
		out.write("use this function is safe,because the password can be hidden ");
		out.write("\r\n");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//当重载service方法时，父类的方法会被覆盖，如果想要doPost doGet的方法起作用，要用super.service()
		super.service(request, response);
		PrintWriter out= response.getWriter();
		out.println("hello world!");
		
	}
	

}
