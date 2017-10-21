package algorithms.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RetrieveFromSet {

	public static void main(String[] args) {

		RetrieveFromSet app = new RetrieveFromSet();
		
	    Set<Foo> set = new HashSet<Foo>();
	    
	    set.add(app.new Foo("Hello"));

	    for (Iterator<Foo> it = set.iterator(); it.hasNext(); ) {
	        Foo f = it.next();
	        if (f.equals(app.new Foo("Hello")))
	            System.out.println("foo found");
	    }
	}

	class Foo {
		
	    private String string;
	    
	    Foo(String string) {
	        this.string = string;
	    }
	    
	    @Override
	    public int hashCode() { 
	        return string.hashCode(); 
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	        return string.equals(((Foo) obj).string);
	    }
	}
}
