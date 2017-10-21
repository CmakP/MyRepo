package core;

public class StaticInitializerBlock {

		static {
	        System.out.println("Static block");
	    }

	    {
	        System.out.println("Non-static block");
	    }
	    
	    StaticInitializerBlock() {
	    	System.out.println("Constructor\n");
	    }

	    public static void main(String[] args) {
	    	StaticInitializerBlock t = new StaticInitializerBlock();
	    	StaticInitializerBlock t2 = new StaticInitializerBlock();
	    	Test t3 = t.new Test();
	    }
	    
	    class Test {
	    	
	    	Test () {
	    		System.out.println("Constructor");
	    	}
	    	
	    	{
		        System.out.println("Inner-Class block");
		    }
	    }
}
