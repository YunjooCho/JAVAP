package p05_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

//XX�� a++ 
//while(true){ //���� while�� �ϳ� & continued���� while�� 2��
//break;
//}
//for(;;){ <-���ѷ���
//}
//for(;true;){
//}
//continue(Y/N)  if��? - ȥ�� ���ϰ����� ���� �������̶� ���� while ���� while

public class NumberGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//a~b ������ ���� �߻� => (int)(math.random()*(b-a+1) + a);
		int number = (int)(Math.random()*100 + 1);
		int input;
		int count = 0;
		while(true) {
			
			++count;
			System.out.print("���� �Է� :");
			input = Integer.parseInt(br.readLine());
			
			if(input < number) {
				System.out.println(input + " ���� Ů�ϴ�");
			}else if(input > number) {
				System.out.println(input + "���� �۽��ϴ�");
			}else {
				System.out.println("������~ " + count + "������ ���߼̽��ϴ�.");
				System.out.print("continue(Y/N)? ");
				String yn = br.readLine().toUpperCase();
				while(true) {
					if(yn.contentEquals("Y")||yn.contentEquals("y")||yn.contentEquals("N")||yn.contentEquals("n"))
					break;
				}
				if(yn.equals("N")) {
					System.out.println("���α׷��� �����մϴ�");
					break;
				}
			}
		
		}

	}

}
