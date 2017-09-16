package abstractclassinterquote;
/**
 * 实现类，继承Bird抽象类实现接口Penguin
 * @author Administrator
 *
 */
public class Realize extends Bird implements Penguin {
	
	public static void main(String[] args) {
		//实现Realize
		Realize realize = new Realize();
		
		System.out.println("Realize可以实现抽象类和接口的所有方法");
		//Realize的方法都能实现
		realize.canLayEgg();
		realize.canSwim();
		realize.cantFly();
		realize.fly();
		System.out.println("");
		
		System.out.println("使用抽象类引用Realize的对象,只能使用抽象类Bird的方法");
		//使用抽象类引用Realize的对象,只能使用抽象类Bird的方法
		Bird bird = new Realize();
		bird.layEggs();
		bird.fly();
		System.out.println("");
		
		System.out.println("使用接口引用Realize的对象,只能使用接口Penguin的方法");
		//使用接口引用Realize的对象,只能使用接口Penguin的方法
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
