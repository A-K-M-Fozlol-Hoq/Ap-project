package main;

import java.io.File;
import java.util.Scanner;

public class Student {
	private String id,password,result;
	Student(){
		id="";
		password="";
		result="";
	}
	Student(String id, String password){
		this.id=id;
		this.password=password;
		result="";
	}
	
	Student(String id, String password, String result){
		this.id=id;
		this.password=password;
		this.result=result;
	}
	
	String getID() {
		return this.id;
	}
	
	String getPassword() {
		return this.password;
	}
	
	String getResult() {
		return this.result;
	}
	
	String getResult(String projectName, String filePath) {
		String name="",pass="",allMarks="",totalMark="";
		try {
			File databaseLocation = new File(filePath);
			String databaseAbsolutePath = databaseLocation.getAbsolutePath();
			File databaseFile = new File(databaseAbsolutePath);
			Scanner scan = new Scanner(databaseFile);
			while(scan.hasNext()) {
				name = scan.next();
				pass = scan.next();
				allMarks = scan.next();
				totalMark = scan.next();
				if(name.matches(this.id) && pass.matches(this.password) ) {
					return totalMark;
				}
			}
			scan.close();
		}
		catch(Exception e) {
//			System.out.println(e);
			System.out.println("Please write carefully your project name!");
		}
		System.out.println("You entered wrong username or password or projectName. Please try again!");
		return "invalid mark";
	}
	
	public static void createProject(String projectName, Student[] allStudentsInfo, int totalStudents) {
		String data = "", id="",pass="";
		for(int i=0; i<totalStudents; i++) {
			id=allStudentsInfo[i].getID();
			pass = allStudentsInfo[i].getPassword();
			data = data + id+" "+pass+" "+"0000000000"+" "+"0"+"\n";
		}
		DBUtilsHandler.writeDatabase("database/project/"+projectName+".txt", data,"Project created successfully!");
	}
	
}
