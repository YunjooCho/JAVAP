package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//배열에 for 문을 적용시켜봅시다.
public class Ex08Array02 {
	
	// 상수
	// 상수란 한번 값이 정해지면 더 이상 바꿀 수 없는 공간
	// 상수는 변수처럼 선언하고 사용하지만
	// 선언할 때 제일 앞에 final 이라는 키워드를 붙여서
	// 상수로 지정해주면 된다
	
	// 상수 이름은 snake 표기법을 사용한다.
	// snake표기법이란
	// 모든 글자를 다 대문자로 적어주고
	// 단어 사이에는 _를 넣어주는 방법을 뜻한다
	static final int SIZE = 5;

	public static void main(String[] args) throws IOException {
		//int 배열을 하나 만들어보자
		int[] array = new int [SIZE];
		
		//이 배열의 크기는 상수만큼의 크기를 갖기 때문에
		//크기가 5가 된다.
		
		//배열의 크기를 확인할 때에는
		//배열이름.length를 사용하면 된다.
		 System.out.println("배열의 크기 : " + array.length);
		 
		 //배열의 전체를 한번씩 찍어보자
		 //배열의 각 위치는 우리가 index를 통해서 접근하기 때문에
		 //for 문을 이용해 줄 수 있다.
		 for(int i = 0; i < array.length; i++) {
			 System.out.println(i+"번째의 값 : " + array[i]);
		 }
		 
		 //기본형 데이터타입 배열의 경우
		 //모든 값이 0으로 초기화가 된다

		 //for문을 통해서 각 위치에 값을 입력해주자
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		 for(int i = 0; i < array.length; i++) {
			 System.out.println(i + "번째의 값" + array[i]);
			 array[i] = Integer.parseInt(bufferedReader.readLine());
		 }
	}

}
