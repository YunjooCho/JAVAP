package p06_class;

import java.util.Scanner;

public class AssertP {

	public static void main(String[] args) {		
		AssertP as = new AssertP();
		as.inPut();
		as.outPut();
	}
	
	private int x, y, result = 1;
	
	public void inPut() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x �Է� : ");
		x = scanner.nextInt();
		System.out.print("y �Է� : ");
		y = scanner.nextInt();
	}
	
	public void outPut() {
		assert y >= 0 : "y�� 0���� ũ�ų� ���ƾ� �Ѵ�"; //�����޽���
		
		//���α׷����� ������ ��
		for(int i = 1; i <= y; i++) {
			result *= x;
		}
		System.out.println(x + "�� " + y + "�� : " + result);
	}

}
