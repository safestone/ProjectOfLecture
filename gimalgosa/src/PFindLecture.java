import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PFindLecture {
	
	public PFindLecture(VUserInfo vUserInfo) {
	}

	public void run(VUserInfo vUserInfo) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int num1 = Integer.valueOf(vUserInfo.getCredit());
		vUserInfo.setCredit(String.valueOf(num1));
		System.out.println("선택하고자 하는 캠퍼스의 번호를 입력해주세요");
		System.out.println("1. 용인 2. 서울");
		String root = scanner.next();
		
		VFindLecture vFindLecture = new VFindLecture();
		vFindLecture.setRoot(root);
		
		CFindLecture cFindLecture = new CFindLecture();
		VLecture vLecture = cFindLecture.Sugangsincheong(vFindLecture);
		
		if(vLecture != null) {
			System.out.println(vLecture.getRootKorean());
			System.out.println("원하시는 선택지의 번호를 입력해주세요");
			if(vLecture.getRootEnglish().contains("yongin")) {
				Scanner LcetureScan = new Scanner(new File("data/yongin.txt"));
				while(LcetureScan.hasNext()) {
					String str = LcetureScan.nextLine();
					System.out.println(str);
				}
			} else if (vLecture.getRootEnglish().contains("seoul")) {
				if(vLecture.getRootEnglish().contains("seoul")) {
					Scanner LcetureScan = new Scanner(new File("data/seoul.txt"));
					while(LcetureScan.hasNext()) {
						String str = LcetureScan.nextLine();
						System.out.println(str);
					}
				}
			}
		}
		String subject = scanner.next();
		vFindLecture.setSubject(subject);
		vFindLecture.setRoot(vLecture.getRootEnglish());
		vLecture = cFindLecture.Subject(vFindLecture);
		
		System.out.println(vLecture.getSubjectKorean());
		System.out.println("원하시는 선택지의 번호를 입력해주세요");
		Scanner sc = new Scanner(new File("data/"+vLecture.getSubjectEnglish()+".txt"));
		while(sc.hasNext()) {
			String str = sc.nextLine();
			System.out.println(str);
		}
		vFindLecture.setSubject(vLecture.getSubjectEnglish());
		System.out.println("원하시는 선택지의 번호를 입력해주세요");
		String departmentNum = scanner.next();
		vFindLecture.setLectureNum(departmentNum);
		vLecture = cFindLecture.lecture(vFindLecture);
		
		System.out.println(vLecture.getLectureKorean());
		System.out.println("원하시는 선택지의 번호를 입력해주세요");
		Scanner sc1 = new Scanner(new File("data/"+vLecture.getdepartmentEnglish()+".txt"));
		while(sc1.hasNext()) {
			String str = sc1.nextLine();
			System.out.println(str);
		}
		int num = scanner.nextInt();
		vFindLecture.setSelectNum(num);
		vFindLecture.setSelect(vLecture.getLectureNumber());
		vFindLecture.setSelectEnglish(vLecture.getLectureEnglish());
		vLecture = cFindLecture.select(vFindLecture);
		
		System.out.println(vLecture.getSeletInformation());
		
		File file = new File("data/miridamgi"+vUserInfo.getName()+".txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(vLecture.getSeletInformation());
		writer.newLine();
		
		writer.flush();
		writer.close();
		
		
		int num2 = Integer.valueOf(vLecture.getSeletCredit());
		int sum = num1 - num2;
		System.out.println("남은 학점 : " + sum);
	}
}
