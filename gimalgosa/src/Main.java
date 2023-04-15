
public class Main {

	public Main() {
		
	}

	private void run() {
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		
		if(vUserInfo != null) {
			System.out.println("다음 단계");
		} else {
			System.out.println("재설정");
			PSugangsincheong pSugangsincheong = new PSugangsincheong(vUserInfo);
			pSugangsincheong.run();
		}
		
		
		
	}
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}


}
