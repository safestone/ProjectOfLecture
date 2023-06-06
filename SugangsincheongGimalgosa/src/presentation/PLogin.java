package presentation;


import java.util.Scanner;
import valueObject.VLogin;
import control.CLogin;
import valueObject.VUserInfo;

public class PLogin {
	
	private CLogin cLogin;
	
	public VUserInfo login(Scanner sc) {
		
		System.out.println("사용자 아이디를 입력하세요");
		String userId = sc.next();
		System.out.println("사용자 비밀번호를 입력하세요");
		String password = sc.next();
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		if (vUserInfo == null) {
			System.out.println("잘 못 입력하셨습니다.");
		} else {
			System.out.println(vUserInfo.getName() + "님 안녕하세요");	
		}
		
		return vUserInfo;
	}

}
