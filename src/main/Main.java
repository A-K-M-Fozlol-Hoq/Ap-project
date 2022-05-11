package main;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		variables
		char willLoopContinue ='y';
		int userType=0;
		
		PrintMessage.printIntro();
		
		for (; willLoopContinue =='y' || willLoopContinue =='Y'; ) {
			System.out.println("        1)Student log in.               2)Teacher log in.         3)Admin log in.");
			System.out.println("Please enter your option: ");
			userType = scan.nextInt();
			
//			do all stuff
			System.out.println("Please enter y or Y to continue again otherwise enter anything else: ");
			willLoopContinue = scan.next().charAt(0);
		}
		scan.close();
	}
}
 