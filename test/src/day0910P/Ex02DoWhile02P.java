package day0910P;

//사용자로부터 점수를 입력받아서
//총점을 계산해주는 프로그램
//단 사용자가 입력한 점수가 잘못된 형식(0보다 적거나 100보다 큰 셩우)
//일 때에는
//올바른 점수가 들어올 때 까지
//다시 입력받는다.
//입력을 할 때에는 do while을 사용하도록 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex02DoWhile02P {

	public static void main(String[] args) throws IOException {
		//메모리 생성
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//변수 
		int kor = 0, eng = 0, math = 0;
			
		//반복문		
		do {
			System.out.print("국어 점수 입력 : ");
			kor = Integer.parseInt(bufferedReader.readLine());
			if( kor > 100 || kor < 0) {
				System.out.println("잘못된 형식입니다\n다시 입력하세요");		
			}
		}while (kor > 100 || kor < 0);
		
		do {
			System.out.print("영어 점수 입력 : ");
			eng = Integer.parseInt(bufferedReader.readLine());
			if( eng > 100 || eng < 0) {
				System.out.println("잘못된 형식입니다\n다시 입력하세요");		
			}
		}while (eng > 100 || eng < 0);
		
		do {
			System.out.print("수학 점수 입력 : ");
			math = Integer.parseInt(bufferedReader.readLine());
			if( math > 100 || math < 0) {
				System.out.println("잘못된 형식입니다\n다시 입력하세요");		
			}
		}while (math > 100 || math < 0);
		
		int tot = kor + eng + math;
		System.out.println("총점 : " + tot);
	}

}
