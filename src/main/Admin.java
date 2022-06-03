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
		print("Please enter your option: \n");
		print("1)Create a new project. \n2)Add teacher. \n3)Change User name. \n4)Change Password.");
		print("\n5)Logout.");
		selectedMenu = scan.nextInt();
		switch(selectedMenu) {
		    case 1:
		    	createproject();
		        break;
		    case 2:
			  	print("Enter unique teacher's user name: \n[Pro tip: Don't use space]:");
			  	String teacherUserName= scan.nextLine();
			    teacherUserName=scan.nextLine();
			    print("Enter teacher's password: \n[Pro tip: Don't use space]:");
			    String teacherPassword =scan.nextLine();
			    Teacher teacher = new Teacher(teacherUserName, teacherPassword);
			    addTeacher(teacher);
			    break;
		    case 3:
			  	changeUserName();
			    break;
		    case 4:
			  	changePassword();
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
		print("Please enter unique project name: ");
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
        
        Student.createProject(projectName, allStudentsInfo, totalStudents);
        DBUtilsHandler.addNewProjectAtTeachersDatabase(teacherName, projectName);
        
	}
	
	private void changeUserName() {
		String newUserName="";
		print("Please enter new user name: ");
		newUserName= scan.nextLine();
		newUserName= scan.nextLine();
		DBUtilsHandler.writeDatabase("database/admin/admin.txt", newUserName, "User name updated successfully!");
	}
	
	private void changePassword() {
		String newPassword="";
		print("Please enter new password: ");
		newPassword= scan.nextLine();
		newPassword= scan.nextLine();
		DBUtilsHandler.writeDatabase("database/admin/password.txt", newPassword, "Password updated successfully!");
	}
	
	
}
