package util;

import java.text.DecimalFormat;

public class DoubleToTwoDecimals {
	
	public static void main(String[] args) {
		
		double d = 2;
		System.out.println(DoubleToTwoDecimals.twoDecimals(d)); 

		String s = String.format("%.2f", DoubleToTwoDecimals.twoDecimals(d));
		System.out.printf(s);   
 	}
	
	/**
	 * 
	 * Rounds and formats the number to two decimal places
	 * 
	 * @param number to be rounded up and converted to two decimal format
	 * @return number with two decimal places
	 */
     public static double twoDecimals(double number) {
    	 return Double.valueOf(new DecimalFormat("#.##").format(number));
    //	 return Double.valueOf(new DecimalFormat("#.##").format(Math.round(number * 100.0) / 100.0));
     }
}
