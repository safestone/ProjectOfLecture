import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MFindLecture {

	public VLecture FindRoot(VFindLecture vFindLecture) {
		try {
			Scanner scanner = new Scanner(new File("data/root.txt"));
			VLecture vLecture = new VLecture();
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] RootInformation = line.split("\\s");
				if(RootInformation[0].equals(vFindLecture.getRoot())) {
					vLecture.setRootKorean(RootInformation[1]);
					vLecture.setRootEnglish(RootInformation[2]);
					break;
				}
			}
			scanner.close();
			return vLecture;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public VLecture Subject(VFindLecture vFindLecture) {
			try {
				VLecture vLecture = new VLecture();
				if(vFindLecture.getRoot().contains("yongin")) {
					Scanner scanner = new Scanner(new File("data/yongin.txt"));
					while(scanner.hasNext()) {
						String line = scanner.nextLine();
						String[] SubjectInformation = line.split("\\s");
						if(SubjectInformation[0].equals(vFindLecture.getSubject())) {
							vLecture.setSubjectKorean(SubjectInformation[1]);
							vLecture.setSubjectEnglish(SubjectInformation[2]);
							break;
						}
					}
					scanner.close();
				} else if (vFindLecture.getRoot().contains("seoul")) {
					Scanner scanner = new Scanner(new File("data/seoul.txt"));
					while(scanner.hasNext()) {
						String line = scanner.nextLine();
						String[] SubjectInformation = line.split("\\s");
						if(SubjectInformation[0].equals(vFindLecture.getSubject())) {
							vLecture.setSubjectKorean(SubjectInformation[1]);
							vLecture.setSubjectEnglish(SubjectInformation[2]);
							break;
						}
					}
					scanner.close();
				}
				return vLecture;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}

	public VLecture lecture(VFindLecture vFindLecture) {
		try {
			Scanner scanner = new Scanner(new File("data/"+vFindLecture.getSubject()+".txt"));
			VLecture vLecture = new VLecture();
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] LectureInformation = line.split("\\s");
				if(LectureInformation[0].equals(vFindLecture.getLectureNum())) {
					vLecture.setLectureNumber(LectureInformation[0]);
					vLecture.setLectureKorean(LectureInformation[1]);
					vLecture.setLectureEnglish(LectureInformation[2]);
					break;
				}
			}
			scanner.close();
			return vLecture;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public VLecture select(VFindLecture vFindLecture) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("data/"+vFindLecture.getSelectEnglish()+".txt"));
			VLecture vLecture = new VLecture();
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] SeletInformation = line.split("\\s");
				if(line.contains(vFindLecture.getSelect())) {
					vLecture.setSeletInformation(line);
					vLecture.setSeletCredit(SeletInformation[3]);
				}
			}
			scanner.close();
			return vLecture;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	}



