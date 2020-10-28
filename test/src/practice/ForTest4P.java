package practice;

public class ForTest4P {

	public static void main(String[] args) {
		//돼지저금통
		int sum = 0; //합
		int mul = 1; //곱
		
		for(int i = 1; i <= 10; i++) {
			
			sum += i;
			mul *= i;
			System.out.println(i  + "\t" + sum + "\t" + mul);

			
			
		}
	

	}

}
