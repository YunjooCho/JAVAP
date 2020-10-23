package p03_method;

public class OperatorP {

	public static void main(String[] args) {
		int a = 0;
		
		a += 5;
		a *= 2;
		a -= 3;
		System.out.println("a = " + a); // a = 7
		
		a++;
		System.out.println("a =" + a); // a = 8
		
		int b = a++;
		System.out.println("b = " + b + " a = " + a);
		
		

	}

}
