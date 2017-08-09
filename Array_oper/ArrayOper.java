package com.lxy.array_oper;

/**
 * 数组的操作
 * 
 * @author xiaoyang
 *
 */
public class ArrayOper {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		// 输出堆区arr的地址
		System.out.println("堆区数组arr的地址为:" + arr);

		System.out.println("数组遍历的结果为:");
		// 遍历数组，输出值
		traversalArr(arr);
		
		System.out.println("逆序操作过后的数组值为:");
		// 逆序操作
		reverseArr(arr);
		
		// 求最大值，最小值同理省略
		System.out.println("数组中的最大值为:\n"+maxArr(arr));
		
		
		System.out.println("数组中的最大值的索引为:");
		// 查找，返回索引值
		searchArr(arr,maxArr(arr));
		

	}
	
	//遍历数组，输出值
	private static void traversalArr(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print('[');
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				//最后一个元素
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i]+",");
			}
		}
		System.out.println(']');
	}

	// 查表返回索引
	private static void searchArr(int[] arr,int max) {
		// TODO Auto-generated method stub
		int index = -1;//找不到则返回-1
		for (int i = 0; i < arr.length; i++) {
			if (max==arr[i]) {
				index = i;
			}
		}
		System.out.println(index);
	}
	//返回数组中的最大值
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
	
	//逆序操作
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
