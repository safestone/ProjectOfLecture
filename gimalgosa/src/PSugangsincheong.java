import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PSugangsincheong {

	public void run(VUserInfo vUserInfo) throws FileNotFoundException {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. 책가방 조회 2. 책가방 삭제 3. 수강신청 4. 나가기");
			int answer = sc.nextInt();
			VSugangsincheong vSugangsincheong = new VSugangsincheong();
			CSugangsincheong cSugangsincheong = new CSugangsincheong();
			
			if(answer == 1) {
				Scanner scanMiridamgi = new Scanner(new File("data/miridamgi"+vUserInfo.getName()+".txt"));
				while(scanMiridamgi.hasNext()) {
					String line = scanMiridamgi.nextLine();
					System.out.println(line);
				}
			} else if (answer == 2) {
				
			} else if (answer == 3) {
				
			} else if (answer == 4) {
				break;
			} 
		}
	}

}
