package loop;


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
//�ڴٽ� �����ϱ�!!!!!!!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ForTest5 {

	public static void main(String[] args) throws IOException {
		//�޸� ���� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x;
		int y; 
		int calc = 1;
		
		
		//���
		for(int j = 1; j <=3; j++) { //�ش� ������ 3�� �ݺ�
			
			//Ű���� �Է�
			System.out.print("x�� �Է� : ");
			x = Integer.parseInt(br.readLine());
			System.out.print("y�� �Է� : ");
			y = Integer.parseInt(br.readLine());
			//int x = System.in.read()-'0';  ��-'0' : ����ȭ(-48�� ����)
			//System.in.read(); -�÷���1 ������ �̵�
			//System.in.read(); -�÷���2 ���� �ٷ� �̵�
			//int y = System.in.read()-'0';  ��-'0' : ����ȭ(-48�� ����)
		
			for(int i = 1; i <= y; i++) {
			
			calc *= x;		
			
			}//for i
			System.out.println(x + "�� " + y + "�� " + calc);
			calc = 1;
			System.out.println("--------------------------");
			
			
		}//for j

		
	}

}
