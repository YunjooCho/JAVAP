package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2개의 배열을 동시에 사용해서
//이름과 총점을 동시에 관리해보자
public class Ex01Array {
	final static int SIZE = 5; //더이상 값을 바꾸지 못함(배열의 크기는 변하지 않음), 한계치는 없음
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//이름을 담당할 배열을 하나 만들자
		String[] nameArray = new String[SIZE];
		//총점을 담당할 배열을 하나 만들자
		int[] sumArray =  new int[SIZE];
		
		//차례대로 입력을 해보자
		for(int i = 0; i < SIZE; i++) {
			System.out.println((i+1) + "번 학생의 이름 : ");
			nameArray[i] = bufferedReader.readLine();
			System.out.print(nameArray[i] + " 학생의 국어점수 : ");
			int kor = Integer.parseInt(bufferedReader.readLine());
			while( kor < 0 || kor > 100) {
				System.out.println("잘못입력하셨습니다");
				System.out.print(nameArray[i] + " 학생의 국어점수 : ");
				kor = Integer.parseInt(bufferedReader.readLine());
			}
			System.out.print(nameArray[i] + " 학생의 영어점수 : ");
			int eng = Integer.parseInt(bufferedReader.readLine());
			while( eng < 0 || eng > 100) {
				System.out.println("잘못입력하셨습니다");
				System.out.print(nameArray[i] + " 학생의 영어점수");
				eng = Integer.parseInt(bufferedReader.readLine());
			}
			System.out.print(nameArray[i] + " 학생의 수학점수 : ");
			int math = Integer.parseInt(bufferedReader.readLine());
			while ( math < 0 || math > 100) {
				System.out.println("잘못입력하셨습니다");
				System.out.print(nameArray[i] + " 학생의 수학점수 : ");
				math = Integer.parseInt(bufferedReader.readLine());
			}
			sumArray[i] = kor + eng + math;
		}
		//보고 싶은 학생의 번호를 입력하면 그 학생의 정보를 출력하게 만들어보자
		System.out.println("보고 싶은 학생의 번호를 입력하세요(1~5) : ");
		int userChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
			
		System.out.println(nameArray[userChoice] + " 학생의 총점 :" + sumArray[userChoice]);
		
		//20분동안 여러분들은 출력하는 부분을
		//무한루프로 만드시고
		//만약 사용자가 보고 싶은 학생의 번호를 입력할 때 -1을 입력하면 프로그램이 종료
		//혹은 사용자가 잘못된 번호를 입력하면 잘못 입력하셨습니다. 다시 입력해주세요 라고 입력하게 개조해보기
		//예시
		//보고싶은 학생 : 3
		//3번 학생의 총점 : 218점
		//보고싶은 학생 : 99
		//잘못입력하셨습니다
		//보고싶은 학생 : -1
		//사용해주셔서 감사합니다			
		
		while(true) {
	         System.out.println("보고 싶은 학생의 번호를 입력하세요(1~5, -1은 종료): ");
	         System.out.print("> ");
	         userChoice = Integer.parseInt(bufferedReader.readLine());
	         if(userChoice == -1) {
	            //사용자가 종료를 선택했을 때
	            System.out.println("사용해주셔서 감사합니다.");
	            break;
	         }else if(userChoice >= 1 && userChoice <= 5) {
	            //학생 번호가 유효할때
	            int index = userChoice - 1;
	            System.out.println(nameArray[index]+" 학생의 총점: "+sumArray[index]);
	            //System.out.println(nameArray[userChoice - 1]+" 학생의 총점: "+sumArray[userChoice - 1]);도 가능
	         }else {
	            //잘못입력했을 때
	            System.out.println("잘못입력하셨습니다.");
	         }
	      }
		
		
		
		
	}

}
