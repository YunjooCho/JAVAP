package day0915;
//숙제1: Car 클래스를 만들어서 그 클래스 객체를 활용하는 프로그램을 작성해보세요.
//Car  클래스의 필드: 차량번호, 차량 종류, 연식, 가격, 색깔 (o)
//메소드: 현재 차량의 정보를 예쁘게 출력하는 메소드 (o)
//차량에 대한 파라미터가 있는 생성자와 파라미터가 없는 생성자 (o)
//캡슐화(o)

//숙제2: Student의 나머지 필드에 대해서 겟터 셋터를 구현하시고 (o)
//StudentEx.java를 알맞게 고치시오(o)

import java.text.DecimalFormat;

public class CarEx01 {

	
	public static void main(String[] args) {
		//객체 생성
		DecimalFormat df = new DecimalFormat("#,###"); //★★★★★★왜 안됨?? df.format(myCar.carPrice)
		
		//7. 필드 캡슐화 후 수정
		
		System.out.println("◆◆◆◆◆◆◆내 차정보◆◆◆◆◆◆◆◆◆");
		System.out.println("파라미터가 없는 생성자 사용");
		Car myCar = new Car();
		System.out.println();
		
		
		Car friendCar = new Car("나1212", "세단", 10, 20000000,"빨강");
		System.out.println("◆◆◆◆◆◆◆친구 차정보◆◆◆◆◆◆◆◆◆");
		System.out.println("파라미터가 있는 생성자 사용");
		friendCar.setCarNumber("나1212");
		friendCar.setCarType("세단");
		friendCar.setCarYear(10);
		friendCar.setCarPrice(20000000);
		friendCar.setColor("빨강");
		System.out.printf("차량번호: %d, 차량 종류: %s, 연식: %d, 가격: %d, 색깔: %s", friendCar.getCarNumber(), friendCar.getCarType(), friendCar.getCarYear(), friendCar.getCarPrice(), friendCar.getColor());
		System.out.println();
		
		
//4. 캡슐화 이전 출력		
//		Car myCar = new Car();
//		System.out.println("◆◆◆◆◆◆◆내 차정보◆◆◆◆◆◆◆◆◆");
//		System.out.println("파라미터가 없는 생성자 사용");
//		System.out.printf("차량번호: %d, 차량 종류: %s, 연식: %d, 가격: %d, 색깔: %s", myCar.carNumber, myCar.carType, myCar.carYear, myCar.carPrice, myCar.color);
//		System.out.println();
//		
//		
//		Car friendCar = new Car();
//		System.out.println("◆◆◆◆◆◆◆친구 차정보◆◆◆◆◆◆◆◆◆");
//		System.out.println("파라미터가 있는 생성자 사용");
//		friendCar.carNumber = 1212;
//		friendCar.carType = "세단";
//		friendCar.carYear = 10;
//		friendCar.carPrice = 20000000;
//		friendCar.color = "빨강";
//		System.out.printf("차량번호: %d, 차량 종류: %s, 연식: %d, 가격: %d, 색깔: %s", friendCar.carNumber, friendCar.carType, friendCar.carYear, friendCar.carPrice, friendCar.color);
//		System.out.println();
		
	}

}
