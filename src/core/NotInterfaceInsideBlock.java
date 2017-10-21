package core;

public class NotInterfaceInsideBlock {

	public static void main(String[] args) {
		new NotInterfaceInsideBlock().greetInEnglish();
	}
	 
	// Interfaces are are inherently static and abstract
 	interface HelloThere {
 		public void greet();
    }
 	
	public void greetInEnglish() {
        
        // Local Class inside method block
        class EnglishHelloThere implements HelloThere {
        	@Override
            public void greet() {
                System.out.println("Hello ");
            }
        }
        
     	HelloThere myGreeting = new EnglishHelloThere();
        myGreeting.greet();
    }
}
