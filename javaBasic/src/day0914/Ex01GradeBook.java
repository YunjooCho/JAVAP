package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01GradeBook {

	final static int YEAR = 3;
	final static int TEST_NUMBER = 4;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//국어, 영어, 수학에 대한 2차원 배열을 만들어준다
		int[][] koreanArray = new int[YEAR][TEST_NUMBER];
		int[][] englishArray = new int[YEAR][TEST_NUMBER];
		int[][] mathArray = new int[YEAR][TEST_NUMBER];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			showMenu();
			int choice = Integer.parseInt(bufferedReader.readLine());
			if(choice == 1) {
				int year = selectYear(bufferedReader);
	            int testNumber = selectTest(bufferedReader);
	           
               koreanArray[year-1][testNumber-1] = validateScore(bufferedReader, 1);
               englishArray[year-1][testNumber-1] = validateScore(bufferedReader, 2);
               mathArray[year-1][testNumber-1] = validateScore(bufferedReader, 3);
				
			}else if(choice == 2) {
				int year = selectYear(bufferedReader);
				int testNumber = selectYear(bufferedReader);
				String message = new String();
				switch(testNumber) {
				case 1:
					message = "1학기 중간고사";
					break;
				case 2:
					message = "1학기 기말고사";
					break;
				case 3:
					message = "2학기 중간고사";
					break;
				case 4:
					message = "2학기 기말고사";
					break;
					
				}
				System.out.println(year + "학년" + message);
				printScore(koreanArray[year-1][testNumber-1], englishArray[year-1][testNumber-1], mathArray[year-1][testNumber-1]);
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	
	}
	
	static void printScore(int korean, int english, int math) {
	      System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
	   }
	
	
	static int selectYear(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		System.out.println("입력할 학년을 선택해주세요 : ");
		System.out.print("> ");
		int year = Integer.parseInt(bufferedReader.readLine());
		while(year < 1 || year > 3) {
			System.out.println("잘못된 학년입니다.");
			System.out.print("입력할 학년을 선택해주세요 : ");
			year = Integer.parseInt(bufferedReader.readLine());
		}
		return year;
	}
	
	static int selectTest(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		System.out.println("시험을 선택해 주세요: ");
		System.out.println("1.1학기 중간 2.1학기 기말 3.2학기 중간 4.2학기 기말");
		System.out.println("> ");
		int testNumber = Integer.parseInt(bufferedReader.readLine());
		while(testNumber < 1 || testNumber > 4) {
			System.out.println("입력할 시험을 선택해 주세요: ");
			System.out.println("1.1학기 중간 2.1학기 기말 3.2학기 중간 4.2학기 기말");
			System.out.println("> ");
			testNumber = Integer.parseInt(bufferedReader.readLine());
		}
		return testNumber;
	}
	
	
	static void showMenu() {
		System.out.println("=======================");
		System.out.println("비트고등학교 성적관리프로그램");
		System.out.println("\t1.입력");
		System.out.println("\t2.출력");
		System.out.println("\t3.종료");
		System.out.print("> ");
	}
	
	
	
	//점수가 올바른지 체크하고 올바르지 않으면 올바른 점수가 들어올때까지 계속 입력을 받는 메소드
	static int validateScore(BufferedReader bufferedReader, int code) throws NumberFormatException, IOException {
	      String message = new String();
	      switch(code) {
	      case 1:
	         message = "국어 점수를 입력해주세요: ";
	         break;
	      case 2:
	         message = "영어 점수를 입력해주세요: ";
	         break;
	      case 3:
	         message = "수학 점수를 입력해주세요: ";
	         break;
	      }
	      System.out.print(message);
	      int score = Integer.parseInt(bufferedReader.readLine());
	      
	      while(score < 0 || score > 100) {
	         System.out.println("잘못입력하셨습니다.");
	         System.out.print(message);
	         score = Integer.parseInt(bufferedReader.readLine());
	      }
	      
	      return score;
	   }
	

}
