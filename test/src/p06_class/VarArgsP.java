package p06_class;

public class VarArgsP {
	//오버로드시, 파라미터를 간편화하는 방법(가변 인자 선언, 매개변수의 동적분할)
	
	//필드명 선언
	private int sum;
	
	//Sum메소드(오버로드)
	//VarArgs사용하지 않을 때
//	public int sum(int a, int b) {
//		sum = a + b;
//		return sum;
//	}
//	
//	public int sum(int a, int b, int c) {
//		sum = a + b + c;
//		return sum;
//	}
//	
//	public int sum(int a, int b, int c, int d) {
//		sum = a + b + c + d;
//		return sum;
//	}
//	
	//VarArgs사용
	public int sum(int...ar) {//파라미터를 동적배열로 받음
		//파라미터 int를 Object로 바꾸면 모든 데이터타입을 다 받겠다는 뜻 - 자동으로 autoBoxing, UnBoxing
		int hap = 0;
		for(int i  = 1; i < ar.length; i++) {
			hap += ar[i];
		}
		return hap;
	}
	
	public static void main(String[] args) {
		VarArgsP va = new VarArgsP();
		System.out.println("합 = " + va.sum(10,20));
		System.out.println("합 = " + va.sum(10,'A'));
		System.out.println("합 = " + va.sum(10,20,30));
		System.out.println("합 = " + va.sum(10,20,30,40));
		System.out.println("합 = " + va.sum(10,20,30,100));

	}

}
