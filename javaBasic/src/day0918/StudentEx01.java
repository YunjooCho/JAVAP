package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

//Student 클래스 배열을 ArratUtil을 사용해서 관리하는 프로그램
public class StudentEx01 {
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
	
	private static void printArray() {
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);//toStrong으로 인해 주소값이 아닌 객체 내용들이 나오게 됨
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
		
		System.out.print("국어 점수: ");
		s.setKorean(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("영어 점수: ");
		s.setEnglish(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("수학 점수: ");
		s.setMath(Integer.parseInt(bufferedReader.readLine()));
		
		return s;//정보가 입력된 객체를 반환
	}
}
