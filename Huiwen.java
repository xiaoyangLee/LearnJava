package com.lxy.experiment3;

import java.util.Scanner;

/**
 * �ж�һ���ַ����Ƿ�Ϊ�����ַ���
 * @author xiaoyang
 *
 */
public class Huiwen {
	public static void main(String[] args) {
		System.out.println("������һ���ַ���");
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		boolean val = Analyze(str1); //����Analyze���������Ƿ�Ϊ�������У����ز������͵�ֵ��
		Print(val);
		scanner.close();
	}

	private static void Print(boolean val) {
		// TODO Auto-generated method stub
		//ͨ������Ĳ������͵�ֵ������Ƿ�Ϊ��������
		if (val) {
			System.out.println("���ַ����ǻ�������");
		}
		else {
			System.out.println("���ַ������ǻ�������");
		}
	}

	private static boolean Analyze(String str) {
		// TODO Auto-generated method stub
		//�����Ƿ�Ϊ�������еĺ�����
		for(int i = 0;i<str.length()/2;i++)
		//���ַ������м�ֿ���ʹ��charAt()���������ߵ�ֵ��һ�Ƚϣ�����ͬ�򷵻�true��
		if (str.charAt(i)==str.charAt(str.length()-i-1)) {
			return true;
		}
		return false;
	}
}
