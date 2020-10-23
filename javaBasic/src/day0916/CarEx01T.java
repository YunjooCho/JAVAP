package day0916;

import java.text.DecimalFormat;

public class CarEx01T {
	public static void main(String[] args) {
		//CarT 객체를 여러개 만들어보자
		
		CarT c1 = new CarT();
		CarT c2 = new CarT();
		CarT c3 = new CarT();
		
		System.out.println("c1.getName().toUpperCase();" + c1.getNumber().toUpperCase());
		//c1, c2, c3에 셋터를 이용해서 정보를 입력해보자
		c1.setNumber("00가 0000");
		c1.setType("모닝");
		c1.setYear(2019);
		c1.setPrice(5000000);
		c1.setColor("빨간색");
		
		c2.setNumber("11가 1111");
		c2.setType("벤츠");
		c2.setYear(2020);
		c2.setPrice(10000000);
		c2.setColor("은색");
		
		c3.setNumber("22가 2222");
		c3.setType("BMW");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("검은색");
		
		c1.printInfo(); //CarT.java의 출력 메소드
		c2.printInfo(); //CarT.java의 출력 메소드
		c3.printInfo(); //CarT.java의 출력 메소드
		 
		DecimalFormat df = new DecimalFormat("#,###"); //세자리마다 ,찍기
		System.out.println(df.format((long)c1.getPrice())); //long형 혹은 double형만 가능하므로 long형으로 변환
		
		c3.setNumber("11가 1111");//같은 클래스 21~30에 주었던 값위에 c2객체와 동일한 값으로 덮어씀
		c3.setType("벤츠");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("은색");
		
		c2.printInfo();
		c3.printInfo();//CarT.java의 출력 메소드, c2.printInfo()와 c3.printInfo()에 동일한 결과 출력
		//차량번호 : 11가 1111, 차량종류 : 벤츠
		//연식 : 2020년, 가격: 10000000원
		//색상 : 은색
		
		
		//c2와 c3에는 똑같은 정보가 들어가 있다.
		//그렇다면 c2.equals(c3)는 어떻게 될까?
		System.out.println("c2.equals(c3):" + c2.equals(c3));
		//false가 나오는 이유 : 해당 비교는 값이 아닌 주소값을 비교하므로 false가 출력
		//CarT에서 오버라이딩하여 true로 출력되게 함
		
		System.out.println("c2.equals(abc): " + c2.equals("abc"));
		System.out.println("'abc'.equals('abc'): " + "abc".equals("abc"));
		
		System.out.println();
		System.out.println("c1> " + c1); //toString()하지 않았을 때 문제 : day0916.CarT@4554617c로 출력됨
								         //객체의 toString()(Object클래스의 메소드)를 실행시킨 결과값을 출력한다.
			                   	         //toString()메소드를 쓰지않아도 내부적으로 호출함
	}
}
