package p12_exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exception2P {

	private int number;
	
	public static void main(String[] args) throws Exception {
		Exception2P ex = new Exception2P();
		ex.input();
		ex.output();


	}
	
	public void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("원하는 단을 입력 : ");
		number = Integer.parseInt(br.readLine());
		
	}
	public void output() {
		if(number >= 2 && number <= 9) {
			for(int i = 1; i <= 9; i++) {
				System.out.println(number + "*" + i + " = " + (number * i));
			}
		}else {
			try {
				throw new MakeExceptionP("범위 초과");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
