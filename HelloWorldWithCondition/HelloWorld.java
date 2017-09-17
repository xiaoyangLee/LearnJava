package helloworld;

import java.util.concurrent.Callable;

/**
 * 在if条件语句的限定下，输出HelloWorld
 * 
 * @author Administrator
 *
 */
public class HelloWorld {
	/*
	 * 原题目如下，在if中填入条件，使其输出HelloWorld if(){ System.out.print("Hello "); }else{
	 * System.out.println("World!"); }
	 */
	public static void main(String[] args) {
		//使用userCall()
		System.out.println("使用userCall()");
		useCall();
		//使用新建Object对象的方法
		System.out.println("使用新建Object对象的方法");
		newObject();
		//使用小聪明的办法
		System.out.println("使用小聪明的办法");
		funny();
		//使用append
		System.out.println("使用append");
		useAppend();
		//使用Java反射机制
		System.out.println("使用Java反射机制");
		useReflex();
		
	}

	// 第一种方法，使用callable<>泛型接口和回调函数
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
	
	//第二种方法，新建Object对象
	@SuppressWarnings("unused")
	public static void newObject(){
		if(new Object(){{System.out.print("Hello");}}==null){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//第三种方法，一个很搞笑的...但是也符合
	@SuppressWarnings("unused")
	public static void funny(){
		if(true)System.out.print("Hello");if(false){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//第四种方法，使用append
	public static void useAppend(){
		if(System.out.append("Hello")==null){ 
			System.out.print("Hello "); 
		}else{ 
			System.out.println("World!"); 
		}
	}
	
	//第五种方法，使用Java反射机制
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
