package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import day0916.CarT;
import util.ArrayUtil;

//차량관리 프로그램
//1. 입력
// 입력시에는 배열에 이미 똑같은 번호가 있을 시에는 차량 번호를 다시 입력받게 하세요
//2. 목록 출력
// 목록 출력시에는  
//         1. 차량번호
//         2. 차량번호
//         3. 차량번호
// 의 형식으로 목록이 출력되고 사용자가 번호를 선택하여 상세보기로 들어갈 수 있게 하세요
//3. 상세 보기
// 목록에서 선택한 번호의 차량 상세보기로 들어가면
// 차량 번호 차량 종류 차량 색상
// 차량 연식 차량 가격
//   예시) 차량번호: 00가 0000 차량종류: 벤츠 차량색상: 검은색
//        차량연식: 2020 년형  차량가격: 20000000원 
// 이 출력되고 
// 수정 삭제 목록돌아가기 가 출력되게 만드세요
// A) 수정
//    수정에는 색상, 연식, 가격을 수정할 수 있게 만드세요.
// B) 삭제
//    삭제 시에는 사용자가 동의하면 삭제하고 목록으로 이동하고 동의하지 않을 시에는 해당 차량의 개별보기 페이지로 이동하세요
// C) 목록보기
//    다시 목록으로 이동합니다.
public class CarEx01 {
	//1.필드선언
	private static BufferedReader bufferedReader;
	//private static DecimalFormat decimalFormat;
	private static CarT[] carArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.배열선언
		carArray = new CarT[0];	
		//3.버퍼리더 초기화
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
				
		showMenu();
		
	}//main
	
	
	//3.메뉴 메소드 - 메뉴 선택 집어넣기
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("==============================");
			System.out.println("차량 관리 프로그램");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("> ");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//입력메소드 
				add();
			}else if(userChoice == 2) {
				//출력메소드
				printAll();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시 메뉴를 선택해 주세요.");
			}
		}//메뉴 while
	}//메뉴 메소드
	
	
	//4.객체에 정보를 입력하는 메소드
	private static CarT setCarInfo() throws NumberFormatException, IOException {
		CarT c = new CarT();
		System.out.print("차량 번호: ");
		c.setNumber(bufferedReader.readLine());
		//중복확인
		while(ArrayUtil.contains(carArray, c)) {
			System.out.println("이미 존재하는 차량번호입니다.");
			System.out.print("차량 번호: ");
			c.setNumber(bufferedReader.readLine());
		}
		
		System.out.print("차량 종류: ");
		c.setType(bufferedReader.readLine());
		
		System.out.print("차량 색상: ");
		c.setColor(bufferedReader.readLine());
		
		System.out.print("차량 연식: ");
		c.setYear(validateIntegerValue(2000, 2020));
		
		System.out.print("차량 가격: ");
		c.setPrice(validateIntegerValue(0));
		
		return c;
		
	}//setCarInfo 메소드
	
	//8-1. 차량 가격의 값 확인(오버로딩 1)
	private static int validateIntegerValue(int minimum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(bufferedReader.readLine());
		while(value < minimum) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			System.out.println("> ");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		
		
		return value;
	}
	
	//8-2. 차량 연식의 값 확인(오버로딩 2)
	private static int validateIntegerValue(int minimum, int maximum) throws NumberFormatException, IOException {
			int value = Integer.parseInt(bufferedReader.readLine());
			while(value < minimum || value > maximum) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				System.out.println("> ");
				value = Integer.parseInt(bufferedReader.readLine());
			}
			
			return value;
		}
	
	
	//5.4를 통해 얻은 객체정보를 배열에 추가하는 메소드
	private static void add() throws NumberFormatException, IOException {//setCarInfo때문
		carArray = ArrayUtil.add(carArray, setCarInfo()); 				 //ArrayUtil로 배열 증가
		//원형 : carArray = ArrayUtil.add(carArray, c); //객체c        	 //증가된 부분에 추가할 객체는 setCarInfo로 생성하여 정보 입력 후 추가
	}
	
	
	//6.배열을 출력하는 메소드 - 일부 > 상세 (메뉴2)
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("--------------------");
		System.out.println("일련번호\t차량 번호");
		for(int i = 0; i < carArray.length; i++) {
			System.out.printf("%d. \t%s\t\n", (i+1), carArray[i].getNumber());
		}
		System.out.println("--------------------");
		System.out.println("개별 보기할 차량번호를 선택해 주세요(0은 종료)");
		System.out.print("> ");
		int userCarNumber = validateIntegerValue(0, carArray.length) - 1; //0은 최소값, carArray.length-1은 최대값, 출력값은 하나
