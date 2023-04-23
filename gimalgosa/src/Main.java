import java.io.IOException;
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
					System.out.println(vUserInfo.getName() + " : " + vUserInfo.getRoot() + " | " + vUserInfo.getDepartment() + " | 최대 수강 학점 : " + vUserInfo.getCredit() + "학점 |");
					while(true) {
						System.out.println("번호를 선택해주세요.");
						System.out.println("1. 강좌 조회 | 2. 책가방 | 3. 종료 |");
						int num = sc.nextInt();
						if(num == 1) {
							PFindLecture pFindLecture = new PFindLecture(vUserInfo);
							pFindLecture.run(vUserInfo);
						} else if (num == 2) {
							PSugangsincheong pSugangsincheong = new PSugangsincheong();
							pSugangsincheong.run(vUserInfo);
						} else if (num == 3) {
							System.out.println("종료되었습니다.");
							System.exit(0);
						}
						
					}
				} else {
					System.out.println("1. 로그인 다시 시도 | 2. 아이디 찾기 | 3. 비밀번호 찾기 | 4.종료 |");
					int answer = sc.nextInt();
					if (answer == 1) {
						vUserInfo = pLogin.login();
					} else if (answer == 2) {
						PFindId pFindId = new PFindId();
						pFindId.FindId();
					} else if (answer == 3) {
						PFindPW pFindPW = new PFindPW();
						pFindPW.FindPW();
					} else if (answer == 4) {
						System.out.println("종료되었습니다.");
						System.exit(0);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}
}
