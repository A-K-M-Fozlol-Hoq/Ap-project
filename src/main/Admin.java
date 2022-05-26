package main;
import java.util.Scanner;
import java.io.File;

public class Admin extends Teacher{
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
	}
}
