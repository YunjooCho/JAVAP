package class_constructor;

import java.util.Scanner;

/*
5������ ������ ä���ϴ� ���α׷�
1������ 5������ ��� ���� ���� 1�̴�
1������ 20���� ����Ѵ�

�̸� �Է� : ȫ�浿
��   �Է� : 12311

�̸�      1 2 3 4 5   ����
ȫ�浿   O X X O O   60
----------------
��ü �迭
�ο��� �Է� : 3

�̸� �Է� : ȫ�浿
�� �Է�    : 13211

�̸� �Է� : �ڳ�
�� �Է�    : 11111

�̸� �Է� : ��ġ
�� �Է�    : 13242

�̸�      1 2 3 4 5   ����
ȫ�浿    O X X O O   60
�ڳ�      O O O O O   100
��ġ      O X X X X   20
*/
public class Examination {
	private String name;
	private String dap; //"12311" - String�� ������ �迭�̶�� Ư�� �̿�
	private char[] ox;
	private int score;
	public static final String JUNG = "11111"; //����
	
	//������ - �������Է�
	//ScannerŬ����
	//1������
	public Examination() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("<1������>");
		System.out.print("�̸� �Է� : ");
		this.name = scanner.next();
		System.out.print("�� �Է� : ");
		this.dap = scanner.next();
	}
	
	//2������ //��������
	public Examination(String name, String dap) {
			this.name = name;
			this.dap = dap;
	}
	
	//�޼ҵ�
	//compare() - ��(����)
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
	
	//getter(����)
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
