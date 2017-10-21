package hackerrank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        if(payment >= 0 && payment <= Math.pow(10, 9)) {
//        	payment = Double.valueOf(new DecimalFormat("#.##").format(payment));
//        	String number = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
//            System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
//            System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment));
//            System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
//            System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
            
            
            NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US); 
            NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN")); 
            NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
            NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE); 
            
            String us = usFormat.format(payment);
            String india = indiaFormat.format(payment);
            String china = chinaFormat.format(payment);
            String france = franceFormat.format(payment);
            System.out.println("US: " + us);
            System.out.println("India: " + india);
            System.out.println("China: " + china);
            System.out.println("France: " + france);
        }
	}
}
