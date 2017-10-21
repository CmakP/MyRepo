package algorithms.string;

public class RemovingSpacesWithinString {

	public RemovingSpacesWithinString(String exps) {
		 /**remove if any spaces from the expression**/
        exps = exps.replaceAll("\\s+", "");
        System.out.println(exps);
    }

	public static void main(String[] args) {
		new RemovingSpacesWithinString("(   ( 2 *   5   )   +  (   6  /  2  ) )");
	}

}
