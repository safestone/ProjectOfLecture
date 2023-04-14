import java.util.Scanner;

public class VLogin {

	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		
		int i = 1;

		String CorrectID = "1234";
		String CorrectPW = "1234";
		
		while (i <= 3) {
			System.out.println("현재 아이디 비밀번호는 1234로 통일함.");
			System.out.println("사용자 아이디를 입력해주세요.");
			String userID = scanner.next();
			
			if (userID.equals(CorrectID)) {
				System.out.println("사용자 비밀번호를 입력해주세요.");
				String userPW = scanner.next();
				if (userPW.equals(CorrectPW)) {
					return true;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					System.out.println("남은 기회" + (3-i));
					i++;
				}
			} else {
				System.out.println("아이디가 일치하지 않습니다.");
				System.out.println("남은 기회" + (3-i));
				i++;
			}		
		}
		return false;
		
	}

}
