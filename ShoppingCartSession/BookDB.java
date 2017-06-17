package com.lxy.shoppingcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.sun.javafx.collections.MappingChange.Map;


public class BookDB {
	private static Map<String, Book>books=(Map<String, Book>) new LinkedHashMap<String,Book>();
	static{
		((HashMap<String, Book>) books).put("1",new Book("1","深入理解计算机系统"));
		((HashMap<String, Book>) books).put("2",new Book("2","算法导论"));
		((HashMap<String, Book>) books).put("3",new Book("3","Java编程思想"));
		((HashMap<String, Book>) books).put("4",new Book("4","编程之美"));
		((HashMap<String, Book>) books).put("5",new Book("5","ACM程序设计"));
	}
	
	
	//获取所有图书
	public static Collection<Book>getAll() {
		return (((LinkedHashMap<String, Book>) books).values());
	}
	
	//根据指定的id获得图书
	public static Book getBook(String id) {
		return	((LinkedHashMap<String, Book>) books).get(id);
	}
	
}
