package practice;

/*
�ŵ������� ���Ͻÿ�
x�� y���� ����Ͻÿ�

[������]
x�� �Է� : 2
y�� �Է� : 5
2�� 5�� xx   (2*2*2*2*2)

x�� �Է� : 3
y�� �Է� : 4
3�� 4�� xx   (3*3*3*3)
 */
//������ Ǯ��
//��1���� �����Է����� ���


import java.io.IOException;

public class ForTest55 {
	public static void main(String[] args) throws IOException{
		
		//����
		int x, y, calc = 1;
		
		//�ݺ�
		for(int j = 1; j<=3; j++) {
			//Ű���� �Է�
			System.out.println("x�� �Է� : ");
			x = System.in.read()-48; //int��
			System.in.read(); //�÷��� ����
			System.in.read(); //�÷��� ����
			
			System.out.println("y�� �Է� : ");
			y = System.in.read()-48; //int��
			System.in.read(); //�÷��� ����
			System.in.read(); //�÷��� ����
			
			
			//���(for)
			calc = 1; //�ʱ�ȭ
			for(int i = 1; i <= y; i++) {
				calc *= x;
			}//���for
			
			//���
			System.out.println(x + "�� " + y + "�� " + calc);
			System.out.println("-----------------------------");
			
			
		}//�ݺ� for j	
		
		
	}
}
