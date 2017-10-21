package core;

public class MyBasicStaticMemberClass implements MyStaticMemberInterface.MyStaticInterface {

	@Override
	public void implementMe() {
		System.out.println("Hey I have implemented successfully!!!");
	}
	 
	public void implement() {
		System.out.println("Hey I have implemented successfully!!!");
	}
	
	public static void main(String a[]) {
	/*
	 * Polymorphism via Interfaces
	 * As with class reference types, the compiler will restrict invocations to methods 
	 * in the interface, hence there the following line will cause a compile time error
	 * IMPORTANT - Compiler bases its rulings on the static type of the reference
	 */
		 
		MyStaticMemberInterface.MyStaticInterface app = new MyBasicStaticMemberClass();
	//	MyBasicStaticMemberClass app = new MyBasicStaticMemberClass();
		app.implementMe();	
		// Compile time error
	//	app.implement();
	}
}

 class MyStaticMemberInterface {
    
	 public static interface MyStaticInterface {
   		public void implementMe();
   	 }
 }

