package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MModifyLecture {

	public void addLecture(String lectureInfo, String departmentFileName) throws IOException {
		String path = "data/"+departmentFileName+".txt";
		File file = new File(path);
		
		FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);
        
        writer.newLine();
        writer.write(lectureInfo);
        
        System.out.println("강좌룰 추가하였습니다.");
		 
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료
	}

	public void removeLecture(String code, String departmentFileName) throws IOException {
		String path = "data/"+departmentFileName+".txt";
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

	}

}
