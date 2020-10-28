//package day0916P;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import day0916.CarT;
//
//
//
//public class CarEx04Array02 {
//	private static int SIZE = 3;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		//사용자가 입력한 값으로 Car 객체를 만들어서
//		//Car배열에 비어있는 칸에 넣고
//		//비어있는 칸이 없으면 "빈 칸이 없습니다"라고 나오는 프로그램을 만들어보자
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		CarT[] carArray = new CarT[SIZE];
//		
//		while(true) {
//			System.out.print("1. 입력  2. 출력  3. 종료 : ");
//			int userChoice = Integer.parseInt(bufferedReader.readLine());
//			//만약 입력을 눌렀을 때
//			//빈칸인지 아닌지는 어떻게 알 수 있을까?
//			if(userChoice == 1) {
//				int index;// = -1; //->?????????????????
//				for(int i = 0; i < carArray.length; i++) { //[0][1][2]돌려서 값이 null이면 
//					if(carArray[i] == null) {
//						index = i;
//						 System.out.println("i: " + i + "index: " + index);
//					}else {
//						index = -1;
//					}
//				}
//				if(index == -1) {
//					System.out.println("빈칸이 없습니다.");
//				}else {
//					CarT c = new CarT();
//					System.out.print("번호 : ");
//					c.setNumber(bufferedReader.readLine());
//					System.out.print("차종 : ");
//					c.setType(bufferedReader.readLine());
//					System.out.print("연식 : ");
//					c.setYear(Integer.parseInt(bufferedReader.readLine()));
//					System.out.print("가격 : ");
//					c.setPrice(Integer.parseInt(bufferedReader.readLine()));
//					System.out.print("색상 : ");
//					c.setColor(bufferedReader.readLine());
//					carArray[index] = c;
//					
//				}
////				if(index == -1) {
////					System.out.println("빈칸이 없습니다.");
////				}else {
////					CarT c = new CarT();
////					System.out.print("번호 : ");
////					c.setNumber(bufferedReader.readLine());
////					System.out.print("차종 : ");
////					c.setType(bufferedReader.readLine());
////					System.out.print("연식 : ");
////					c.setYear(Integer.parseInt(bufferedReader.readLine()));
////					System.out.print("가격 : ");
////					c.setPrice(Integer.parseInt(bufferedReader.readLine()));
////					System.out.print("색상 : ");
////					c.setColor(bufferedReader.readLine());
////					carArray[index] = c;
////					
////				}
//			}else if(userChoice == 2) {
//				//출력
//				//입력값이 있는지 없는지 확인
////				if(c.setNumber == 0) {
////					
////				}
//			}else if(userChoice == 3){
//				System.out.println("사용해주셔서 감사합니다");
//				break;
//			}else {
//				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해 주세요");
//			}
//			
//		}//메뉴의 while
//	}
//}
