package day0910P;



//������ �����
//�Է¹��� ������ �� ����ϱ�

import java.io.IOException;

public class Ex03NestedForP02 {

	public static void main(String[] args) throws IOException{
		
		//����
		int user;
		int dan;
		
		//�ݺ���(������)
		System.out.print("���ϴ� ���� �Է��ϼ��� : ");
		user = System.in.read() - 48;
		for(int i = 1; i <= user; i++) {
			for(int j = 1; j <= 9; j++) {
				dan = i * j; 
				System.out.println(i + " * " + j + " = " + dan);
			}
		}

	}

}
