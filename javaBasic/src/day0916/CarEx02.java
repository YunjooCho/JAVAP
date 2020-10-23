package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사용자로부터 차량 정보를 입력받고 출력하는 프로그램을 작성하세요
//조건 1. 만약 아무런 정보가 없다면 출력이 되지 않게 하시오
//조건 2. 무한루프를 통해서 입력과 출력을 사용자가 선택하는 만큼 반복하게 만드세요

//예시:
//1. 입력 2. 출력 3. 종료 : 1
//차량 번호는? (00가 0000)
//차량 종류는 .....
//차량 색상은? (빨간색)
//입력완료
//1. 입력 2. 출력 3. 종료 : 2 
//(차량의 정보가 출력됨)

//20분까지
public class CarEx02 {
	
	//1.메뉴 메소드
	public static void showMenu() {
		
		System.out.println("============================");
		System.out.print("1.입력   2.출력    3. 종료  : ");

	}
	
	
	public static void main(String[] args) throws IOException {
	 //2. 키보드 입력 메모리 선언
	 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	 CarT c = new CarT();
	 //3.메뉴출력
	 while(true) {
		 
		 showMenu();
		 int choice = Integer.parseInt(bufferedReader.readLine());
		 if(choice == 1) {
			 
			 //차량 정보 입력
			 System.out.print("번호: ");
			 c.setNumber(bufferedReader.readLine());
			 System.out.print("차종: ");
			 c.setType(bufferedReader.readLine());
			 System.out.print("연식: ");
			 c.setYear(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("가격: ");
			 c.setPrice(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("색상: ");
			 c.setColor(bufferedReader.readLine());
			 //★나중에 메소드로 입력하도록 해보기 insertCarinfo(bufferedReader);
			 
		 }else if(choice == 2) {
			 //4. 차량 정보 출력
			 //만약 c의 필드값이 0이거나 ""이면 아무런 정보가 입력되지 않았다는 뜻이므로
			 //경고메시지만 출력한다
			 //null이 아닌 이유는 CarT.java에서 초기화하여 null값을 없앰
			 if(c.getYear() == 0) {
				 System.out.println("아직 입력된 정보가 없습니다");
			 }else {
				 c.printInfo();//CarT.java에 작성한 메소드
			 }
			 
		 }else if(choice == 3) {
			 System.out.println("사용해주셔서 감사합니다");
			 break;
		 }else{
			 System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택하세요.");
		 }
		 
	 
	 }//메뉴반복 while
	 
	}
	
	

//	//★나중에 메소드로 입력하도록 해보기
//	//2.입력 메소드
//	public static void insertCarinfo(BufferedReader bufferedReader) throws IOException {
//		
//		String yn = new String();
//		do{
//		
//		System.out.print("차량 번호는? ");
//		c.setNumber(bufferedReader.readLine());
//		System.out.print("차량 종류는? ");
//		c.setType(bufferedReader.readLine());
//		System.out.print("차량 색상은? ");
//		c.setColor(bufferedReader.readLine());
//	
//		System.out.println("입력을 종료하시겠습니까(Y/N)?");
//		yn = bufferedReader.readLine().toUpperCase();
//		
//		}while(yn.equals("Y"));
//			System.out.println("입력을 종료합니다");
//	     
//		
//		
//		
//	}
	

}
