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
//선생님 풀이

import java.io.IOException;

public class ForTest55 {

	public static void main(String[] args) throws IOException{
		
		for(int j=1;j<=3;j++) { //3번 반복 j=1
		  System.out.print("x값 입력 : ");
	      int x = System.in.read()-48; //1개 문자
	      System.in.read(); //버퍼 비우기
	      System.in.read();
	      
	      System.out.print("y값 입력 : ");
	      int y = System.in.read()-'0';
	      System.in.read(); //버퍼 비우기
	      System.in.read();
	      
	      int mul = 1; //초기화
	      for(int i=1; i<=y; i++) { //1, 2, 3, 4,....
	         mul *= x;
	      }//for i
	      
	      System.out.println(x+"의 "+y+"승은 "+mul);
	      System.out.println("-----------------");
	 
		}//for j
  }
}
