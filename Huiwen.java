package com.lxy.experiment3;

import java.util.Scanner;

/**
 * 判断一个字符串是否为回文字符串
 * @author xiaoyang
 *
 */
public class Huiwen {
	public static void main(String[] args) {
		System.out.println("请输入一个字符串");
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		boolean val = Analyze(str1); //调用Analyze函数分析是否为回文序列，返回布尔类型的值。
		Print(val);
		scanner.close();
	}

	private static void Print(boolean val) {
		// TODO Auto-generated method stub
		//通过传入的布尔类型的值，输出是否为回文序列
		if (val) {
			System.out.println("此字符串是回文序列");
		}
		else {
			System.out.println("此字符串不是回文序列");
		}
	}

	private static boolean Analyze(String str) {
		// TODO Auto-generated method stub
		//分析是否为回文序列的函数。
		for(int i = 0;i<str.length()/2;i++)
		//将字符串从中间分开，使用charAt()方法将两边的值逐一比较，若相同则返回true。
		if (str.charAt(i)==str.charAt(str.length()-i-1)) {
			return true;
		}
		return false;
	}
}
