package main;
import java.util.Scanner;

import presentation.PFindId;
import presentation.PFindPW;
import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;


public class Main {
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong pSugangsincheong;
	
	public Main() {
		pLogin = new PLogin();
		pSugangsincheong = new PSugangsincheong();
	}
	
	private void run() {
		try {
			keyboard = new Scanner(System.in);
			VUserInfo vUserInfo = pLogin.login(keyboard);
			
			while (true) {
				if(vUserInfo != null) {
					System.out.println("| " + vUserInfo.getName() + " | " + vUserInfo.getRoot() + " | " + vUserInfo.getDepartment() + " | 최대 수강 학점 : " + vUserInfo.getCredit() + "학점 |");
					pSugangsincheong.run(vUserInfo, keyboard);
					vUserInfo = null;
				} else {
					System.out.println("1. 로그인 다시 시도 | 2. 아이디 찾기 | 3. 비밀번호 찾기 | 4.종료 |");
					int answer = keyboard.nextInt();
					if (answer == 1) {
						vUserInfo = pLogin.login(keyboard);
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
		} catch (Exception e) {
			// TODO: handle exception
			e.getLocalizedMessage();
			System.out.println(e.getLocalizedMessage());
		}

	}
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}


}
