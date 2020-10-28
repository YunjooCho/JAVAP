package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사용자로부터 점수를 입력받아서
//총점을 계산해주는 프로그램
//단 사용자가 입력한 점수가 잘못된 형식(0보다 적거나 100보다 큰 셩우)
//일 때에는
//올바른 점수가 들어올 때 까지
//다시 입력받는다.
//입력을 할 때에는 do while을 사용하도록 한다.

public class Ex05GrandBookP2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int kor = 0, eng = 0, math = 0;

		do {
			if(kor < 0 || kor > 100) {
				System.out.println("잘못입력하셨습니다");
			}
			System.out.print("국어점수 : ");
			kor = Integer.parseInt(br.readLine());
		}while(kor < 0 || kor > 100);
		
		do {
			if(eng < 0 || eng > 100) {
				System.out.println("잘못입력하셨습니다");
			}
			System.out.print("영어점수 : ");
			eng = Integer.parseInt(br.readLine());
		}while(eng < 0 || eng > 100);
		
		do {
			System.out.print("수학점수 : ");
			math = Integer.parseInt(br.readLine());
			if(math < 0 || math > 100) {
				System.out.println("잘못입력하셨습니다");
			}
		}while(math < 0 || math > 100);
		
		int sum = kor + eng + math;
		System.out.println("총점  = " + sum);
			
			
	}

}
