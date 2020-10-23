package p03_method;

public class CompTest2P {

	public static void main(String[] args) {
		char ch = 'P';
		
		int result = ch >= 'A' && ch <= 'Z' ? ch + 32 : ch - 32;
		System.out.println(ch + " -> " + (char)result);

	}

}
