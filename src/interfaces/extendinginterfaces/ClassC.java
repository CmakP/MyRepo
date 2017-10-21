package interfaces.extendinginterfaces;

public class ClassC extends ClassA {

	public ClassC() {}

	@Override
	public void methodFromInterfaceA() {
		System.out.println("Implementing InterfaceA from ClassC.");
	}
	
	@Override
	public void methodFromInterfaceB() {}

	@Override
	public void methodFromInterfaceD() {}
	
	@Override
	public void methodFromInterfaceE() {}

	@Override
	public void methodFromAbstractClassD() {}

	public static void main(String[] args) {
		
		// Accessing the static method of the super class
		ClassA.printStatic();
		
		ClassC c = new ClassC();
		// Overloading + Accessing protected members
		c.print();
		// Accessing protected method of the super class
		c.printProtected();
		// Accessing the default method in interfaceA
		c.defaultMethod();
		
// An interface can be used as the type of an object reference variable		
// The a reference could be used to point to any object of any class that implements InterfaceA
// Next few lines demonstrate polymorphism via interfaces 		
		InterfaceA a = new ClassC();
		
		a.methodFromInterfaceA();
		a = new ClassB();
		a.methodFromInterfaceA();

// next line causes a compilation error. Despite there is print() in ClassC, 
// there is no print() in InterfaceA. 
// COMPILER BASES ITS RULINGS ON STATIC TYPE OF THE REFERENCE!!!
//		a.print();
	}
	
	@Override
	public void print() {
		System.out.println("Accessing protected instance variable within ClassA: " + j);
	}
}
