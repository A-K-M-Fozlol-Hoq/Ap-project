package main;

public class Teacher extends Student{
	private String userName, password;
	Teacher(){
		userName="";
		password="";
	}
	Teacher(String userName, String password){
		this.userName=userName;
		this.password = password;
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
}
