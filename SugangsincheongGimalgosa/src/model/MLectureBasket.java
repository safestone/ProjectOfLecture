package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class MLectureBasket {
	
	private int i;
	
	public MLectureBasket() {
		this.i = 0;
	}

	public void addBasket(VUserInfo vUserInfo, Vector<VLecture> vLectureVector) throws IOException {
		
		String Code = String.valueOf(vLectureVector.get(i).getCode());
		String line = Code + " " + vLectureVector.get(i).getName() + " " + vLectureVector.get(i).getCredit() + " " + vLectureVector.get(i).getTime() + " " + vLectureVector.get(i).getProfessor();
		System.out.println(line);  //백터에 담긴 데이터를 String 형식으로 한 문자열에 담음
		
		//파일 객체 생성
		String path = "data/miridamgi"+vUserInfo.getId()+".txt";
		File file = new File(path);
		//파일이 없을 시 생성
		if (!file.exists()) {
            file.createNewFile();
            System.out.println("파일 생성");
        }
		FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);
        
        writer.write(line);
        writer.newLine();
        
        System.out.println("책가방에 강좌를 담았습니다.");
		 
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료
        
        i += 1;
	}

	public void lookBasket(VUserInfo vUserInfo) throws IOException {
		String path = "data/miridamgi"+vUserInfo.getId()+".txt";
		
		BufferedReader reader = new BufferedReader(
	            new FileReader(path)
	        );
	 
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
 
        reader.close();
	
	}

	public void deleteBasket(VUserInfo vUserInfo, String code) throws IOException {
		String path = "data/miridamgi"+vUserInfo.getId()+".txt";
		String targetString = code;
		
		FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // 삭제할 문자열이 포함되어 있지 않으면 해당 라인을 저장
            if (!line.contains(targetString)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        }

        bufferedReader.close();
        fileReader.close();

        // 새로운 파일에 수정된 내용을 씀
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();

        System.out.println("책가방에서 " + code + "이(가) 성공적으로 삭제되었습니다.");
	}

	public void sincheong(VUserInfo vUserInfo, Vector<VLecture> vLectureVector, String code2) throws IOException {
		if(code2 != null) {
			String path = "data/miridamgi"+vUserInfo.getId()+".txt";
			String path2 = "data/sincheong"+vUserInfo.getId()+".txt";
			FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(code2)) {
                    File file = new File(path2);
        			//파일이 없을 시 생성
        			if (!file.exists()) {
        	            file.createNewFile();
        	            System.out.println("파일 생성");
        	        }
        			FileWriter fw = new FileWriter(file, true);
        	        BufferedWriter writer = new BufferedWriter(fw);
        	        
        	        writer.write(line);
        	        writer.newLine();
        	        
        	        System.out.println("수강신청이 완료되었습니다.");
        			 
        	        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        	        writer.close(); // 스트림 종료
                    break;
                }
            }    
		} else if (code2 == null) {
			String Code = String.valueOf(vLectureVector.get(i).getCode());
			String line = Code + " " + vLectureVector.get(i).getName() + " " + vLectureVector.get(i).getCredit() + " " + vLectureVector.get(i).getTime() + " " + vLectureVector.get(i).getProfessor();
			System.out.println(line);  //백터에 담긴 데이터를 String 형식으로 한 문자열에 담음
			
			String path = "data/sincheong"+vUserInfo.getId()+".txt";
			File file = new File(path);
			//파일이 없을 시 생성
			if (!file.exists()) {
	            file.createNewFile();
	            System.out.println("파일 생성");
	        }
			FileWriter fw = new FileWriter(file, true);
	        BufferedWriter writer = new BufferedWriter(fw);
	        
	        writer.write(line);
	        writer.newLine();
	        
	        System.out.println("수강신청이 완료되었습니다.");
			 
	        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
	        writer.close(); // 스트림 종료
	        
	        i += 1;
		}
		
	}

	public void lookSincheong(VUserInfo vUserInfo) throws IOException {
		String path = "data/sincheong"+vUserInfo.getId()+".txt";
		
		BufferedReader reader = new BufferedReader(
	            new FileReader(path)
	        );
	 
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
 
        reader.close();
	}

	public void deletesincheong(VUserInfo vUserInfo, String code) throws IOException {
		String path = "data/sincheong"+vUserInfo.getId()+".txt";
		String targetString = code;
		
		FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // 삭제할 문자열이 포함되어 있지 않으면 해당 라인을 저장
            if (!line.contains(targetString)) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        }

        bufferedReader.close();
        fileReader.close();

        // 새로운 파일에 수정된 내용을 씀
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();

        System.out.println("신청목록에서 " + code + "이(가) 성공적으로 삭제되었습니다.");
	}
}
