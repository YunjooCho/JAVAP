package day0910;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Ex10LottoNumbers02 {

	final static int SIZE = 6; 
	final static int MAX = 45;
	
	public static void main(String[] args) throws IOException {
		//�޸� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//�ζ� ��ȣ�� ������ ��Ʈ�迭�� ���������
		int[] lottoNumbers = new int[SIZE];
		int count = 1;
		int user;
		int correct = 0;
				
		//����
		Random random = new Random();
		for(int i = 0; i < lottoNumbers.length; i++) {
			
			lottoNumbers[i] = random.nextInt(MAX) + 1; //0~44�� +1�� 
		}
		//�ߺ� ����
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < lottoNumbers.length; j++) {
				
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1; //i�� ���ο� ���� ����
					j = -1; //���� j++�� ����ǹǷ� -1 -> 0���� �ٲ�� ó������ �˻���� (i�� �ߺ��� ����� ���� ������ ����(i = 4)
			
				}//j�� if��
				
			}//for �ߺ� j��
				
				

		}//for �ߺ� i��
//		System.out.println("�ߺ����� ��");
//		for(int i = 0; i < lottoNumbers.length; i++) {//for �ߺ� ���
//			System.out.println(lottoNumbers[i]);
//			
//		}//for �ߺ� ���
//		
		for(int i = 0; i < lottoNumbers.length - 1; i++) {
	         if(lottoNumbers[i] > lottoNumbers[i+1]) {
	            int temp = lottoNumbers[i];
	            lottoNumbers[i] = lottoNumbers[i+1];
	            lottoNumbers[i+1] = temp;
	            i = -1;
	         }
	      }
	      
//	      System.out.println("���� ��");
//	      
//	      for(int i = 0; i < lottoNumbers.length; i++) {
//	         System.out.println(lottoNumbers[i]);
//	      }
		
		
		for(int i = 0; i <= lottoNumbers.length - 1; i++) {//�Է�
			
			System.out.println(count + "��° ���ڸ� �Է��ϼ��� : ");
			user = Integer.parseInt(bufferedReader.readLine());
			//user�� �迭�� �ƴ� ��� �������, �Է� -> �Է°��� �迭�� ����� �� �� -> correct����(�Ǵ� ��ȭ����) -> �Է°� ���� �Է� ���ڷ� �ʱ�ȭ ����
			if( user < 1 || user > 45 ) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				System.out.println(count + "��° ���ڸ� �Է��ϼ��� : ");
				user = Integer.parseInt(bufferedReader.readLine());
			}
			if ( user == lottoNumbers[i]) {
				correct++;
			}
			count++;
			System.out.println("��" + correct + "�� ���߼̽��ϴ�");
		}//�Է� for��
		
		
		
		
		
		
	}

}
