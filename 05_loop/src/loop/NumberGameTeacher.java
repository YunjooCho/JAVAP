package loop;

/*
���ڸ��߱� ����
1~100������ ������ �߻��Ͽ� ���ߴ� ����

[������]
���� �Է� : 50
50���� Ů�ϴ�

���� �Է� : 90
90���� �۽��ϴ�

...

���� �Է� : 87
������ xx������ ���߼̽��ϴ�        

continue(Y/N) : n
���α׷��� �����մϴ�
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGameTeacher {

	public static void main(String[] args) throws IOException {
		//�޸𸮻���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����
		int com, user, count = 0;
		String yn;
		
		for(;;) { //while(true)�� ����
			com = (int)(Math.random()*100)+1;
		
			while(true) {
			
			
				//����ڰ� ������ �Է�
				System.out.print("���� �Է� : ");
				user = Integer.parseInt(br.readLine());
				count++; //1,2,3,4,5,....
			
				//��
				if(com > user)
					System.out.print(user + "���� Ů�ϴ�\n");
			
				else if(com < user)
					System.out.print(user + "���� �۽��ϴ�\n");
			
				else
					break;
			

			
			}//while
			System.out.println("������~" + count + "�� ���� ���߼̽��ϴ�");
			System.out.println("----------------------------------");
			
			while(true) {
				System.out.print("continue(Y/N) : ");
				yn = br.readLine();
				
				//�� while���� ��� ����� Y/y/N/n�̸�  ��������
				if(yn.contentEquals("Y")||yn.contentEquals("y")||yn.contentEquals("N")||yn.contentEquals("n"))
					break;
				//�� ���� ���ڴ� �ݺ��� ����
			}//continue�� while
			
				if(yn.equals("n")||yn.equals("N")) break; // for�� ������
			

		}//for
		System.out.println("���α׷��� �����մϴ�");
	}

}
