package class_constructor;

import java.util.Scanner;

public class ExaminationT {
	//1.�ʵ弱��
	private String name;
	private String dap; //"12311" - String�� ������ �迭�̶�� Ư�� �̿�
	private char[] ox;
	private int score;
	public static final String JUNG = "11111"; //����
	
	//2.������ - �������Է�
	//ScannerŬ����
	//1������
	public ExaminationT() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		this.name = scanner.next();
		System.out.print("�� �Է� : ");
		this.dap = scanner.next();
		
		ox = new char[dap.length()]; //��������	
	}
	
	
	//3.�޼ҵ� �ۼ�
	public void compare() {
		for(int i = 0; i < ox.length; i++) {//��������
			if(dap.charAt(i) == JUNG.charAt(i)) {
				ox[i] = 'O';
				score += 20; //��������
			}else {
				ox[i] = 'X';
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getOX() {//�迭���� �ּҸ� ������ �ִ�(�����Ͱ��� �����ִ� ���� �ƴ�)
		return ox;
	}
	
	public int getScore() {
		return score;
	}
	
}
