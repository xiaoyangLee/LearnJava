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

		// 获取用户购买的商品id
		String id = request.getParameter("id");
		if (id == null) {
			// 如果id为null重定向到ListBookServlet页面
			String url = "ListBookServlet";
			response.sendRedirect(url);
			return;
		}

		Book book = BookDB.getBook(id);
		// 创建或者获得用户的Session对象
		HttpSession session = request.getSession();
		// 从Session中获取用户的购物车，使用List集合模拟
		List<Book> cart = (List) session.getAttribute("cart");
		if (cart == null) {
			// 首次购买，为用户创建一个购物车
			cart = new ArrayList<Book>();
			// 将购物车存入Session对象
			session.setAttribute("cart", cart);
		}
		//将商品放入购物车
		cart.add(book);
		//创建cookie存放Session的标识号
		Cookie cookie=new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		//重定向到购物车页面
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
