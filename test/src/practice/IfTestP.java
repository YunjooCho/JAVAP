package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTestP {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("�Է� : ");
		int num = Integer.parseInt(br.readLine());
		
		//�Է¹��� ���� ¦������ Ȧ������ Ȯ��
		if (num % 2 == 0) System.out.println("¦��");
		else System.out.println("Ȧ��");
		
		
		//�빮��&�ҹ���&Ư������
		if (num >= 'A' && num <= 'Z') System.out.println("�빮�� : " + (char)num);
		else if(num >= 'a' && num <= 'z') System.out.println("�ҹ��� : " + (char)num);
		else System.out.println("���� �Ǵ� Ư������");
	}

}
