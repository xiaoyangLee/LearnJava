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
		//����û��������Ʒ��
		String id=req.getParameter("id");
		if (id==null) {
			//���idΪnull,�ض���ListBookServletҳ�档
			String url="ListBookServlet";
			resp.sendRedirect(url);
			return;
		}
		Book book=BookDB.getBook(id);
		//�������߻���û���Session����
		HttpSession session=req.getSession();
		//��Session�����л�ȡ�û��Ĺ��ﳵ��
		List cart=(List)session.getAttribute("cart");
		if (cart==null) {
			//�״ι���Ϊ�û�����һ�����ﳵ��
			cart=(List) new ArrayList<Book>();
			//�����ﳵ����session����
		}
		//����Ʒ���빺�ﳵ
		((ArrayList<Book>) cart).add(book);
		//����cookie���Session�ı�ʶ�š�
		Cookie cookie=new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/");
		resp.addCookie(cookie);
		//�ض��򵽹��ﳵ
		String url="CartServlet";
		resp.sendRedirect(url);
	}
		
}
