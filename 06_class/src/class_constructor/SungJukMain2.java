package class_constructor;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJukMain2 {

	//필드선언
//	static SungJuk[] ar;
//	static BufferedReader bufferedReader;
	
	public static void main(String[] args) throws IOException  {
		//선생님풀이
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("인원수 입력 : ");
		int count = Integer.parseInt(bufferedReader.readLine());
		SungJuk[] ar = new SungJuk[count];
		
//		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("인원수 입력 : ");
//		int count = Integer.parseInt(bufferedReader.readLine());
//		ar = new SungJuk[count-1];
		
		for(int i = 0; i < count; i++) {
			//add();
			//선생님 풀이
			System.out.print("이름 입력 : ");
			String name = bufferedReader.readLine();
			System.out.print("국어 입력 : ");
			int kor = Integer.parseInt(bufferedReader.readLine());
			System.out.print("영어 입력 : ");
			int eng = Integer.parseInt(bufferedReader.readLine());
			System.out.print("수학 입력 : ");
			int math = Integer.parseInt(bufferedReader.readLine());
			ar[i] = new SungJuk(name, kor, eng, math);
			ar[i].calc();
		}
		
		
		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");	
//		for(int i = 0; i < ar.length; i++) {
//			ar[i].calc();
//			System.out.println(ar[i].getName()+ "\t" 
//							   + ar[i].getKor() + "\t" 
//							   + ar[i].getEng() + "\t" 
//							   + ar[i].getMath() + "\t" 
//							   + ar[i].getTot() + "\t" 
//							   + String.format("%.2f", ar[i].getAvg()) + "\t"
//			                   + ar[i].getGrade());
//		}
		//선생님 풀이
		for(SungJuk data : ar) {
			System.out.println(data.getName()+ "\t" 
					   + data.getKor() + "\t" 
					   + data.getEng() + "\t" 
					   + data.getMath() + "\t" 
					   + data.getTot() + "\t" 
					   + String.format("%.2f", data.getAvg()) + "\t"
	                   + data.getGrade());
		}
		
		

	}
	
//	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
//		int value = Integer.parseInt(bufferedReader.readLine());
//		
//		while(value < minimum || value > maximum) {
//			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
//			value = Integer.parseInt(bufferedReader.readLine());
//		}
//		
//		return value;
//	}
//	
//	private static SungJuk setInfo() throws IOException {
//		
//		SungJuk s = new SungJuk();
//		System.out.println("이름 입력 : ");
//		s.setName(bufferedReader.readLine());
//		System.out.println("국어 입력 : ");
//		s.setKor(validateNumber(0,100));
//		System.out.println("영어 입력 : ");
//		s.setEng(validateNumber(0,100));
//		System.out.println("수학 입력 : ");
//		s.setMath(validateNumber(0,100));
//	
//		return s;
//	}
//	
//	private static SungJuk[] add(SungJuk[] ar, SungJuk s) {
//		//현재 배열을 임시 배열에 복사한다
//		int size = ar.length;
//		SungJuk[] temp = new SungJuk[size];
//		for(int i = 0; i < size; i++) {
//			temp[i] = ar[i];
//		}
//		
//		//배열의 크기를 1증가(증가와 동시에 초기화됨)
//		ar = new SungJuk[size + 1];
//		
//		//studentArray에 temp의 값 복사
//		for(int i = 0; i < size; i++) { //임시 배열의 크기에 맞춰 작성
//			ar[i] = temp[i];
//		}
//		
//		ar[size] = s; //postArray의 크기가 size+1로 증가했기 때문에 size가 
//							 //가장 마지막 인덱스가 됨, 마지막 인덱스에 추가 객체를 저장
//		
//		return ar;
//	}
//	
//	private static void add() throws IOException {
//		ar = add(ar, setInfo());
//	}
	
}
