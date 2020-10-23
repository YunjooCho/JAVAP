package method;

import java.util.Random;
import java.text.DecimalFormat;
import java.io.IOException;

public class MethodTest4 {
	
	
	public static void main(String[] args) throws IOException {
		System.out.println(Math.abs(-25));//★커피 자판기(300) 형식
		//Math클래스의 abs()메소드 : 절대값 구하는 메소드
		
		//난수 -컴퓨터가 무작위로 발생하는 수, 0 <= 난수 < 1 (실수형)
		System.out.println("난수 = " + Math.random()); //★커피 자판가()형식
		//Math클래스의 random()메소드 : 난수를 구하는 메소드
		
		//난수만 처리하는 Random클래스
		Random r = new Random(); //생성(Static아님)
		System.out.println("난수 = " + r.nextDouble()); //nextDouble 객체
		
		//DecimalFormat(NumberFormat)클래스의 format()메소드
		//숫자를 3자리마다 , 찍기
		int num = 1234567;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		
		//System클래스의 in필드
		//키보드 입력 - 1개의 문자
		System.out.println("데이터a : ");
		char a = (char)System.in.read(); //지역변수
		//System.in.read();는 기본 int로 받음
		
		//flush -  버퍼 비우기
		System.in.read(); //▶줄바꾸기?
		System.in.read(); //▶줄 앞으로가기?
		
		System.out.println("데이터b : ");
		char b = (char)System.in.read();
		System.out.println("결과 = " + a + "\t" + b);
		
		//사용자 정의 함수 출력(클래스명이 작업하고 있는 클래스) - a와 b중에서 큰 값을 출력하는 메소드를 사용자가 작성 
		//main함수 밖
		MethodTest4 mt = new MethodTest4();
		char max = mt.big(a,b);
		System.out.println("큰 값 = " + max);
		
		
	}
	
	public char big(char a, char b){ //사용자 정의 함수 구현, parameter(매개변수), argument(인수)
		return a > b ? a : b;
	}
	
}

//자바
// -main 메소드
// -자바가 아는 패키지는 java.lang
// -자바는 모든 클래스를 java.lang(default package) 찾는다

//예외처리 Exception
//오류로 인해 갑작스럽게 중단 된 경우 입력된 정보를 저장
//try~catch
//throws
// -try~catch는 지금 모르므로 JVM에게 떠 넘기기 사용
// -함수 뒤에 작성(해당함수(System.in.read();)를 포함하고 있는 main함수 뒤에 입력)

//엔터의 역할(기능)
//1. 커서를 맨 앞으로 이동 -> \r
//2. 다음 줄로 이동 -> \n
// =>엔터 안에 두 글자 존재