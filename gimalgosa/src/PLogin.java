import java.util.Scanner;

public class PLogin {

	public VUserInfo login() {
	    Scanner sc = new Scanner(System.in);

	    int tryCount = 0;
	    VUserInfo vUserInfo = null;
	    while (tryCount < 3 && vUserInfo == null) {
	        System.out.println("사용자 아이디를 입력하세요");
	        String userId = sc.next();
	        System.out.println("사용자 비밀번호를 입력하세요");
	        String password = sc.next();

	        VLogin vLogin = new VLogin();
	        vLogin.setUserId(userId);
	        vLogin.setPassword(password);

	        CLogin cLogin = new CLogin();
	        vUserInfo = cLogin.login(vLogin);
	        if (vUserInfo == null) {
	            System.out.println("잘 못 입력하셨습니다. 다시 시도해 주세요.");
	            System.out.println("남은 기회" + (2 - tryCount));
	            tryCount++;
	            
	        } else {
	            System.out.println(vUserInfo.getName() + "님 안녕하세요");
	        }
	    }
	    sc.close();
	    return vUserInfo;
	}


}
