package loop;

/*
더하기 연습 프로그램
10~99 사이의 난수를 2개(a, b) 발생하여 합을 구하는 프로그램
문제수는 총 5문제를 제공한다 - for
1문제당 점수 20점씩 계산

[실행결과]
[1] 25 + 36 = 45
틀렸다

[2] 78 + 10 = 88
딩동뎅
...

[5] 12 + 25 = 37
딩동뎅

당신의 총 x문제를 맞추어서 xx점 입니다

또 할래 (Y/N) : n
프로그램을 종료합니다
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddGameTeacher {

	public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int a, b, user, count;
	      int yn;
	      
	      while(true) {
	         count=0;
	         for(int i=1; i<=5; i++){//5문제
	            a = (int)(Math.random()*90)+10;//10~99
	            b = (int)(Math.random()*90)+10;
	            
	            System.out.print("[문제"+i+"] "+a + " + " + b + " = ");
	            user = Integer.parseInt(br.readLine());
	            
	            if((a+b) == user) {
	               System.out.println("딩동뎅");
	               count++;
	            }else {
	               System.out.println("틀렸다");
	            }
	         }//for
	         
	         System.out.println();
	         System.out.println("당신의 총 "+count+"문제를 맞추어서 "+count*20+"점 입니다");
	         
	         while(true) {
	            System.out.print("\n continue(y/n) : ");
	            yn = br.read();
	            br.read();
	            br.read();
	            
	            if(yn=='Y' || yn=='y' || yn=='N' || yn=='n') break;
	            else System.out.println("잘못된 문자입니다");
	         }//while
	         
	         if(yn=='N' || yn=='n') break;
	      
	      }//while
	      
	      System.out.println("프로그램을 종료합니다");
	   }
}
