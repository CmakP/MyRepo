package core;

public class HelloWorldAnonymousClasses {
	  
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }
  
    public void sayHello() {
        
        class EnglishGreeting implements HelloWorld {
        	
            String name = "world";
            
            @Override
            public void greet() {
                greetSomeone("world");
            }
            
            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
      
        // Note the semi-colon at the end of the statement
        HelloWorld englishGreeting = new EnglishGreeting();
        
        /*
         * The anonymous class expression consists of the following:
         * 
         * The new operator
         * 
         * The name of an interface to implement or a class to extend. 
         * In this example, the anonymous class is implementing the interface HelloWorld.
         * 
         * Parentheses that contain the arguments to a constructor, just like a 
         * normal class instance creation expression. 
         * 
         * Note: When you implement an interface, there is no constructor, so you use 
         * an empty pair of parentheses, as in this example. A body, which is a 
         * class declaration body. More specifically, in the body, 
         * method declarations are allowed but statements are not.
         * Because an anonymous class definition is an expression, it must be part of 
         * a statement. In this example, the anonymous class expression is part of the 
         * statement that instantiates the frenchGreeting object. 
         * 
         * >>>>>>>>>>>>>>>>>>>> IMPORTATNT <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
         * 
         * (This explains why there is a semicolon after the closing brace.)
         * 
         * -----------------------------------------------------------------
         */
        HelloWorld frenchGreeting = new HelloWorld() {
        	
            String name = "tout le monde";
            
            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }
            
            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
        
        HelloWorld spanishGreeting = new HelloWorld() {
        	
            String name = "mundo";
            
            @Override
            public void greet() {
                greetSomeone("mundo");
            }
            
            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }            
}
