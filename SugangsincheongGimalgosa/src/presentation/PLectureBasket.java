package presentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import control.CLectureBasket;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureBasket {
	private Vector<VLecture> vLectureVector;
	private CLectureBasket cLectureBasket;
	
	public PLectureBasket() {
		this.vLectureVector = new Vector<VLecture>();
		cLectureBasket = new CLectureBasket();
	}
	
	public void add(VLecture vLecture) {
		this.vLectureVector.add(vLecture);
	}

	public void Basket(VUserInfo vUserInfo, Scanner keyboard) throws IOException {
		boolean bRunnig = true;
		while(bRunnig) {
			System.out.println("0.추가 1.조회 2.삭제 9.돌아가기");
			String command = keyboard.next();
			int select = Integer.parseInt(command);
			
			switch(select) {
			case 0:
				cLectureBasket.addBasket(vUserInfo, vLectureVector); //강좌를 책가방에 추가
				bRunnig = false;
				break;
			case 1:
				cLectureBasket.lookBasket(vUserInfo); //책가방 조회				
				break;
			case 2:
				System.out.println("삭제할 강좌의 코드를 입력해주세요.");  // 책가방에 담긴 강좌 삭제
				String code = keyboard.next();
				
				cLectureBasket.deleteBasket(vUserInfo, code);
				break;
			case 9:
				bRunnig = false;  //돌아가기
				break;
			}
		}
	}

	public void sincheong(VUserInfo vUserInfo, Scanner keyboard) throws IOException {
		boolean bRunnig = true;
		while(bRunnig) {
			System.out.println("0.미리담기 조회 1.신청 2.신청 조회 3.삭제 9.돌아가기");  
			String command = keyboard.next();
			int select = Integer.parseInt(command);
			String code = null;

			switch(select) {
			case 0:
				cLectureBasket.lookBasket(vUserInfo);  //미리담기 조회
				while(true) {
					System.out.println("0.신청 1.돌아가기");  
					int answer = keyboard.nextInt(); 
					if (answer == 0) {
						System.out.println("강좌 코드를 입력하세요");  //책가방에 있는 강좌 중 코드가 동일한 문자열을 찾아서 신청함
						code = keyboard.next();
						cLectureBasket.sincheong(vUserInfo, vLectureVector, code);
					} else if (answer == 1) {
						break; //돌아가기
					}
				}
				break;
			case 1:
				cLectureBasket.sincheong(vUserInfo, vLectureVector, code);  //강좌 선택에서 선택한 강좌를 신청함.
				bRunnig = false;
				break;
			case 2:
				cLectureBasket.lookSincheong(vUserInfo);  //신청한 강좌 조회
				break;
			case 3:
				System.out.println("삭제할 강좌의 코드를 입력해주세요.");
				code = keyboard.next();
				cLectureBasket.deletesincheong(vUserInfo, code);  //신청한 강좌중에서 특정 강좌 삭제
				break;
			case 9:
				bRunnig = false;  //돌아가기
				break;
			}
		}		
	}
}
