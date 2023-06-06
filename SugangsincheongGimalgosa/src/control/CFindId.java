package control;

import model.MAccount;
import valueObject.VFindId;
import valueObject.VUserInfo;

public class CFindId {

	public VUserInfo FindId(VFindId vFindId) {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.FindId(vFindId);
		return vUserInfo;
		
	}

}
