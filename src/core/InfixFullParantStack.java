package core;

import java.util.StringTokenizer;

/*
 * nfix notation is the common arithmetic and logical formula notation, in which operators 
 * are written infix-style between the operands they act on (e.g. 2 + 2). It is not as 
 * simple to parse by computers as prefix notation ( e.g. + 2 2 ) or postfix notation 
 * ( e.g. 2 2 + ), but many programming languages use it due to its familiarity.
 * 
 * Here are the steps to evaluate infix expression which is fully parenthesized using stack.
 *
	1. Read one input character
  	2. Actions at end of each input
     	   Opening brackets         (2.1)  Push into stack and then Go to step (1)
     	   Number                        (2.2)  Push into stack and then Go to step (1)
     	   Operator                      (2.3)  Push into stack and then Go to step (1)
     	   
     	   Closing brackets            (2.4)  Pop from character stack
                                   		 (2.4.1) Pop is used four times
                                           		The first popped element is assigned to op2
                                           		The second popped element is assigned to op
                                           		The third popped element is assigned to op1
                                           		The fourth popped element is the remaining opening bracket, 
                                           		which can be discarded.
                                           		Evaluate op1 op op2
                                           		Convert the result into character and 
                                           		push into the stack
                                           		
    		New line character           (2.5)  Pop from stack and print the answer
                                         		STOP
 */
public class InfixFullParantStack {

	public static String evaluateInfix(String exps){
        
        /**remove if any spaces from the expression**/
        exps = exps.replaceAll("\\s+", "");
        /**we assume that the expression is in valid format**/
        MyGenericsStack<String> stack = new MyGenericsStack<String>(exps.length());
        /**break the expression into tokens**/
        StringTokenizer tokens = new StringTokenizer(exps, "{}()*/+-", true);
        while(tokens.hasMoreTokens()){
            String tkn = tokens.nextToken();
            /**read each token and take action**/
            if(tkn.equals("(")
                    || tkn.equals("{")
                    || tkn.matches("[0-9]+")
                    || tkn.equals("*")
                    || tkn.equals("/")
                    || tkn.equals("+")
                    || tkn.equals("-")){
                /**push token to the stack**/
                stack.push(tkn);
            } else if(tkn.equals("}") || tkn.equals(")")){
                try {
                    int op2 = Integer.parseInt(stack.pop());
                    String oprnd = stack.pop();
                    int op1 = Integer.parseInt(stack.pop());
                    /**Below pop removes either } or ) from stack**/
                    if(!stack.isStackEmpty()){
                        stack.pop();
                    }
                    int result = 0;
                    if(oprnd.equals("*")){
                        result = op1*op2;
                    } else if(oprnd.equals("/")){
                        result = op1/op2;
                    } else if(oprnd.equals("+")){
                        result = op1+op2;
                    } else if(oprnd.equals("-")){
                        result = op1-op2;
                    }
                    /**push the result to the stack**/
                    stack.push(result+"");
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        String finalResult = "";
        try {
            finalResult = stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalResult;
    }
     
    public static void main(String a[]){
        String expr = "((2*5)+(6/2))";
        System.out.println("Expression: "+expr);
        System.out.println("Final Result: "+evaluateInfix(expr));
        expr = "(((2 * 5) - (1 * 2)) / (11 - 9))";
        System.out.println("Expression: "+expr);
        System.out.println("Final Result: "+evaluateInfix(expr));
         
    }
}
 
/**
 * Stack implementation
 */
class MyGenericsStack<T extends Object> {
 
    private int stackSize;
    private T[] stackArr;
    private int top;
     
    /**
     * constructor to create stack with size
     * @param size
     */
    @SuppressWarnings("unchecked")
    public MyGenericsStack(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top
     * of the stack
     * @param entry
     * @throws Exception
     */
    public void push(T entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the
     * top of the stack.
     * @return
     * @throws Exception
     */
    public T pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public T peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    /**
     * This method returns true if the stack is
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
}