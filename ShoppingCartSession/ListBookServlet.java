package com.lxy.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListBookServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		Collection<Book>books=BookDB.getAll();
		out.write("本站提供的图书有：<br>");
		for(Book book :books){
			String url="PurchaseServlet?id="+book.getId();
			out.write(book.getName()+"<a href='"+url+"'>点击购买</a><br>");
		}
	}
		
}
