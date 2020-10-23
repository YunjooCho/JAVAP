package day0916;
//숙제2는 이 CarEx04Arry02를 완성시키세요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.CarT;


public class CarEx04Array02 {
	private static int SIZE = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//사용자가 입력한 값으로 Car 객체를 만들어서
		//Car배열에 비어있는 칸에 넣고
		//비어있는 칸이 없으면 "빈 칸이 없습니다"라고 나오는 프로그램을 만들어보자
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		CarT[] carArray = new CarT[SIZE];
		
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			//만약 입력을 눌렀을 때
			//빈칸인지 아닌지는 어떻게 알 수 있을까?
			if(userChoice == 1) {
				
				if(findEmptyIndex(carArray) == -1) {
					//빈칸이 없으므로 경고메시지만 출력
					System.out.println("빈칸이 없습니다.");
				}else {
					//빈칸이 있으니까 c객체를 만들어 주자
					CarT c = new CarT();
					System.out.print("차량 번호 : ");
					c.setNumber(bufferedReader.readLine());
					
					System.out.print("차량 종류 : ");
					c.setType(bufferedReader.readLine());
					
					System.out.print("차량 연식 : ");
					c.setYear(Integer.parseInt(bufferedReader.readLine()));
					
					System.out.print("차량 가격 : ");
					c.setPrice(Integer.parseInt(bufferedReader.readLine()));
					
					System.out.print("차량 색상 : ");
					c.setColor(bufferedReader.readLine());
					
					carArray = add(carArray, c);
				}
				
			}else if(userChoice == 2) {
				//출력
				//입력값이 있는지 없는지 확인
				printArray(carArray); //toString(), 어제했던 printInfo(c1)를 떠올려보기
			}else if(userChoice == 3){
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해 주세요");
			}
		}//▶메뉴의 while
		
	}//▶main
		
	
	
	//1. 배열의 빈칸을 찾아주는 findEmptyIndex(CarT[] carArray)메소드
	private static int findEmptyIndex(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				return i; //칸이 비어있을때 return, 여기에 도달하지 못하면 빈칸이 없다는 뜻, 아래 리턴을 만나 -1올 돌려줌
			}
		}//▶for문
		return -1; 
	}//1.메소드 (index를 써줘도 되긴 할거 같은데 아래서 사용하므로 굳이 필요없어보임)
	
	
	//2. 파라미터로 Car배열과 Car객체를 받아서 Car객체를 배열에 넣어서
	//   그 배열을 리턴하는 add(Car[] carArray, Car c)메소드
	private static CarT[] add(CarT[] carArray, CarT c) { //main메소드가 사용하기 때문에  static을 붙임
		int index = findEmptyIndex(carArray); //상기 메소드를 가져옴
											  //빈칸이 없으므로 경고메시지만 출력
											  //상기 메소드에서 -1이 나온 경우, 코드의 흐름에 따라 상기 메소드가 호출된 
											  //main메소드 안에서 if문(if(findEmptyIndex(carArray) == -1))으로 걸러지기 때문에
											  //여기 메소드에는 -1자체가 들어오지 않음
		System.out.println("빈칸이 없습니다.");
		carArray[index] = c; //객체의 주소값이 배열에 연결됨
		
		return carArray;
	}
	
	private static void printArray(CarT[] carArray) { //배열에 있는 내용을 출력하는데 있어서 배열의 내용이 null이 아닌 경우만 출력
		                                              //main메소드가 사용하기 때문에  static을 붙임
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				System.out.println(carArray[i]);
			}
		}
	}
	
	
	//3.메뉴 메소드
	private static void showMenu() { //main메소드가 사용하기 때문에  static을 붙임
		System.out.println("=====================");
		System.out.println("차량관리 프로그램");
		System.out.println("1.입력 2.출력 3. 종료");
		System.out.println("=====================");
		System.out.print("메뉴입력> ");
	}//메뉴 메소드
	
	
}//Class

	
	


//예제 1: 현재 입력 하는 코드들을 2개의 메소드로 나누세요
//		 메소드 1: 입력할 index를 찾는 메소드
//		 메소드 2: 배열에 해당위치에 Car 객체를 넣어서 배열을 다시 리턴해주는 메소드
//예제 2: 현재 출력 하는 코드들을 메소드로 분리하세요
//예제 3: 메뉴를 출력하는 코드들을 메소드로 분리하세요  

//<질문>
//1. -1. userChoice == 1 아래같이 적용가능??(x) - 차량데이터를 3번 다 입력해야 메뉴로 넘어감
//   -2. int index = -1;을 밖에서 선언하는 이유?(x) - 다음 if문인 if(index == -1) {System.out.println("빈칸이 없습니다."); 에서 index = -1을 찾지못해 오류발생
//   -3. -1을 집어넣는 이유는 후에 배열크기가 바껴도 중복되지 않기 위해?? - <선생님> : -1은 배열에 존재할 수 없는 인덱스이기 때문에
//   -4. userChoice흐름 - 51번 carArray[index] = c;, 갤탭 필기부분 참조
//<1-1질문예시>
//if(userChoice == 1) {
//	int index;
//	for(int i = 0; i < carArray.length; i++) { //[0][1][2]돌려서 값이 null이면 
//		if(carArray[i] == null) {
//			index = i;
//			 System.out.println("i: " + i + "index: " + index);
//			 System.out.println();
//			 
//			 CarT c = new CarT();
//				System.out.print("번호 : ");
//				c.setNumber(bufferedReader.readLine());
//				System.out.print("차종 : ");
//				c.setType(bufferedReader.readLine());
//				System.out.print("연식 : ");
//				c.setYear(Integer.parseInt(bufferedReader.readLine()));
//				System.out.print("가격 : ");
//				c.setPrice(Integer.parseInt(bufferedReader.readLine()));
//				System.out.print("색상 : ");
//				c.setColor(bufferedReader.readLine());
//				carArray[index] = c;
//		}else {
//			index = -1;
//			System.out.println("빈칸이 없습니다.");
//		}
//	}