package main;

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
	
	public static void createProject(String projectName, Student[] allStudentsInfo, int totalStudents) {
		String data = "", id="",pass="";
		for(int i=0; i<totalStudents; i++) {
			id=allStudentsInfo[i].getID();
			pass = allStudentsInfo[i].getPassword();
			data = data + id+" "+pass+" "+"0000000000"+" "+"0"+"\n";
		}
		DBUtilsHandler.writeDatabase("database/project/"+projectName+".txt", data,"Project created successfully!");
	}
	
	
//	public int calculateMark(int[] work) {
//		
//		return 1;
//	}
//	public int calculateMark(int[] mainTask, int[] extraTask) {
//		
//		return 1;
//	}
}
