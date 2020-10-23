package class_constructor;

import java.util.Scanner;

public class ExaminationT {
	//1.필드선언
	private String name;
	private String dap; //"12311" - String은 문자의 배열이라는 특성 이용
	private char[] ox;
	private int score;
	public static final String JUNG = "11111"; //정답
	
	//2.생성자 - 데이터입력
	//Scanner클래스
	//1번문제
	public ExaminationT() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		this.name = scanner.next();
		System.out.print("답 입력 : ");
		this.dap = scanner.next();
		
		ox = new char[dap.length()]; //★차이점	
	}
	
	
	//3.메소드 작성
	public void compare() {
		for(int i = 0; i < ox.length; i++) {//★차이점
			if(dap.charAt(i) == JUNG.charAt(i)) {
				ox[i] = 'O';
				score += 20; //★차이점
			}else {
				ox[i] = 'X';
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getOX() {//배열명은 주소를 가지고 있다(데이터값을 갖고있는 것이 아님)
		return ox;
	}
	
	public int getScore() {
		return score;
	}
	
}
