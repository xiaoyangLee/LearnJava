package abstractclassinterquote;
/**
 * Bird抽象类 
 * 抽象类可以有非抽象方法，如果有抽象方法，此类必定为抽象类或者接口
 * @author Administrator
 *
 */
public abstract class Bird {
	public String name;
	
	//鸟儿可以飞翔
	protected void fly() {
		System.out.println("Birds can fly!");
		
	}
	//鸟儿会下蛋
	protected void layEggs(){
		System.out.println("Birds can lay eggs!");
	}
	//抽象方法-获得鸟儿的名字,抽象方法没有方法体，所以加花括号是错误的
	protected abstract String getName();
	
	//默认构造方法
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//构造方法，给鸟儿名字
	public Bird(String name) {
		super();
		this.name = name;
	}
	
}
