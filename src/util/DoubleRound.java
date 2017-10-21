package util;

import java.text.DecimalFormat;

public class DoubleRound {
	
	public static void main(String[] args) {
		
		double d = 0.989;
		System.out.println("Round number: " + Double.valueOf(new DecimalFormat("#.##").format(Math.round(d))));

		String s = String.format("%.4f", DoubleToTwoDecimals.twoDecimals(d));
		System.out.printf(s);   
 	}
}
