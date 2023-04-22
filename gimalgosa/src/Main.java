import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	private Scanner sc;
	
	public Main() {
		
	}

	private void run() {
		try {
			PLogin pLogin = new PLogin();
			VUserInfo vUserInfo = pLogin.login();
			
			sc = new Scanner(System.in);
			while (true) {
				if(vUserInfo != null) {
					PFindLecture pFindLecture = new PFindLecture(vUserInfo);
					pFindLecture.run(vUserInfo);
					break;
				} else {
					System.out.println("1. 로그인 다시 시도 2. 아이디 찾기 3. 비밀번호 찾기");
					int answer = sc.nextInt();
					if (answer == 1) {
						vUserInfo = pLogin.login();
					} else if (answer == 2) {
						PFindId pFindId = new PFindId();
						pFindId.FindId();
					} else if (answer == 3) {
						PFindPW pFindPW = new PFindPW();
						pFindPW.FindPW();
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}
}
