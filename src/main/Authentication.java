package main;
import java.io.File; 

import java.util.Scanner;
public class Authentication {
//	utilities function
	static void print(String str) {
		System.out.println(str);
	}
	
	private static void printLoginError() {
		print("\n\n---------------Login Error-----------------");
		print("\nPlease enter right user name and password.");
		print("\n-----------------------------------------------\n");
	}
	
	public static boolean checkUser(String userName, String passWord) {
		printLoginError();
		return true;
	}
	
	public static boolean checkUser(String teacherOrAdmin,String userName, String passWord) {
		String user="";
		String pass="";
		if(teacherOrAdmin=="teacher") {
			printLoginError();
		}else {
			try {
				File adminUserNameDatabase = new File("database/admin/admin.txt");
				String adminUserNamePath = adminUserNameDatabase.getAbsolutePath();
//				print(adminUserNamePath);
//				adminUserNamePath = adminUserNamePath.replace("\\", "/");
//				print (adminUserNamePath);
				File adminUserNameDbFile = new File(adminUserNamePath);
				Scanner adminUserName = new Scanner(adminUserNameDbFile);
				while(adminUserName.hasNext()) {
					user = adminUserName.next();
				}
				adminUserName.close();
				
				
				File adminPasswordDatabase = new File("database/admin/password.txt");
				String adminPasswordPath = adminPasswordDatabase.getAbsolutePath();
				File adminPassDbFile = new File(adminPasswordPath);
				Scanner adminPassword = new Scanner(adminPassDbFile);
				while(adminPassword.hasNext()) {
					pass = adminPassword.next();
				}
				adminPassword.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			print(user+pass+" "+userName+passWord);
			if(user.equals(userName) && pass.equals(passWord)) {
				return true;
			}else {
				printLoginError();
				return false;
			}
			
		}
		return false;
	}
	
	
}
