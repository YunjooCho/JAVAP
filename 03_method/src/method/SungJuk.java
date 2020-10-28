package method;

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

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SungJuk {
	
	public static void main(String[] args) throws IOException {
		
		//메모리 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		System.out.println("[실행결과]");
		System.out.println("이름입력 : ");
		String name = br.readLine();
		System.out.println("국어 : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("영어 : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("수학 : ");
		int math = Integer.parseInt(br.readLine());
		
		//총점 메소드, 평균 메소드
		SungJuk sungJuk = new SungJuk(); 
		int tot = sungJuk.calcTot(kor, eng, math);
		double avg = sungJuk.calcAvg(tot);
		
		
		//총점&평균 다른 풀이
		//int tot = kor + eng + math;
		//double avg = (double)tot / 3;
		
		//출력
		System.out.println("\t *** " + name + " 성적 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg));
		

	}

	public int calcTot(int kor, int eng, int math) { 
		//구현, ko = kor & en = eng & ma = math로 잡아도 됨(메모리가 다름)
		return kor + eng + math;
			
	}
	
	public double calcAvg(int tot) {
		return tot / 3.0;
	}
	
}
