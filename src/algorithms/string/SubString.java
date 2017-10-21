package algorithms.string;

public class SubString {
	
	public static void main(String[] args) {
		
		String input = "012345678901234567890";
   
		// Returns the last occurence of the char searching backwards
    	int index = input.lastIndexOf('1', input.length());
    	System.out.println(index);
    	
    	//referencing with string
    	index = input.indexOf("5", 9);
    	System.out.println(index);
    	
    	//referencing with code
    	index = input.indexOf(input.charAt(5), 9);
    	System.out.println(index);
    	
    	//comparing char with string
    	char[] charArray = input.toCharArray();
    	System.out.println(String.valueOf(charArray[3]).equals("3"));
        
    	//public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
    	//ignoreCase– if true, ignore case when comparing characters.(optional)
    	//toffset − the starting offset of the subregion in this string.
        //other − the string argument.
    	//ooffset − the starting offset of the subregion in the string argument.
    	//len − the number of characters to compare.
    	String Str1 = "Welcome to Tutorialspoint.com";
        String Str2 = "Tutorials";
        String Str3 = "TUTORIALS";
        System.out.print("Return Value :" );
        System.out.println(Str1.regionMatches(11, Str2, 0, 9));
        System.out.print("Return Value: " );
        System.out.println(Str1.regionMatches(true, 11, Str3, 0, 9));

    }

}
