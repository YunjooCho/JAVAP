package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//String 클래스에 대해 알아보자
//String 이란?
//여러개의 문자가 모여있는 char[]을 ->char배열의 클래스가 스트링
//우리가 다루기 쉽게 클래스의 형태로 바꿔놓은 것

//String 클래스 안에는 스트링을 다루는 데 도움이 되는 다양한 메소드가 준비되어있다.

public class Ex01String {
	public static void main(String[] args) throws IOException {
		String string1 = new String("abc");
		String string2 = "abc";
		String string3 = "1234567";
		System.out.println("string1.equals(string2) : " + string1.equals(string2));//단순히 문자비교
		
		//1번: 해당 스트링의 몇번째 칸에 무슨 글자가 있는지 확인할 때에는
		//charAt(index)를 실행하면 된다.
		System.out.println("string1.charAt(0): " + string1.charAt(0)); //결과값 : a
		
		
		//2번: 2개의 문자열을 연결시킬때에는 concat을 사용한다.
		System.out.println("string1.concat(string2) : " + string1.concat(string2)); //결과값 : abcabc
		
		
		//3번: 해당 문자열에 이러한 하위 문자열이 있는지 체크할 때에는 contains()를 사용한다.
		System.out.println("string1.contains(\"ab\") : "+ string1.contains("ab"));
		//\뒤에 "를 입력하면 "이부분도 그대로 출력됨
		
		
		//4번: 해당 문자열이 초기화는 되어있지만 비어있는 문자열인지 체크할 때에는 isEmpty()를 사용한다.
		
		//null != ""; (선언하고 초기화 안하면 null값)
		//null인 상태에선 아무것도 할 수 없다. 새로운 초기화를 할 때 까지
		//""혹은 new String()으로 초기화하면 모든 메소드를 호출 할 수 있지만
		//다만 아무런 문자도 문자열에 없는 상태인 것이다.
		
		//null : 스택 영역에는 주소값이 부여되어있지만 힙 영역의 해당 주소가 아무런 초기화가 되어있지 않은 상태
		//우리가 그 클래스의 필드 혹은 메소드를 접근 하려면
		//힙 영역에서 그 내용을 찾아야 하는데
		//널인 상태에서는 그 내용들이 없으므로
		//접근할 수 없게 되는 것이다.(이사할 곳이 건물도 안 올라간 상태)
		//""은 힙 영역에 할당이 되어있는 상태
		
		//즉 isEmpty()메소드는
		//해당 스트링이 널이 아닐 때만 실행가능하다.		
		System.out.println("string1.isEmpty():" + string1.isEmpty());
		System.out.println("\"\".isEmpty() : " + "".isEmpty());
		
		//5번: 해당 스트링의 길이를 알고 싶을 때는 length()
		System.out.println("string1.length() : " + string1.length()); //결과값 : 3
		
		//6번: 해당 문자열이 문자패턴과 일치하는지 확인할 때에는 matches()을 사용한다
		//     문자 패턴은 정규표현식을 사용해야한다.
		//     다양한 정규표현식을 사용해서 우리가 문자열이 여러가지 형태를 만족하는지
		//     테스트 가능하다	
		//     ex)핸드폰 번호
		//     하지만 어려운 개념이므로 우리는 해당 문자열이 숫자로만 이루어졌는가 아닌가만 배워보도록 하자
		//     해당 스트링이 모두다 스트링으로 이루어졌는지 체크할 때에는 \d* 으로 테스트한다.
		//Student클래스(day0915)의 s1.getKorean().matches("\\d*")); ->korean은 int형이므로 비교가 안됨
		
		//\\d : \를 2개 붙이는 이유는 "\\d" 문자 안에서 \ 다음 \문자가 특수문자라고 알려주는 것과 같습니다. 이 형식을 사용하면 숫자만 true를 반환합니다.
		//       ex) ^[a-zA-Z]+\\d{2} 는 어떠한 값이 true를 반환할까?
		//       => ^시작열을 알리기에 앞에 a~Z까지 +로 인해 문자가 꼭 1개 들어가야 합니다.. 그리고 숫자 2개를 포함한다라고 해석 할 수 있습니다.
		//출처: https://postitforhooney.tistory.com/entry/JavaRegex-자바-정규표현식에-대해서-공부하고-예제-만들기 [PostIT]

		System.out.println("string: " + string1); //abc
		System.out.println("string1.matches(\\d*) : " + string1.matches("\\d*")); //결과값 : false
		System.out.println("string3.matches(\\d*) : " + string3.matches("\\d*")); //결과값 : true->값이 숫자면 true가 나옴
		//왜 false가 나오는가 : 단순히 string1, string2는 숫자값이 없기 때문
		System.out.println("\"12345\".matches(\\d*) : " + "12345".matches("\\d*"));
		
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자를 입력해주세요 : ");
		String userInput = bufferedReader.readLine();
		while(!userInput.matches("\\d*")) {//어떻게 숫자와 문자가 구별되는지 : 조건앞에 !가 붙어 있어 false일때 while문장이 반복 실행, true이면 밖으로 빠져나감
			System.out.println("숫자만 입력해주세요");
			System.out.print("> ");
			userInput = bufferedReader.readLine();
		}
		int userNumber = Integer.parseInt(userInput);//숫자형태를 입력하면 여기로 와서 정수화 -> userNumber에 대입되어 아래서 출력됨
		System.out.println("사용자가 입력한 숫자 : " + userNumber);
	}
}
