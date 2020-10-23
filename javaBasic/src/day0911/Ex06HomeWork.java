package day0911;



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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06HomeWork {
	
	
	//1.메뉴 메소드
	static void showMenu()  {
		
		System.out.println("===========================");
		System.out.println(" 비트고등학교 국영수 성적 관리 프로그램");
		System.out.println(" 1.입력\t2.출력\t3.종료");
		System.out.println("===========================");
		System.out.print("메뉴선택 > ");
	}
	
	
	//3.배열 입력 메소드
	static int validateScore(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		//main으로부터 BufferedReader변수를 받아와서 사용
		//main메소드에 있는 korean, english, math를 받아와 score에 대입
		//키보드로 입력한 점수는 여기서 필터링됨, 
		//필터링된 값이 다시 main으로 돌아가 변수(korean, english, math)에 저장됨
			
			System.out.print("점수를 입력하세요 : ");
			int score = Integer.parseInt(bufferedReader.readLine());
			
			while(score < 0 || score > 100) {
				System.out.println("잘못 입력하셨습니다");
				System.out.print("점수를 입력하세요 : ");
				score = Integer.parseInt(bufferedReader.readLine());
			}
			return score; //while문에 해당하지 않는 값(유효한 점수)을 score변수에 저장
			
		
		}
	
	
	//★★★★★★★4.배열 출력 메소드
	//외부로부터 정보가 필요한 것은 다 ()안에 넣기
	static void printScore(BufferedReader bufferedReader, int score, int grade, int[][] korArray, int[][] engArray, int[][] mathArray) throws IOException {
		
		System.out.print("출력할 학년(1,2,3)을 선택 : ");
		int gradE = Integer.parseInt(bufferedReader.readLine());
		
		
		while( gradE < 0 || gradE > 100) {
			System.out.println("올바르지 않은 학년입니다.");
			System.out.print("출력할 학년(1,2,3)을 선택 : ");
			gradE = Integer.parseInt(bufferedReader.readLine());
		}
		
		System.out.print("몇번째?(1-1학기 중간,2-1학기 기말,3-2학기 중간,4-2학기 기말) : ");
		int whenScorE = Integer.parseInt(bufferedReader.readLine());
		while(whenScorE < 1 || whenScorE > 4) {
			System.out.println("올바르지 않은 순서입니다.");
			System.out.print("몇번째?(1-1학기 중간,2-1학기 기말,3-2학기 중간,4-2학기 기말) : ");
			whenScorE = Integer.parseInt(bufferedReader.readLine());					
		}
		
		
		System.out.println("==================================");
		System.out.print(gradE + "학년");
		switch (whenScorE) {
		case 1:
			System.out.println("1학기 중간");
			break;
		case 2:
			System.out.println("1학기 기말");
			break;
		case 3:
			System.out.println("2학기 중간");
			break;
		case 4:
			System.out.println("2학기 기말");
			break;
		}
		System.out.printf("국어 : %d, 영어 : %d, 수학 : %d\n", korArray[gradE-1][whenScorE-1], engArray[gradE-1][whenScorE-1], mathArray[gradE-1][whenScorE-1]);
	}
		
		
	//}
	
	public static void main(String[] args) throws IOException {
		
		//키보드 입력 메모리 생성
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//2.배열 선언
		// -국어, 영어, 수학(o)
		int[][] korArray = new int[3][4];
		int[][] engArray = new int[3][4];
		int[][] mathArray = new int[3][4];
		
		int grade = 0;
		int whenScore = 0;
		
		
		//1.메뉴 메소드 만들기
		// -메소드 (o)
		// -입력하면 해당 메뉴로 넘어가도록함(o)
		// -입력메뉴 (o)
		// -출력메뉴 (o)
		// -종료메뉴(o)
		while(true) {
			showMenu();
			int selectMenu = Integer.parseInt(bufferedReader.readLine());
			if(selectMenu == 1) {		
				//3.배열에 점수입력하는 메소드 만들기
				// -학년, 중간/기말(o)
				// -국어, 영어, 수학 (하나로 통일)(o)
				for(int i = 0; i < korArray.length; i++)  {
					System.out.print("학년 입력(1,2,3) : ");
					grade = Integer.parseInt(bufferedReader.readLine());
					
					while(grade < 1 || grade > 3) {
						System.out.println("올바르지 않은 학년입니다.");
						System.out.print("학년 입력(1,2,3) : ");
						grade = Integer.parseInt(bufferedReader.readLine());
					}//while
					for(int j = 0; j < korArray[i].length; j++) {
						System.out.print("몇번째?(1-1학기 중간,2-1학기 기말,3-2학기 중간,4-2학기 기말) : ");
						whenScore = Integer.parseInt(bufferedReader.readLine());
						while(whenScore < 1 || whenScore > 4) {
							System.out.println("올바르지 않은 순서입니다.");
							System.out.print("몇번째?(1->1학기 중간,2->1학기 기말,3->2학기 중간,4->2학기 기말) : ");
							whenScore = Integer.parseInt(bufferedReader.readLine());
						}//while
						
						System.out.print("국어 ");
						korArray[grade-1][whenScore-1] = validateScore(bufferedReader); //입력용이 아닌 메소드로 값을 넘겨주기 위한 내용
						//korean에 validateScore의 메소드 결과값(score)이 저장
						
						System.out.print("영어 ");
						engArray[grade-1][whenScore-1] = validateScore(bufferedReader);//입력용이 아닌 메소드로 값을 넘겨주기 위한 내용
						
						System.out.print("수학 ");
						mathArray[grade-1][whenScore-1] = validateScore(bufferedReader);//입력용이 아닌 메소드로 값을 넘겨주기 위한 내용
						
					}//점수 입력 반복 for j(언제)
				}//점수 입력 반복  for i(학년)
			}else if(selectMenu == 2) {
				//4.필요한 점수 출력하는 메소드 만들기
				// -학년, 중간/기말
				// -국어, 영어, 수학
				
				
				printScore(bufferedReader, grade, whenScore, korArray, engArray, mathArray);
				
				
				
			}else {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		

		

	}

}


	



	
}
