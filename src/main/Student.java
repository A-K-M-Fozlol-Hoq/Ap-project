package main;

public class Student {
	private String id,password;
	Student(){
		id="";
		password="";
	}
	Student(String id, String password){
		this.id=id;
		this.password=password;
	}
	
	String getID() {
		return this.id;
	}
	
	String getPassword() {
		return this.password;
	}
	
	public static void createProject(String projectName, String teacherName, Student[] allStudentsInfo, int totalStudents) {
		String data = teacherName+"\n", id="",pass="";
		for(int i=0; i<totalStudents; i++) {
			id=allStudentsInfo[i].getID();
			pass = allStudentsInfo[i].getPassword();
			data = data + id+" "+pass+" "+"0000000000"+" "+"0"+"\n";
		}
		DBUtilsHandler.writeDatabase("database/project/"+projectName+".txt", data);
	}
	
	public int calculateMark(int[] work) {
		
		return 1;
	}
	public int calculateMark(int[] mainTask, int[] extraTask) {
		
		return 1;
	}
}
