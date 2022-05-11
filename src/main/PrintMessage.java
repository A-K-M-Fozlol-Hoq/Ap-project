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
	
	public static void printLoginType() {
		System.out.println("        1)Student log in.               2)Teacher log in.         3)Admin log in.");
		System.out.println("Please enter your option: ");
	}

	public static void printAdminMenu() {
		System.out.println("Please enter your option: ");
		System.out.println("1)Create a new class. \n2)Add teacher. \\n3)Change User name. \n4)Change Password.");
		System.out.println("\n5)Logout.");
	}
}
