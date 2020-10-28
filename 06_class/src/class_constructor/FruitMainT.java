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


//차이점 : Fruit클래스 생성
//       get메소드 사용 안함
//       출력이 배열이 아닌 1인분

class Fruit{
	//1.필드명
		private String product;
		private int jan, feb, mar, tot;
		private static int jansum, febsum, marsum;
		final static int SIZE = 3;
		static FruitMainT[] arr;
		//위 필드를 String[] product, int[] jan 등으로 잡은 경우는 1인분이 아님
		//★private int price; - 가격을 입력받아서 계산도 해보기
		
		//2.생성자
		public Fruit(String product, int jan, int feb, int mar) {
			this.product = product;
			this.jan = jan;
			this.feb = feb;
			this.mar = mar;
		}
		
		//3.메소드
//		public String getProduct() {
//			return product;
//		}
//		public int getJan() {
//			return jan;
//		}
//		public int getFeb() {
//			return feb;
//		}
//		public int getMar() {
//			return mar;
//		}
//		public int getTot() {
//			return tot;
//		}
//		public int getJanSum() {
//			return jansum;
//		}
//		public int getFebSum() {
//			return febsum;
//		}
//		public int getMarSum() {
//			return marsum;
//		}
		
		public void calcTot() {
			tot = jan + feb + mar;//this.가 생략되어 있음
			
			jansum += jan;
			febsum += feb;
			marsum += mar;
		}
		
		public void disp() {
			
			System.out.println(product + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
			
//			for(int i = 0; i < arr.length; i++) {
//				System.out.println(arr[i].getProduct() + "\t"
//						           + arr[i].getJan() + "\t"
//						           + arr[i].getFeb() + "\t"
//						           + arr[i].getMar() + "\t"
//						           + arr[i].getTot());
//			}
		}
		
		public static void outPut() {
			System.out.println("\t" + jansum + "\t" + febsum + "\t" + marsum);
		}//outPut()을 따로 잡은 이유 : disp()는 main에서 반복되므로 따로 분리함
	
}


public class FruitMainT {
	
	
	public static void main(String[] args) {
		//4.배열 생성
		Fruit[] ar = new Fruit[3];
		ar[0] = new Fruit("사과", 100, 80, 75);
		ar[1] = new Fruit("포도", 30, 25, 10);
		ar[2] = new Fruit("딸기", 25, 30, 90);
		
		
		System.out.println("-------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("-------------------------------------");
		for(Fruit f : ar) {
			f.calcTot();
			f.disp();
		System.out.println("-------------------------------------");
		Fruit.outPut();
		}
		
		
	}
}
