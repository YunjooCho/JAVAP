package day0911P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2���� �迭�� ���ÿ� ����ؼ�
//�̸��� ������ ���ÿ� �����غ���(5��)

public class Ex01ArrayP {
	
	final static int SIZE = 5;

	public static void main(String[] args) throws IOException {
	//�޸𸮻���
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	//�̸��� ����� �迭�� �ϳ� ������	
	String[] nameArray = new String[SIZE];
		
	//������ ����� �迭�� �ϳ� ������
	int[] totArray = new int[SIZE];	
		
	//���ʴ�� �Է��� �غ���
	for(int i = 0; i < nameArray.length; i++) {
		System.out.println((i+1) + "�� �л��� �̸� �Է� : ");
		nameArray[i] = bufferedReader.readLine();
		
		System.out.println(nameArray[i] + "�л��� ���� : ");
		totArray[i] = Integer.parseInt(bufferedReader.readLine());
		while(totArray[i] < 0 || totArray[i] > 100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			System.out.println(nameArray[i] + "�л��� ���� : ");
			totArray[i] = Integer.parseInt(bufferedReader.readLine());
		}//while
	
		
	}
	 //���� ���� �л��� ��ȣ�� �Է��ϸ� �� �л��� ������ ����ϰ� ������
	System.out.println("����� ����ϴ� �л��� ��ȣ(1~5) : ");
	int selectNumber = Integer.parseInt(bufferedReader.readLine());
	System.out.printf(selectNumber + "�� �л��� �̸� : %s, ���� : %d", nameArray[selectNumber-1], totArray[selectNumber-1]);	
   
	
	}

}
