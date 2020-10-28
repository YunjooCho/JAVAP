package p06_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/*
SungJuk 클래스 이용하시오
객체 배열

[실행결과]
인원수 입력 : 2

이름 입력 : 홍길동
국어 입력 : 85
영어 입력 : 93
수학 입력 : 100

이름 입력 : 코난
국어 입력 : 75
영어 입력 : 86
수학 입력 : 92

----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동   85      93      100
코난      75      86      92
 */
public class SungJukMain2P {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("인원 수 입력 : ");
		int number = Integer.parseInt(br.readLine());
		
		SungJukP[] arr = new SungJukP[number];
		
		for(int i = 0; i < number; i++) {
			System.out.print("이름 입력 : ");
			String name = br.readLine();
			System.out.print("국어 입력 : ");
			int kor = Integer.parseInt(br.readLine());
			System.out.print("영어 입력 : ");
			int eng = Integer.parseInt(br.readLine());
			System.out.print("수학 입력 : ");
			int math = Integer.parseInt(br.readLine());
			arr[i] = new SungJukP(name, kor, eng, math);
			arr[i].calc();
			System.out.println();
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");		
		for(SungJukP data : arr) {
			System.out.println(data.getName()+ "\t" 
					   + data.getKor() + "\t" 
					   + data.getEng() + "\t" 
					   + data.getMath() + "\t" 
					   + data.getTot() + "\t" 
					   + String.format("%.2f", data.getAvg()) + "\t"
	                   + data.getGrade());
		}
	}

}
