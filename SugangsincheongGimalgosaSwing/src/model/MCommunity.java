package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import valueObject.VCommunity;

public class MCommunity {
    private ArrayList<VCommunity> posts;
    
    
    public MCommunity() {
    	this.posts = new ArrayList<>();
    }
    
    private void savePostsToFile(int command) throws IOException {
    	String filePath = "data/posts.txt";
    	File file = new File(filePath);
    	
    	if (!file.exists()) {
            file.createNewFile();
            System.out.println("파일 생성");
        }
    	FileWriter fw = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fw);
        
        for(VCommunity post : posts) {
        	if(post.getCode() == command) {
        		writer.write("식별번호: " + command);
        		writer.write(" 작성자: " + post.getName());
        		writer.write(" 게시물 제목: " + post.getTitle());
        		writer.write(" 게시물 내용: " + post.getContent());
        		writer.newLine();
        	}
        }
        writer.flush();
    }
	
    private void deletePostsTextFile(int select) throws IOException {
		String path = "data/posts.txt";
		String targetString = String.valueOf(select);
		
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
	
	public void addPost(VCommunity vCommunity) throws IOException {
		posts.add(vCommunity);
		System.out.println("작성자: " + vCommunity.getName());
		System.out.println("게시물 제목: " + vCommunity.getTitle());
		System.out.println("게시물 내용: " + vCommunity.getContent());
		System.out.println("게시물이 등록되었습니다.");
		
		int command = vCommunity.getCode();
		
		savePostsToFile(command);
	}

	public void displayPosts() {
		for (VCommunity post : posts) {
			System.out.println("작성자: " + post.getName());
            System.out.println("게시물 제목: " + post.getTitle());
            System.out.println("게시물 내용: " + post.getContent());
            System.out.println("-------------------------------------------");
        }
	}
	
	public void displayPosts_Admin() {
		for (VCommunity post : posts) {
            System.out.println("식별번호: " + post.getCode());
			System.out.println("작성자: " + post.getName());
            System.out.println("게시물 제목: " + post.getTitle());
            System.out.println("게시물 내용: " + post.getContent());
            System.out.println("-------------------------------------------");
        }
	}
	
	public void removePost(int select) throws IOException {
		Iterator<VCommunity> iterator = posts.iterator();
		while (iterator.hasNext()) {
		    VCommunity post = iterator.next();
		    if (post.getCode() == select) {
		        System.out.println("게시물이 삭제되었습니다.");
		        deletePostsTextFile(select);
		        iterator.remove();
		    }
		}

	}


}
