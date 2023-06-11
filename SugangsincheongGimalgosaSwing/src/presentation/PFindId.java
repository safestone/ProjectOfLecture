package presentation;
import java.util.Scanner;

import control.CFindId;
import valueObject.VFindId;
import valueObject.VUserInfo;

public class PFindId {

	private Scanner sc;

	public void FindId() {
		sc = new Scanner(System.in);
		System.out.println("성명을 입력해주세요 (full name)");
		String name = sc.next();
		System.out.println("생년월일 6자리 (6 digits of date of birth)");
		String date = sc.next();
		
		VFindId vFindId = new VFindId();
		vFindId.setName(name);
		vFindId.setDate(date);
		
		CFindId cFindId = new CFindId();
		VUserInfo vUserInfo = cFindId.FindId(vFindId);
		
		if (vUserInfo != null) {
			System.out.println("사용자의 아이디는 " + vUserInfo.getId() + " 입니다");
		} else {
			System.out.println("입력한 정보에 맞는 계정이 존재하지 않습니다.");
		}
	}

}
