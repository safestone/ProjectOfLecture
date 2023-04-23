import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PSugangsincheong {
	 
	public void removeLinesFromFile(VUserInfo vUserInfo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제하고자 하는 강좌의 번호를 입력해주세요.");
		String input = sc.next();
		
			String filePath = "data/miridamgi"+vUserInfo.getName()+".txt";
	        String searchString = input;
	        
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            String line;
	            StringBuilder stringBuilder = new StringBuilder();
	            
				Scanner scanner = new Scanner(new File("data/miridamgi"+vUserInfo.getName()+".txt"));

				while(scanner.hasNext()) {
					String line1 = scanner.nextLine();
					String[] CreditInformation = line1.split("\\s");
					if(CreditInformation[0].equals(searchString)) {
						vUserInfo.setRemoveCredit(CreditInformation[3]);
						break;
					}
				}
	            while ((line = reader.readLine()) != null) {
	                if (!line.contains(searchString)) {
	                    stringBuilder.append(line);
	                    stringBuilder.append("\n"); 
	                }
	            }
	            reader.close();
	            
	            FileWriter writer = new FileWriter(filePath);
	            writer.write(stringBuilder.toString());
	            writer.close();
	            
	            System.out.println("강좌 번호 : " + searchString + "가 삭제되었습니다.");
	            
	        } catch (IOException e) {
	       
	        }
	    }

	public void run(VUserInfo vUserInfo) throws FileNotFoundException {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. 책가방 조회 2. 책가방 수정 3. 수강신청 4. 나가기");
			int answer = sc.nextInt();
			VSugangsincheong vSugangsincheong = new VSugangsincheong();
			CSugangsincheong cSugangsincheong = new CSugangsincheong();
			
			if(answer == 1) {
				Scanner scanMiridamgi = new Scanner(new File("data/miridamgi"+vUserInfo.getName()+".txt"));
				while(scanMiridamgi.hasNext()) {
					String line = scanMiridamgi.nextLine();
					System.out.println(line);
				}
				System.out.println("현재 학점 : " + vUserInfo.getUseCredit());
				
			} else if (answer == 2) {
				removeLinesFromFile(vUserInfo);
			
				Scanner scanMiridamgi = new Scanner(new File("data/miridamgi"+vUserInfo.getName()+".txt"));
				while(scanMiridamgi.hasNext()) {
					String line = scanMiridamgi.nextLine();
					System.out.println(line);
				}
			} else if (answer == 3) {
				
			} else if (answer == 4) {
				break;
			} 
		}
	}

}
