package main;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Admin extends Teacher{
//	utilities function
	static void print(String str) {
		System.out.println(str);
	}

	private int selectedMenu;
	Scanner scan = new Scanner(System.in);
	
	void printAdminMenu() {
		print("Please enter your option: ");
		print("1)Create a new project. \n2)Add teacher. \n3)Change User name. \n4)Change Password.");
		print("\n5)Logout.");
		selectedMenu = scan.nextInt();
		switch(selectedMenu) {
		  case 1:
			  	
		    break;
		  case 2:
			  	print("Enter teacher's user name: ");
			  	String teacherUserName= scan.nextLine();
			    teacherUserName=scan.nextLine();
			    print("Enter teacher's password: ");
			    String teacherPassword =scan.nextLine();
			    Teacher teacher = new Teacher(teacherUserName, teacherPassword);
			    addTeacher(teacher);
			    break;
		  case 3:
			  	
			    break;
		  default:
			  System.out.println("Please enter valid option.");
		}
	}
	
//	overriding addTeacher method of Teacher class
	public Teacher addTeacher(Teacher teacher) {		
		String existingTeachers="",userNameAndPassword="",userName="",password="",allTeachers="";
		try {
			File teachersDatabase = new File("database/teacher/teacher.txt");
			String teachersDatabasePath = teachersDatabase.getAbsolutePath();
			File teachersDatabaseFile = new File(teachersDatabasePath);
			Scanner teachersUserNameAndPassword = new Scanner(teachersDatabaseFile);
			while(teachersUserNameAndPassword.hasNext()) {
				userName = teachersUserNameAndPassword.next();
				password = teachersUserNameAndPassword.next();
				userNameAndPassword=  userName+" "+password+"\n";
				existingTeachers=existingTeachers+userNameAndPassword;
			}
			teachersUserNameAndPassword.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		allTeachers= existingTeachers+teacher.getUserName()+" "+teacher.getPassword()+"\n";
		
		try {
		      FileWriter myWriter = new FileWriter("database/teacher/teacher.txt");
		      myWriter.write(allTeachers);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (Exception e) {
		      System.out.println(e);
		    }
		return teacher;
	}
}
