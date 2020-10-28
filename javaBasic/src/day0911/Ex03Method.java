package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메소드
//메소드란 해당 클래스에 선언과 정의되어있는 기능

//수학시간에 배운 함수
//f(x) = 3x;
//우리가 넣은 숫자에 3이 곱해진 값이 결과로 나오게 된다

//자바의 메소드도 마찬가지
//우리가 어떤 타입의 값을 넣을지를 말해주고
//그 값을 통해서 어떤 기능이 실행될지를 적어주고
//그 결과값을 호출된 곳으로 보낼 때 자료형을 적어주면 된다.

//메소드를 선언해보자
//메소드를 선언할 때에는
//리턴타입 메소드이름(파라미터)
//로 선언할 수 있다.

//리턴 타입 : 해당 메소드가 호출된 곳으로 보내줄 값의 데이터타입
//		   만약 호출된 곳으로 보내줄 값이 있는 경우에는 메소드 내부에서
//			반드시!!  return이라는 명령어를 통해서 값을 되돌려줘야 한다
//			만약 아무런 값도 보내주지 않을 것이라면 리턴타입은 void가 된다
//메소드 이름 : 소문자로 시작하는 동사(낙타등 표기법)
//파라미터 : 해당 메소드가 실행할때 필요로 하는 외부의 값, 메소드 내부에서 변수처럼 쓰이기 때문에 매개변수라고도 한다
public class Ex03Method {
	//사용자로부터 정수 2개를 받아서 그 합을 보내주는 메소드
	static int add(int a, int b) {
		int sum = a + b;
		
		return sum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int userNumber1 = 10;
		int userNumber2 = 150; //이름(변수명)이 틀려도 add메소드의 int a, int b에 값을 넘겨줄 수 있다
		
		int result  = add(userNumber1, userNumber2);
		System.out.println("result :" + result);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("국어");
		int korean = validateScore(bufferedReader);
		System.out.println("영어");
		int english = validateScore(bufferedReader);
		System.out.println("수학");
		int math = validateScore(bufferedReader);
		
		int sum = korean + english + math;
		
	}
	
	//사용자로부터 숫자를 입력받아서
	//만약 해당 숫자가 0~100의 범위를 벗어나면
	//다시 입력을 하게 만들어서
	//범위 내의 숫자가 입력되었을 때만 그 숫자를 return하는 메소드
	
	//메소드 구현
	//public int validateScore로도 작성가능
	static int validateScore(BufferedReader bufferedReader) throws NumberFormatException, IOException{
		System.out.println("점수를 입력해주세요 : ");
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다");
			System.out.println("점수를 입력해주세요 : ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		 return score;
	}//validateScore메소드

}
