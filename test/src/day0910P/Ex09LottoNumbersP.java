package day0910P;

import java.util.Random;

//�ζǹ�ȣ ���۱�
//�ζ� ��ȣ�� 1~45���� 6���� ���ڰ� �ʿ��ϴϱ�
//�츮�� �̸� ����� ��������

public class Ex09LottoNumbersP {
	final static int SIZE = 6;
	final static int MAX = 45;
	public static void main(String[] args) {
		int[] lottoNumbers = new int[SIZE];
		
		//����
		Random random = new Random();
		for(int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1;
		}
		System.out.println("���� ���� ����");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//�ߺ�����
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < lottoNumbers.length; j++) {
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1; //i�� ���ο� ���� ����
					j = -1;
				}
			}
		}
		System.out.println("�ߺ� ���� ��");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//����
		for(int i = 0; i < lottoNumbers.length - 1; i++) {
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i+1];
				lottoNumbers[i+1] = temp;
				i = -1;
			}
		}
		System.out.println("���� ��");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
	}

}
