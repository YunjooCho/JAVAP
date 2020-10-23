package class_constructor;
/*
객체배열
과일 판매량 구하기
월별 매출합계도 구하시오

[실행결과]
-------------------------------------
PUM      JAN      FEB      MAR      TOT
-------------------------------------
사과       100       80       75        255
포도        30       25       10        xxx
딸기        25       30       90        xxx
------------------------------------
        xxx      xxx      xxx         
        
*/

//static 문제
//배열? - ㅇㅇ객체배열(1인분)
//Fruit클래스를 생성하여 처리
//main메소드는 출력용
//BufferedReader 필요X
//생성자를 통해 데이터 받기
//calcTot()
//display()  - 과일명, 1월, 2월, 3월, 합계
//output() - 1월의 합계, 2월의 합계, 3월의 합계를 출력하는 메소드

//class Fruit {
//	     생성자
//	   calcTot() - 모든 합계 구하는 메소드
//	   display() - 과일명, 1월, 2월, 3월, 합계
//	   output() - 1월의 합계, 2월의 합계, 3월의 합계를 출려하는 메소드
//	}


public class FruitMain {
	//1.필드명
	private String product;
	private int jan, feb, mar, tot;
	static int jansum, febsum, marsum;
	final static int SIZE = 3;
	static FruitMain[] arr;
	//★private int price; - 가격을 입력받아서 계산도 해보기
	
	//2.생성자
	public FruitMain(String product, int jan, int feb, int mar) {
		this.product = product;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}
	
	//3.메소드
	public String getProduct() {
		return product;
	}
	public int getJan() {
		return jan;
	}
	public int getFeb() {
		return feb;
	}
	public int getMar() {
		return mar;
	}
	public int getTot() {
		return tot;
	}
	public int getJanSum() {
		return jansum;
	}
	public int getFebSum() {
		return febsum;
	}
	public int getMarSum() {
		return marsum;
	}
	
	public void calcTot() {
		tot = jan + feb + mar;//this.가 생략되어 있음
	}
	
	public static void output() {
		for(int i = 0; i < SIZE; i++) {
			jansum += arr[i].getJan();
		}
		
		for(int i = 0; i < SIZE; i++) {
			febsum += arr[i].getFeb();
		}
		
		for(int i = 0; i < SIZE; i++) {
			marsum += arr[i].getMar();
		}
	}
	
	
	public void disp() {
		System.out.println("-------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("-------------------------------------");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getProduct() + "\t"
					           + arr[i].getJan() + "\t"
					           + arr[i].getFeb() + "\t"
					           + arr[i].getMar() + "\t"
					           + arr[i].getTot());
		}
	}
	
	public static void main(String[] args) {
		//4.배열 생성
		arr = new FruitMain[SIZE];
		arr[0] = new FruitMain("사과", 100, 80, 75);
		arr[1] = new FruitMain("포도", 30, 25, 10);
		arr[2] = new FruitMain("딸기", 25, 30, 90);
		
		//5.메소드 구현
		for(int i = 0; i < SIZE; i++) {
			arr[i].calcTot();
		}
		FruitMain.output();
		arr[2].disp();
		System.out.println("-------------------------------------");
		System.out.println("   \t" + jansum + "\t" + febsum + "\t" + marsum);
	}
}
