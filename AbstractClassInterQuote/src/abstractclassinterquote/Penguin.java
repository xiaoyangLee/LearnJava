package abstractclassinterquote;
/**
 * Penguin�ӿ� 
 * �ӿڵķ��������η�ֻ����public���߿�
 * @author Administrator
 *
 */
public interface Penguin {
	
	//�ӿ��������ı������Ǿ�̬�ģ�Ĭ�ϼ�static
	static int num = 1;
	
	String name = "Penguin";
	
	//��첻���
	public void cantFly();
	
	//�����µ�
	public void canLayEgg();
	
	//������Ӿ
	public void canSwim();
	
}
