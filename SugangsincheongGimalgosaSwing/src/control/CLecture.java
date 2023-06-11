package control;

import java.util.Vector;

import model.MLecture;
import valueObject.VLecture;

public class CLecture {
	private MLecture mLecture;
	
	public CLecture() {
		this.mLecture = new MLecture();
	}
	public Vector<VLecture> getTerminal(String string) {
		Vector<VLecture> vLectureVector = this.mLecture.terminal(string);
		return vLectureVector;
	}

}
