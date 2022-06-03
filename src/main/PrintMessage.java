package main;
import java.util.Scanner;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

public class PrintMessage {
	Scanner scan = new Scanner(System.in);
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
		print("\nProgrammer: Tasin Shahriar Chowdhury,\tA.K.M Fozlol Hoq");
		print("\nInstructor: Santa Maria Shithil, lecturer, Stamford University Bangladesh");
	}
	public static void closeProgram() {
		PrintMessage.printBye();
        System.exit(0);
	}
	
	public static  int  calculateMark(String task) {
//		0010111011
		int total=0;
		for (int i = 0; i < task.length(); i++) {
            if(task.charAt(i) =='1') {
            	total=total+1;
            }
        }
		return total;
	}
	public static int calculateMark(String task, int bonus) {
//		1001111101 , 1 = 8
		int total=bonus;
		for (int i = 0; i < task.length(); i++) {
            if(task.charAt(i) =='1') {
            	total=total+1;
            }
        }
		return total;
	}
	
	
}
