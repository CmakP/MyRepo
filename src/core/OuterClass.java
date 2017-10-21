package core;

// OuterClass
public class OuterClass {

    public int x = 0;
    
    public static int y = 10;
    
    static void message(String message) {
		System.out.format("Static Method: %s%n", message);
	}

    //Non-Static nested classes (Inner-Classes)
    public class InnerClass { // or class InnerClass

        public int x = 1;
        
        // Important!!! 
        /*
         * ONLY Non-Static nested classes (Inner-Classes) can NOT have static members. 
         * Because, an instance of that class must be created in the context of 
         * an instance of the enclosing class.(Parent/Caller/Context) 
         * In other words static is not applicable to instances of objects but only to classes
         * so java forbids static members to non-static members(object instances).
         * 
         * Hence the next line is a compilation error
         */
         //public static int w = 2;
         
         // However, You can declare constants, means static final variables.
         public static final int Z = 2;
        
         void methodInInnerClass(int x) {
        	System.out.println("Inner Class: ");
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x); //ShadowTest.InnerClass.this.x
            System.out.println("OuterClass.this.x = " + OuterClass.this.x);
            System.out.println("OuterClass.StaticNestedClass.x = " + OuterClass.StaticNestedClass.x);
            System.out.println("z = " + Z);
        }
    }
    
    // Public Static nested class
    public static class StaticNestedClass {  //  static class StaticNestedClass
    	
    	public int y = 1;
    	public static int x = 12;
    	
    	void methodInInnerClass(int y) {
    		System.out.println("Static Nested Class: ");
    		System.out.println("y = " + y);
            System.out.println("this.y = " + this.y);
            System.out.println("ShadowTest.this.y = " + OuterClass.y);
            System.out.println("x = " + x);
            System.out.println("ShadowTest.InnerClass.z = " + OuterClass.InnerClass.Z);
    	}
    }
    
    // Private Static nested class
    private static class privateStaticNestedClass {
    	
    	// Note: THis Non-Static method is available to instance of this class
    	public void test() {
    		message("privateStaticNestedClass!");
    	}
    	
    	@SuppressWarnings("unused")
		public static void staticTest() {
    		message("privateStaticNestedClass!");
    	}
    }

    public static void main(String... args) {
    	
        OuterClass st = new OuterClass();
        OuterClass.InnerClass fl = st.new InnerClass();
        fl.methodInInnerClass(23);
        System.out.println();
        
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.methodInInnerClass(23);  
        System.out.println();
        // or
        //new OuterClass.StaticNestedClass().methodInInnerClass(23);
        
        StaticMemberClass.staticMethodInStaticMemberClass();
        StaticMemberClass memberObject = new StaticMemberClass();
        memberObject.methodInStaticMemberClass();
        
        System.out.println();
        OuterClass.privateStaticNestedClass privateNestedObj = new OuterClass.privateStaticNestedClass();
        privateNestedObj.test();
        
        OuterClass.message("From main!");
        
        
    }
}

// I am assuming this is called a Static Class, not sure though.
class StaticMemberClass {  // Compile Error: Public Class StaticMemberClass
	
	public static void staticMethodInStaticMemberClass() {
		System.out.println("Caller : Static Member Class - staticMethodInStaticMemberClass");
		new OuterClass.StaticNestedClass().methodInInnerClass(100);
		System.out.println();
	}
	
	public void methodInStaticMemberClass() {
		System.out.println("Caller : Static Member Class - nonStaticMethodInStaticMemberClass");
		new OuterClass().new InnerClass().methodInInnerClass(150);
		System.out.println();
	}
}
