package if_switch;
/*
이름(name),국어(kor),영어(eng),수학(math)점수를 입력받아서 
총점(tot),평균(avg), 학점(grade)을 구하시오

평균이 90이상이면 'A'학점
평균이 80이상이면 'B'학점
평균이 70이상이면 'C'학점
평균이 60이상이면 'D'학점
그외는 'F'학점


[실행결과]
이름 입력 : 홍길동 
국어 입력 : 78  
영어 입력 : 89  
수학 입력 : 100

   *** 홍길동 성적 ***
국어      영어      수학      총점      평균      학점
78     89   100    xxx   xx.xxx   x
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SungJuk {

	public static void main(String[] args) throws IOException {
		//메모리 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		System.out.println("이름 입력 :");
		String name = br.readLine();
		System.out.println("국어 입력 :");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("영어 입력 :");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("수학 입력 :");
		int math = Integer.parseInt(br.readLine());
		char grade;
		
		//계산
		int tot = kor + eng + math;
		double avg = (double)tot / 3;
		
		
//		//if문
//		if (avg >= 90) {
//			grade = 'A';
//		}else if (avg >= 80) {
//			grade = 'B';
//		}else if (avg >= 70) {
//			grade = 'C';
//		}else if (avg >= 60) {
//			grade = 'D';
//		}else {
//			grade = 'F';
//		}
		
		
		//switch문
		switch((int)avg / 10) {
		case 10 : 
		case 9 : grade = 'A';
		         break;
		case 8 : grade = 'B';
				 break;
		case 7 : grade = 'C';
				 break;
		case 6 : grade = 'D';
				 break;
		default : grade = 'F';
		}
		
		//출력
		System.out.println("\t *** " + name + " 성적표 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg) + "\t" + grade);
		
	}

}
