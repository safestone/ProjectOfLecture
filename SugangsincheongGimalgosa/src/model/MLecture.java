package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VIndex;
import valueObject.VLecture;

public class MLecture {
	public Vector<VLecture> terminal(String fileName) {
		Vector<VLecture> vindexVector = null;		
		try {
		Scanner File = new Scanner(new File(fileName));
		vindexVector = new Vector<VLecture>();
		while(File.hasNext()) {
			VLecture vIndex = new VLecture();
			vIndex.loadTermianl(File);
			vindexVector.add(vIndex);

		}
		
		File.close();
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vindexVector;
	}
}
