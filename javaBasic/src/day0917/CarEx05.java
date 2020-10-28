package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import day0916.CarT; //ctrl+shift+o

//만약 꽉 차면
//가장 앞에 거부터 제거하고  ▶생성자초기화?놉, 뒷배열을 앞배열로 덮어쓰기
//한칸씩 땡겨서 맨 마지막에 덮어씌우는 형식으로  ▶temp?놉, 뒷배열을 앞배열로 덮어쓰기
//배열을 관리하는 프로그램
public class CarEx05 {
	private static int SIZE = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		CarT[] carArray = new CarT[SIZE];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//입력 메소드 실행
				carArray = add(carArray); //carArray에 add메소드에서 반환된 값을 덮어 씌우기
			}else if(userChoice == 2) {
				//출력 메소드 실행
				printArray(carArray);
			}else if(userChoice == 3) {
				//메시지 출력 후 종료
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
	
	//5. 출력 메소드
	private static void printArray(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				System.out.println(carArray[i]); //배열이 null이 아닐 때 출력
			}
		}
	}
	
	
	//4. 2에서 받아온 숫자를 배열의 인덱스에 입력하고, 해당 배열에 3에서 받아온 객체값을 입력 
	private static CarT[] add(CarT[] carArray) throws NumberFormatException, IOException   { //리턴타입: 배열 (형태 : 클래스명[]) -리턴타입에는 클래스, 배열 등 여러가지가 올 수 있음
		int index = findEmptyIndex(carArray); //배열을 한칸씩 땡겨주고 맨 마지막 인덱스에 새로운 c객체를 넣어줌
										      //2번 메소드에서 받아온 -1, 0, 1, 2가 있음
		if(index != -1) {                     //-1이 아닌 경우만 3번메소드가 실행
			//빈칸이 존재하므로 index 빈 칸에            
			//Car 객체를 넣어준다.
			carArray[index] = setCarInfo();   //3번 메소드, 해당 배열에 반환된 객체c주소값을 대입(객체c안에 차량정보가 존재)
		}else {
			//index가 -1인 경우
			//배열이 모두 다 꽉 찼으므로 배열을 한칸씩 땡겨서
			//맨 마지막 칸에 새로 입력된 c를 넣게 만들어 주자
			for(int i = 1; i < carArray.length; i++) { //초기값이 1인 이유는 ★코드 참조
				carArray[i-1] = carArray[i];//★앞 배열은 뒷배열로 덮어씀 ->한칸씩 땡겨김
			}
			carArray[SIZE - 1] = setCarInfo(); //가장 마지막 칸에 새 객체를 넣어줌
											   //SIZE - 1이 마지막 칸을 가리키게 되는 이유는 
											   //배열은 0 ~ (SIZE - 1)(배열크기 -1)이기 때문에
		}
		return carArray;                      //객체c주소값이 입력된 배열을 반환(선생님: carArray전체를 반환)
	}
	
	//3.객체에 값을 넣어주는 메소드
	private static CarT setCarInfo() throws NumberFormatException, IOException  { //차량정보 입력
		                                                                          //리턴타입 : 객체 (형태 : 클래스명)
		                                                                          //반환되는 정보는 CarT클래스의 객체
																				  //NumberFormatException : 숫자만 있어야 함(?)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		CarT c = new CarT();//객체 초기화(기본형은 0, 참조형은 "")
		
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
		
		return c; //위에 값들이 저장된 객체c를 반환(c에 윗 값들이 들어가 있는 상태가 됨)
	}
	
	//2.배열이 비어있는지 찾는 메소드(비어있는 경우에는 해당 메소드의 인덱스값을 반환, 비어있지 않은 경우에는 -1을 반환)
	private static int findEmptyIndex(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	
	//1.메뉴 메소드
	private static void showMenu() {
		System.out.println("비트 차량관리 프로그램 ver 2.0");
		System.out.println("1.입력   2.출력   3.종료");
		System.out.print("> ");
	}
}
