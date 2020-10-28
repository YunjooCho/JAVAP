package day0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import day0915.Student;

public class StudentEx01 {
	private static ArrayList<Student> list;
	private static BufferedReader bufferedReader;
	private static int id;
	public static void main(String[] args) throws NumberFormatException, IOException {
		list = new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		id = 1;
		
		showMenu();
	}
	
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("1.입력   2.출력   3.종료");
			System.out.print("> ");
			int choice = validateInt(1,3);
			if(choice == 1) {
				insert();
			}else if(choice == 2) {
				selectAll();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}
				
		}
	}
	
	private static void insert() throws IOException {
		//list에 추가할 Student객체를 하나 만든다.
		Student s = new Student();
		s.setId(id);
		id++;
		System.out.println("이름");
		System.out.print("> ");
		s.setName(bufferedReader.readLine());
		
		System.out.println("국어 점수");
		s.setKorean(validateInt(0,100));
		
		System.out.println("영어 점수");
		s.setEnglish(validateInt(0,100));
		
		System.out.println("수학 점수");
		s.setMath(validateInt(0,100));
		
		list.add(s);
	}
	
	private static void selectAll() throws IOException {
		for(int i = 0; i < list.size();i++) {
			System.out.printf("%d. %s\n", i+1, list.get(i).getName());
		}
		System.out.println("상세보기할 번호를 입력해주세요 (0은 종료)");
		int userChoice = validateInt(0, list.size()) - 1;
		if(userChoice == -1) {
			
		}else {
			selectOne(userChoice);
		}
	}
	
	private static void selectOne(int index) throws IOException {
		Student s = list.get(index);
		System.out.printf("이름 : %s 학번 : %d\n", s.getName(), s.getId());
		System.out.printf("국어 : %d 영어 : %d 수학 : %d", s.getKorean(), s.getEnglish(), s.getMath());
		System.out.printf("총점 : %d 평균 : %.2f\n", s.calculateSum(), s.calculateAverage());
		System.out.println("1.수정   2. 삭제   3.목록으로");
		int userChoice = validateInt(1,3);
		if(userChoice == 1) {
			update(index);
		}else if(userChoice == 2) {
			delete(index);
		}else if(userChoice == 3) {
			selectAll();
		}
	}
	
	private static void update(int index) throws IOException {
		System.out.println("이름");
		System.out.print("> ");
		list.get(index).setName(bufferedReader.readLine());
		System.out.println("국어");
		System.out.print("> ");
		list.get(index).setKorean(validateInt(0,100));
		System.out.println("이름");
		System.out.print("> ");
		list.get(index).setEnglish(validateInt(0,100));
		System.out.println("이름");
		System.out.print("> ");
		list.get(index).setMath(validateInt(0,100));
		selectOne(index);

	}
	
	
	
	private static void delete(int index) throws IOException {
		System.out.println("정말로 삭제하시겠습니까?");
		System.out.print("> ");
		String yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			list.remove(index);
			selectAll();
		}else if(yn.equals("N")) {
			selectOne(index);
		}
	}
	
	
	//숫자의 유효값확인 메소드와 숫자-글자 확인 메소드 따로 만들 것!!!
	private static int stringToInteger() throws IOException {
		String userInput = bufferedReader.readLine();
		while(!userInput.matches("\\d*")) {
			System.out.println("숫자만 입력해주세요");
			System.out.print("> ");
			userInput = bufferedReader.readLine();
		}
		return Integer.parseInt(userInput);
	}
	
	
	//키보드로 입력된 값을 stringToInteger()에서 글자일땐 반복문 실행, 숫자일땐 정수화하여 출력
	//정수화된 값이 유효한지 확인
	private static int validateInt(int minimum, int maximum) throws IOException {
		int value = stringToInteger(); 
		while(value < minimum || value > maximum) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			System.out.print("> ");
			value = stringToInteger();
		}
		return value;
	}
	
}

