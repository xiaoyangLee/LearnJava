package helloworld;

import java.util.concurrent.Callable;

/**
 * ��if���������޶��£����HelloWorld
 * 
 * @author Administrator
 *
 */
public class HelloWorld {
	/*
	 * ԭ��Ŀ���£���if������������ʹ�����HelloWorld if(){ System.out.print("Hello "); }else{
	 * System.out.println("World!"); }
	 */
	public static void main(String[] args) {
		//ʹ��userCall()
		System.out.println("ʹ��userCall()");
		useCall();
		//ʹ���½�Object����ķ���
		System.out.println("ʹ���½�Object����ķ���");
		newObject();
		//ʹ��С�����İ취
		System.out.println("ʹ��С�����İ취");
		funny();
		//ʹ��append
		System.out.println("ʹ��append");
		useAppend();
		//ʹ��Java�������
		System.out.println("ʹ��Java�������");
		useReflex();
		
	}

	// ��һ�ַ�����ʹ��callable<>���ͽӿںͻص�����
	public static void useCall(){
		if(new Callable<Boolean>(){
			public Boolean call(){
				System.out.print("Hello");
				return false;
			}
		}.call()){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//�ڶ��ַ������½�Object����
	@SuppressWarnings("unused")
	public static void newObject(){
		if(new Object(){{System.out.print("Hello");}}==null){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//�����ַ�����һ���ܸ�Ц��...����Ҳ����
	@SuppressWarnings("unused")
	public static void funny(){
		if(true)System.out.print("Hello");if(false){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//�����ַ�����ʹ��append
	public static void useAppend(){
		if(System.out.append("Hello")==null){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//�����ַ�����ʹ��Java�������
	public static void useReflex(){
		try{
		if(System.out.getClass().getDeclaredMethod("print", String.class).invoke(System.out,"Hello")!=null){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
