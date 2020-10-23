package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�ζ� ��ȣ���۱� 2��
//����ڷκ��� ���ڸ� �Է� �޾Ƽ�
//6���� �� ������: 1��
//5���� ������: 2��
//4��: 3��
//3��: 4��
//�� ��µǴ� ���α׷��� �ۼ��Ͻÿ�.
//�� ����ڰ� 1~45�� ��� ���� �Է��ϸ�
//�ùٸ� ���� �Է��Ҷ����� �ٽ� �Է��� �ϰ� ���弼��

//���α׷� ����:
//�ζǹ�ȣ ��÷ �Ϸ�
//1��° ���ڸ� �Է��ϼ���: 3
//2��° ���ڸ� �Է��ϼ���: 1
//3��° ���ڸ� �Է��ϼ���: 1000
//�߸� �Է��ϼ̽��ϴ�.
//3��° ���ڸ� �Է��ϼ���: -150
//�߸� �Է��ϼ̽��ϴ�.
//3��° ���ڸ� �Է��ϼ���: 43
//4��° ���ڸ� �Է��ϼ���: 23
//5��° ���ڸ� �Է��ϼ���: 12
//6��° ���ڸ� �Է��ϼ���: 11
//�� 4�� ���߼̽��ϴ�. 3�� ��÷�Դϴ�!!! (55�б���)

import java.util.Random;

public class Ex10LottoNumbers02P {
	final static int SIZE = 6;
	final static int MAX = 46;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�迭, ���� ����
		int[] lottoNumbers = new int[6];
		int user;
		int count = 1;
		int correct = 0;
		
		
		//���� �߻�, �迭�� �Է�
		Random random = new Random();
		for(int i = 0; i < SIZE; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1;
		}
		//�ߺ� ����
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1;
					j = -1; 
				}
			}
		}
		//����
		for(int i = 0; i < SIZE - 1; i++) {
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i+1];
				lottoNumbers[i+1] = temp;
				i = -1;
			}
		}
		
		//����ڷκ��� ���� �Է¹ޱ�
		for(int i = 0; i < SIZE; i++) {
			System.out.print(count + "��° ���ڸ� �Է��ϼ��� :");
			user = Integer.parseInt(br.readLine());
			count++;
			if(user < 1 || user > 45) {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				System.out.print(count + "��° ���ڸ� �Է��ϼ��� :");
				user = Integer.parseInt(br.readLine());
			}//if
			
			if(user == lottoNumbers[i]) {
				correct++;
			}
		}
		
		//��� ���
		switch(correct) {
		case 6 : System.out.println("�� " + correct + "�� ���߼̽��ϴ�. 1�� �Դϴ�!!!");
			     break;
		case 5 : System.out.println("�� " + correct + "�� ���߼̽��ϴ�. 2�� �Դϴ�!!!");
			     break;
		case 4 : System.out.println("�� " + correct + "�� ���߼̽��ϴ�. 3�� �Դϴ�!!!");
			     break;
		case 3 : System.out.println("�� " + correct + "�� ���߼̽��ϴ�. 4�� �Դϴ�!!!");
			     break;
	    default : System.out.println("�� " + correct + "�� ���߼̽��ϴ�. ������ ���Դϴ�.");
	    		 break;
		}
	}
}
