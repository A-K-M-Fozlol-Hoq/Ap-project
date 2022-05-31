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
}
