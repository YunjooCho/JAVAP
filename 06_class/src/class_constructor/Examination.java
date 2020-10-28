package class_constructor;

import java.util.Scanner;

/*
5문제의 시험지 채점하는 프로그램
1번부터 5번까지 모든 답은 전부 1이다
1문제당 20점씩 계산한다

이름 입력 : 홍길동
답   입력 : 12311

이름      1 2 3 4 5   점수
홍길동   O X X O O   60
----------------
객체 배열
인원수 입력 : 3

이름 입력 : 홍길동
답 입력    : 13211

이름 입력 : 코난
답 입력    : 11111

이름 입력 : 또치
답 입력    : 13242

이름      1 2 3 4 5   점수
홍길동    O X X O O   60
코난      O O O O O   100
또치      O X X X X   20
*/
public class Examination {
	private String name;
	private String dap; //"12311" - String은 문자의 배열이라는 특성 이용
	private char[] ox;
	private int score;
	public static final String JUNG = "11111"; //정답
	
	//생성자 - 데이터입력
	//Scanner클래스
	//1번문제
	public Examination() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("<1번문제>");
		System.out.print("이름 입력 : ");
		this.name = scanner.next();
		System.out.print("답 입력 : ");
		this.dap = scanner.next();
	}
	
	//2번문제 //★차이점
	public Examination(String name, String dap) {
			this.name = name;
			this.dap = dap;
	}
	
	//메소드
	//compare() - 비교(공용)
	public void compare() {
		ox = new char[JUNG.length()];
		int count = 0;
		for(int i = 0; i < JUNG.length(); i++) {
			if((dap.charAt(i)==JUNG.charAt(i))) {
				ox[i] = 'O';
				count++;
			}else {
				ox[i] = 'X';
			}
			score = count * 20;
		}
	}
	
	//getter(공용)
	public String getName() {
		return name;
	}
	
	public char getOx(int index) {
		return ox[index];
	}
	
	public int getScore() {
		return score;
	}
	
	
	
	
}
