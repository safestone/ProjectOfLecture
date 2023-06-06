package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	private PLectureSelection pLectureSelection;
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBaskt;

	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBaskt = new PLectureBasket();
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean bRunning = true;
		while(bRunning) {
			System.out.println("0.강좌 선택 1.미리담기 2.수강신청 9.종료");
			
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			switch (selection) {
			case 0:
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;
			case 1:
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.show();
				break;
			case 2:
				pSincheongBaskt.add(vLecture);
				pSincheongBaskt.show();
				break;
			case 9:
				bRunning = false;
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}
}


