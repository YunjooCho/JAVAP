package day0910;

//����ڷκ��� ������ �Է¹޾Ƽ�
//������ ������ִ� ���α׷�
//�� ����ڰ� �Է��� ������ �߸��� ����(0���� ���ų� 100���� ū �Ϳ�)
//�� ������
//�ùٸ� ������ ���� �� ����
//�ٽ� �Է¹޴´�.
//�Է��� �� ������ do while�� ����ϵ��� �Ѵ�.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02DoWhile02 {

	public static void main(String[] args) throws IOException {
		
		
	
		//�޸� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//����
		int kor =0, eng = 0, math = 0;
		
		do {
			if(kor > 100 || kor < 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			System.out.println("�������� :");
			kor=Integer.parseInt(bufferedReader.readLine());
		}while(kor > 100 || kor < 0);
		do {
			if(eng > 100 || eng < 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			System.out.println("�������� :");
			eng=Integer.parseInt(bufferedReader.readLine());
		}while(eng > 100 || eng < 0);
		do {
			if(math > 100 || math < 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			System.out.println("�������� :");
			math=Integer.parseInt(bufferedReader.readLine());
		}while(math > 100 || math < 0);
		
		int sum = kor + eng + math;
		System.out.println("���� :" + sum);
		
		}//main
	}//class
