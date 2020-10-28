package p06_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
public class StringTest2TP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str, target, replaceing;
		int index, count;
		
		System.out.println("문자열 입력 : ");
		str = br.readLine();
		
		System.out.println("현재 문자열 입력 : ");
		target = br.readLine();
		
		System.out.println("바꿀 문자열 입력 : ");
		replaceing = br.readLine();
		
		if(str.length() < target.length()) {
			System.out.println("입력한 문자열의 크기가 작습니다.");
		}else {
			str = str.toLowerCase();
			target = target.toLowerCase();
			
			index = count = 0;
			while((index = str.indexOf(target,index)) != -1) { //target문자열이 있는 곳을 index(0)번째 문자열부터 찾음
				index += target.length();
				count++;
			}
			
			System.out.println(str.replace(target, replaceing));
			System.out.println(count + "개 치환");
		}
		

	}

}
