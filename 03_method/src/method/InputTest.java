package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputTest {

	public static void main(String[] args) throws IOException {
		//MethodTest4에서 했던 입력은 한글자 밖에 입력할수 없으므로
		//문자열을 입력하는 방법을 실시
		//IOSteam
		
		//메모리 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("정수 A :");
		int a = Integer.parseInt(br.readLine()); //한 줄,엔터를 칠 때까지 한 줄로 취급
		//br.readLine()는 문자열
		System.out.println("실수 B : ");
		double b = Double.parseDouble(br.readLine());
		
		System.out.println(a + " + " + b + " = " + (a+b));
	}

}
