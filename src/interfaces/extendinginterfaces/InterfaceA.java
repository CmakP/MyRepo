package interfaces.extendinginterfaces;
/**
 * Project: ExtendingInterface
 * File: InterfaceA.java
 * Date: Apr 14, 2017
 * Time: 12:33:48 PM
 */

public interface InterfaceA {

	public void methodFromInterfaceA();

	// Before Java 8, the interface only contains method signatures. 
	// With Java 8 new feature Default Methods or Defender Methods, 
	// you can include method body within the interface.
	default void defaultMethod() {
        System.out.println("from InterfaceA, default method...");
    }
	
	static void someStaticMethod() {
        System.out.println("from InterfaceA static method...");
    }
	
	/*
	 * Why do we need to implement a method within the interface?
	 * 
     * Let's say you have an interface which has multiple methods, 
     * and multiple classes are implementing this interface. One 
     * of the method implementations can be common across the classes, 
     * we can make that method as a default method, so that the 
     * implementation is common for all classes.
     *
     * How to work with existing interfaces?
     * 
	 * Second scenario where you have already existing application, 
	 * for a new requirement we have to add a method to the existing 
	 * interface. If we add new method then we need to implement it 
	 * through out the implementation classes. By using the Java 8 
	 * default method we can add a default implementation of that 
	 * method which resolves the problem.
	 */
}
