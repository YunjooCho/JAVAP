package class_constructor;

public class StringTest {

	public static void main(String[] args) {
		String a = "apple";//문자열 literal 생성
		String b = "apple";
		if(a==b)System.out.println("a와 b의 참조값은 같다");//주소비교
		else System.out.println("a와 b의 참조값은 다르다");
		if(a.equals(b)) System.out.println("a와 b의 문자열은 같다");
		else System.out.println("a와 b의 문자열은 다르다");
		System.out.println();
		
		String c = new String("apple");
		String d = new String("apple");
		if(c==d)System.out.println("c와 d의 참조값은 같다");
		else System.out.println("c와 d의 참조값은 다르다");
		if(c.equals(d)) System.out.println("c와 d의 문자열은 같다");
		else System.out.println("c와 d의 문자열은 다르다");
		System.out.println();
		
		String e = "오늘 날짜는 " + 2020 + 9 + 25;
		//앞에 문자열이 있기 때문에 연산이 아닌 결합이 됨
		//4번의 메모리가 생성(+가 실행될때마다 새로운 메모리가 생성됨)
		//JVM에 의해서 삭제시 Garbage Collector로 보낸다
		//Garbage Collector가 실행되면 컴퓨터는 멈춘다(매우 빠른 속도)
		System.out.println("e = " + e);
		
		
		System.out.println("문자열 크기 = " + e.length());
		//배열크기 : 배열명.length
		//글자크기 : 객체명.length()
		System.out.println();
		
		for(int i = 0; i < e.length(); i++) {
			System.out.println(i + " : " + e.charAt(i)); //해당 인덱스의 문자를 가져옴
		}
		System.out.println();
		
		
		System.out.println("부분 문자열 추출=" + e.substring(7)); //파이썬[7:]
		System.out.println("부분 문자열 추출=" + e.substring(7,11));//파이썬[7:11] -> [7]~[10]
		
		System.out.println("대문자 변경=" + "Hello".toUpperCase());
		System.out.println("소문자 변경=" + "Hello".toLowerCase());
		
		System.out.println("문자열 검색=" + e.indexOf("짜"));
		System.out.println("문자열 검색=" + e.indexOf("날짜"));
		System.out.println("문자열 검색 =" + e.indexOf("개바부"));

	}

}
