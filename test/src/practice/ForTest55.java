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
//선생님 풀이
//★1개의 문자입력으로 사용


import java.io.IOException;

public class ForTest55 {
	public static void main(String[] args) throws IOException{
		
		//변수
		int x, y, calc = 1;
		
		//반복
		for(int j = 1; j<=3; j++) {
			//키보드 입력
			System.out.println("x값 입력 : ");
			x = System.in.read()-48; //int형
			System.in.read(); //플러쉬 삭제
			System.in.read(); //플러쉬 삭제
			
			System.out.println("y값 입력 : ");
			y = System.in.read()-48; //int형
			System.in.read(); //플러쉬 삭제
			System.in.read(); //플러쉬 삭제
			
			
			//계산(for)
			calc = 1; //초기화
			for(int i = 1; i <= y; i++) {
				calc *= x;
			}//계산for
			
			//출력
			System.out.println(x + "의 " + y + "승 " + calc);
			System.out.println("-----------------------------");
			
			
		}//반복 for j	
		
		
	}
}
