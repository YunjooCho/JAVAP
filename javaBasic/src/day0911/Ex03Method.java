package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�޼ҵ�
//�޼ҵ�� �ش� Ŭ������ ����� ���ǵǾ��ִ� ���

//���нð��� ��� �Լ�
//f(x) = 3x;
//�츮�� ���� ���ڿ� 3�� ������ ���� ����� ������ �ȴ�

//�ڹ��� �޼ҵ嵵 ��������
//�츮�� � Ÿ���� ���� �������� �����ְ�
//�� ���� ���ؼ� � ����� ��������� �����ְ�
//�� ������� ȣ��� ������ ���� �� �ڷ����� �����ָ� �ȴ�.

//�޼ҵ带 �����غ���
//�޼ҵ带 ������ ������
//����Ÿ�� �޼ҵ��̸�(�Ķ����)
//�� ������ �� �ִ�.

//���� Ÿ�� : �ش� �޼ҵ尡 ȣ��� ������ ������ ���� ������Ÿ��
//		   ���� ȣ��� ������ ������ ���� �ִ� ��쿡�� �޼ҵ� ���ο���
//			�ݵ��!!  return�̶�� ��ɾ ���ؼ� ���� �ǵ������ �Ѵ�
//			���� �ƹ��� ���� �������� ���� ���̶�� ����Ÿ���� void�� �ȴ�
//�޼ҵ� �̸� : �ҹ��ڷ� �����ϴ� ����(��Ÿ�� ǥ���)
//�Ķ���� : �ش� �޼ҵ尡 �����Ҷ� �ʿ�� �ϴ� �ܺ��� ��, �޼ҵ� ���ο��� ����ó�� ���̱� ������ �Ű�������� �Ѵ�
public class Ex03Method {
	//����ڷκ��� ���� 2���� �޾Ƽ� �� ���� �����ִ� �޼ҵ�
	static int add(int a, int b) {
		int sum = a + b;
		
		return sum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int userNumber1 = 10;
		int userNumber2 = 150; //�̸�(������)�� Ʋ���� add�޼ҵ��� int a, int b�� ���� �Ѱ��� �� �ִ�
		
		int result  = add(userNumber1, userNumber2);
		System.out.println("result :" + result);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("����");
		int korean = validateScore(bufferedReader);
		System.out.println("����");
		int english = validateScore(bufferedReader);
		System.out.println("����");
		int math = validateScore(bufferedReader);
		
		int sum = korean + english + math;
		
	}
	
	//����ڷκ��� ���ڸ� �Է¹޾Ƽ�
	//���� �ش� ���ڰ� 0~100�� ������ �����
	//�ٽ� �Է��� �ϰ� ����
	//���� ���� ���ڰ� �ԷµǾ��� ���� �� ���ڸ� return�ϴ� �޼ҵ�
	
	//�޼ҵ� ����
	//public int validateScore�ε� �ۼ�����
	static int validateScore(BufferedReader bufferedReader) throws NumberFormatException, IOException{
		System.out.println("������ �Է����ּ��� : ");
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 0 || score > 100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			System.out.println("������ �Է����ּ��� : ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		 return score;
	}//validateScore�޼ҵ�

}
