package p03_method;

import java.util.Random;
import java.text.DecimalFormat;
import java.io.IOException;

public class Methode4P {

	public static void main(String[] args) throws IOException {
		System.out.println(Math.abs(-25)); //★커피 자판기(300) 형식
		
		//난수 - 컴퓨터가 무작위로 발생하는 수
		System.out.println("난수 = " + Math.random()); //★커피 자판가()형식
		
		//난수만 처리하는 클래스
		Random r = new Random();
		System.out.println("난수 = " + r.nextDouble());
		
		//숫자 3자리마다 ,찍는 메소드
		int num = 1234567;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		//키보드 입력 - 1개의 문자
		System.out.print("데이터 a : ");
		char a = (char)System.in.read();
		//flush -  버퍼 비우기
		System.in.read();
		System.in.read();
		
		System.out.print("데이터 b : ");
		char b = (char)System.in.read();
		System.out.println("결과 = " + a + "\t" + b);
		
		//사용자 정의 함수
		Methode4P mt4 = new Methode4P();
		char max = mt4.big(a,b);
		System.out.println("큰 값 = " + max);
	}

	public char big(char a, char b) {
		return a > b ? a : b;
	}
}
