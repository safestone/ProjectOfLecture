
public class Main {

	private void run() {
		VLogin vLogin = new VLogin();
		if (vLogin.login()) {
			System.out.println("로그인 되었습니다.");
			VSugangsincheong vSugangsincheong = new VSugangsincheong();
			vSugangsincheong.run(); //객체.함수
		} else {
			System.out.println("로그인 시퀀스를 종료합니다.");
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		//object name declaration
		//memory allocation
		//invoke constructor
		//object name and memory address binding
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}


}
