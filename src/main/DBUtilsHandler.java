package main;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class DBUtilsHandler {
	public static String getTeachers() {
		String userNameAndPassword="",userName="",password="",allTeachers="";
		try {
			File teachersDatabase = new File("database/teacher/teacher.txt");
			String teachersDatabasePath = teachersDatabase.getAbsolutePath();
			File teachersDatabaseFile = new File(teachersDatabasePath);
			Scanner teachersUserNameAndPassword = new Scanner(teachersDatabaseFile);
			while(teachersUserNameAndPassword.hasNext()) {
				userName = teachersUserNameAndPassword.next();
				password = teachersUserNameAndPassword.next();
				userNameAndPassword=  userName+" "+password+"\n";
				allTeachers=allTeachers+userNameAndPassword;
			}
			teachersUserNameAndPassword.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return allTeachers;
	}
	
	public static String getTeachersNames() {
		String userNameAndPassword="",userName="",password="",allTeachersNames="";
		try {
			File teachersDatabase = new File("database/teacher/teacher.txt");
			String teachersDatabasePath = teachersDatabase.getAbsolutePath();
			File teachersDatabaseFile = new File(teachersDatabasePath);
			Scanner teachersUserNameAndPassword = new Scanner(teachersDatabaseFile);
			while(teachersUserNameAndPassword.hasNext()) {
				userName = teachersUserNameAndPassword.next();
				password = teachersUserNameAndPassword.next();
				allTeachersNames=allTeachersNames+userName+" ";
			}
			teachersUserNameAndPassword.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return allTeachersNames;
	}
	
	public static void writeDatabase(String fileLocation, String data,String successMessage) {
//		System.out.println(fileLocation+"\n"+data);
		try {
		      FileWriter myWriter = new FileWriter(fileLocation);
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println(successMessage);
		} catch (Exception e) {
		      System.out.println(e);
	    }
	}
	
	public static void addNewProjectAtTeachersDatabase(String teacherName, String newProject) {
//		System.out.println(teacherName+"\n"+newProject);
		String existingProjects= DBUtilsHandler.readFile("database/teacher/"+teacherName+".txt");
		String allProjects = existingProjects+" "+newProject;
		writeDatabase("database/teacher/"+teacherName+".txt", allProjects,"Project updated successfully!");
	}
	
	public static String readFile(String filePath) {
		String input="",data="";
		try {
			File databaseLocation = new File(filePath);
			String databaseAbsolutePath = databaseLocation.getAbsolutePath();
			File databaseFile = new File(databaseAbsolutePath);
			Scanner scan = new Scanner(databaseFile);
			while(scan.hasNext()) {
				input = scan.next();
				data=data+" "+input;
			}
			scan.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return data;
		
	}
}
