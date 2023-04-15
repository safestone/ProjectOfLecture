import java.util.Scanner;

public class PLogin {

	public VUserInfo login() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사용자 아이디를 입력하세요");
		String userId = sc.next();
		System.out.println("사용자 아이디를 입력하세요");
		String password = sc.next();
		sc.close();
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		if (vUserInfo == null) {
			System.out.println("잘 못 입력하셨습니다.");
		} else {
			System.out.println(vUserInfo.getName() + "님 안녕하세요");
			
		}
		
		return vUserInfo;
	}

}
