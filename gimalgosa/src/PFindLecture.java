import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PFindLecture {

	public PFindLecture(VUserInfo vUserInfo) {
	}

	public void run(VUserInfo vUserInfo) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(vUserInfo.getName() + " : " + vUserInfo.getRoot() + " " + vUserInfo.getDepartment());
		System.out.println("선택하고자 하는 캠퍼스의 번호를 입력해주세요");
		System.out.println("1. 용인 2. 서울");
		String root = scanner.next();
		
		VSugangsincheong vSugangsincheong = new VSugangsincheong();
		vSugangsincheong.setRoot(root);
		
		CSugangsincheong cSugangsincheong = new CSugangsincheong();
		VLecture vLecture = cSugangsincheong.Sugangsincheong(vSugangsincheong);
		
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
		vSugangsincheong.setSubject(subject);
		vSugangsincheong.setRoot(vLecture.getRootEnglish());
		vLecture = cSugangsincheong.Subject(vSugangsincheong);
		
		System.out.println(vLecture.getSubjectKorean());
		System.out.println("원하시는 선택지의 번호를 입력해주세요");
		Scanner sc = new Scanner(new File("data/"+vLecture.getSubjectEnglish()+".txt"));
		while(sc.hasNext()) {
			String str = sc.nextLine();
			System.out.println(str);
		}
		vSugangsincheong.setSubject(vLecture.getSubjectEnglish());
		System.out.println("원하시는 선택지의 번호를 입력해주세요");
		String departmentNum = scanner.next();
		vSugangsincheong.setLectureNum(departmentNum);
		vLecture = cSugangsincheong.lecture(vSugangsincheong);
		
		System.out.println(vLecture.getLectureKorean());
		Scanner sc1 = new Scanner(new File("data/"+vLecture.getdepartmentEnglish()+".txt"));
		while(sc1.hasNext()) {
			String str = sc1.nextLine();
			System.out.println(str);
		}
	}
}
