package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01ArrayT {

	final static int SIZE = 5;
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	      //이름을 담당할 배열을 하나 만들자
	      String[] nameArray = new String[SIZE];
	      //총점을 담당할 배열을 하나 만들자
	      int[] sumArray = new int[SIZE];
	      
	      //차례대로 입력을 해보자
	      for(int i = 0; i < SIZE; i++) {
	         System.out.print((i+1)+"번 학생의 이름: ");
	         nameArray[i] = bufferedReader.readLine();
	         System.out.print(nameArray[i]+" 학생의 국어점수: ");
	         int korean = Integer.parseInt(bufferedReader.readLine());
	         while(korean < 0 || korean > 100) {
	            System.out.println("잘못입력하셨습니다.");
	            System.out.print(nameArray[i]+" 학생의 국어점수: ");
	            korean = Integer.parseInt(bufferedReader.readLine());
	         }
	         System.out.print(nameArray[i]+" 학생의 영어점수: ");
	         int english = Integer.parseInt(bufferedReader.readLine());
	         while(english < 0 || english > 100) {
	            System.out.println("잘못입력하셨습니다.");
	            System.out.print(nameArray[i]+" 학생의 영어점수: ");
	            english = Integer.parseInt(bufferedReader.readLine());
	         }
	         
	         System.out.print(nameArray[i]+" 학생의 수학점수: ");
	         int math = Integer.parseInt(bufferedReader.readLine());
	         while(math < 0 || math > 100) {
	            System.out.println("잘못입력하셨습니다.");
	            System.out.print(nameArray[i]+" 학생의 수학점수: ");
	            math = Integer.parseInt(bufferedReader.readLine());
	         }
	         
	         sumArray[i] = korean+english+math;
	      }
	      //보고 싶은 학생의 번호를 입력하면 그 학생의 정보를 출력하게 만들어보자
	      System.out.print("보고 싶은 학생의 번호를 입력하세요(1~5): ");
	      int userChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
	      
	      System.out.println(nameArray[userChoice]+" 학생의 총점: "+sumArray[userChoice]);
	      
	      //20분동안 여러분들은 출력하는 부분을 
	      //무한루프로 만드시고
	      //만약 사용자가 보고 싶은 학생의 번호를 입력할 때 - 1을 입력하면 프로그램이 종료
	      //혹은 사용자가 잘못된 번호를 입력하면 잘못입력하셨습니다. 다시 입력해주세요~라고 입력하게 프로그램을 개조해보세요.
	      //예시
	      //보고싶은 학생: 3
	      //3번 학생의 총점: 218점
	      //보고싶은 학생: 4
	      //4번 학생의 총점: 299점
	      //보고싶은 학생: 99
	      //잘못입력하셨습니다.
	      //보고싶은 학생: -1
	      //사용해주셔서 감사합니다.
	      
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
