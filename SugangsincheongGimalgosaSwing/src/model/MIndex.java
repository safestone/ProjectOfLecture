package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VIndex;

public class MIndex {
	public Vector<VIndex> nextIndex(String fileName) {
		Vector<VIndex> vindexVector = null;
		try {
			Scanner File = new Scanner(new File(fileName));	
			vindexVector = new Vector<VIndex>();
			while(File.hasNext()) {
				VIndex vIndex = new VIndex();
				vIndex.load(File);

				vindexVector.add(vIndex);
			}
			File.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vindexVector;
	}
	
	
}
