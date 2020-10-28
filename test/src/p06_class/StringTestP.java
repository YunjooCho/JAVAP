package p06_class;

public class StringTestP {
	public static void main(String[] args){
		//문자열 literal생성
		String a = "apple"; 
		String b = "apple";
		
		//참조값 비교
		if(a==b)System.out.println("a와 b의 참조값은 같다");
		else System.out.println("a와 b의 참조값은 다르다");
		
		//문자열 비교
		if(a.equals(b))System.out.println("a와 b의 문자열은 같다");
		else System.out.println("a와 b의 문자열은 다르다");
		System.out.println();
		
		
		//String 객체 생성
		String c = new String("apple");
		String d = new String("apple");
		//참조값 비교
		if(c==d) System.out.println("c와 d의 참조값은 같다");
		else System.out.println("c와 d의 참조값은 다르다");
		//문자열 비교
		if(c.equals(d)) System.out.println("c와 d의 문자열은 같다");
		else System.out.println("c와 d의 문자열은 다르다");
		System.out.println();
		
		String e = "오늘 날짜는 " + 2020 + 9 + 25;
		//앞에 문자열이 있기 때문에 뒤에 숫자는 연산이 아닌 결합이 됨
		//4회 메모리가 생성(+가 실행될때마다)
		//JVM에 의해서 삭제시 Garbage Collector로 보냄
		//Garbage Collector가 실행되면 컴퓨터는 멈춘다(매우 빠른 속도)
		System.out.println("e = " + e);
		
		//문자열 크기 확인
		System.out.println("문자열 크기 = " + e.length());//공백도 글자로 취급
		System.out.println();
		
		//해당 인덱스의 문자를 가져옴
		for(int i = 0; i < e.length(); i++) {
			System.out.println(i + " : " + e.charAt(i));
		}
		System.out.println();
		
		System.out.println("부분 문자열 추출 = " + e.substring(7));
		System.out.println("부분 문자열 추출 = " + e.substring(7, 11));
		
		System.out.println("대문자 변경 = " + "Hello".toUpperCase());
		System.out.println("소문자 변경 = " + "Hello".toLowerCase());
		
		System.out.println("문자열 검색 = " + e.indexOf("짜"));
		System.out.println("문자열 검색 = " + e.indexOf("날짜"));
		System.out.println("문자열 검색 = " + e.indexOf("개바부"));
		
		
	}
}
