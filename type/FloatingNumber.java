package javafloat;
/**
 * Java的浮点数
 * 绝大部分下我们都是使用的double,float很难满足要求
 * @author Administrator
 *
 */
public class FloatingNumber {
	public static void main(String[] args) {
		//double的存储8个字节，有效位数15位
		double x = 2.0-1.1;
		System.out.println(x);
		
		//float存储占4个字节，有效位数6-7位
		//如果先定义，强制类型转换，那么结果就是0.9
		float i = (float) (2.0-1.1);
		System.out.println("2.0-1.1的结果是:"+i);

		//如果直接输出结果，那么会是0.899999999999
		System.out.print("2.0-1.1的结果是:");
		System.out.println(2.0-1.1);
	}
}
