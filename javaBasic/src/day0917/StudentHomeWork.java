package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

//동적할당이 되는 배열버전
public class StudentHomeWork {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1.배열 선언(동적할당)
		Student[] studentArray =  new Student[0]; //동적할당 배열이라서 [0]이 옴

		//2.메모리 생성
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//3-2.메뉴 출력
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//입력 메소드 실행
				studentArray = add(studentArray, bufferedReader); //손으로 입력한 학생정보와 배열정보가 필요
			}else if(userChoice == 2){
				//출력 메소드 실행
				printArray(studentArray);
			}else if(userChoice == 3){
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 입력해주세요.");
			}
		}//메뉴 while문
		
	}
	//6. 배열 출력 메소드 - 여태까지 객체 출력은 있었으나 배열출력 메소드는 없었음
	private static void printArray(Student[] studentArray) { //private라 CarEx06은 영향받지 않음
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);
		}
	}
	
	//5.ArrayUtil에서 제작한 배열에 요소를 추가해 배열을 늘리는 메소드 + 객체에 정보를 입력해 반환하는 메소드
	//  두가지를 통해 객체에 정보를 입력한 후, 배열에 추가하여 배열을 늘림
	private static Student[] add(Student[] studentArray, BufferedReader bufferedReader) throws NumberFormatException, IOException {
		studentArray = ArrayUtil.add(studentArray, setStudentInfo(bufferedReader));
		
		return studentArray;
	}
	
	//4. 객체에 학생정보를 입력하는 메소드
	private static Student setStudentInfo(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		Student s = new Student();//Student.java에서 생성자 구현
		System.out.print("이름 : ");//Student.java에서 구현
		s.setName(bufferedReader.readLine());
		
		System.out.print("학번 : ");//Student.java에서 구현
		s.setId(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("국어점수 : ");//Student.java에서 구현
		s.setKorean(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("영어점수 : ");//Student.java에서 구현
		s.setEnglish(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("수학점수 : ");//Student.java에서 구현
		s.setMath(Integer.parseInt(bufferedReader.readLine()));
		
//		System.out.println("총점 : ");//Student.java에서 구현
//		s.calculateSum();
//		
//		System.out.println("평균 : ");//Student.java에서 구현
//		s.calculateAverage();
		
		return s;
		
	}
	
	//3-1.메뉴 메소드
	private static void showMenu() {
		System.out.println("=======================");
		System.out.println("학생 정보 관리 프로그램");
		System.out.println("1.입력 2.출력 3.종료");
		System.out.println("=======================");
		System.out.print("메뉴선택 > ");
	}
}



//<질문>
//1.이 class의 add는 ArrayUtil.add의 상속?
//2.여기서 총점과 평균을 출력하려면? - 애초에 필드가 없고 메소드만 존재, 필드를 만들어 줘야함? 필드가 없으므로 생성자에서 총점과 평균을 초기화 하고 있지도 않음
//                          - 아니면 메소드만 있어도 구현이 가능?

