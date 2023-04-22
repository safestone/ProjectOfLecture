import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MSugangsincheong {

	public VLecture FindRoot(VSugangsincheong vSugangsincheong) {
		try {
			Scanner scanner = new Scanner(new File("data/root.txt"));
			VLecture vLecture = new VLecture();
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] RootInformation = line.split("\\s");
				if(RootInformation[0].equals(vSugangsincheong.getRoot())) {
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

	public VLecture Subject(VSugangsincheong vSugangsincheong) {
			try {
				VLecture vLecture = new VLecture();
				if(vSugangsincheong.getRoot().contains("yongin")) {
					Scanner scanner = new Scanner(new File("data/yongin.txt"));
					while(scanner.hasNext()) {
						String line = scanner.nextLine();
						String[] SubjectInformation = line.split("\\s");
						if(SubjectInformation[0].equals(vSugangsincheong.getSubject())) {
							vLecture.setSubjectKorean(SubjectInformation[1]);
							vLecture.setSubjectEnglish(SubjectInformation[2]);
							break;
						}
					}
					scanner.close();
				} else if (vSugangsincheong.getRoot().contains("seoul")) {
					Scanner scanner = new Scanner(new File("data/seoul.txt"));
					while(scanner.hasNext()) {
						String line = scanner.nextLine();
						String[] SubjectInformation = line.split("\\s");
						if(SubjectInformation[0].equals(vSugangsincheong.getSubject())) {
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

	public VLecture lecture(VSugangsincheong vSugangsincheong) {
		try {
			Scanner scanner = new Scanner(new File("data/"+vSugangsincheong.getSubject()+".txt"));
			VLecture vLecture = new VLecture();
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] LectureInformation = line.split("\\s");
				if(LectureInformation[0].equals(vSugangsincheong.getLectureNum())) {
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
	}



