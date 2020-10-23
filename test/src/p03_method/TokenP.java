package p03_method;

import java.util.StringTokenizer;

public class TokenP {

	public static void main(String[] args) {
		
		//StringTokenizer클래스
		String str = "학원/집//게임방";
		
		StringTokenizer st = new StringTokenizer(str, "/"); //'/'로 구분한다고 선언 - 여러가지 기호가 올 수 있음
		System.out.println("토큰 개수 = " + st.countTokens());
		//3개, 자료가 없는 것은 무시됨(값이 아무것도 없는 것), " "의 경우는 32라는 값이 있음
		
		while(st.hasMoreTokens()) {//토큰이 있는지 없는지 True|False
			System.out.println(st.nextToken());
		}//토큰이 있는 동안 토큰 출력하기(토큰을 꺼내 다음 토큰을 찾아 이동)
		
		
		//차이점
		//for문은 사용할 수 없음
		//공백은 취급 안함
		
		System.out.println("---------------------------------------");
		
		//split()메소드
		String[] ar = str.split("/");
		//String클래스 함수, 배열로 꺼내옴
		//split라는 함수가 배열을 만들어 넘기는 함수(String[])라 new를 하지 않아도 됨
		for(String data : ar) {
			System.out.println(data);
		}//for
		System.out.println("ar배열 크기 = " + ar.length);
		//차이점
		//for문 사용가능
		//공백도 배열 인덱스를 하나 차지(배열도 취급함) - 0부터 시작

	}

}
