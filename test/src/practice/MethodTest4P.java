package practice;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class MethodTest4P {

	public static void main(String[] args) throws IOException {
		
		//★커피 자판기(300) 형식 - 절대값(ABS) : Input에 따라 Output 산출
		System.out.println(Math.abs(-25));
		System.out.println();
		
		
		//★커피 자판가()형식 : Input이 없는데도 Output 산출
		//난수 -컴퓨터가 무작위로 발생하는 수, 0 <= 난수 < 1 (실수형)
		System.out.println("난수 = " + Math.random());
		
		//난수만 처리하는 클래스
		//메모리 생성(Static아님)
		Random rd = new Random(); 
		System.out.println("난수 : " + rd.nextDouble()); //nextDouble 객체
		System.out.println("소수셋째자리 :" + String.format("%.3f", rd.nextDouble()));
		System.out.println();
		
		//숫자를 3자리마다 , 찍기
		int a = 4500000;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(a));
		
		//키보드 입력 - 1개의 문자
		System.out.println("입력 : ");
		char key = (char)System.in.read();
		System.out.println((int)key);
		
		//flush -  버퍼 비우기
		
		
		//사용자 정의 함수 출력 - a와 b중에서 큰 값을 출력하는 메소드 작성 
		//main함수 밖
			
	}

}
