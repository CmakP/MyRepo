package core;

/*
 * A local class has access to the members of its enclosing class. In the below example, 
 * the PhoneNumber constructor accesses the member LocalClassExample.regularExpression.
 * In addition, a local class has access to local variables. However, a local class can 
 * only access local variables that are declared final. When a local class accesses a local 
 * variable or parameter of the enclosing block, it captures that variable or parameter. 
 * For example, the PhoneNumber constructor can access the local variable numberLength because 
 * it is declared final; numberLength is a captured variable.
 * 
 * However, starting in Java SE 8, a local class can access local variables and parameters 
 * of the enclosing block that are final or effectively final. A variable or parameter whose 
 * value is never changed after it is initialized is effectively final. For example, suppose 
 * that the variable numberLength is not declared final, and you add the highlighted assignment
 * statement in the PhoneNumber constructor: Try it!!!
 */

public class LocalClassExample {
	  
    static String regularExpression = "[^0-9]";
  
    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
      
        //final int numberLength = 10;
        
        // Valid in JDK 8 and later:
        int numberLength = 10;
       
        // Note: Local Class inside the method body
        class PhoneNumber {
            
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber) {
            /*
             * Because of this assignment statement, the variable numberLength is not 
             * effectively final anymore. As a result, the Java compiler generates an 
             * error message similar to "local variables referenced from an inner class 
             * must be final or effectively final" where the inner class PhoneNumber 
             * tries to access the numberLength variable:
             */
            //   numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(
                  regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }
            
            // Starting in Java SE 8, if you declare the local class in a method, 
            // it can access the method's parameters.
            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1 +
                    " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
        
        // Valid in JDK 8 and later:
        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null) 
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}
