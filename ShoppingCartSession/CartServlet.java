package com.lxy.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.TouchInputSupport.TouchCountListener;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class CartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//变量Cart引用用户的购物车
		List cart=null;
		//变量purFlag标记用户是否买过商品
		boolean purFlag=true;
		//获得用户的Session
		HttpSession session=req.getSession(false);
		//如果session为null,purFlag置为false
		if (session==null) {
			purFlag=false;
		}else{
			//获得用户购物车
			cart=(List)session.getAttribute("cart");
			//如果用的购物车为null，purFlag置为false
			if (cart==null) {
				purFlag=false;
			}
		}
		/**
		 * 如果purFlag为false，表明用户没有购买图书，重定向到ListServlet页面
		 */
		if (!purFlag) {
			out.write("对不起！你还没有购买任何商品！<br>");
		}else{
			//否则显示用户购买图书的信息
			out.write("您购买的图书有：<br>");
			double price=0;
			for(Book book: cart){
				out.write(book.getName()+"<br>");
			}
		}
	}
		
}
