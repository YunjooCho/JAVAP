package class_constructor;

import java.util.Scanner;

public class Assert { //���α׷��� ����� ����Ǵ��� Ȯ�� - �߰�üũ
	//1.�ʵ�� ����
	private  int x, y , result = 1;
	
	//2.�޼ҵ� �ۼ�
	public void inPut() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x �Է� : ");
		x = scanner.nextInt();
		System.out.print("y �Է� : ");
		y = scanner.nextInt(); //Ƚ��
	}
	
	public void outPut() {
		//y�� �ݵ�� ����� �Է¹޵��� �ϰڴ�
		//y�� ������ ������ �۾��� ����
		//�׳� Run As�� �ƴ� Run As - Run Configrations - arguments - VM arguments���� -ea�Է�
		//-da�� ����Ʈ
		//����� ó��
		//assert y >= 0;
		assert y >= 0 : "y�� 0���� ũ�ų� ���ƾ� �Ѵ�"; 
		//�����޽��� 
		//Exception in thread "main" java.lang.AssertionError: y�� 0���� ũ�ų� ���ƾ� �Ѵ�
		
		//���α׷����� ������ ��
		for(int i = 1; i <= y; i++) {
			 result *= x; //��� x�� ���� ���Ѵ�
		}
		
		System.out.println(x + "�� " + y + "���� " + result);
	}
	
	public static void main(String[] args) {
		Assert as = new Assert();
		as.inPut();
		as.outPut();
	}
}

//�������� ���ϴ� ���α׷�
// x�Է� : 2
// y�Է� : 5               input() - �Է�(Scanner)
//--------------------------------
// 2�� 5���� xx             output() - ���, ���