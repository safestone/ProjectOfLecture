package control;

import java.io.IOException;

import model.MModifyLecture;

public class CModifyLecture {
	private MModifyLecture mModifyLecture;
	
	public CModifyLecture() {
		this.mModifyLecture = new MModifyLecture();
	}
	
	public void addLecture(String lectureInfo, String departmentFileName) throws IOException {
		mModifyLecture.addLecture(lectureInfo, departmentFileName);
	}

	public void removeLecture(String code, String departmentFileName) throws IOException {
		mModifyLecture.removeLecture(code, departmentFileName);
	}

}
