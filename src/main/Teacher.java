package main;
import java.util.Scanner;

public class Teacher extends Student{
	private String userName, password, courses;
	Scanner scan = new Scanner(System.in);
	Teacher(){
		userName="";
		password="";
		courses="";
	}
	Teacher(String userName, String password){
		this.userName=userName;
		this.password = password;
		courses="";
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	public Teacher addTeacher(Teacher teacher) {		
		return teacher;
	}
	
	public String selectCourse() {
		courses = DBUtilsHandler.readFile("database/teacher/"+userName+".txt");
		courses =courses.substring(1, courses.length());
		String[] coursesArray = courses.split(" ");
		int i=0,index=0;
		for(i=0; i<coursesArray.length; i++) {
			System.out.println(i+1+" : "+coursesArray[i]);
		}
		System.out.println("Please select course for further continue: ");
		index=scan.nextInt();
		return coursesArray[index-1];
		
	}
}
