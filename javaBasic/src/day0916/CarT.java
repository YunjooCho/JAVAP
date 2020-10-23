package day0916;



public class CarT {
	//숙제1: Car 클래스를 만들어서 그 클래스 객체를 활용하는 프로그램을 작성해보세요.
	//Car  클래스의 필드: 차량번호, 차량 종류, 연식, 가격, 색깔
	//메소드: 현재 차량의 정보를 예쁘게 출력하는 메소드
	//차량에 대한 파라미터가 있는 생성자와 파라미터가 없는 생성자 
	//캡슐화
	
	//필드
	private String number;
	private String type;
	private int year;
	private int price;
	private String color;
	
	//메소드
	//차량 정보 출력메소드
	public void printInfo() {
		
		System.out.printf("차량번호 : %s, 차량종류 : %s\n", number, type);
		System.out.printf("연식 : %d년, 가격: %d원\n", year, price);
		System.out.printf("색상 : %s\n", color);
		
	}
	
	//파라미터 없는 생성자
	public CarT() {
		number = new String(); //null값 없앰
		type = new String();
		year = 0;
		price = 0;
		color = new String();
	}
	
	//파라미터가 있는 생성자
	public CarT(String number, String type, int year, int price, String color) {
		this.number = number; //this는 객체를 가리킴(필드와 파라미터 구분), 여기서 초기화
		this.type = type;
		this.year = year;
		this.price = price;
		this.color = color;
	}
	
	//필드에 대한 캡슐화
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setYear(int year) {
		this.year = year;
	}	
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	//equasls와 toString은 클래스마다 만들어주어야함 
	public boolean equals(Object obj) { //같은 패키지의 Ex01Class.java참조 
										//java.lang.Object를 상속 받았기 때문에 생기는 문제 해결
		                                //줄번호 옆에 역삼각형 : 오버라이드함
			//파라미터로 넘어온 객체가 이 equals메소드를 실행하는 객체와 같은지 비교하려면
			//1. obj가 이 CarT 클래스의 객체인지 확인한다
			//2. obj가 CarT 클래스의 객체가 맞다면
			//   필드 중 몇몇 정보를 비교해서 같을 때에만 (비교하기 위해 형변환 함)
			//   return true 해준다.
			
			//1. obj가 해당 클래스객체인지 확인할때에는
			//	 instanceof 클래스이름 이란 코드로 확인 가능하다
			//   instanceof : 해당 클래스의 객체인지 아닌지를 확인하는 예약문
		if(obj instanceof CarT) { //obj가 형변환이 가능하다면(해당 클래스 객체라면!!!!!!!)obj를 형변환 시켜줌
								  //형태 : 객체  + instanceof + 클래스 ->형변환 & 해당 클래스의 객체인지 아닌지 확인
								  //obj가 CarT 클래스의 객체이므로(obj변수의 뜻은 모든 객체)
							      //obj를 카로 형변환 시켜줄 수 있다.
							      //Object obj = new Object();에는 필드가 없음
			CarT c = (CarT)obj;   //Object에는 필드가 없으므로 클래스를 CarT로 바꿔줌(형변환)
			                      //아직 부모클래스이므로 자식클래스에 맞게 오버라이딩(number, type에 접근할 수 있게 만들어줌)
			if(number.equals(c.number)){
					//둘다 CarT의 객체
					//앞에 number는 equals를 실행하는 객체(c2.equals(c3)로 생각해보기 -c2객체의 number), 
					//c.number는 파라미터로 넘어온 obj를 c로 바꾼 number 
				return true;
			}
		}
		return false;
		
	}
	public String toString() {
		return "차량 번호: " + number +
				", 차량 종류 : " + type +
				", 차량 가격 : " + price + "원, " +
				", 차량 연식 : " + year + "년, " + 
				", 차량 색상  : " + color;
	}
}
