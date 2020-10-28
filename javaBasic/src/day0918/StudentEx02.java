package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

//학생 등록에 추가적인 메소드를 더 만들어보자
// 1. 만약 학생번호와 이름이 같은 학생이 입력되면
//    잘못 입력했다고 알려주고  ▶for문&if문?돌아가는 동안 arr[i] = arr[0],[1],[2],[3] : 놉, contains메소드사용
//    중복이 아닌 학생이 입력될때까지 다시 입력을 받자
// 2. 잘못된 점수는 잘못 입력했다고 알려주고
//    올바른 점수가 들어올때까지 다시 입력을 받자
public class StudentEx02 {
	private static BufferedReader bufferedReader; //★메소드에서 사용하고자 하는 매개변수(파라미터)가 필드로 저장되어 있으면 파라미터 사용할 필요없이 바로 가져다 쓸 수 있다
												  //필드, 이전에는 메소드 실행시 객체로 받았었음(파라미터)
											      //calculateSum()에서 파라미터를 사용하지 않은 이유 : 과목이 필드로 저장되어 있었기 때문
												  //Null로 초기화
	private static Student[] studentArray;//필드 위와 같은 이유료 필드화함
	public static void main(String[] args) throws NumberFormatException, IOException {
		studentArray = new Student[0]; //배열 초기화
		bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //초기화
		
		//메인메소드에서 초기화, 즉 생성자를 호출하고 나서부터는
		//만약 메인메소드가 다른 메소드를 그 이후에 호출하게 된다면
		//이미 초기화가 된 상태이기 때문에 NullPointerException이 발생하지 않고
		//정상적으로 사용할 수 있다.
		
			showMenu();//while문도, if조건문도 메소드로 보냄
		
	}//main메소드
	
	private static void showMenu() throws NumberFormatException, IOException{ //여기서 다른 메소드를 호출할 예정, 또 호출된 메소드가 또 다른 메소드를 호출
		while(true) {
			System.out.println("비트 성적 관리 프로그램");
			System.out.println("1.입력  2.출력  3.종료");
			System.out.print("> ");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//입력메소드 실행
				add();
			}else if(userChoice == 2) {
				//출력메소드 실행
				printArray();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
	
	private static void printArray() throws NumberFormatException, IOException {
		System.out.println("============================");
		System.out.println("번호\t이름");
		System.out.println("============================");
		for(int i = 0; i < studentArray.length; i++) {
			System.out.printf("%d\t%s\n",(i+1),studentArray[i].getName());//toStrong으로 인해 주소값이 아닌 객체 내용들이 나오게 됨
																		  //1,2,3,4....로 출력,이름은 studentArray[0],[1],[2],[3]...
		}
		
		System.out.print("상세보기할 번호를 입력해주세요(0은 뒤로가기): ");
		int userChoice = Integer.parseInt(bufferedReader.readLine())-1; //-1,0,1,2,3.....:배열의 인덱스
		//만약 userChoice가 올바르지 않으면, 다시 입력을 하도록 시킨다.
		//userChoice가 올바르지 않은 경우는 몇부터 몇인가?
		//userChoice가 -1미만이거나 studentArray.length - 1 초과이면 (-1과 배열의 인덱스값으로 들어올수 있는 값이 아니면 올바르지 않음)
		while(userChoice < -1 || userChoice > studentArray.length - 1 ) {			                               
			System.out.println("잘못된 번호입니다.");
			System.out.print("상세보기할 번호를 입력해주세요(0은 뒤로가기): ");
			userChoice = Integer.parseInt(bufferedReader.readLine())-1; 
		}
		if(userChoice == -1) {
			//메시지만 출력
			System.out.println("메뉴로 돌아갑니다."); //본 메시지 외에 아무 처리없이 main메소드로 돌아감
		}else {
			//상세보기 메소드 호출
			printOne(userChoice);
		}
	}
	
	private static void printOne(int index) throws NumberFormatException, IOException{ //본 메소드가 호출되는 printArray를 보면 ()안에 userChoice(배열의 인덱스)를 써주었음
											 //userChoice를 파라미터로(index)로 받아 사용
		System.out.printf("%s 학생의 정보\n", studentArray[index].getName());
		System.out.printf("학번 : %d, 이름 : %s\n", studentArray[index].getId(),studentArray[index].getName());
		System.out.printf("국어 : %03d점, 영어 : %03d점, 수학 : %03d점\n", 
				studentArray[index].getKorean(), studentArray[index].getEnglish(), studentArray[index].getMath());
		System.out.printf("총점 : %03d점, 평균 : %.2f점\n", 
				studentArray[index].calculateSum(), studentArray[index].calculateAverage());
		//수정, 삭제를 위한 입력을 받는다
		System.out.println("===============================");
		System.out.println("1.수정 2.삭제 3.목록으로");
		int userChoice = Integer.parseInt(bufferedReader.readLine());
		 if(userChoice == 1) {
	         //수정 메소드 호출
	         System.out.println("국어 : ");
	         studentArray[index].setKorean(validateScore());
	         
	         System.out.println("영어 : ");
	         studentArray[index].setEnglish(validateScore());
	         
	         System.out.println("수학 : ");
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
	
	private static void add() throws NumberFormatException, IOException {//버퍼리더, 배열을 필드에 넣어주었기 때문에 파라미터 입력하지 않아도 사용할 수 있음
		studentArray = ArrayUtil.add(studentArray, setStudentInfo());
		
	}
	
	private static Student setStudentInfo() throws NumberFormatException, IOException {//버퍼리더를 필드에 넣어주었기 때문에 파라미터 입력하지 않아도 사용할 수 있음
		Student s = new Student();   //s라는 객체를 생성, 초기화(기본형은 0, 참조형은 null)
		System.out.print("학생 이름: ");
		s.setName(bufferedReader.readLine()); //name필드가 private로 접근제한되어있기 때문에 setName()메소드로 설정값을 입력해줌 
		
		System.out.print("학생 번호: ");
		s.setId(Integer.parseInt(bufferedReader.readLine()));
		//우리가 이름과 번호를 입력하고 나서
		//만약 해당 이름과 번호가 중복이면
		//중복인걸 알려주고
		//다시 이름과 번호를 입력받게 한다(이름만 같은건 상관없음)
		//즉 어레이유틸의 contains의 결과값이 true인 동안에는
		//계속 입력을 받으면 되는 것이다!
		while(ArrayUtil.contains(studentArray, s)) { //외부에서 만든 메소드를 사용했기때문에 클래스명.메소드()로 사용
			//중복된 이름과 번호이므로 다시 입력을 받는다.
			System.out.println("중복된 학생입니다.");
			System.out.println("다시 입력해주세요");
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
		
		return s;//정보가 입력된 객체를 반환
	}
	
	private static int validateScore() throws NumberFormatException, IOException {
		int score = Integer.parseInt(bufferedReader.readLine());
		
		while(score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다");
			System.out.print("다시 입력해주세요: ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		
		return score;
	}
}
