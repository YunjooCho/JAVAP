package practice;

/*
거듭제곱을 구하시오
x의 y승을 계산하시오

[실행결과]
x값 입력 : 2
y값 입력 : 5
2의 5승 xx   (2*2*2*2*2)

x값 입력 : 3
y값 입력 : 4
3의 4승 xx   (3*3*3*3)
 */
//★Buffered 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest5P {

	public static void main(String[] args) throws IOException {
		//메모리 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//변수
		int x, y, result = 1;
		
		//무한으로 반복
		while(true) {
			
			
			//키보드 입력
			System.out.print("x값 입력 : ");
			x = Integer.parseInt(br.readLine());
			System.out.print("y값 입력 : ");
			y = Integer.parseInt(br.readLine());
			
			//계산
			for(int i = 1; i <= y; i++) {
				
				 result *= x;
			
			}//for
			
			
			
			System.out.println(x + "의 " + y + "승 " + result); 
			System.out.println("----------------------------");	
			//반복에 대한 초기화
			result = 1;
			
		}//while
	}
}
