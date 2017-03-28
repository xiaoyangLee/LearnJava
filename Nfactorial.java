package com.lit.experiment2;

import java.util.Scanner;

/**
 * A class is to print number n's factorial.
 * 
 * @author xiaoyang
 *
 */
public class Nfactorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input a number you want to count");
		int n = scanner.nextInt();
		if (n == 0) {
			System.out.println("The value is 0!=1");
		} else {
			System.out.println("The value is ");
			//调用包含for循环语句的函数完成
			//long x = Nfact(n);
			//调用包含递归语句的函数完成
			long x = Digui(n);
			//调用包含while语句的函数完成
			// long x = Whil(n);
			print(x);
			scanner.close();
		}
	}

	private static void print(long x) {
		// TODO Auto-generated method stub
		System.out.print("=");
		System.out.println(x);
	}

	// Use the "for" statement to complete.
	private static long Nfact(int n) {
		// TODO Auto-generated method stub
		long s = 1;
		for (; n > 0; n--) {
			if (n == 1) {
				System.out.print(n + "");
				break;
			} else
				System.out.print(n + "x");
			s = n * s;

		}
		return s;
	}

	// Use the "while" statement to complete.
	private static long Whil(int n) {
		long s = 1;
		while (n > 0) {
			if (n == 1) {
				System.out.print(n + "");
				break;
			} else
				System.out.print(n + "x");
			s = n * s;
			n--;
		}
		return s;
	}

	// Use the "digui" statement to complete.
	private static long Digui(int n) {
		if (n == 1) {
			System.out.print(n + "");
			return 1;
		} else {
			System.out.print(n + "x");
			return n * Digui(n - 1);
		}
	}
}
