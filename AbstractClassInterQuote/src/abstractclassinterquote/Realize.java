package abstractclassinterquote;
/**
 * ʵ���࣬�̳�Bird������ʵ�ֽӿ�Penguin
 * @author Administrator
 *
 */
public class Realize extends Bird implements Penguin {
	
	public static void main(String[] args) {
		//ʵ��Realize
		Realize realize = new Realize();
		
		System.out.println("Realize����ʵ�ֳ�����ͽӿڵ����з���");
		//Realize�ķ�������ʵ��
		realize.canLayEgg();
		realize.canSwim();
		realize.cantFly();
		realize.fly();
		System.out.println("");
		
		System.out.println("ʹ�ó���������Realize�Ķ���,ֻ��ʹ�ó�����Bird�ķ���");
		//ʹ�ó���������Realize�Ķ���,ֻ��ʹ�ó�����Bird�ķ���
		Bird bird = new Realize();
		bird.layEggs();
		bird.fly();
		System.out.println("");
		
		System.out.println("ʹ�ýӿ�����Realize�Ķ���,ֻ��ʹ�ýӿ�Penguin�ķ���");
		//ʹ�ýӿ�����Realize�Ķ���,ֻ��ʹ�ýӿ�Penguin�ķ���
		Penguin penguin = new Realize();
		penguin.canSwim();
		penguin.cantFly();
		penguin.canLayEgg();
	}

	@Override
	public void cantFly() {
		// TODO Auto-generated method stub
		System.out.println("Penguin can't fly");
	}

	@Override
	public void canLayEgg() {
		// TODO Auto-generated method stub
		System.out.println("Penguin can lay eggs");
	}

	@Override
	public void canSwim() {
		// TODO Auto-generated method stub
		System.out.println("Penguin can swim");
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Penguin";
	}
	

}
