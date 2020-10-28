package loop;


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
//★다시 정리하기!!!!!!!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ForTest5 {

	public static void main(String[] args) throws IOException {
		//메모리 생성 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x;
		int y; 
		int calc = 1;
		
		
		//계산
		for(int j = 1; j <=3; j++) { //해당 내용을 3번 반복
			
			//키보드 입력
			System.out.print("x값 입력 : ");
			x = Integer.parseInt(br.readLine());
			System.out.print("y값 입력 : ");
			y = Integer.parseInt(br.readLine());
			//int x = System.in.read()-'0';  ※-'0' : 정수화(-48도 가능)
			//System.in.read(); -플러쉬1 앞으로 이동
			//System.in.read(); -플러쉬2 다음 줄로 이동
			//int y = System.in.read()-'0';  ※-'0' : 정수화(-48도 가능)
		
			for(int i = 1; i <= y; i++) {
			
			calc *= x;		
			
			}//for i
			System.out.println(x + "의 " + y + "승 " + calc);
			calc = 1;
			System.out.println("--------------------------");
			
			
		}//for j

		
	}

}
