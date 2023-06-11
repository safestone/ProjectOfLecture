package control;

import java.io.IOException;

import model.MStudentRegister;

public class CStudentRegister {
	
	private MStudentRegister mStudentRegister;
	
	public CStudentRegister() {
		this.mStudentRegister = new MStudentRegister();
	}
	
	public void addStudent(String student) throws IOException {
		mStudentRegister.addStudent(student);
	}

	public void removeStudent(String removeId) throws IOException {
		mStudentRegister.removeStudent(removeId);
	}

	public void lookStudent() throws IOException {
		mStudentRegister.lookStudent();
	}

}
