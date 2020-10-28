package day0910P;
//배열
//배열이란 똑같은 자료형이 모여있는 것을 가리킴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예시:
//인트 배열이라고 하면
//인트가 사용자 지정한 만큼의 갯수가 모여있고
//그 전체를 하나의 배열이라고 한다
public class Ex07ArrayP {

	public static void main(String[] args) throws IOException {
		//배열 선언
		int[] arr = new int[5];
		
		arr[0] = 15;
		System.out.println("arr[0] = " + arr[0]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "번 인덱스에 입력할 값 : ");
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		
		int size = 10;
		arr = new int[size];
		System.out.println(arr[10]);
	}

}
