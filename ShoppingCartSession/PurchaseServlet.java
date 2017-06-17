package com.lxy.shoppingcart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class PurchaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得用户购买的商品。
		String id=req.getParameter("id");
		if (id==null) {
			//如果id为null,重定向到ListBookServlet页面。
			String url="ListBookServlet";
			resp.sendRedirect(url);
			return;
		}
		Book book=BookDB.getBook(id);
		//创建或者获得用户的Session对象
		HttpSession session=req.getSession();
		//从Session对象中获取用户的购物车。
		List cart=(List)session.getAttribute("cart");
		if (cart==null) {
			//首次购买为用户创建一个购物车。
			cart=(List) new ArrayList<Book>();
			//将购物车存入session对象
		}
		//将商品放入购物车
		((ArrayList<Book>) cart).add(book);
		//创建cookie存放Session的标识号。
		Cookie cookie=new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/");
		resp.addCookie(cookie);
		//重定向到购物车
		String url="CartServlet";
		resp.sendRedirect(url);
	}
		
}
