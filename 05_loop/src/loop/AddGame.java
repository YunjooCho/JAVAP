package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
���ϱ� ���� ���α׷�
10~99 ������ ������ 2��(a, b) �߻��Ͽ� ���� ���ϴ� ���α׷�
�������� �� 5������ �����Ѵ� - for
1������ ���� 20���� ���

[������]
[1] 25 + 36 = 45
Ʋ�ȴ�

[2] 78 + 10 = 88
������
...

[5] 12 + 25 = 37
������

����� �� x������ ���߾ xx�� �Դϴ�

�� �ҷ� (Y/N) : n
���α׷��� �����մϴ�
 */

public class AddGame {

	public static void main(String[] args) throws IOException {
		
		//�޸𸮻���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a, b, sum = 0, count = 0 , user, rightanswer = 0;
		String yn;
		
		//����
		a = (int)(Math.random()*90)+10;
		b = (int)(Math.random()*90)+10;
		
	
		
		//�ݺ���
		while(true) {
			count = 0;
			rightanswer = 0;
			
			for(int i = 1 ; i <= 5; i++) {
			
				//���ڼ���
				count++;
				//���
				sum = a + b;
			
			
				//���
				System.out.print("[" + count + "]" + a +" + "+ b + " = ");
			
				//����� �Է�
				user = Integer.parseInt(br.readLine());
			
				//����Ȯ��
				if (sum != user) {
					System.out.println("Ʋ�ȴ�");
					a = (int)(Math.random()*90)+1;
					b = (int)(Math.random()*90)+1;
				
				}else {
					rightanswer++;
					System.out.println("������");
					a = (int)(Math.random()*90)+1;
					b = (int)(Math.random()*90)+1;
				}
			
			
			
			}//for
			System.out.println("����� �� " + rightanswer + "������ ���߾ " + (rightanswer * 20) + "�� �Դϴ�");
		
			while(true) {
				System.out.print("���ҷ�(Y/N) : ");
				yn = br.readLine();
			
				// Y/y/N/n�̸�  ��������
				if(yn.contentEquals("Y")||yn.contentEquals("y")||yn.contentEquals("N")||yn.contentEquals("n")) {
					break;
				}else {
					System.out.println("�߸��� ����Դϴ�");
				}
				//�� ���� ���ڴ� �ݺ��� ����
			
				}//���ҷ� ����while
			//N/n�̸� while ��������
			if(yn.contentEquals("N")||yn.contentEquals("n")) {
				break;
			}
		}//���ҷ� �ݺ� while
		
		System.out.println("���α׷��� �����մϴ�");
	}

}
