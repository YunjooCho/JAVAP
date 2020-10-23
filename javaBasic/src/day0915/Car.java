package day0915;

import java.text.DecimalFormat;

public class Car {

	//숙제
	//1.필드(멤버변수)선언
	//Car 클래스의 필드: 차량번호, 차량 종류, 연식, 가격, 색깔
	//5.private로 수정
	//6.셋터&겟터 작성
	private String carNumber;
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarNumber() {
		return carNumber;
	}
	
	
	private String carType;
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarType() {
		return carType;
	}
	
	
	private int carYear;
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getCarYear() {
		return carYear;
	}
	
	
	private int carPrice;
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public int getCarPrice() {
		return carPrice;
	}
	
	
	private String color;
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}

	//메소드: 현재 차량의 정보를 예쁘게 출력하는 메소드
	public void printCar(String carNumber, String carType, int carYear, int carPrice, String color) {
		DecimalFormat df = new DecimalFormat("#,###"); //★★★★★★왜 안됨?? df.format(myCar.carPrice)
		System.out.printf("차량번호: %d, 차량 종류: %s, 연식: %d, 가격: %d, 색깔: %s\n", carNumber, carType, carYear, carPrice, color);
		
	}
		
	
	//2.파라미터가 있는 생성자
	public Car(String carNumber, String carType, int carYear, int carPrice, String color) {
		
		this.carNumber = carNumber;//여기서부터
		this.carType = carType;
		this.carYear = carYear;
		this.carPrice = carPrice;
		this.color = color;//여기까지 없으면
		
	}
	
	//3.파라미터가 없는 생성자
	public Car() {
		
		carNumber = "가1011";
		carType = "SUV";
		carYear = 13;
		carPrice = 300000000;
		color = "하얀색";
		printCar(carNumber, carType, carYear, carPrice, color);
	}
	
	
}
