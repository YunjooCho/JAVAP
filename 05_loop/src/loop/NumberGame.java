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

//XX�� a++ 
//while(true){ //���� while�� �ϳ� & continued���� while�� 2��
//break;
//}
//for(;;){ <-���ѷ���
//}
//for(;true;){
//}
//continue(Y/N)  if��? - ȥ�� ���ϰ����� ���� �������̶� ���� while ���� while

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NumberGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//a~b ������ ���� �߻� => (int)(math.random()*(b-a+1) + a);
		int num = (int)(Math.random()*100)+1; //1~100����
		int inp;
		int count = 0;
		String yn;
		
		//�ݺ�
		for(;;) {
			//�Է¹ޱ�		
			while (true) {
				
				//���° ���ڼ���
				++count;	
				System.out.println("���� �Է� : ");
				inp = Integer.parseInt(br.readLine());
			
				//��, ���
				if(num > inp) { 
					System.out.println(inp + "���� Ů�ϴ�");
				}else if(num < inp) {
					System.out.println(inp + "���� �۽��ϴ�");
				}else {
					 break;
				}	
						
				
			}//while
			System.out.println("������~" + count + "������ ���߼̽��ϴ�");
			System.out.println("--------------------------------");
			
			while(true) {
				
				System.out.println("continue(Y/N)?");
				yn = br.readLine();
			
				if(yn.equals("n") || yn.equals("N") || yn.equals("y") || yn.equals("Y")) {
					break; 
				}else {
					System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
				}
				
			}//continue�� while
			if(yn.equals("n") || yn.equals("N")) break;
			
		}//for		
		System.out.println("���α׷��� �����߽��ϴ�");	
		
	}

}
