package main;
import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.PFindId;
import presentation.PFindPW;
import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;


public class PMainFrame extends JFrame{
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong pSugangsincheong;
	
    public PMainFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pLogin = new PLogin();
        pSugangsincheong = new PSugangsincheong();

        // PLogin 패널에 로그인 이벤트 리스너 설정
        pLogin.setLoginListener(new PLogin.LoginListener() {
            public void onLogin(VUserInfo vUserInfo) {
                // 로그인 이벤트 발생 시 실행될 내용 구현
                if (vUserInfo != null) {
                    // 로그인 성공한 경우
                    System.out.println("로그인 성공: " + vUserInfo.getName() + "님");
                    // 예시: PSugangsincheong 패널을 추가하거나 다른 작업 수행
                    pLogin.setVisible(false);
                    add(pSugangsincheong);
                } else {
                    // 로그인 실패한 경우
                    System.out.println("로그인 실패");
                }
            }
        });

        this.add(pLogin);
        this.setVisible(true);
    }
	
	private void run() {

	}
	public static void main(String[] args) {
		PMainFrame pMainFrame = new PMainFrame(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		pMainFrame.run();
	}


}
