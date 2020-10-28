package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.CarT;
import util.ArrayUtil;

//동적할당이 되는 배열버전
public class CarEx06 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//배열 선언(동적할당)
		CarT[] carArray = new CarT[0];//동적할당으로 배열의 크기를 조절할 예정이기 때문에 0을 입력
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//carArray 추가 메소드 실행
				carArray = add(carArray,bufferedReader);
			}else if(userChoice == 2) {
				//carArray 출력 메소드 실행
				printArray(carArray);
			}else if(userChoice == 3){
				System.out.println("사용해주셔서 감사합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다");
			}
		}//메뉴 반복while		
	}
	private static void showMenu() {
		System.out.println("1.입력 2.출력 3.종료");
		System.out.print("> ");
	}
	
	private static CarT[] add(CarT[] carArray, BufferedReader bufferedReader) throws NumberFormatException, IOException {
		//버퍼드리더로 파라미터를 계속 넘겨줄 예정
		carArray = ArrayUtil.add(carArray,setCarInfo(bufferedReader)); //객체 추가하는 메소드
																	   //setCarInfo에서 객체에 들어갈 차량정보를 넣어줌
		return carArray;
	}
	
	private static CarT setCarInfo(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		//객체생성만, 배열에 입력은 하지 않음
		//이 메소드가 실행될때마다 새로운 c객체가 생성되어 각각의 c마다 주소값이 달라짐
		//이 메소드 종료 후에도 내부에서 객체c는 남아있어 main메소드에서 본 메소드가 호출된 곳으로 값을 넘겨줌
		//단축번호 1,2,3,4....와 같은 이미지
		//힙 메모리 영역 - 객체저장됨, 스택-?? 
		CarT c = new CarT();
		
		System.out.print("차량 번호: ");
		c.setNumber(bufferedReader.readLine());
		
		System.out.print("차량 종류: ");
		c.setType(bufferedReader.readLine());
		
		System.out.print("차량 연식: ");
		c.setYear(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("차량 가격: ");
		c.setPrice(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("차량 색상: ");
		c.setColor(bufferedReader.readLine());
		
		return c;
		
	}
	
	private static void printArray(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			System.out.println(carArray[i]);
		}
	}
}
