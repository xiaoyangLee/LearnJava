package com.lxy.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseServlet() {
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

		// ��ȡ�û��������Ʒid
		String id = request.getParameter("id");
		if (id == null) {
			// ���idΪnull�ض���ListBookServletҳ��
			String url = "ListBookServlet";
			response.sendRedirect(url);
			return;
		}

		Book book = BookDB.getBook(id);
		// �������߻���û���Session����
		HttpSession session = request.getSession();
		// ��Session�л�ȡ�û��Ĺ��ﳵ��ʹ��List����ģ��
		List<Book> cart = (List) session.getAttribute("cart");
		if (cart == null) {
			// �״ι���Ϊ�û�����һ�����ﳵ
			cart = new ArrayList<Book>();
			// �����ﳵ����Session����
			session.setAttribute("cart", cart);
		}
		//����Ʒ���빺�ﳵ
		cart.add(book);
		//����cookie���Session�ı�ʶ��
		Cookie cookie=new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		//�ض��򵽹��ﳵҳ��
		String url="CartServlet";
		response.sendRedirect(url);
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
