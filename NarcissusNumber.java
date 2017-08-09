/*
Java实现水仙花数
*/
public class NarcissusNumber {
	public static void main(String[] args) {
		int a=0;
		int b=0;
		int c=0;
		for(int i=100;i<999;i++){
			a=i/100;	//求出百位数
			b=i/10%10;	//求出十位数
			c=i%10;		//求出个位数
			
			//这么写显然不是好的写法，Math.pow(a,3)可以计算a的3次方
			if (i==(a*a*a+b*b*b+c*c*c)) {
				System.out.println(i);
			}
		}
	}
}
