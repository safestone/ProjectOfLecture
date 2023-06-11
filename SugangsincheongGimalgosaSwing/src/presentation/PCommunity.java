package presentation;

import java.io.IOException;
import java.util.Scanner;

import control.CCommunity;
import valueObject.VCommunity;
import valueObject.VUserInfo;

public class PCommunity {
	private CCommunity cCommunity;
	private int i;
    
	public PCommunity() {
		this.cCommunity = new CCommunity();
		this.i = 0;
	}

	public void community(VUserInfo vUserInfo, Scanner keyboard) throws IOException {
		boolean bRunning = true;
		while(bRunning) {
			if(vUserInfo.getId().equals("admin")) {
				System.out.println("0.관리자 게시물 작성 1.게시물 조회 2.게시물 삭제 9.돌아가기");
			} else {
				System.out.println("0.게시물 작성 1.게시물 조회 9.돌아가기");
			}
			
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			switch (selection) {
			case 0:
				keyboard.nextLine();
				System.out.println("게시물 제목을 입력하세요:");
                String title = keyboard.nextLine();
                System.out.println("게시물 내용을 입력하세요:");
                String content = keyboard.nextLine();
                
                VCommunity vCommunity = new VCommunity();
                vCommunity.setName(vUserInfo.getName());
                vCommunity.setTitle(title);
                vCommunity.setContent(content);
                vCommunity.setCode(i);
                
                cCommunity.addPost(vCommunity);
                
                i++;
				break;
			case 1:                
                cCommunity.displayPosts(); //게시판 조회
				break;
			case 2:       
                cCommunity.displayPosts_Admin();
                System.out.println("삭제하고자 하는 게시물의 코드를 입력해주세요.");
                int select = keyboard.nextInt();
                
				cCommunity.removePost(select);
				break;
			default:
				bRunning = false;
				break;
			}
		}
	}

}
