
public class CFindLecture {

	public VLecture Sugangsincheong(VFindLecture vFindLecture) {
		MFindLecture mFindLecture = new MFindLecture();
		VLecture vLecture = mFindLecture.FindRoot(vFindLecture);
		return vLecture;
		
	}

	public VLecture Subject(VFindLecture vFindLecture) {
		MFindLecture mFindLecture = new MFindLecture();
		VLecture vLecture = mFindLecture.Subject(vFindLecture);
		return vLecture;
	}

	public VLecture lecture(VFindLecture vFindLecture) {
		MFindLecture mFindLecture = new MFindLecture();
		VLecture vLecture = mFindLecture.lecture(vFindLecture);
		return vLecture;
	}

	public VLecture select(VFindLecture vFindLecture) {
		MFindLecture mFindLecture = new MFindLecture();
		VLecture vLecture = mFindLecture.select(vFindLecture);
		return vLecture;
	}

}
