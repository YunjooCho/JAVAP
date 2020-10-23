package method;

public class MethodTest3 {
	int a; //필드
	int b;
	
	public int sum(int a, int b) {//덧셈 메소드 - 구현
		return a + b;         //메소드 괄호 안에 있는 값 - parameter, argument
							  //a + b
	}
	
	public int sub(int a, int b) {
		return a - b;         
	}
	
	public int mul(int a, int b) {
		return a * b;         
	}
	
	public double div(int a, int b) {
		return (double)a / b;         
	}

	
	
	public static void main(String[] args) {
		int a = 10; //지역변수
		
		//호출
		MethodTest3 mt = new MethodTest3();
		System.out.println("합 = " + mt.sum(25, 36));
		System.out.println("차 = " + mt.sub(25, 36));
		System.out.println("곱 = " + mt.mul(25, 36));
		System.out.println("몫 = " + String.format("%.2f", (mt.div(25, 36))));
	}

}
