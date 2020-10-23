package class_constructor;

public class VarArgs {
	//오버로드시, 파라미터를 간편화하는 방법(가변 인자 선언, 매개변수의 동적분할)
	private int sum;
	
	//sum메소드(오버로드)
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
	
	//VarArgs 사용
	public int sum(int ... ar) { //파라미터를 동적배열로 받음
		//파라미터 int를 Object로(모든 데이터타입을 다 받겠다) - 자동으로 autoboxing, unboxing
		int hap = 0;
		for(int i = 0; i < ar.length; i++) {
			
			hap += ar[i];
		}//for
		System.out.println("파라미터 갯수 : " + ar.length + "개"); //▶파라미터 갯수
		return hap;
	}
	
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		System.out.println("합 = " + va.sum(10,20)); //호출
		System.out.println("합 = " + va.sum(10,'A'));
		System.out.println("합 = " + va.sum(10,20,30));
		System.out.println("합 = " + va.sum(10,20,30,40));
		
	}
}
