package method;

/*
 ch에 있는 데이터가 대문자이면 소문자로 출력하고 아니면(소문자) 대문자로 출력하시오
 
 [실행결과]
  T -> t
  
  또는
  
  e -> E
 */

public class CompTest2 {
	public static void main(String[] args) {
		char ch = 'P';
				
		//대문자(A~Z) -> 65 ~ 90
		int result = ch >= 65 && ch <= 90 ? ch + 32 : ch - 32;
		System.out.println(ch + " -> " + (char)result);
		
		
		//<선생님 풀이>
		//char로 계산하면 결과값은 int형으로 변환됨
		//int result = ch>= 'A' && ch <= 'Z' ? ch + 32 : ch - 32;
		//System.out.println(ch + " -> " + (char)result);
	}
}
