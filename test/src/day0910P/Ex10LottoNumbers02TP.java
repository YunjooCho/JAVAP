package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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

public class Ex10LottoNumbers02TP {
	//1. ��� ����
	final static int SIZE = 6;
	final static int MAX = 45;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//�迭
		int[] lottoNumbers = new int[SIZE];
		int[] userNumbers = new int[SIZE];
		
		//�ζ� ��ȣ ����
		Random random = new Random();
		for(int i = 0; i < SIZE; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1;
		}
		//�ߺ�����
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

		System.out.println("�ζ� ��ȣ ��÷ �Ϸ�");
		
		//����� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < userNumbers.length; i++) {
			System.out.print((i+1) + "��° ���ڸ� �Է��ϼ��� : ");
			int number = Integer.parseInt(br.readLine());
			
			//����� �Է� ���� �ߺ��� ��� boolean������ ���� ����
			boolean isDuplicated = false;
			for(int j = 0; j < i; j++) {
				if(number == userNumbers[i]) {
					isDuplicated = true;
				}
			}
			
			
			while(number < 0 || number > MAX || isDuplicated == true) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				System.out.print((i+1) + "��° ���ڸ� �Է��ϼ��� : ");
				number = Integer.parseInt(br.readLine());
				
				isDuplicated = false;
	            for(int j = 0; j < i; j++) {
	               if(number == userNumbers[i]) {
	                  isDuplicated = true;
	               }
	            }
			}
			userNumbers[i] = number;
		}
		
		
		//����ڰ� �Է��� ���ڷ� �̷���� �迭 ����
		for(int i = 0; i < userNumbers.length - 1; i++) {
			if(userNumbers[i] > userNumbers[i+1]) {
				int temp = userNumbers[i];
				userNumbers[i] = userNumbers[i+1];
				userNumbers[i+1] = temp;
				i = -1;
			}
		}
		
		
		//�ζ� �迭�� ����� �Է¹迭 ��
		int score = 0;
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < userNumbers.length; j++) {
				if(lottoNumbers[i] == userNumbers[j]) {
					score++;
				}
			}
		}
		
		//�� �迭 ���
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i] + "\t" + userNumbers[i]);
		}
		switch(score) {
		case 6 :
			System.out.println("��" + score + "�� ���߼̽��ϴ�. 1���Դϴ�.");
			break;
		case 5 :
			System.out.println("��" + score + "�� ���߼̽��ϴ�. 2���Դϴ�.");
			break;
		case 4 :
			System.out.println("��" + score + "�� ���߼̽��ϴ�. 3���Դϴ�.");
			break;
		case 3 :
			System.out.println("��" + score + "�� ���߼̽��ϴ�. 4���Դϴ�.");
			break;
		default :
			System.out.println("��" + score + "�� ���߼̽��ϴ�. Ż���Դϴ�.");
			break;
			
		}
	
	}

}
