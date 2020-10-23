package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("원하는 월 입력 : ");
		int month = Integer.parseInt(br.readLine());
		//이 경우 키보드로 문자가 입력되면 숫자로 변환 안됨
		//char는 parse없음
		int days;
		
		switch(month) {
		case 1 : 
		case 3 : 
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : days = 31; 
				break; //switch를 벗어나라
		case 2 : days = 28; 
				break;
		
		case 4 : 
		case 6 : 
		case 9 :
		case 11 : days = 30;
				break;
			
		default : days = 0; //지정된 숫자 외의 값이 들어올 때 출력할 내용(초기화와 유사)
		}
		System.out.println(month + "월은 " + days + "일 입니다");
	}
	
}
