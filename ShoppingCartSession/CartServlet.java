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
		//����Cart�����û��Ĺ��ﳵ
		List cart=null;
		//����purFlag����û��Ƿ������Ʒ
		boolean purFlag=true;
		//����û���Session
		HttpSession session=req.getSession(false);
		//���sessionΪnull,purFlag��Ϊfalse
		if (session==null) {
			purFlag=false;
		}else{
			//����û����ﳵ
			cart=(List)session.getAttribute("cart");
			//����õĹ��ﳵΪnull��purFlag��Ϊfalse
			if (cart==null) {
				purFlag=false;
			}
		}
		/**
		 * ���purFlagΪfalse�������û�û�й���ͼ�飬�ض���ListServletҳ��
		 */
		if (!purFlag) {
			out.write("�Բ����㻹û�й����κ���Ʒ��<br>");
		}else{
			//������ʾ�û�����ͼ�����Ϣ
			out.write("�������ͼ���У�<br>");
			double price=0;
			for(Book book: cart){
				out.write(book.getName()+"<br>");
			}
		}
	}
		
}
