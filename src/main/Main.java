package main;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Main extends Admin{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char willLoopContinue ='y';
		int userType=0;
		
		PrintMessage.printIntro();

//		for (; willLoopContinue =='y' || willLoopContinue =='Y'; ) {
		while (willLoopContinue =='y' || willLoopContinue =='Y') {
			PrintMessage.printLoginType();
			
			try {
				userType = scan.nextInt();
	        } catch (InputMismatchException exception) {
	            System.out.println("Not an integer, please try again.");
	        }
			
			
			switch(userType) {
			  case 1:
			    // code block
			    break;
			  case 2:
				    // code block
				    break;
			  case 3:
//				    Admin admin = new Admin();
//				    admin.printAdminMenu();
				  Authentication.checkUser("admin", "admin", "admin");
				    break;
			  default:
				  System.out.println("Please enter valid option.");
			}
			
//			do all stuff
			System.out.println("Please enter y or Y to continue again otherwise enter anything else: ");
			willLoopContinue = scan.next().charAt(0);
		}
		PrintMessage.printBye();
		scan.close();
	}
}
 