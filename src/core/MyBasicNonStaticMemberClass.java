package core;

public class MyBasicNonStaticMemberClass {

	public static void main(String a[]){
		new ParentClass().new ChildClass().myMethod();
		ParentClass pc = new ParentClass();
		
        ParentClass.ChildClass cc1 = pc.new ChildClass();
        cc1.myMethod();
        
        ParentClass.ChildClass cc = pc.getInnerInstance();
        cc.myMethod();
    }
}
	
	class ParentClass{
	     
	    public class ChildClass{
	         
	        public void myMethod(){
	            System.out.println("Hey you have called me!!!");
	        }
	    }
	     
	    public ChildClass getInnerInstance(){
	        return this.new ChildClass();
	    }
	}
