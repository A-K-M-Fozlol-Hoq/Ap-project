package main;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char willLoopContinue ='y';
		int userType=0;
		boolean isLoggedIn = false;
		String userName="";
		String password="";
		
		PrintMessage.printIntro();

//		for (; willLoopContinue =='y' || willLoopContinue =='Y'; ) {
		while (willLoopContinue =='y' || willLoopContinue =='Y') {
			if(isLoggedIn==false) {
				PrintMessage.printLoginType();
			
				try {
					userType = scan.nextInt();
		        } catch (InputMismatchException exception) {
		            System.out.println("Not an integer, please try again.");
				    PrintMessage.closeProgram();
		        }
				
				try {
					System.out.println("Please Enter your user name: ");
					userName= scan.nextLine();
					userName= scan.nextLine();
					System.out.println("Please enter your password: ");
					password= scan.nextLine();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			switch(userType) {
			  case 1:
				  String projectName="";
				   System.out.println("Enter project name[pro tips: project name is case sensetive]: ");
				   projectName=scan.nextLine();
				   Student student = new Student(userName, password);
				   String result = student.getResult(projectName, "database/project/"+projectName+".txt");
				   System.out.println("You obtained "+result+" marks out of 10! Best of luck!\n");
			       break;
			  case 2:
				   isLoggedIn= Authentication.checkUser(userName, password);
				   if(isLoggedIn) {
					   Teacher teacher = new Teacher(userName, password);
					   String selectedCourse = teacher.selectCourse();
					   teacher.printMenu(selectedCourse);
				   }
				    break;
			  case 3:
				  	
				    isLoggedIn= Authentication.checkUser("admin", userName, password);
				    if(isLoggedIn) {
				    	Admin admin = new Admin();
					    admin.printAdminMenu();
				    }
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
 