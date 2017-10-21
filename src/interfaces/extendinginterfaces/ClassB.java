package interfaces.extendinginterfaces;

public class ClassB implements InterfaceE {

	public ClassB() {}
	
	public static void main(String[] args) {
        InterfaceA a = new ClassB();
        a.defaultMethod();
        InterfaceA.someStaticMethod();
        a.methodFromInterfaceA();
        
    }
	
//	@Override
//    public void defaultMethod(){
//        System.out.println("from ClassB...");
//    }
	
	@Override
	public void methodFromInterfaceA() {
		System.out.println("Implementing InterfaceA from ClassB.");
	}
	
	@Override
	public void methodFromInterfaceB() {}


	@Override
	public void methodFromInterfaceD() {}

	@Override
	public void methodFromInterfaceE() {}
}
