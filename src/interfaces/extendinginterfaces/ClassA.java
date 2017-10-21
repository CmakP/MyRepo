package interfaces.extendinginterfaces;
/**
 * Project: ExtendingInterface
 * File: ClassB.java
 * Date: Apr 14, 2017
 * Time: 12:43:19 PM
 */

public abstract class ClassA implements InterfaceE {

	public ClassA() {}

	public abstract void methodFromAbstractClassD();
	
	public static void printStatic() {
		System.out.println("Static method from ClassA");
	}
	
	public void print() {
		System.out.println("Concrete method from ClassA");
	}
	
	protected void printProtected() {
		System.out.println("Concrete Protected method from ClassA");
	}
	
	public static final int i = 0;
	
	protected int j = 2;

}
