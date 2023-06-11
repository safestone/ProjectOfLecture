package control;

import java.io.IOException;

import model.MCommunity;
import valueObject.VCommunity;

public class CCommunity {
	
	private MCommunity mCommunity;
	
	public CCommunity() {
		this.mCommunity = new MCommunity();
	}
	
	public void addPost(VCommunity vCommunity) throws IOException {
		mCommunity.addPost(vCommunity);
	}

	public void displayPosts() {
		mCommunity.displayPosts();
	}

	public void displayPosts_Admin() {
		mCommunity.displayPosts_Admin();
	}
	
	public void removePost(int select) throws IOException {
		mCommunity.removePost(select);
	}



}
