package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Ex01 업그레이드버젼
//총점이 아니라 
//국영수 점수를 관리하는
//무한루프 프로그램을 작성하시오(20분까지)

//조건 1. 처음 입력시에는 for 반복문을 사용해서 5명의 이름과 국영수 점수를 다 입력한다.
//조건 2. 입력후에는 무한루프를 통해서
//    내가 보고 싶은 학생의 이름과 점수, 총점, 평균만 볼수 있게 한다.
//예시:
//보고 싶은 학생의 번호를 입력하세요: (1입력)
//1번 김땡땡 학생
//국어: 80점 영어: 80점 수학: 81점
//총점: 241점 평균: 80.33점
//보고 싶은 학생의 번호를 입력하세요: (20000 입력)
//잘못입력하셨습니다.
//보고 싶은 학생의 번호를 입력하세요: (2입력)
//2번 최동동 학생
//국어: 70점 영어: 69점 수학: 68점
//총점: 207점 평균: 69점
//보고 싶은 학생의 점수를 입력하세요: (-1입력)
//사용해주셔서 감사합니다.

//Ex01에 반해 각 과목의 점수가 배열에 저장됨
//배열 a[i] = 5; -> 주소값아님, 갖고있는 값을 호출 


public class Ex02Array02 {
	
	final static int SIZE = 5;
	final static int NUMBER_OF_SUBJECT = 3; //과목수
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		//이름을 담당할 배열을 하나 만들자
	    String[] nameArray = new String[SIZE];
	    //국어을 담당할 배열
	    int[] korArray = new int[SIZE];
	    //영어을 담당할 배열
	    int[] engArray = new int[SIZE];
	    //수학을 담당할 배열
	    int[] mathArray = new int[SIZE];
	    
		for(int i = 0; i < nameArray.length; i++) { //i는 배열의 주소[0]~[4]
			System.out.print((i+1) + "번 학생의 이름 : ");
			nameArray[i] = bufferedReader.readLine();
			System.out.print(nameArray[i] + "학생의 국어점수 : ");
			korArray[i] = Integer.parseInt(bufferedReader.readLine());
			while(korArray[i] < 0 || korArray[i] > 100) {
	            System.out.println("잘못입력하셨습니다.");
	            System.out.print(nameArray[i]+" 학생의 국어점수 : ");
	            korArray[i] = Integer.parseInt(bufferedReader.readLine());
			}
			System.out.print(nameArray[i] + "학생의 영어점수 : ");
	        engArray[i] = Integer.parseInt(bufferedReader.readLine());
			while(engArray[i] < 0 || engArray[i] > 100) {
		        System.out.println("잘못입력하셨습니다.");
		        System.out.print(nameArray[i]+" 학생의 영어점수 : ");
		        engArray[i] = Integer.parseInt(bufferedReader.readLine());	            
	         }
			System.out.print(nameArray[i] + "학생의 수학점수 : ");
			mathArray[i] = Integer.parseInt(bufferedReader.readLine());
			while(mathArray[i] < 0 || mathArray[i] > 100) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.print(nameArray[i] + "학생의 수학점수 : ");
			}
		}//for
			
			
			//내가 보고싶은 학생의 정보 출력
			while(true) {
		         System.out.println("보고 싶은 학생의 번호를 입력하세요(1~5, -1은 종료): ");
		         System.out.print("> ");
		         
		         int userChoice = Integer.parseInt(bufferedReader.readLine());
		         if(userChoice == -1) {
		            //사용자가 종료를 선택했을 때
		            System.out.println("사용해주셔서 감사합니다.");
		            break;
		         }else if(userChoice >= 1 && userChoice <= 5) {
		            //학생 번호가 유효할때
		            int index = userChoice - 1;
		            System.out.println((index+1) + "번 " + nameArray[index] + "학생");
		            System.out.println("국어 : " + korArray[index] +"점 영어 : " + engArray[index] +"점  수학 : " + mathArray[index] + "점");
		            
		            int tot = korArray[index] + engArray[index] + mathArray[index];
					double avg = tot / (double)NUMBER_OF_SUBJECT;
					System.out.println("총점: "+ tot + "점 평균 : " + String.format("%.3f", avg));
					//System.out.println(nameArray[userChoice - 1]+" 학생의 총점: "+sumArray[userChoice - 1]);도 가능
		         }else {
		            //잘못입력했을 때
		            System.out.println("잘못입력하셨습니다.");
		         }
		      }//출력 while문
		}
	}


