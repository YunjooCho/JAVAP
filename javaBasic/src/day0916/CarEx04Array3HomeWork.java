package day0916;
//숙제2는 이 CarEx04Arry02를 완성시키세요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.CarT;


public class CarEx04Array3HomeWork {
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
				int index = -1;   //▶여기에 위치한 이유 : 기본값을 -1로 두고 싶음
	      		  //▶for문의 else를 새로 작성하여 그 안에 들어가면, 그다음 if(index == -1) {System.out.println("빈칸이 없습니다."); 에서 index = -1을 찾지못해 오류발생
				for(int i = 0; i < carArray.length; i++) { //▶[0][1][2]돌려서 값이 null이면 i값을 해당 인덱스에 집어 넣음 [0]->[1]->[2]로 2가 가장 마지막에 와 이전 값들을 덮어씀
												   //▶carArray[2]부터 차량정보 입력이 됨
												   //▶[0]->[1]->[2]순서로 입력하고 싶으면 조건을 int i = carArray.length-1; i >= 0; i--로 줌
				if(carArray[i] == null) {
				index = i;
				break;    //▶break가 없으면 입력 순서가 [2]-[1]-[0]이 됨. break를 넣으면 0이 null값이면 바로 빠져나가 [0]-[1]-[2]의 순으로 입력
				      //▶System.out.println("i: " + i + " index: " + index); 결과값 보려고 내가 입력한것
				}
				
				}//▶for문
				      //▶System.out.println("index: " + index); 결과값 보려고 내가 입력한것
				if(index == -1) { //▶index의 기본값은 -1이므로 계속 빈칸이 없다고 출력됨
				System.out.println("빈칸이 없습니다.");
				}else {           //▶만약 배열이 null값(아무 값도 저장되지 않은 상태)라서 index 변수에 각 배열의 인덱스([0],[1],[2])가 대입되었다면 아래 입력과정이 실행됨
				CarT c = new CarT();
				System.out.print("번호 : ");
				c.setNumber(bufferedReader.readLine());
				System.out.print("차종 : ");
				c.setType(bufferedReader.readLine());
				System.out.print("연식 : ");
				c.setYear(Integer.parseInt(bufferedReader.readLine()));
				System.out.print("가격 : ");
				c.setPrice(Integer.parseInt(bufferedReader.readLine()));
				System.out.print("색상 : ");
				c.setColor(bufferedReader.readLine());
				carArray[index] = c; //
				
				}
			}else if(userChoice == 2) {
				//출력
				//입력값이 있는지 없는지 확인
				for(int i = 0; i < carArray.length; i++) {
					if(carArray[i] == null) {
						
						System.out.println((i+1) + "번 : - ");
						
					}else {
						
						System.out.println((i+1) + "번: " + carArray[i]);
					}
				}
				
			}else if(userChoice == 3){
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해 주세요");
			}
			
		}//▶메뉴의 while
	}

	//메뉴 메소드
	static void showMenu() {
		System.out.println("=====================");
		System.out.println("차량정보 입출력 프로그램");
		System.out.println("1.입력 2.출력 3. 종료");
		System.out.println("=====================");
		System.out.print("메뉴입력> ");
	}
	
	
	
}

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