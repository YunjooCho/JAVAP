package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04MultiArray03 {

	//최대 학생 수 체크용 상수
	   final static int STUDENT_SIZE = 10;
	   //반의 총 갯수
	   final static int CLASS_NUMBER = 4;
	   
	   public static void main(String[] args) throws NumberFormatException, IOException {
	      // 입력을 받을때 사용할 BufferedReader 변수 (= 객체) 생성
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	      // 점수를 저장할 int[][][] scoreArray 생성
	      //3차원 : int[][][] scoreArray = new int[CLASS_NUMBER][][];
	      
	      //2차원
	      int[][] koreanArray = new int[CLASS_NUMBER][];
	      int[][] englishArray = new int[CLASS_NUMBER][];
	      int[][] mathArray = new int[CLASS_NUMBER][];
	      
	      while(true) {
	         //메뉴 메소드 호출
	         showMenu();
	         int choice = Integer.parseInt(bufferedReader.readLine());
	         if(choice == 1) {
	            //성적을 입력하기
	            
	            //1. 반을 선택한다.
	            int classNumber = selectClassNumber(bufferedReader);
	            //2. 학생 규모를 선택한다.
	            int studentSize = selectStudentSize(bufferedReader);
	            //3. for문을 이용해서 학생의 성적을 차례대로 넣어준다.
	            //3차원 : scoreArray[classNumber] = new int[studentSize][3];
	            
	            koreanArray[classNumber] = new int[studentSize];
	            englishArray[classNumber] = new int[studentSize];
	            mathArray[classNumber] = new int[studentSize];
	            
	            for(int i = 0; i < koreanArray[classNumber].length; i++) {
	               System.out.println((i+1)+"번 학생의 점수 입력");
	               //3차원
//	               scoreArray[classNumber][i][0] = validateScore(bufferedReader, 1);
//	               scoreArray[classNumber][i][1] = validateScore(bufferedReader, 2);
//	               scoreArray[classNumber][i][2] = validateScore(bufferedReader, 3);
	               
	               koreanArray[classNumber][i] = validateScore(bufferedReader,1);
	               englishArray[classNumber][i] = validateScore(bufferedReader,2);
	               mathArray[classNumber][i] = validateScore(bufferedReader,3);
	            }
	            
	         }else if(choice == 2) {
	            //성적을 출력하기
	            //1. 반을 입력받는다.
	            int classNumber = selectClassNumber(bufferedReader);
	            
	            //2. 해당 반이 초기화되었는지 체크한다.
	            if(koreanArray[classNumber] == null) {
	               //아직 초기화 안되있으므로 경고 메시지 출력
	               System.out.println("아직 입력이 되지 않은 반입니다.");
	            }else {
	            //3. 초기화 되어있으면 출력한다.
	               for(int i = 0; i < koreanArray[classNumber].length; i++) {
	                  System.out.println("=======================");
	                  System.out.println((i+1)+"번 학생의 점수");
	                  System.out.printf("국어:%3d점 영어:%3d점 수학:%3d점\n", 
	                        koreanArray[classNumber][i], englishArray[classNumber][i], mathArray[classNumber][i]);
	               }
	            }
	         }else if(choice == 3) {
	            System.out.println("사용해주셔서 감사합니다.");
	            break;
	         }else {
	            System.out.println("잘못입력하셨습니다.");
	         }
	      }
	   }
	   static void showMenu() {
	      System.out.println("======================");
	      System.out.println("비트고등학교 성적관리 프로그램");
	      System.out.println("======================");
	      System.out.println("|\t1. 입력\t|");
	      System.out.println("|\t2. 출력\t|");
	      System.out.println("|\t3. 종료\t|");
	   }
	   static int selectClassNumber(BufferedReader reader) throws NumberFormatException, IOException {
	      System.out.println("반을 선택해주세요");
	      System.out.print("> ");
	      int classNumber = Integer.parseInt(reader.readLine());
	      while(classNumber < 1 || classNumber > CLASS_NUMBER) {
	         System.out.println("잘못입력하셨습니다.");
	         System.out.println("반을 선택해주세요");
	         System.out.print("> ");
	         classNumber = Integer.parseInt(reader.readLine());
	      }
	      
	      return classNumber - 1;
	   }
	   static int selectStudentSize(BufferedReader reader) throws NumberFormatException, IOException {
	      System.out.println("학생 숫자를 선택해주세요");
	      System.out.print("> ");
	      int studentSize = Integer.parseInt(reader.readLine());
	      
	      while(studentSize < 0 || studentSize > STUDENT_SIZE) {
	         System.out.println("잘못입력하셨습니다.");
	         System.out.println("학생 숫자를 선택해주세요");
	         System.out.print("> ");
	         studentSize = Integer.parseInt(reader.readLine());
	      }
	      
	      return studentSize;
	   }
	   static int validateScore(BufferedReader reader, int code) throws NumberFormatException, IOException {
	      String message = new String();
	      switch(code) {
	      case 1:
	         message = "국어";
	         break;
	      case 2:
	         message = "영어";
	         break;
	      case 3:
	         message = "수학";
	         break;
	      }
	      message += " 점수를 입력해주세요.";
	      System.out.println(message);
	      System.out.print("> ");
	      int score = Integer.parseInt(reader.readLine());
	      while(score < 0 || score > 100) {
	         System.out.println("잘못 입력하셨습니다.");
	         System.out.println(message);
	         System.out.print("> ");
	         score = Integer.parseInt(reader.readLine());
	      }
	      
	      return score;
	   }

}
