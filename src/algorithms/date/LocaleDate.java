package algorithms.date;

import java.time.LocalDate;
import java.util.Scanner;

public class LocaleDate {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        String dateString = year + "-" + month + "-" + day;
		LocalDate localDate = LocalDate.parse(dateString);
        System.out.format("Day of the week for date %s is: %s", dateString, localDate.getDayOfWeek());
        in.close();
	}
}
