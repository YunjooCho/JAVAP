package class_constructor;

import java.util.Scanner;

public class ExaminationMain {
	
	
	
	public static void main(String[] args) {
		//System.in.read(); - 1개의 문자
		//BufferedReader
		//JDK 5.0 - Scanner : 기본 생성자가 없음
		Scanner scan = new Scanner(System.in); 
		//Scanner scan = new Scanner(); - error : The constructor Scanner() is undefined
		//InputStream 타입 : System.in
		//Socket도 InputStream 타입 (채팅)
		//flush는 기본 필요 없으나 반복문으로 돌릴 때 못읽는 경우가 있음
		//예외처리 필요 없음, import문 필요함
		//System.out.print("문자열 입력 : ");
		//String str = scan.next();//문자열 받음
		
		//정수
		//scan.nextInt();
		//scan.nextDouble();	
		
		//1번문제 //★차이점
		Examination ex = new Examination();
		System.out.println("이름\t1 2 3 4 5\t점수");
		ex.compare();
		System.out.println(ex.getName() + "\t"
					     + ex.getOx(0) + " " + ex.getOx(1) + " " + ex.getOx(2) + " "
					     + ex.getOx(3) + " " + ex.getOx(4) + "\t"
					     + ex.getScore());
		
		//2번문제
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("<2번문제>");
		System.out.print("인원수 입력 : ");
		int people = scanner.nextInt();
		Examination[] arr = new Examination[people];
		for(int i = 0; i < arr.length; i++) {
			System.out.print("이름 입력 : ");
			String name = scanner.next();
			System.out.print("답 입력 : ");
			String dap = scanner.next();
			arr[i] = new Examination(name, dap); //★차이점
			arr[i].compare();
			System.out.println();
		}
		
		//★차이점 - 선생님 풀이 참조
		System.out.println("이름\t1 2 3 4 5\t점수");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getName() + "\t"
				     + arr[i].getOx(0) + " " + arr[i].getOx(1) + " " + arr[i].getOx(2) + " "
				     + arr[i].getOx(3) + " " + arr[i].getOx(4) + "\t"
				     + arr[i].getScore());
		}
			
		
	}

}
