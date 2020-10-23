package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

import day0916.CarT;
import util.ArrayUtil;

//자동차 관리 프로그램을 ArrayList로 작성하세요(
public class CarEx01 {
	//필드선언
	private static ArrayList<CarT> carList;
	private static BufferedReader bufferedReader;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		carList = new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		showMenu();
		
	}//main

	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("차량 관리 프로그램");
			System.out.println("1. 입력  2. 출력  3. 종료");
			System.out.print("> ");
			int choice = validateNumber(1,3);
			if(choice == 1) {
				//입력 메소드 호출
				add();
			}else if(choice == 2) {
				//출력 메소드 호출
				printAll();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}//while
	}//showMenu
	
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(bufferedReader.readLine());
		while(value < minimum || value > maximum) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		return value;
	}
	
	private static void add() throws NumberFormatException, IOException {
		CarT c = new CarT();
		System.out.print("차량 번호 : ");
		c.setNumber(bufferedReader.readLine());
		while(carList.contains(c)) {//객체배열->어레이리스트 수정부분
			System.out.println("이미 존재하는 차량번호입니다.");
			System.out.print("차량 번호: ");
			c.setNumber(bufferedReader.readLine());
		}
		System.out.print("차량 종류 : ");
		c.setType(bufferedReader.readLine());
		System.out.print("차량 연식 : ");
		c.setYear(validateNumber(2000, 2020));
		System.out.print("차량 가격 : ");
		c.setPrice(Integer.parseInt(bufferedReader.readLine()));
		System.out.print("차량 색상 : ");
		c.setColor(bufferedReader.readLine());
		
		carList.add(c);//객체배열->어레이리스트 수정부분
	}//add
	
	
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("    차 량 목 록");
		System.out.println("일련번호   |  차량번호");
		for(int i = 0; i < carList.size();i++) {
			System.out.printf("%d.\t%s\n", (i+1), carList.get(i).getNumber());
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("상세정보를 확인할 차량의 일련번호를 선택하세요(0은 메인메뉴로 돌아가기):");
		int number = validateNumber(0, carList.size()) - 1;
		if(number == -1) {
			System.out.println("메인메뉴로 돌아갑니다");
		}else {
			printOne(number);
		}
	}//printAll
	
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		DecimalFormat df = new DecimalFormat("#,###");
		CarT c = carList.get(index);
		System.out.println("-------------------------------------------");
		System.out.printf("차량 번호 : %s, 차량 종류 : %s\n", c.getNumber(), c.getType());
		System.out.printf("차량 연식 : %d년, 차량 가격 : %s\n원", c.getYear(), df.format((long)c.getPrice()));
		System.out.printf("차량 색상 : %s\n", c.getColor());
		System.out.println("-------------------------------------------");
		System.out.println("1.등록정보 수정  2.등록정보 삭제  3.차량 목록으로 돌아가기");
		int selectNumber = validateNumber(1,3);
		if(selectNumber == 1) {
			update(index);
		}else if(selectNumber == 2) {
			delete(index);
		}else if(selectNumber == 3) {
			System.out.println("차량 목록으로 돌아갑니다.");
		}
	}
	
	
	private static void update(int index) throws NumberFormatException, IOException {
		
		System.out.print("차량 색상 : ");
		carList.get(index).setColor(bufferedReader.readLine());
		System.out.print("차량 연식 : ");
		carList.get(index).setYear(Integer.parseInt(bufferedReader.readLine()));
		System.out.print("차량 가격 : ");
		carList.get(index).setPrice(Integer.parseInt(bufferedReader.readLine()));
		
		printOne(index);
	
	}
	
	
	private static void delete(int index) throws IOException {
		System.out.print("정말로 삭제하시겠습니까?(Y/N): ");
		String yn = new String();
		yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			carList.remove(index);
			printAll();
		}else if(yn.equals("N")) {
			printOne(index);
		}else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			yn = new String().toUpperCase();
		}
	}
	
	
}//class
