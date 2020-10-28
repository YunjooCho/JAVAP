package class_constructor;

public class FinalMain {
	public final String FRUIT = "사과"; //문자열 리터럴, 힙영역에 메모리 생성
	public final String FRUIT2; //힙영역에 메모리 생성
	
	public static final String ANIMAL = "사자";//final은 private 안씀(언제든지 쓸 수 있게 해야함)
						                      //public static final 형태를 가장 많이 사용 -static영역에 메모리 생성
	public static final String ANIMAL2;//static영역에 메모리 생성
	
	static {//static초기화 구역 (static이 선언되면 이 구역에서만 초기화 할 수 있음)
		ANIMAL2 = "기린";
		//FRUIT2 = "배"; -error : Cannot make a static reference to the non-static field FRUIT2
	}
	
	public FinalMain() {
		FRUIT2 = "딸기"; //static을 선언하지 않으면 생성자로 초기화가 가능
	}
	
	public static void main(String[] args) {
		final int AGE = 10;
		//AGE++; - error : final이 선언된 상수가 된 값은 변경할 수 없다. 
		System.out.println("상수 = " + AGE);
		
		final int AGE2;
		AGE2 = 20; //처음 초기화
		//AGE2 = 30; - error : The final local variable AGE2 may already have been assigned
		//파이널 지역의 변수 AGE2(상수)는 이미 값이 할당되어 있습니다. - 이미 값이 할당되어 있는 상수는 값 변경이 불가능(초기화 후 대입이 불가능)
		
		FinalMain fm = new FinalMain();//힙영역에 메모리 생성
		System.out.println("FRUIT = " + fm.FRUIT);
		System.out.println("FRUIT2 = " + fm.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMain.ANIMAL);
		System.out.println("ANMIMAL2 = " + ANIMAL2); 
		//static이 선언되어 있으면 자기 자신의 구역이라 클래스명을 뺄 수도 있음
		//static이 선언되어 있지 않으면 앞에 객체명을 넣어주어야 함(힙영역에서 불러옴)
		//main메소드 안에서는 static의 초기화가 이루어질 수 없음
	}
	
	
}//class FinalMain
