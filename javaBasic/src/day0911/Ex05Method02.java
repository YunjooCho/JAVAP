package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//리턴 타입이 없는 메소드
//그리고 메소드 중간에 리턴하는 메소드
public class Ex05Method02 {
	//1. 리턴 타입이 없는 메소드
	//	  아무것도 리턴하지 않을 때에는 void라고 적어주고
	//	  그러한 경우엔 return명령어를 쓰지 않는다.
	static void showMenu() {
		System.out.println("----------------------");
		System.out.println("비트고등학교 성적관리 프로그램");
		System.out.println("\t1.입력");
		System.out.println("\t2.출력");
		System.out.println("\t3.종료");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int korean = 0;
		int math = 0;
		int english = 0;
		String name = new String();
		
		while(true) {
			showMenu(); //showMenu메소드
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//입력 메소드 실행
				
				//점수를 입력받아서 유효한 점수를 리턴해주는 메소드를 만들어서
				//국영수 점수에 입력 시키시오
				System.out.print("이름을 입력하세요 : ");
				name = bufferedReader.readLine();
				
				System.out.print("국어 ");
				korean = validateScore(bufferedReader); //입력용이 아닌 메소드로 값을 넘겨주기 위한 내용
				//korean에 validateScore의 메소드 결과값(score)이 저장
				
				System.out.print("영어 ");
				english = validateScore(bufferedReader);//입력용이 아닌 메소드로 값을 넘겨주기 위한 내용
				
				System.out.print("수학 ");
				math = validateScore(bufferedReader);//입력용이 아닌 메소드로 값을 넘겨주기 위한 내용
				
				
				
			}else if(userChoice == 2) {
				//출력 메소드 실행
				
				//파라미터로 넘어온 이름, 국영수 점수를
				//예쁘게 출력하는 메소드를 작성하시오
				printScore(name, korean, english, math);
				
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}
		}
	}
	static int validateScore(BufferedReader bufferedReader) throws NumberFormatException, IOException {
	//외부로부터 BufferedReader변수를 하나 받아와서 사용
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
		
	static void printScore(String name, int korean, int english, int math) {
		System.out.println("==================================");
		System.out.println("\t이름 : " + name);
		System.out.printf("국어 : %d 영어 : %d 수학 : %d\n",korean, english, math);
		int sum = korean + english + math;
		double average = sum / (double)3;
		System.out.printf("총점 : %d 평균 : %.2f\n",sum,average);
		
	}
	
}
