package p05_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class ForTest5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("x�� �Է� : ");
		int x = Integer.parseInt(br.readLine());
		System.out.print("y�� �Է� : ");
		int y = Integer.parseInt(br.readLine());
		
		int calc = 1;
		
		for(int i = 1; i <= y; i++) {
			calc *= x;
		}
		System.out.println(x + "�� " + y + "�� : " + calc);
	}

}
