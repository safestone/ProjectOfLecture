package control;

import java.io.IOException;
import java.util.Vector;

import model.MLectureBasket;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class CLectureBasket {
	
	private MLectureBasket mLectureBasket;

	public CLectureBasket() {
		mLectureBasket = new MLectureBasket();
	}
	
	public void addBasket(VUserInfo vUserInfo, Vector<VLecture> vLectureVector) throws IOException {
		mLectureBasket.addBasket(vUserInfo, vLectureVector);
	}

	public void lookBasket(VUserInfo vUserInfo) throws IOException {
		mLectureBasket.lookBasket(vUserInfo);
	}

	public void deleteBasket(VUserInfo vUserInfo, String code) throws IOException {
		mLectureBasket.deleteBasket(vUserInfo, code);
	}

	public void sincheong(VUserInfo vUserInfo, Vector<VLecture> vLectureVector, String code) throws IOException {
		mLectureBasket.sincheong(vUserInfo, vLectureVector, code);
	}

	public void lookSincheong(VUserInfo vUserInfo) throws IOException {
		mLectureBasket.lookSincheong(vUserInfo);		
	}

	public void deletesincheong(VUserInfo vUserInfo, String code) throws IOException {
		mLectureBasket.deletesincheong(vUserInfo, code);
	}

}
