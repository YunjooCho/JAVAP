package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest2T {

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
			System.out.println("입력한 문자열의 크기가 작습니다");
		}else {
			str = str.toLowerCase();
			target = target.toLowerCase();
			
			index = count = 0;
			while((index = str.indexOf(target,index)) != -1) {//str안에 target문자열이 있으면
				System.out.println("index1 = " + index);//내가 확인용으로 작성한것
				//target문자열이 있는 곳을 index(0)번째 문자열부터 찾음
				index += target.length(); //index = index + target.length();
				System.out.println("index2 = " + index);//내가 확인용으로 작성한것
				count++;
			}
			
			System.out.println(str.replace(target, replaceing));
			System.out.println(count + "개 치환");
		}
	}

}
