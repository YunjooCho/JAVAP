package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a;
		System.out.println("a �Է� : ");
		a = Integer.parseInt(br.readLine());
		
		if(a >= 50) System.out.println(a + "�� 50���� ũ�ų� ����");
		else System.out.println(a + "�� 50���� �۴�");
		System.out.println();
		
		
		if(a % 2 == 0) System.out.println( a + "�� ¦��");
		else System.out.println(a + "�� Ȧ��");
		System.out.println();
		
		if(false) {
			if(true) System.out.println("A");
			else System.out.println("B");
		}
		System.out.println("C");
		System.out.println();
		
		if(a >= 'A' && a <= 'Z') {
			System.out.println((char)a + "�� �빮��");
		}else if(a >= 'a' && a <= 'z') {
			System.out.println((char)a + "�� �ҹ���");
		}else {
			System.out.println((char)a + "�� �����̰ų� Ư������");
		}
	 }
	}


