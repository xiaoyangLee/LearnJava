package com.lxy.array_oper;

/**
 * ����Ĳ���
 * 
 * @author xiaoyang
 *
 */
public class ArrayOper {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		// �������arr�ĵ�ַ
		System.out.println("��������arr�ĵ�ַΪ:" + arr);

		System.out.println("��������Ľ��Ϊ:");
		// �������飬���ֵ
		traversalArr(arr);
		
		System.out.println("����������������ֵΪ:");
		// �������
		reverseArr(arr);
		
		// �����ֵ����Сֵͬ��ʡ��
		System.out.println("�����е����ֵΪ:\n"+maxArr(arr));
		
		
		System.out.println("�����е����ֵ������Ϊ:");
		// ���ң���������ֵ
		searchArr(arr,maxArr(arr));
		

	}
	
	//�������飬���ֵ
	private static void traversalArr(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print('[');
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				//���һ��Ԫ��
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i]+",");
			}
		}
		System.out.println(']');
	}

	// ���������
	private static void searchArr(int[] arr,int max) {
		// TODO Auto-generated method stub
		int index = -1;//�Ҳ����򷵻�-1
		for (int i = 0; i < arr.length; i++) {
			if (max==arr[i]) {
				index = i;
			}
		}
		System.out.println(index);
	}
	//���������е����ֵ
	private static int maxArr(int[] arr) {
		// TODO Auto-generated method stub
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if (arr[i]>max) {
				max=arr[i];
			}
		}
		//System.out.println(max);
		return max;
	}
	
	//�������
	private static void reverseArr(int[] arr) {
		// TODO Auto-generated method stub
		int temp;
		for(int i=0;i<arr.length/2;i++){
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		traversalArr(arr);
	}

}
