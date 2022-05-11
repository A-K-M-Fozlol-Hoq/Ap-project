package main;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;


public class PrintMessage {
	public static void printIntro() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
		String formattedDate = myDateObj.format(myFormatObj);  
		System.out.println(".                                 ######################                                "+formattedDate);
		System.out.println(".                             ********************************                          ");
		System.out.println(".               ***************Stamford University Bangladesh******************");
		System.out.println(".             ******************* Project Management System ***********************");
	}
}
