package day0910P;

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


public class Ex02DoWhile02P {

	public static void main(String[] args) throws IOException {
		//�޸� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//���� 
		int kor = 0, eng = 0, math = 0;
			
		//�ݺ���		
		do {
			System.out.print("���� ���� �Է� : ");
			kor = Integer.parseInt(bufferedReader.readLine());
			if( kor > 100 || kor < 0) {
				System.out.println("�߸��� �����Դϴ�\n�ٽ� �Է��ϼ���");		
			}
		}while (kor > 100 || kor < 0);
		
		do {
			System.out.print("���� ���� �Է� : ");
			eng = Integer.parseInt(bufferedReader.readLine());
			if( eng > 100 || eng < 0) {
				System.out.println("�߸��� �����Դϴ�\n�ٽ� �Է��ϼ���");		
			}
		}while (eng > 100 || eng < 0);
		
		do {
			System.out.print("���� ���� �Է� : ");
			math = Integer.parseInt(bufferedReader.readLine());
			if( math > 100 || math < 0) {
				System.out.println("�߸��� �����Դϴ�\n�ٽ� �Է��ϼ���");		
			}
		}while (math > 100 || math < 0);
		
		int tot = kor + eng + math;
		System.out.println("���� : " + tot);
	}

}
