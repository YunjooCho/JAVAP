package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� ���� ���α׷�
//�츮�� ����ڷκ��� �Է��� �޵�
//���� �������� ����ڷκ��� ������� ������ �Է� �޾Ƽ�
//���� ����ڰ� ���Ḧ �����ϸ� ���α׷��� ���ᰡ �Ǵ� �������� ������

public class Ex05GradeBook {
	public static void main(String[] args) throws IOException {
		//�޸� ����(�ʱ�ȭ�� ����)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//��Ʈ���� �ʱ�ȭ ���ִ� ���(Uppercase�޼ҵ带 ����ϹǷ� �ʱ�ȭ �ʿ�)
		//1�� ������
		String yn = new String();
		System.out.println("1��" + yn);
		//2�� null
		yn = null;
		System.out.println("2��" + yn);
		//3�� ���ͷ�(����)
		yn = "";
		System.out.println("3��" + yn);
		//4�� ���ͷ�
		yn = "��Ʈ��";
		System.out.println("4��" + yn);
		
		do {
			System.out.println("�̸� : ");
			String name = bufferedReader.readLine();
			
			System.out.println("���� : ");
			int kor = Integer.parseInt(bufferedReader.readLine());
			
			System.out.println("���� : ");
			int eng = Integer.parseInt(bufferedReader.readLine());
			
			System.out.println("���� : ");
			int math = Integer.parseInt(bufferedReader.readLine());
			
			int sum = kor + eng + math;
			System.out.println("���� : " + sum);
			
			System.out.println("����Ͻðڽ��ϱ�? (y/n)");
			yn = bufferedReader.readLine();
			yn = yn.toUpperCase();//������ yn�� �־��� sum = sum + i ���� ��?
			//yn = bufferedReader.readLine().toUpperCase();
			//toUpperCase()�޼ҵ��
			//�ش� ������ ��� �빮�ڷ� �ٲ��ִ� �޼ҵ��̴�
		}while(yn.equals("Y"));
		System.out.println("���α׷��� �����մϴ�");
	}

}
