package p03_method;
/*
이름(name), 국어(kor), 영어(eng), 수학(math)점수를 입력받아서 총점(tot),평균(avg)를 구하시오

총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수

[실행결과]
이름 입력 : 홍길동
국어 입력 : 95
영어 입력 : 90
수학 입력 : 91

  *** 홍길동 성적 ***
국어      영어      수학      총점      평균
95      90      91      xxx      xx.xxx
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SungJuk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 입력 : ");
		String name = br.readLine();
		System.out.print("국어 입력 : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.print("영어 입력 : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.print("수학 입력 : ");
		int math = Integer.parseInt(br.readLine());
		
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		
		System.out.println("\t*** " + name + " 성적 ***");
		System.out.println("");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg));

	}

}
