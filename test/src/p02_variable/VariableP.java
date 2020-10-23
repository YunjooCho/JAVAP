package p02_variable;

public class VariableP {

	public static void main(String[] args) {
		boolean a;
		a = true; //true = 1
		System.out.println("a = " + a);
		//System.out.println("a = " + (int)a); - error
		
		char b;
		b = 'A'; //ASCIIÄÚµå 65
		System.out.println("b = " + b);
		
		char c;
		c = 65;
		System.out.println("c = " + c);
		
		int d = 'A';
		System.out.println("d = " + d);
		
		float f = 43.8f;
		System.out.println("f = " + f);

	}

}
