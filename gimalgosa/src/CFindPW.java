
public class CFindPW {

	public VUserInfo FindPW(VFindPW vFindPW) {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.FindPW(vFindPW);
		return vUserInfo;
	}
}
