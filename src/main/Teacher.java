package main;
import java.io.File;
import java.util.Scanner;

public class Teacher extends Student{
	private String userName, password, courses;
	private void print(String str) {
		System.out.println(str);
	}
	int selectedMenu=1;
	Scanner scan = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
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
	public void printMenu(String selectedCourse) {
		System.out.println("Select menu: ");
		System.out.println("1 .View students result.\n2 .Update students result.");
		try {
			selectedMenu= scan.nextInt();
		}catch(Exception e) {
			System.out.println(e);
		}
		if(selectedMenu<3) {
			switch(selectedMenu) {
			  case 1:
				  	viewResult("database/project/"+selectedCourse+".txt");
			    break;
			  case 2:
				  updateResult("database/project/"+selectedCourse+".txt");
				    break;
			  default:
				  System.out.println("Entered wrong option.");
				  PrintMessage.closeProgram();
			}
		}else {
			System.out.println("Entered wrong number!");
			PrintMessage.closeProgram();
		}
	}
	
	private void viewResult (String filePath) {
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
				System.out.println(name+" : "+totalMark);
			}
			scan.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void updateResult(String filePath) {
		String name="",pass="",allMarks="",totalMark="", updatedData="", haveToUpdate="";
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
				System.out.println("name: "+name+", old result : "+allMarks+", total mark: "+totalMark);
				print("Do you want to update? press 'y' or 'Y' to update(you might need to enter twice): ");
				try {
					haveToUpdate = scan2.nextLine();
					haveToUpdate = scan2.nextLine();
				}catch(Exception e) {
					System.out.println(e);
				}
				if(haveToUpdate.matches("y") || haveToUpdate.matches("Y")) {
					String updatedAllMarks="",task;
					int bonus=0;
					for(int i=0; i<10; i++) {
						print("Did he completed task"+(i+1)+"? Enter '1' if he complete the task: ");
						task=scan2.nextLine();
						if(task.matches("1") ) {
							updatedAllMarks=updatedAllMarks+"1";
						}else {
							updatedAllMarks=updatedAllMarks+"0";
						}
					}
					print("His updated total mark is: "+ PrintMessage.calculateMark(updatedAllMarks));
					print("Do you want to give bonus mark? Enter 'Y' or 'y' to give extra mark: ");
					haveToUpdate =scan2.nextLine();
					if(haveToUpdate.matches("y") || haveToUpdate.matches("Y")) {
						print("Enter bonus mark: ");
						bonus = scan2.nextInt();
						updatedData = updatedData+name+" "+pass+" "+updatedAllMarks+" "+PrintMessage.calculateMark(updatedAllMarks,bonus)+"\n";
					}
					else {
						updatedData = updatedData+name+" "+pass+" "+updatedAllMarks+" "+PrintMessage.calculateMark(updatedAllMarks)+"\n";
					}
					
				}else {
					updatedData = updatedData+name+" "+pass+" "+allMarks+" "+totalMark+"\n";
				}
			}
			scan.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		DBUtilsHandler.writeDatabase(filePath, updatedData, "Result Updated Successfully!");
	}
	
	
}
