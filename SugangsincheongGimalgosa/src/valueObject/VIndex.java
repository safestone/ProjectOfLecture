package valueObject;

import java.util.Scanner;

public class VIndex {
	private int code;
	private String name;
	private String fileName;
	private String credit;
	private String time;
	private String professor;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public void load(Scanner file) {
		this.setCode(file.nextInt());
		this.setName(file.next());
		this.setFileName(file.next());
	}
	public void loadTermianl(Scanner file) {
		this.setCode(file.nextInt());
		this.setName(file.next());
		this.setCredit(file.next());
		this.setTime(file.next());
		this.setProfessor(file.next());		
	}
	
}
