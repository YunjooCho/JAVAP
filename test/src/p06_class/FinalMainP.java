package p06_class;

public class FinalMainP {
	public final String FRUIT = "사과";
	public final String FRUIT2;
	
	public static final String ANIMAL = "사자";
	public static final String ANIMAL2;
	public final String ANIMAL3 = "고양이";
	
	public FinalMainP() { //static이 선언되지 않은 필드에 대해서는 생성자로 초기화
		FRUIT2 = "딸기";
		//ANIMAL2 = "기린"; - error : 파이널 필드인  ANIMALS2는 할당할 수 없습니다,
	}
	
	static {
		ANIMAL2 = "기린";//static이 선언된 변수의 초기화
	}
	
	public static void main(String[] args) {
		final int AGE = 10;
		//AGE++; - error! final이 선언된 상수 값은 변할 수 없음
		System.out.println("상수 = " + AGE);
		
		final int AGE2;
		AGE2 = 20; //처음 초기화
		//AGE2 = 30; - 이미 값이 할당되어 있는 상수는 값 변경이 불가능

		FinalMainP fm = new FinalMainP();
		System.out.println("FRUIT = " + fm.FRUIT);
		System.out.println("FRUIT2 = " + fm.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMainP.ANIMAL);
		System.out.println("ANIMAL2 = " + ANIMAL2);
		System.out.println("ANIMAL3 = " + fm.ANIMAL3);
	}

}
