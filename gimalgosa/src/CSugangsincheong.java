import java.io.IOException;

public class CSugangsincheong {

	public VComplete cSugangsincheong(VSugangsincheong vSugangsincheong) throws IOException {
		MSugangsincheong mSugangsincheong = new MSugangsincheong();
		VComplete vComplete = mSugangsincheong.Sugangsincheong(vSugangsincheong);
		return vComplete;		
	}

}
