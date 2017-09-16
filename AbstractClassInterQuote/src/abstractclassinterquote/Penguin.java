package abstractclassinterquote;
/**
 * Penguin接口 
 * 接口的方法的修饰符只能是public或者空
 * @author Administrator
 *
 */
public interface Penguin {
	
	//接口中声明的变量都是静态的，默认加static
	static int num = 1;
	
	String name = "Penguin";
	
	//企鹅不会飞
	public void cantFly();
	
	//企鹅会下蛋
	public void canLayEgg();
	
	//企鹅会游泳
	public void canSwim();
	
}
