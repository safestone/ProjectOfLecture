package presentation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import control.CStudentRegister;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	private PLectureSelection pLectureSelection;
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBaskt;
	private CStudentRegister cStudentRegister;
	private PModifyLecture pModifyLecture;
	private PCommunity pCommunity;

	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBaskt = new PLectureBasket();
		this.cStudentRegister = new CStudentRegister();
		this.pModifyLecture = new PModifyLecture();
		this.pCommunity = new PCommunity();
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) throws IOException {
		VLecture vLecture = null;
		boolean bRunning = true;
		while(bRunning) {
			
			if(vUserInfo.getId().equals("admin")) {
				System.out.println("3.게시판 4.학생 등록 5.학생 조회 6. 학생 삭제 7.강좌 수정 9.로그아웃");
			} else {
				System.out.println("0.강좌 선택 1.미리담기 2.수강신청 3.게시판 9.로그아웃");
			}
			
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			switch (selection) {
			case 0:
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;
			case 1:
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.Basket(vUserInfo, keyboard);
				break;
			case 2:
				pSincheongBaskt.add(vLecture);
				pSincheongBaskt.sincheong(vUserInfo, keyboard);
				break;
			case 3:
				pCommunity.community(vUserInfo, keyboard);
				break;
			case 4:
				System.out.println("ID PW 이름 생년월일 학과 최대수강학점");
				System.out.println("와 같이 입력해주세요.");
				System.out.println("Ex. hong hong 홍길동 021210 서울 융합소프트웨어학부 17");
				keyboard.nextLine();  //개행 삭제
				String student = keyboard.nextLine();
				cStudentRegister.addStudent(student);
				String path = "data/Account";
				
				BufferedReader reader = new BufferedReader(
			            new FileReader(path)
			        );
			 
		        String str;
		        while ((str = reader.readLine()) != null) {
		            System.out.println(str);
		        }
		 
		        reader.close();
				break;	
			case 5:
				cStudentRegister.lookStudent();
				break;
			case 6:
				System.out.println("삭제하고자 하는 학생의 ID를 입력해주세요");
				String removeId = keyboard.next();
				
				cStudentRegister.removeStudent(removeId);
				break;
			case 7:
				pModifyLecture.run(keyboard);
				break;
			case 9:
				bRunning = false;
				System.out.println("로그아웃되었습니다.");
				break;
			default:
				break;
			}
		}

	}
}


