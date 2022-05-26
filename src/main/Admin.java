package main;
import java.util.Scanner;
import java.io.File;

public class Admin {
//	utilities function
	static void print(String str) {
		System.out.println(str);
	}

	private int selectedMenu;
	Scanner scan = new Scanner(System.in);
	
	void printAdminMenu() {
		print("Please enter your option: ");
		print("1)Create a new class. \n2)Add teacher. \n3)Change User name. \n4)Change Password.");
		print("\n5)Logout.");
		selectedMenu = scan.nextInt();
		print(Integer.toString(selectedMenu));
//		File db = new File("database");
//		db.mkdir();
//		File dir = new File("database/admin");
//		dir.mkdir();
//		String path = dir.getAbsolutePath();
//		File admin = new File(path+"/admin.txt");
//		File pass = new File(path+"/password.txt");
//		print(path);
//		try{
//			admin.createNewFile();
//			pass.createNewFile();
//			print("hello");
//		}
//		catch(Exception e) {
//			System.out.print(e);
//		}
	}
}
