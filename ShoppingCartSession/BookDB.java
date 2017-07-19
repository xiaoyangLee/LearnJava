package com.lxy.shoppingcart;

import java.util.Collection;
import java.util.LinkedHashMap;

import java.util.Map;


public class BookDB {
	private static Map<String, Book>books=new LinkedHashMap<String,Book>();
	static{
			books.put("1",new Book("1","�����������ϵͳ"));
			books.put("2",new Book("2","�㷨����"));
			books.put("3",new Book("3","Java���˼��"));
			books.put("4",new Book("4","���֮��"));
			books.put("5",new Book("5","ACM�������"));
	}
	
	
	//��ȡ����ͼ��
	public static Collection<Book>getAll() {
		return books.values();
	}
	
	//����ָ����id���ͼ��
	public static Book getBook(String id) {
		return books.get(id);
	}
	
}
