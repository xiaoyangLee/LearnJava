package com.lxy.oop;
/**
 * 因为编码问题不得不删除原来的数据。现在是UTF-8编码。
 */

import com.lxy.oop.Person;
import com.lxy.oop.Student;
public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("",'女');
		p1.setAge(17);
		Student p2= new Student("", 123456, "", '男');
		Student p3= new Student("", 1234556, "", '女');
		p2.setAge(18);
		System.out.println(p1.toString());
		System.out.println(p2.toString()+p2.getAge()+p2.getSex());
		System.out.println(Person.getCount()+"--"+Student.getCount());
		p1=p3;
		System.out.println(p1.toString());
		
	}
}