//		while(userCarNumber < -1 || userCarNumber > carArray.length - 1) { //사용자는 0부터 배열크기만큼 입력하지만 실제로 
//																	 //userCarNumber에 입력되는 값은 -1 ~ (Array.length-1)임
//			System.out.print("잘못 입력하셨습니다. 차량번호를 다시 선택해 주세요: ");
//			userCarNumber = Integer.parseInt(bufferedReader.readLine());
//		}
		if(userCarNumber == -1) {
			System.out.println("메인화면으로 돌아갑니다.");
		}else {
			//7번 메소드를 표시(상세보기 메소드 호출)
			printOne(userCarNumber);
		}
	}//printArray
		
	
	//7.출력할 상세정보를 표현하는 메소드 - 수정, 삭제, 목록
	// 차량 번호 차량 종류 차량 색상
	// 차량 연식 차량 가격
	private static void printOne(int index) throws NumberFormatException, IOException { //printArray의 userSelect를 파라미터로 받음
		DecimalFormat format = new DecimalFormat("#,###");//버퍼리더처럼 필드 선언도 가능하나 여기서 하지 않는이유는 사용하는 곳이 여기뿐이라 굳이 할 필요 없음
		System.out.println("==============================");
		System.out.printf("%s 차량의 정보\n", carArray[index].getNumber());
		System.out.printf("차량 번호 : %s, 차량 종류 : %s, 차량 색상 : %s\n", carArray[index].getNumber(), carArray[index].getType(),carArray[index].getColor());
		System.out.printf("차량 연식 : %d년, 차량 가격 : %s원\n", carArray[index].getYear(),format.format((long) carArray[index].getPrice()));
		
		//수정, 삭제를 위한 메뉴 선택
		System.out.println("==============================");
		System.out.println("1.수정  2.삭제  3.목록으로 돌아가기 ");
		int userSelect = validateIntegerValue(1,3);
		if(userSelect == 1) {
			update(index); //차량 색상, 연식, 가격을 수정하는 메소드
		}else if(userSelect == 2) {
			delete(index);
		}else if(userSelect == 3) {
			printAll();
		}
	}//printOne
	
	
	//9. 차량 색상, 연식, 가격을 수정하는 메소드
	private static void update(int index) throws NumberFormatException, IOException {
		System.out.println("차량 색상:");
		carArray[index].setColor(bufferedReader.readLine());
		
		System.out.println("차량 연식:");
		carArray[index].setYear(validateIntegerValue(2000, 2020));
		
		System.out.println("차량 가격:");
		carArray[index].setPrice(validateIntegerValue(0));
		
		printOne(index);
		
	}//update
	
	
	//10.차량 정보를 삭제하는 메소드
	private static void delete(int index) throws IOException {
		System.out.println("해당 차량을 정말 삭제하시겠습니까?(y/n)");
		System.out.print("> ");
		String yn = bufferedReader.readLine();
		if(yn.contentEquals("y")) {
			carArray = ArrayUtil.removeByIndex(carArray, index);
			printAll();
		}else if(yn.equals("n")) {
			printOne(index);
		}
	}
		
}



//<PrintOne 내가 했던 풀이>		
//String userSelect = bufferedReader.readLine().toUpperCase();
//if(userSelect.equals("A")){
//	
//	System.out.print("차량 색상: ");
//	carArray[index].setColor(bufferedReader.readLine());
//	
//	System.out.print("차량 연식: ");
//	carArray[index].setYear(Integer.parseInt(bufferedReader.readLine()));
//	
//	System.out.print("차량 가격: ");
//	carArray[index].setPrice(Integer.parseInt(bufferedReader.readLine()));
//	
//	printOne(index);
//	
//}else if(userSelect.equals("B")){
//	System.out.print("정말 삭제하시겠습니까? (y/n): ");
//     String agree = bufferedReader.readLine().toUpperCase();
//     if(agree.equals("Y")) {
//        //삭제하고 학생목록 보기로 이동
//        carArray = ArrayUtil.removeByIndex(carArray, index);
//        printAll();
//     }else if(agree.contentEquals("N")) {
//    	printOne(index);
//     }
//}else if(userSelect.equals("C")) {
//	printAll();
//}else {
//	System.out.println("잘못입력하셨습니다. 다시 입력해주세요");