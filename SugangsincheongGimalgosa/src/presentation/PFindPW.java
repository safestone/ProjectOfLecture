package presentation;
import java.util.Scanner;

import control.CFindPW;
import valueObject.VFindPW;
import valueObject.VUserInfo;

public class PFindPW {

	private Scanner sc;

	public void FindPW() {
		sc = new Scanner(System.in);
		System.out.println("아이디(ID)");
		String Id = sc.next();
		System.out.println("생년월일 6자리 (6 digits of date of birth)");
		String date = sc.next();
		
		VFindPW vFindPW = new VFindPW();
		vFindPW.setId(Id);
		vFindPW.setDate(date);
		
		CFindPW cFindPW = new CFindPW();
		VUserInfo vUserInfo = cFindPW.FindPW(vFindPW);
		
		if (vUserInfo != null) {
			System.out.println("사용자의 비밀번호는 " + vUserInfo.getPw() + " 입니다");
		} else {
			System.out.println("입력한 정보에 맞는 계정이 존재하지 않습니다.");
		}
	}

}
