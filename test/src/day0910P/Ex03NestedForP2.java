package day0910P;

import java.io.BufferedReader;

//���� ���� ���α׷�
//�츮�� ����ڷκ��� �Է��� �޵�
//���� �������� ����ڷκ��� ������� ������ �Է� �޾Ƽ�
//���� ����ڰ� ���Ḧ �����ϸ� ���α׷��� ���ᰡ �Ǵ� �������� ������


import java.io.IOException;
import java.io.InputStreamReader;


public class Ex03NestedForP2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//��Ʈ�� �ʱ�ȭ ���
		//1. ������
		String yn = new String();
		System.out.println("1��" + yn);
		
		//2.null
		yn = null;
		System.out.println("2��" + yn);
		
		//3.���ͷ�(����)
		yn = "";
		System.out.println("3��" + yn);
		
		//4.���ͷ�
		yn = "��Ʈ��";
		System.out.println("4��" + yn);
		
		do {
			System.out.print("�̸� : ");
			String name = br.readLine();
			System.out.print("���� : ");
			int kor = Integer.parseInt(br.readLine());
			System.out.print("���� : ");
			int eng = Integer.parseInt(br.readLine());
			System.out.print("���� : ");
			int math = Integer.parseInt(br.readLine());
			
			System.out.print("Continued(Y/N)? : ");
			yn = br.readLine().toUpperCase();
		}while(yn.equals("Y"));
		System.out.println("���α׷��� �����մϴ�.");
	}

}
