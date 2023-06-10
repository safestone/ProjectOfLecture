package presentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import control.CModifyLecture;

public class PModifyLecture {
	
	private PLectureSelection pLectureSelection;
	private CModifyLecture cModifyLecture;
	
	public PModifyLecture() {
		this.cModifyLecture = new CModifyLecture();
		this.pLectureSelection = new PLectureSelection();
	}
	
	private void terminal(String departmentFileName) throws IOException {
		String path = "data/"+departmentFileName+".txt";
		
		BufferedReader reader = new BufferedReader(
	            new FileReader(path)
	        );
	 
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
 
        reader.close();
	}
	
	public void run(Scanner keyboard) throws IOException {
		boolean bRunning = true;

		while(bRunning) {
			System.out.println("0. 강좌 추가 1.강좌 조회 9.돌아가기");
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			switch (selection) {
			case 0:
				String campusFileName =pLectureSelection.selectIndex("캠퍼스 코드를 선택하세요", "root", keyboard);
				String collegeFileName = pLectureSelection.selectIndex("대학 코드를 선택하세요", campusFileName, keyboard);
				String departmentFileName = pLectureSelection.selectIndex("과목 코드를 선택하세요", collegeFileName, keyboard);
				
				System.out.println("추가하고자 하는 강좌의 정보를 입력해주세요");
				System.out.println("Ex. 9999 예시강좌 문성찬 3 월수1030-1145");
				keyboard.nextLine();
				String lectureInfo = keyboard.nextLine();
				
				cModifyLecture.addLecture(lectureInfo, departmentFileName);
				
				terminal(departmentFileName);
		        
				break;
			case 1:
				campusFileName =pLectureSelection.selectIndex("캠퍼스 코드를 선택하세요", "root", keyboard);
				collegeFileName = pLectureSelection.selectIndex("대학 코드를 선택하세요", campusFileName, keyboard);
				departmentFileName = pLectureSelection.selectIndex("과목 코드를 선택하세요", collegeFileName, keyboard);
				terminal(departmentFileName);
				
				System.out.println("0.삭제하기 1.돌아가기");
				keyboard.nextLine();
				String answer = keyboard.nextLine();
				int select = Integer.parseInt(answer);
				if(select == 0) {
					System.out.println("강좌코드를 입력해주세요");
					String code = keyboard.next();
					cModifyLecture.removeLecture(code, departmentFileName);
					System.out.println("강좌가 삭제되었습니다.");
					System.out.println("---------------------------------------------");
					terminal(departmentFileName);					
				}
				break;
			case 9:
				bRunning = false;
				break;
			default:
				break;
			}
		}
	}

}
