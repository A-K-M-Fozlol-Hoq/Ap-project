package main;
import java.io.File;
import java.util.Scanner;
public class Authentication {
//	utilities function
	static void print(String str) {
		System.out.println(str);
	}
	
	private static void printloginError() {
		print("\n\n---------------Login Error-----------------");
		print("\nPlease enter right user name and password.");
	}
	
	public static boolean checkUser(String userName, String passWord) {
		printloginError();
		return true;
	}
	
	public static boolean checkUser(String teacherOrAdmin,String userName, String passWord) {
		if(teacherOrAdmin=="teacher") {
			printloginError();
		}else {
			try {
				File adminUserNameDatabase = new File("database/admin/admin.txt");
				String adminUserNamePath = adminUserNameDatabase.getAbsolutePath();
//				print(adminUserNamePath);
//				adminUserNamePath = adminUserNamePath.replace("\\", "/");
//				print (adminUserNamePath);
				File adminDbFile = new File(adminUserNamePath);
				Scanner adminUserName = new Scanner(adminDbFile);
				while(adminUserName.hasNext()) {
					String user = adminUserName.next();
					print(user);
				}
				adminUserName.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}

			
			
//			File file = new File("F:/varsity sem (7+)/11th sem/AP Project/database/admin/admin.txt");
//			try {
//				Scanner scanner = new Scanner(file);
//				while(scanner.hasNext()) {
//					String user = scanner.next();
//					print(user);
//				}
//				scanner.close();
//			}
//			catch(Exception e) {
//				System.out.print(e);
//			}
//			
//			print("end");
			
			
		}
		return true;
	}
	
	
}
