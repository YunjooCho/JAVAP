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
//������ Ǯ��

import java.io.IOException;

public class ForTest55 {

	public static void main(String[] args) throws IOException{
		
		for(int j=1;j<=3;j++) { //3�� �ݺ� j=1
		  System.out.print("x�� �Է� : ");
	      int x = System.in.read()-48; //1�� ����
	      System.in.read(); //���� ����
	      System.in.read();
	      
	      System.out.print("y�� �Է� : ");
	      int y = System.in.read()-'0';
	      System.in.read(); //���� ����
	      System.in.read();
	      
	      int mul = 1; //�ʱ�ȭ
	      for(int i=1; i<=y; i++) { //1, 2, 3, 4,....
	         mul *= x;
	      }//for i
	      
	      System.out.println(x+"�� "+y+"���� "+mul);
	      System.out.println("-----------------");
	 
		}//for j
  }
}
