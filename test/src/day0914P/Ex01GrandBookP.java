package day0914P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01GrandBookP {
	//사용자로부터 몇학년 몇번째 시험점수인지 입력 받아서
	//해당 위치에 점수를 넣는 코드를 구현하시오
	//조건1. 잘못된 학년이 입력되지 않게 하시오
	//조건2. 몇번째 시험정수를 입력 받을 때 잘못 된 순서가 입력되지 않게 하시오
	//조건3. 점수가 올바른 점수만 입력되기 하시오

	//예시
	//몇학년 점수입니까? (입력 4)
	//올바르지 않은 학년입니다.
	//몇학년 점수입니까? (입력 2)
	//몇번째 시험입니까? (입력 -2)
	//올바르지 않은 순서입니다.
	//몇번째 시험입니까? (입력 1)
	//몇점입니까? (입력 80)
	//2학년 1학기 중간 고사 국어에 80점이 입력되었습니다.
	//1학년 1학기 중간 
	//국어 40 영어 50 수학 45
	
    //1.상수선언
	final static int YEAR = 3; // 학년
	final static int TEST_NUMBER = 4;//1학기 중간~2학기 기말
	public static void main(String[] args) throws IOException {
	//0.입력메모리 생성
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	//0.배열선언
	int[][] korArray = new int[YEAR][TEST_NUMBER];
	int[][] engArray = new int[YEAR][TEST_NUMBER];
	int[][] mathArray = new int[YEAR][TEST_NUMBER];
	
	//2-2.메뉴 메소드 출력
	while(true) {
		showMenu();
		int choice = Integer.parseInt(bufferedReader.readLine());
		if(choice == 1) {
			//5-2. 학년선택 메소드 호출
			int year = selectYear(bufferedReader);
			//6-2. 시험선택 메소드 호출
			int testNumber = selectTest(bufferedReader);
			//7-2. 성적입력 메소드 호출
			korArray[year][testNumber] = validateScore(bufferedReader,1);
			engArray[year][testNumber] = validateScore(bufferedReader,2);
			mathArray[year][testNumber] = validateScore(bufferedReader,3);
			
			
		}else if(choice == 2) {
			//5-2. 학년선택 메소드 호출
			int year = selectYear(bufferedReader);
			//6-2. 시험선택 메소드 호출
			int testNumber = selectTest(bufferedReader);
			//8-2. 출력 메소드 호출
			String message = new String();
			switch(testNumber){
				case 1 :
					message = "1학년 중간";
					break;
				case 2 :
					message = "1학년 기말";
					break;
				case 3 :
					message = "2학년 중간";
					break;
				case 4 :
					message = "2학년 기말";
					break;
			}
			System.out.println(year + "학년 " + message);
			printScore(korArray[year][testNumber], engArray[year][testNumber], mathArray[year][testNumber]);
			
		}else if(choice == 3) {
			//3.종료 처리
			System.out.println("사용해주셔서 감사합니다");
			break;
		}else {
			//4.예외입력
			System.out.println("잘못 입력하셨습니다. 다시 메뉴를 선택해주세요");
		}
		
		
		
	}//메뉴 while
	
	}//main메소드
	
	//2-1.메뉴 메소드 생성
	static void showMenu() {
		System.out.println("===========================");
		System.out.println("코딩고등학교 성적관리 프로그램");
		System.out.println("1.입력   2.출력   3.종료");
		System.out.println("===========================");
		System.out.print("메뉴 선택> ");
	}
	
	//5-1.학년 선택 메소드 생성
	static int selectYear(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		System.out.println("학년을 선택해주세요(1~3)");
		System.out.print("> ");
		int year = Integer.parseInt(bufferedReader.readLine());
		while(year < 0 || year > 3) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("학년을 선택해주세요(1~3)");
			System.out.print("> ");
			year = Integer.parseInt(bufferedReader.readLine());
		}//while
		return year - 1; //배열이므로 사용자는 1,2,3을 입력. 실제 값은 [0][1][2]입력
	}//selectYear메소드
	
	//6-1. 시험 선택 메소드 생성
	static int selectTest(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		System.out.println("시험을 선택해주세요");
		System.out.println("1.1학기 중간   2.1학기 기말   3.2학기 중간   4.2학기 기말");
		System.out.print("> ");
		int testNumber = Integer.parseInt(bufferedReader.readLine());
		while(testNumber < 0 || testNumber > 4) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("시험을 선택해주세요");
			System.out.println("1.1학기 중간   2.1학기 기말   3.2학기 중간   4.2학기 기말");
			System.out.print("> ");
			testNumber = Integer.parseInt(bufferedReader.readLine());			
		}
		return testNumber - 1;//배열이므로 사용자는 1,2,3,4를 입력. 실제 값은 [0][1][2][3]입력
	}
	
	//7-1. 성적 입력 메소드 생성
	static int validateScore(BufferedReader bufferedReader, int code) throws NumberFormatException, IOException {
		String message = new String();
		switch(code) {
		case 1 :
			message = "국어";
			break;
		case 2 :
			message = "영어";
			break;
		case 3 :
			message = "수학";
			break;
		}//switch
		message += " 점수 입력 : ";
		System.out.print(message);
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다");
			System.out.print(message);
			score = Integer.parseInt(bufferedReader.readLine());
		}//while문
		return score;
	}//validateScore메소드
	
	//8-1. 출력 메소드 생성
	static void printScore(int korean, int english, int math) {
		System.out.printf("국어 :%d, 영어 :%d, 수학 :%d\n", korean, english, math);
	}

}
