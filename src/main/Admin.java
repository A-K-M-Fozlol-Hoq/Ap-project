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
		    	createproject();
		        break;
		    case 2:
			  	print("Enter teacher's user name: \n[Pro tip: Don't use space]:");
			  	String teacherUserName= scan.nextLine();
			    teacherUserName=scan.nextLine();
			    print("Enter teacher's password: \n[Pro tip: Don't use space]:");
			    String teacherPassword =scan.nextLine();
			    Teacher teacher = new Teacher(teacherUserName, teacherPassword);
			    addTeacher(teacher);
			    break;
		    case 3:
			  	
			    break;
		    case 4:
			  	
			    break;
		    case 5:
		    	print("\nLogged out successfully!\n");
		    	PrintMessage.printBye();
			    System.exit(0);
			    break;
			    
		    default:
			    System.out.println("Please enter valid option.");
		}
	}
	
//	overriding addTeacher method of Teacher class
	public Teacher addTeacher(Teacher teacher) {		
//		String existingTeachers="",userNameAndPassword="",userName="",password="",allTeachers="";
//		try {
//			File teachersDatabase = new File("database/teacher/teacher.txt");
//			String teachersDatabasePath = teachersDatabase.getAbsolutePath();
//			File teachersDatabaseFile = new File(teachersDatabasePath);
//			Scanner teachersUserNameAndPassword = new Scanner(teachersDatabaseFile);
//			while(teachersUserNameAndPassword.hasNext()) {
//				userName = teachersUserNameAndPassword.next();
//				password = teachersUserNameAndPassword.next();
//				userNameAndPassword=  userName+" "+password+"\n";
//				existingTeachers=existingTeachers+userNameAndPassword;
//			}
//			teachersUserNameAndPassword.close();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		allTeachers= existingTeachers+teacher.getUserName()+" "+teacher.getPassword()+"\n";
		String existingTeachers = DBUtilsHandler.getTeachers();
		String allTeachers= existingTeachers+teacher.getUserName()+" "+teacher.getPassword()+"\n";
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
	
	
	private void createproject() {
		String projectName="default", teacherName="", studentID="default", studentPassword="default";
		int index=0, selectedTeacherInput=0, totalStudents=0;
		print("Please enter project name: ");
		projectName=scan.nextLine();
		projectName=scan.nextLine();
		String allTeachersNames = DBUtilsHandler.getTeachersNames();
		print("Select your preferred project instructor/teacher: \n");
		String[] allTeachersNamesArray = allTeachersNames.split(" ");
		for(index =0; index < allTeachersNamesArray.length; index = index+1) {
			print(index+1+". "+allTeachersNamesArray[index]);
		}
		selectedTeacherInput= scan.nextInt();
        print("How many students you want to add that project group:");
        totalStudents= scan.nextInt();
        teacherName= allTeachersNamesArray[selectedTeacherInput-1];
        Student[] allStudentsInfo = new Student[totalStudents] ;  
        print("Enter all students userName and password for the group: ");
        studentID=scan.nextLine();
        for(index=0; index<totalStudents; index=index+1) {
        	studentID=scan.nextLine();
        	studentPassword= scan.nextLine();
        	Student student = new Student(studentID, studentPassword);
        	allStudentsInfo[index]= student;
        }
        
        Student.createProject(projectName, teacherName, allStudentsInfo, totalStudents);
        
        
        
        
        
        
//        for(index=0; index<totalStudents; index=index+1) {
//        	studentID = allStudentsInfo[index].getID();
//        	studentPassword = allStudentsInfo[index].getPassword();
//        }
        
//        format to save db:
//        1.teacher name
//        2. studenaid pass options marking
        
	}
}
