package method;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "학원,집,,게임방";
		
		//StringTokenizer클래스의 countTokens()메소드, 파라미터가 있는 생성자(str, ",")
		//표시를 기준으로 잘라냈을 때 잘라내진 것들의 갯수
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰 개수 = " + st.countTokens()); 
		//3개, 자료가 없는 것은 무시됨 - 공백(값이 아예 없는, 비어있는 경우)
		//" "의 경우는 (32라는 값이 있음) 자료가 있는 것으로 처리
		
		//hasMoreTokens()메소드
		while(st.hasMoreTokens()) {//true / false
			System.out.println(st.nextToken());
		}//while - 토큰이 있는 동안 토큰 출력하기(토큰을 꺼내 다음 토큰을 찾아 이동)
		
		//차이점
		//for문 사용 못함
		//공백은 취급 안함
		
		System.out.println("------------------------------------");
		
		//String클래스의 split()메소드
		String[] ar = str.split(","); 
		//String클래스 함수, 배열로 꺼내옴
		//split이라는 함수가 배열을 만들어 넘기는 함수(String[])라 new를 하지 않아도 됨
		for(String data : ar) {
			System.out.println(data);
		}//for
		System.out.println("ar배열 크기 = " + ar.length);
		
		//차이점
		//for문 사용
		//공백도 배열 인덱스 하나 차지(배열도 취급함) - 0부터 시작
	}

}
