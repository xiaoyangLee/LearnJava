package abstractclassinterquote;
/**
 * Bird������ 
 * ����������зǳ��󷽷�������г��󷽷�������ض�Ϊ��������߽ӿ�
 * @author Administrator
 *
 */
public abstract class Bird {
	public String name;
	
	//������Է���
	protected void fly() {
		System.out.println("Birds can fly!");
		
	}
	//������µ�
	protected void layEggs(){
		System.out.println("Birds can lay eggs!");
	}
	//���󷽷�-������������,���󷽷�û�з����壬���Լӻ������Ǵ����
	protected abstract String getName();
	
	//Ĭ�Ϲ��췽��
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//���췽�������������
	public Bird(String name) {
		super();
		this.name = name;
	}
	
}
