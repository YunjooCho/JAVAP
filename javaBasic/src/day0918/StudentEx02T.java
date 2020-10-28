package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

// 학생 등록에 추가적인 메소드를 더 만들어보자
// 1. 만약 학생번호와 이름이 같은 학생이 입력 되면 
//    잘못 입력했다고 알려주고 
//    중복이 아닌 학생이 입력될때까지 다시 입력을 받자
// 2. 잘못된 점수는 잘못 입력했다고 알려주고
//    올바른 점수가 들어올때 까지 다시 입력을 받자
public class StudentEx02T {
   private static BufferedReader bufferedReader;
   private static Student[] studentArray;

   public static void main(String[] args) throws NumberFormatException, IOException {
      studentArray = new Student[0];
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      showMenu();

   }

   private static void showMenu() throws NumberFormatException, IOException {
      while (true) {
         System.out.println("비트 성적 관리 프로그램");
         System.out.println("1. 입력 2. 출력 3. 종료");
         System.out.print("> ");
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         if (userChoice == 1) {
            //입력 메소드 실행
            add();
         } else if (userChoice == 2) {
            //출력 메소드 실행
            printArray();
         } else if (userChoice == 3) {
            System.out.println("사용해주셔서 감사합니다.");
            break;
         } else {
            System.out.println("잘못 입력하셨습니다.");
         }
      }
   }
   
   private static void printArray() throws NumberFormatException, IOException {
      System.out.println("==============================");
      System.out.println("번호\t이름");
      System.out.println("==============================");
      for(int i = 0; i < studentArray.length; i++) {
         System.out.printf("%d\t%s\n", (i+1), studentArray[i].getName());
      }
      System.out.println("상세보기할 번호를 눌러주세요(0은 뒤로가기): ");
      int userChoice = Integer.parseInt(bufferedReader.readLine())-1;
      //만약 userChoice가 올바르지 않으면, 다시 입력을 하도록 시킨다.
      //userchoice가 올바르지 않은 경우는 몇부터 몇인가?
      //userChocie가 -1미만이거나 studentArray.length - 1 초과이면
      while(userChoice < -1 || userChoice > studentArray.length - 1) {//사용자는 0부터 배열크기만큼 입력하지만 실제로 
    	  															  //userChoice에 입력되는 값은 -1 ~ (Array.length-1)임
         System.out.println("잘못된 번호입니다.");
         System.out.print("상세보기할 번호를 눌러주세요: ");
         userChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
      }
      if(userChoice == -1) {
         //메시지 만 출력
         System.out.println("메뉴로 돌아갑니다.");
      }else {
         //상세보기 메소드 호출
         printOne(userChoice);
      }
   }
   
   private static void printOne(int index) throws NumberFormatException, IOException {
      System.out.printf("%s학생의 정보\n", studentArray[index].getName());
      System.out.printf("학번: %d 이름: %s\n", studentArray[index].getId(), studentArray[index].getName());
      System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", 
            studentArray[index].getKorean(), studentArray[index].getEnglish(), studentArray[index].getMath());
      System.out.printf("총점: %03d점 평균: %.2f점\n", studentArray[index].calculateSum(), studentArray[index].calculateAverage());
      //수정, 삭제를 위한 입력을 받는다.
      System.out.println("=====================================");
      System.out.println("1. 수정 2. 삭제 3. 목록으로");
      int userChoice = Integer.parseInt(bufferedReader.readLine());
      if(userChoice == 1) {
         //수정 메소드 호출
         System.out.print("국어: ");
         studentArray[index].setKorean(validateScore());
         
         System.out.print("영어: ");
         studentArray[index].setEnglish(validateScore());
         
         System.out.print("수학: ");
         studentArray[index].setMath(validateScore());
         
         printOne(index);
         
      }else if(userChoice == 2) {
         //삭제 메소드 호출
         //삭제시에는 정말 삭제하시겠습니까? y/n 물어봐서
         //다시 요 메소드로 돌아온다.
         System.out.print("정말 삭제하시겠습니까? (y/n): ");
         String agree = bufferedReader.readLine();
         if(agree.equals("y")) {
            //삭제하고 학생목록 보기로 이동
            studentArray = ArrayUtil.removeByIndex(studentArray, index);
            printArray();
         }else if(agree.equals("n")) {
            printOne(index);
         }
      }else if(userChoice == 3) {
         printArray();
      }
   }
   
   
   private static void add() throws NumberFormatException, IOException {
      studentArray = ArrayUtil.add(studentArray, setStudentInfo());
   }
   
   
   private static Student setStudentInfo() throws NumberFormatException, IOException {
      Student s = new Student();
      System.out.print("학생 이름: ");
      s.setName(bufferedReader.readLine());
      
      System.out.print("학생 번호: ");
      s.setId(Integer.parseInt(bufferedReader.readLine()));
      // 우리가 이름과 번호를 입력하고 나서
      // 만약 해당 이름과 번호가 중복이면
      // 중복인걸 알려주고
      // 다시 이름과 번호를 입력받게 한다.
      // 즉 어레이유틸의 contains의 결과값이 true인 동안에는
      // 계속 입력을 받으면 되는 것이다!
      while(ArrayUtil.contains(studentArray, s)) {
         //중복된 이름과 번호이므로 다시 입력을 받는다.
         System.out.println("중복된 학생입니다.");
         System.out.println("다시 입력해주세요: ");
         System.out.print("학생 이름: ");
         s.setName(bufferedReader.readLine());
         
         System.out.print("학생 번호: ");
         s.setId(Integer.parseInt(bufferedReader.readLine()));
      }
      
      System.out.print("국어 점수: ");
      s.setKorean(validateScore());
      
      System.out.print("영어 점수: ");
      s.setEnglish(validateScore());
      
      System.out.print("수학 점수: ");
      s.setMath(validateScore());
      
      return s;
   }

   private static int validateScore() throws NumberFormatException, IOException {
      int score = Integer.parseInt(bufferedReader.readLine());
      
      while(score < 0 || score > 100) {
         System.out.println("잘못 입력하셨습니다.");
         System.out.print("다시 입력해주세요: ");
         score= Integer.parseInt(bufferedReader.readLine());
      }
      
      return score;
   }
}







