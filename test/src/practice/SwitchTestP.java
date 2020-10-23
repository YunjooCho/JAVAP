package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SwitchTestP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("원하는 달 : ");
		int month = Integer.parseInt(br.readLine());
		int days;
		
		switch (month) {
			case 1 :
			case 3 : 
			case 5 :
			case 7 : 
			case 8 :
			case 10 :
			case 12 : days = 31;
					  break;
			case 2 : days = 28;
					  break;
			case 4 :
			case 6 :
			case 9 :
			case 11 : days = 30;
					  break;
			default : days = 0;
		}
		System.out.println(month + "월은 " + days + "일 입니다");
	}

}
