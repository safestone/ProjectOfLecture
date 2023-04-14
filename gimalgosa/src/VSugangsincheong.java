import java.util.Scanner;

public class VSugangsincheong {
	static Scanner scanner = new Scanner(System.in);
	
	private static void ListOfSubject(int campus) {
		MListOfSubjects listOfSubjects = new MListOfSubjects();
		
		
		int num = Separation(campus);
		
		if (num == 1) {
			listOfSubjects.run();
		} else if (num == 2) {
			listOfSubjects.run2();
		} else if (num == 3) {
			listOfSubjects.run3();
		} else if (num == 4) {
			listOfSubjects.run4();
		} else if (num == 5) {
			listOfSubjects.run5();
		} else if (num == 6) {
			listOfSubjects.run6();
		} else if (num == 7) {
			listOfSubjects.run7();
		} else if (num == 8) {
			listOfSubjects.run8();
		} else if (num == 9) {
			listOfSubjects.run9();
		} else if (num == 10) {
			listOfSubjects.run10();
		} else if (num == 11) {
			listOfSubjects.run11();
		} else if (num == 12) {
			listOfSubjects.run12();
		} else if (num == 13) {
			listOfSubjects.run13();
		} else if (num == 14) {
			listOfSubjects.run14();
		} else if (num == 15) {
			listOfSubjects.run15();
		} else if (num == 16) {
			listOfSubjects.run16();
		} else if (num == 17) {
			listOfSubjects.run17();
		}

	}
	
	private static int Separation(int campus) {
		int num = DayNight(campus);
		
		if (num == 1) {
			System.out.println("원하시는 강좌의 번호를 입력해주세요");
			System.out.println("1.일반교양 2.핵심교양 3.학문기초교양 4.전공");
			int SClass = scanner.nextInt();
			if(SClass == 1) {
				System.out.println("자연캠퍼스 주간 일반교양");
				return 1;
			} else if (SClass == 2) {
				System.out.println("자연캠퍼스 주간 핵심교양");
				return 2;
			} else if (SClass == 3) {
				System.out.println("자연캠퍼스 주간 학문기초교양");
				return 3;
			} else if (SClass == 4) {
				System.out.println("자연캠퍼스 주간 학문기초교양");
				return 4;
			}
		} else if (num == 2) {
			System.out.println("원하시는 강좌의 번호를 입력해주세요");
			System.out.println("1.일반교양 2.핵심교양 3.학문기초교양 4.전공");
			int SClass = scanner.nextInt();
			if(SClass == 1) {
				System.out.println("자연캠퍼스 야간 일반교양");
				return 5;
			} else if (SClass == 2) {
				System.out.println("자연캠퍼스 야간 핵심교양");
				return 6;
			} else if (SClass == 3) {
				System.out.println("자연캠퍼스 야간 학문기초교양");
				return 7;
			} else if (SClass == 4) {
				System.out.println("자연캠퍼스 야간 학문기초교양");
				return 8;
			}
		} else if (num == 3) {
			System.out.println("원하시는 강좌의 번호를 입력해주세요");
			System.out.println("1.일반교양 2.핵심교양 3.학문기초교양 4.전공");
			int SClass = scanner.nextInt();
			if(SClass == 1) {
				System.out.println("인문캠퍼스 주간 일반교양");
				return 9;
			} else if (SClass == 2) {
				System.out.println("인문캠퍼스 주간 핵심교양");
				return 10;
			} else if (SClass == 3) {
				System.out.println("인문캠퍼스 주간 학문기초교양");
				return 11;
			} else if (SClass == 4) {
				System.out.println("인문캠퍼스 주간 학문기초교양");
				return 12;
			}
		} else if (num == 4) {
			System.out.println("원하시는 강좌의 번호를 입력해주세요");
			System.out.println("1.일반교양 2.핵심교양 3.학문기초교양 4.전공");
			int SClass = scanner.nextInt();
			if(SClass == 1) {
				System.out.println("인문캠퍼스 야간 일반교양");
				return 13;
			} else if (SClass == 2) {
				System.out.println("인문캠퍼스 야간 핵심교양");
				return 14;
			} else if (SClass == 3) {
				System.out.println("인문캠퍼스 야간 학문기초교양");
				return 15;
			} else if (SClass == 4) {
				System.out.println("인문캠퍼스 야간 학문기초교양");
				return 16;
			}
		} else if (num == 5) {
			System.out.println("해당되는 번호를 입력해주세요");
			System.exit(0);
		} 
		return 17;
	}
	
	private static int DayNight(int campus) {
		int num = Campus(campus);
		
		if (num == 1) {
			System.out.println("주간, 야간 수업 중 해당되는 숫자를 입력해주세요");
			System.out.println("1.주간 2.야간");
			int time = scanner.nextInt();
			if(time == 1) {
//				System.out.println("자연캠퍼스 주간");
				return 1;
			} else if (time == 2) {
//				System.out.println("자연캠퍼스 야간");
				return 2;
			}
		} else if (num == 2) {
			System.out.println("주간, 야간 수업 중 해당되는 숫자를 입력해주세요");
			System.out.println("1.주간 2.야간");
			int time = scanner.nextInt();
			if(time == 1) {
//				System.out.println("인문캠퍼스 주간");
				return 3;
			} else if (time == 2) {
//				System.out.println("인문캠퍼스 야간");
				return 4;
			}
		} else if (num == 3) {
			System.out.println("해당되는 번호를 입력해주세요.");
			System.exit(0);
		}
		return 5;
	}
	
	private static int Campus(int campus) {
		if (campus == 1) {
			return 1;
		} else if (campus == 2) {
			return 2;
		} else {
			return 3;
		}
		
	}

	public void run() {
		System.out.println("해당되는 캠퍼스의 숫자를 입력해주세요.");
		System.out.println("1.자연캠퍼스 2.인문캠퍼스");
		int campus = scanner.nextInt();
		
		Separation(campus);		
	}

}
