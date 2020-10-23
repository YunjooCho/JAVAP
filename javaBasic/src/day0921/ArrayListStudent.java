package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import day0915.Student;

//숙제:
//Student를 어레이리스트 버젼으로 만드세요
//단 숫자를 입력할때 문자가 입력되면
//잘못입력하셨으니 다시 숫자만 입력하세요
//가 뜨도록 만드세요

//+중복 학생 확인, 
//+yn 잘못입력 했을 시 제대로 된 값이 입력될 때까지 반복

public class ArrayListStudent {

	//1.필드선언
	private static BufferedReader bufferedReader;
	private static ArrayList<Student> studentList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.필드 초기화
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		studentList = new ArrayList<>();
		
		showMenu();
	}
	
	//3.메뉴 메소드
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("학생 정보 관리 프로그램");
			System.out.println("1.입력   2.출력   3.종료");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("메뉴선택 ");
			int choice = validateNumber(1,3);
			if(choice == 1) {
				//입력메소드 호출
				add();
			}else if(choice == 2) {
				//출력메소드 호출
				printAll();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시 입력하세요");
			}
		}//showMenu
	}
	
	//4.유효값 확인 메소드(범위)
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		System.out.print("(숫자를 입력해주세요) : ");
		String inputWord = new String();
		inputWord = bufferedReader.readLine();
		while(!inputWord.matches("\\d*")) {
			System.out.print("숫자만 입력해주세요 : ");
			inputWord = bufferedReader.readLine();
		}
		int value = Integer.parseInt(inputWord);
		if(value < minimum || value > maximum) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		
		return value;
	}//validateNumber
	
	//4-2.유효값 확인 메소드(숫자, 글자)
	private static int validateNumber() throws IOException {
		System.out.print("(숫자를 입력해주세요) : ");
		String inputWord = new String();
		inputWord = bufferedReader.readLine();
		while(!inputWord.matches("\\d*")) {
			System.out.print("숫자만 입력해주세요 :");
			inputWord = bufferedReader.readLine();
		}
		int value = Integer.parseInt(inputWord);
		return value;
	}
	
	//5. 입력 메소드
	private static void add() throws NumberFormatException, IOException {
		Student s = new Student();
		System.out.print("이름 : ");
		s.setName(bufferedReader.readLine());
		System.out.print("학번 ");
		s.setId(validateNumber());
		while(studentList.contains(s)) {
			System.out.println("중복된 학생입니다.다시 입력해주세요.");
			System.out.print("> ");
			s.setName(bufferedReader.readLine());
		}
		System.out.print("국어점수 ");
		s.setKorean(validateNumber(0,100));
		System.out.print("영어점수 ");
		s.setEnglish(validateNumber(0,100));
		System.out.print("수학점수 ");
		s.setMath(validateNumber(0,100));
		
		studentList.add(s);
		
	}//add
	
	
	//6.출력 메소드
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("-----------------");
		System.out.println("학 생 정 보 목 록");
		System.out.println("일련번호 | 이름 ");
		for(int i = 0; i < studentList.size(); i++) {
			System.out.printf("%d.  %s\n", (i+1), studentList.get(i).getName());
		}
		System.out.println("-----------------");
		System.out.println("열람할 학생번호를 선택해주세요(0은 메인메뉴로)");
		int selectNumber = validateNumber(0,studentList.size()) - 1;
		if(selectNumber == -1) {
			System.out.println("메인메뉴로 돌아갑니다.");
		}else {
			printOne(selectNumber);
		}
	}
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		System.out.println("-----------------");
		System.out.println("상 세 정 보 보 기");
		System.out.printf("학생번호 : %d, 이름 : %s\n", studentList.get(index).getId(), studentList.get(index).getName());
		System.out.printf("국어점수 : %03d점, 영어점수 : %03d, 수학점수 : %03d\n", studentList.get(index).getKorean(),studentList.get(index).getEnglish(),studentList.get(index).getMath());
		System.out.printf("총점 : %03d점, 평균 : %.3f점\n", studentList.get(index).calculateSum(), studentList.get(index).calculateAverage());
		System.out.println("-----------------");
		System.out.println("1.수정   2.삭제   3.목록으로");
		int choice = validateNumber(1,3);
		if(choice == 1) {
			update(index);
		}else if(choice == 2) {
			delete(index);
		}else if(choice == 3) {
			printAll();
		}
	}//printOne
	
	
	private static void update(int index) throws NumberFormatException, IOException {
		
		System.out.print("국어점수 : ");
		studentList.get(index).setKorean(validateNumber(0,100));
		System.out.print("영어점수 : ");
		studentList.get(index).setEnglish(validateNumber(0,100));
		System.out.print("수학점수 : ");
		studentList.get(index).setMath(validateNumber(0,100));
		
		printOne(index);
	}//update
	
	
	private static void delete(int index) throws NumberFormatException, IOException {
		System.out.print("정말로 삭제하시겠습니까?(Y/N) : ");
		String yn = new String();
		yn = bufferedReader.readLine().toUpperCase();
		while(true) {
			if(yn.equals("Y")) {
				studentList.remove(index);
				printAll();
			}else if(yn.equals("N")) {
				printOne(index);
			}else {
				
					System.out.println("잘못입력하셨습니다.다시 입력하세요.");
					System.out.print("> ");
					yn = bufferedReader.readLine().toUpperCase();
			}
		}
	}
}

