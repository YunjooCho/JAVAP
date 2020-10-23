package method;

public class Boxing {

	public static void main(String[] args) {
		int a = 25;
		double b = (double)a / 3; //강제형변환 / 자동형변환, Casting, Cast연산
		
		
		int c = 5;
		Integer d = c; 
		// Integer 객체 = int 기본형 ->JDK 5.0 이상부터 가능해짐(AutoBoxing)
		//맞는 형식(AutoBoxing 안되는 경우) : Integer d = new Integer(c);
		
		Integer e = 5;
		int f = e; //JDK 5.0 이상, unAutoBoxing
		//기본형 = 객체형
		//int f = e.intValue();
	}

}
