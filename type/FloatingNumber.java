package javafloat;
/**
 * Java�ĸ�����
 * ���󲿷������Ƕ���ʹ�õ�double,float��������Ҫ��
 * @author Administrator
 *
 */
public class FloatingNumber {
	public static void main(String[] args) {
		//double�Ĵ洢8���ֽڣ���Чλ��15λ
		double x = 2.0-1.1;
		System.out.println(x);
		
		//float�洢ռ4���ֽڣ���Чλ��6-7λ
		//����ȶ��壬ǿ������ת������ô�������0.9
		float i = (float) (2.0-1.1);
		System.out.println("2.0-1.1�Ľ����:"+i);

		//���ֱ������������ô����0.899999999999
		System.out.print("2.0-1.1�Ľ����:");
		System.out.println(2.0-1.1);
	}
}
