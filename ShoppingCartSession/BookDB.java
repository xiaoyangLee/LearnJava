package com.lxy.shoppingcart;

import java.util.Collection;
import java.util.LinkedHashMap;

import java.util.Map;


public class BookDB {
	private static Map<String, Book>books=new LinkedHashMap<String,Book>();
	static{
			books.put("1",new Book("1","深入理解计算机系统"));
			books.put("2",new Book("2","算法导论"));
			books.put("3",new Book("3","Java编程思想"));
			books.put("4",new Book("4","编程之美"));
			books.put("5",new Book("5","ACM程序设计"));
	}
	
	
	//获取所有图书
	public static Collection<Book>getAll() {
		return books.values();
	}
	
	//根据指定的id获得图书
	public static Book getBook(String id) {
		return books.get(id);
	}
	
}
