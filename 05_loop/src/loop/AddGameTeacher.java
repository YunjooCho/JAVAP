package loop;

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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddGameTeacher {

	public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int a, b, user, count;
	      int yn;
	      
	      while(true) {
	         count=0;
	         for(int i=1; i<=5; i++){//5����
	            a = (int)(Math.random()*90)+10;//10~99
	            b = (int)(Math.random()*90)+10;
	            
	            System.out.print("[����"+i+"] "+a + " + " + b + " = ");
	            user = Integer.parseInt(br.readLine());
	            
	            if((a+b) == user) {
	               System.out.println("������");
	               count++;
	            }else {
	               System.out.println("Ʋ�ȴ�");
	            }
	         }//for
	         
	         System.out.println();
	         System.out.println("����� �� "+count+"������ ���߾ "+count*20+"�� �Դϴ�");
	         
	         while(true) {
	            System.out.print("\n continue(y/n) : ");
	            yn = br.read();
	            br.read();
	            br.read();
	            
	            if(yn=='Y' || yn=='y' || yn=='N' || yn=='n') break;
	            else System.out.println("�߸��� �����Դϴ�");
	         }//while
	         
	         if(yn=='N' || yn=='n') break;
	      
	      }//while
	      
	      System.out.println("���α׷��� �����մϴ�");
	   }
}
