package class_constructor;

import java.util.Scanner;

public class ExaminationMain {
	
	
	
	public static void main(String[] args) {
		//System.in.read(); - 1���� ����
		//BufferedReader
		//JDK 5.0 - Scanner : �⺻ �����ڰ� ����
		Scanner scan = new Scanner(System.in); 
		//Scanner scan = new Scanner(); - error : The constructor Scanner() is undefined
		//InputStream Ÿ�� : System.in
		//Socket�� InputStream Ÿ�� (ä��)
		//flush�� �⺻ �ʿ� ������ �ݺ������� ���� �� ���д� ��찡 ����
		//����ó�� �ʿ� ����, import�� �ʿ���
		//System.out.print("���ڿ� �Է� : ");
		//String str = scan.next();//���ڿ� ����
		
		//����
		//scan.nextInt();
		//scan.nextDouble();	
		
		//1������ //��������
		Examination ex = new Examination();
		System.out.println("�̸�\t1 2 3 4 5\t����");
		ex.compare();
		System.out.println(ex.getName() + "\t"
					     + ex.getOx(0) + " " + ex.getOx(1) + " " + ex.getOx(2) + " "
					     + ex.getOx(3) + " " + ex.getOx(4) + "\t"
					     + ex.getScore());
		
		//2������
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("<2������>");
		System.out.print("�ο��� �Է� : ");
		int people = scanner.nextInt();
		Examination[] arr = new Examination[people];
		for(int i = 0; i < arr.length; i++) {
			System.out.print("�̸� �Է� : ");
			String name = scanner.next();
			System.out.print("�� �Է� : ");
			String dap = scanner.next();
			arr[i] = new Examination(name, dap); //��������
			arr[i].compare();
			System.out.println();
		}
		
		//�������� - ������ Ǯ�� ����
		System.out.println("�̸�\t1 2 3 4 5\t����");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getName() + "\t"
				     + arr[i].getOx(0) + " " + arr[i].getOx(1) + " " + arr[i].getOx(2) + " "
				     + arr[i].getOx(3) + " " + arr[i].getOx(4) + "\t"
				     + arr[i].getScore());
		}
			
		
	}

}
