package com.lxy.oop;

public class Student extends Person{
	private String name;
	private int age;
	private char sex;
	private int number;
	private String major;
	private static int count = 0;
	
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
		if (age<18) {
			System.out.println("年龄不得小于18岁！");
			return;
		}
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public static int getCount() {
		return count;
	}
	public Student(String name, int number,String major,char sex) {
		super(name, sex);
		setName(name);
		setNumber(number);
		setMajor(major);
		setSex(sex);
		Student.count++;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return("姓名:"+getName()+",学号："+number+",专业："+major);
	}
}
