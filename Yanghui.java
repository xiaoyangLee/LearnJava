package com.lxy.experiment3;

import java.util.Scanner;
/**
 * ��ӡ��һ�����������ε�������ǡ�
 * @author xiaoyang
 *
 */

public class Yanghui {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫ��ӡ��������ǵ�����");
		int n = scanner.nextInt();
		int mat[][] = yanghui(n);
		print(mat);
		scanner.close();
	}

	private static void print(int[][] mat) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mat.length; i++) {
			//���ǰ��Ŀո�
				System.out.print(String.format("%"+(mat.length-i+1)*2+"c",' '));
			for (int j = 0; j < mat[i].length; j++)
				//System.out.print(" "+mat[i][j]);	
				//��ʽ�������ʽ
				System.out.print(String.format("%4d",mat[i][j]));
			System.out.println();
			
		}
	}

	private static int[][] yanghui(int n) {
		// TODO Auto-generated method stub
		//����������ǵĶ�ά���飬�����丳ֵ��
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
