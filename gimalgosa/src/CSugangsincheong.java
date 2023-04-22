
public class CSugangsincheong {

	public VLecture Sugangsincheong(VSugangsincheong vSugangsincheong) {
		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		VLecture vLecture = mSugangsincheong.FindRoot(vSugangsincheong);
		return vLecture;
		
	}

	public VLecture Subject(VSugangsincheong vSugangsincheong) {
		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		VLecture vLecture = mSugangsincheong.Subject(vSugangsincheong);
		return vLecture;
	}

	public VLecture lecture(VSugangsincheong vSugangsincheong) {
		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		VLecture vLecture = mSugangsincheong.lecture(vSugangsincheong);
		return vLecture;
	}

}
