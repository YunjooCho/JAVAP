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
//��Buffered ���

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest5P {

	public static void main(String[] args) throws IOException {
		//�޸� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����
		int x, y, result = 1;
		
		//�������� �ݺ�
		while(true) {
			
			
			//Ű���� �Է�
			System.out.print("x�� �Է� : ");
			x = Integer.parseInt(br.readLine());
			System.out.print("y�� �Է� : ");
			y = Integer.parseInt(br.readLine());
			
			//���
			for(int i = 1; i <= y; i++) {
				
				 result *= x;
			
			}//for
			
			
			
			System.out.println(x + "�� " + y + "�� " + result); 
			System.out.println("----------------------------");	
			//�ݺ��� ���� �ʱ�ȭ
			result = 1;
			
		}//while
	}
}
