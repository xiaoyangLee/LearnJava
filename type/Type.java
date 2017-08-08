package com.lxy.learnjava.type;

public class Type {
	public static void main(String[] args) {
		byte b = 3, a = 4, c;
		// c = a+b;//不可如此操作,因为+运算是整型的运算，这样是个类型提升
		
		c = (byte) (a + b);//变量相加，会先转为整型，随后计算结果，这里做了强制类型转换，看值是否大于数据范围
		
		c = 127;// 大于127是会报错的，因为byte是8bit，数据长度-128~127,int 32bit数据范围 -2^31~2^32
		
		//那么如果加之前没有超出范围，但是加之后超出了范围呢，再转类型，就会从这个类型表示范围的负数部分开始计算
		
		
		c = (byte) (127 + 1);//使用Xjad反编译工具可以看到常量的运算会先算出值->再考虑类型数据范围，这里结果为-128
		
		System.out.println(c);

	}
}
