import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MSugangsincheong {

	private Scanner sc;
	private VComplete vComplete;

	public VComplete Sugangsincheong(VSugangsincheong vSugangsincheong) throws IOException {
        vComplete = null;

		String filePath = "data/sugangsincheong"+vSugangsincheong.getUserName()+".txt";
		File file = new File(filePath);
		if(!file.exists()){ // 파일이 존재하지 않으면
            file.createNewFile(); // 신규생성
        }
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		sc = new Scanner(System.in);
		System.out.println("신청하고자 하는 강좌의 번호를 입력해주세요");
		String num = sc.next();
		String line = null;
		sc = new Scanner(new File("data/miridamgi"+vSugangsincheong.getUserName()+".txt"));
		while (sc.hasNext()) {
			line = sc.nextLine();
			String[] LectureInformation = line.split("[ ]");
			if(LectureInformation[0].equals(num)) {
				break;
			}
		}
		writer.write(line);
        writer.newLine();
        
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료
		
		return vComplete;
	}

}
