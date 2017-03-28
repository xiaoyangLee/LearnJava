package com.lxy.oop;

public class Person {
	private String name;
	private int age;
	private char sex;
	private static int count = 0;


public Person(String name,char sex){
	setName(name);
	setSex(sex);
	Person.count++;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public char getSex() {
	return sex;
}


public void setSex(char sex) {
	this.sex = sex;
}


public static int getCount() {
	return count;
}

public  String  toString() {
	return("姓名："+getName()+",性别："+getSex()+",年龄:"+getAge());
}
}
