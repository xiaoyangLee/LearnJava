package com.lxy.shoppingcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.sun.javafx.collections.MappingChange.Map;


public class BookDB {
	private static Map<String, Book>books=(Map<String, Book>) new LinkedHashMap<String,Book>();
	static{
		((HashMap<String, Book>) books).put("1",new Book("1","�����������ϵͳ"));
		((HashMap<String, Book>) books).put("2",new Book("2","�㷨����"));
		((HashMap<String, Book>) books).put("3",new Book("3","Java���˼��"));
		((HashMap<String, Book>) books).put("4",new Book("4","���֮��"));
		((HashMap<String, Book>) books).put("5",new Book("5","ACM�������"));
	}
	
	
	//��ȡ����ͼ��
	public static Collection<Book>getAll() {
		return (((LinkedHashMap<String, Book>) books).values());
	}
	
	//����ָ����id���ͼ��
	public static Book getBook(String id) {
		return	((LinkedHashMap<String, Book>) books).get(id);
	}
	
}
