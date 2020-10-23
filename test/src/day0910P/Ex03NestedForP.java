package day0910P;
//구구단 만들기

public class Ex03NestedForP {

	public static void main(String[] args) {
		
		int dan;
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				dan = i*j;
				System.out.println(i + " * " + j + " = " + dan);
			}
		}

	}

}
