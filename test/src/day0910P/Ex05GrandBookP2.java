package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//����ڷκ��� ������ �Է¹޾Ƽ�
//������ ������ִ� ���α׷�
//�� ����ڰ� �Է��� ������ �߸��� ����(0���� ���ų� 100���� ū �Ϳ�)
//�� ������
//�ùٸ� ������ ���� �� ����
//�ٽ� �Է¹޴´�.
//�Է��� �� ������ do while�� ����ϵ��� �Ѵ�.

public class Ex05GrandBookP2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int kor = 0, eng = 0, math = 0;

		do {
			if(kor < 0 || kor > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
			}
			System.out.print("�������� : ");
			kor = Integer.parseInt(br.readLine());
		}while(kor < 0 || kor > 100);
		
		do {
			if(eng < 0 || eng > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
			}
			System.out.print("�������� : ");
			eng = Integer.parseInt(br.readLine());
		}while(eng < 0 || eng > 100);
		
		do {
			System.out.print("�������� : ");
			math = Integer.parseInt(br.readLine());
			if(math < 0 || math > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
			}
		}while(math < 0 || math > 100);
		
		int sum = kor + eng + math;
		System.out.println("����  = " + sum);
			
			
	}

}
