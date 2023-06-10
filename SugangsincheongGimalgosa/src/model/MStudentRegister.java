package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MStudentRegister {

	public void addStudent(String student) throws IOException {
		String path = "data/Account";
		File file = new File(path);
		
		FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);
        
        writer.newLine();
        writer.write(student);
        
        System.out.println("학생을 추가하였습니다.");
		 
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료
	}

	public void removeStudent(String removeId) throws IOException {
		String path = "data/Account";
		String targetString = removeId;
		
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

	public void lookStudent() throws IOException {
		String path = "data/Account";
		
		BufferedReader reader = new BufferedReader(
	            new FileReader(path)
	        );
	 
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
 
        reader.close();
	}

}
