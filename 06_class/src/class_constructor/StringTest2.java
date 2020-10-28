package class_constructor;

/*
치환하는 프로그램을 작성하시오
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : cc
ccbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : cc
ccbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : cc
ccbbcc
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다

indexOf()
replace(??, ??)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest2 {
	//필드명
	private String inputWord;
	private String keyWord;
	private String changeWord;
	private int count;
	
	//생성자
	public StringTest2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열 입력 : ");
		this.inputWord = br.readLine().toLowerCase();
		System.out.print("현재 문자열 입력 : ");
		this.keyWord = br.readLine().toLowerCase();//★★★★★똑같이 소문자로 변환해야함
		System.out.print("바꿀 문자열 입력 : ");
		this.changeWord = br.readLine();
		
		while(inputWord.length() < keyWord.length() || inputWord.length() < changeWord.length()) {
			System.out.println("입력한 문자열의 크기가 작습니다.");
			System.out.print("현재 문자열 입력 : ");
			this.keyWord = br.readLine();
			System.out.print("바꿀 문자열 입력 : ");
			this.changeWord = br.readLine();
		}
	}
	
	public void replaceString() {
		
		//★★★★★치환 횟수 확인(미완성)
		
		int index = count = 0;
		while((index = inputWord.indexOf(keyWord, index)) != -1) {
			index += keyWord.length();
			count++;
		}
		
		
		//글자 변환
		inputWord = inputWord.replace(keyWord, changeWord);
		//원본의 값은 바뀌지 않음 : 예)aabbaa aa->cc 결과값 : ccbbcc
		//원본은 aabbaa그대로
		//<강사님 풀이>
		
		
		//출력
		StringBuffer buffer = new StringBuffer();
		buffer.append(inputWord);
		System.out.println(buffer);
		buffer.append(count);
		buffer.append("번 치환");
		buffer.delete(0, inputWord.length());
		System.out.println(buffer);
		
		
	}
	

	public static void main(String[] args) throws IOException {
		
		StringTest2 st = new StringTest2();
		st.replaceString();
		
	}
}

//<참고내용>
//String str = "aabbaa"
//System.out.println(str.replace("aa","tt"));
//System.out.println("str=" + str);
//원본의 값은 바뀌지 않음 : 예)aabbaa aa->tt 결과값 : ttbbtt
//원본은 aabbaa그대로

//System.out.println(str.indexOf("aa"));
//System.out.println(str.indexOf("aa",2));-2번째부터 위치 찾기
