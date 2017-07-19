package com.lxy.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ����cart�����û��Ĺ��ﳵ
		List<Book> cart = null;
		// ����pruFlag����û��Ƿ������Ʒ
		boolean purFlag = true;
		// ����û���session
		HttpSession session = request.getSession(false);
		// ���sessionΪNull,purFlag��Ϊfalse
		if (session == null) {
			purFlag = false;
		} else {
			// ����û����ﳵ
			cart = (List) session.getAttribute("cart");
			// ����õĹ��ﳵΪnull,purFlag��Ϊfalse
			if (cart == null) {
				purFlag = false;
			}
		}
		
		 	//���purFlag=false,�����û�û�й���ͼ�飬�ض���ListServletҳ��
		
		if (!purFlag) {
			out.write("�Բ�������û�й�����κ���Ʒ!<br>");
		}else{
			//������ʾ�û�����ͼ�����Ϣ
			out.write("���������ͼ���У�<br>");
			//double price=0;
			for(Book book:cart){
				out.write(book.getName()+"<br>");
			}
		}
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
