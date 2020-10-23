package p06_class;

import java.util.Scanner;

public class ExaminationTP {
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	public static final String JUNG = "11111";
	
	public ExaminationTP() {
		Scanner scanner  = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		this.name = scanner.next();
		System.out.print("답 입력 : ");
		this.dap = scanner.next();
		
		ox = new char[dap.length()];
	}
	
	public void compare() {
		for(int i = 0; i < JUNG.length(); i++) {
			if(dap.charAt(i) == JUNG.charAt(i)) {
				ox[i] = 'O';
				score += 20;
			}else {
				ox[i] = 'X';
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getOx() {
		return ox;
	}
	
	public int getScore() {
		return score;
	}
}
