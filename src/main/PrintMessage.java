package main;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;


public class PrintMessage {
	
	static void print(String str) {
		System.out.println(str);
	}
	
	public static void printIntro() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
		String formattedDate = myDateObj.format(myFormatObj);  
		print(".                                 ######################                                "+formattedDate);
		print(".                             ********************************                          ");
		print(".               ***************Stamford University Bangladesh******************");
		print(".             ******************* Project Management System ***********************");
	}
	
	public static void printLoginType() {
		print("        1)Student log in.               2)Teacher log in.         3)Admin log in.");
		print("Please enter your option: ");
	}

	public static void printBye() {
		print("\n\n---------------GOOD BYE-----------------");
		print("\nProgrammer: A.K.M Fozlol Hoq,\tTasin Shahriar Chowdhury");
		print("\nInstructor: Santa Maria Shithil, lecturer, Stamford University Bangladesh");
	}
}
