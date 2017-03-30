package com.lxy.experiment3;

import java.util.Scanner;
/**
 * 打印出一个等腰三角形的杨辉三角。
 * @author xiaoyang
 *
 */

public class Yanghui {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要打印的杨辉三角的行数");
		int n = scanner.nextInt();
		int mat[][] = yanghui(n);
		print(mat);
		scanner.close();
	}

	private static void print(int[][] mat) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mat.length; i++) {
			//输出前面的空格。
				System.out.print(String.format("%"+(mat.length-i+1)*2+"c",' '));
			for (int j = 0; j < mat[i].length; j++)
				//System.out.print(" "+mat[i][j]);	
				//格式化输出形式
				System.out.print(String.format("%4d",mat[i][j]));
			System.out.println();
			
		}
	}

	private static int[][] yanghui(int n) {
		// TODO Auto-generated method stub
		//定义杨辉三角的二维数组，并给其赋值。
		int mat[][] = new int[n][];
		for(int i=0;i<n;i++){
			mat[i] = new int[i+1];
			mat[i][0] = mat[i][i] = 1;
			for (int j = 1; j < i; j++) {
				mat[i][j] = mat[i-1][j]+mat[i-1][j-1];
			}
		}
		return mat;
	}
	
}
