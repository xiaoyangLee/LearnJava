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
		
//		out.println("Refer��ϢΪ:");
//		out.write(request.getHeader("referer"));
		//���Refer����Ϣ
		String referer=request.getHeader("referer");
		//��ȡ���ʵ�ַ,����127.0.0.1
		String sitePart="http://"+request.getServerName();
		
		//�ж�refererͷ�Ƿ�Ϊ�գ����ͷ���׵�ַ�Ƿ���sitePart��ʼ��
		if (referer!=null&&referer.startsWith(sitePart)) {
			//�Ϸ����ӣ������������ص�����
			out.print("���ڴ�������...");
		}else {
			//�Ƿ�������������ת�����ص�htmlҳ�棬ʹ��RequestDispatcherת��
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
