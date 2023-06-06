package control;

import model.MAccount;
import valueObject.VFindPW;
import valueObject.VUserInfo;

public class CFindPW {

	public VUserInfo FindPW(VFindPW vFindPW) {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.FindPW(vFindPW);
		return vUserInfo;
	}
}
