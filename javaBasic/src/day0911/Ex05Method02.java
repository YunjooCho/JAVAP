package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� Ÿ���� ���� �޼ҵ�
//�׸��� �޼ҵ� �߰��� �����ϴ� �޼ҵ�
public class Ex05Method02 {
	//1. ���� Ÿ���� ���� �޼ҵ�
	//	  �ƹ��͵� �������� ���� ������ void��� �����ְ�
	//	  �׷��� ��쿣 return��ɾ ���� �ʴ´�.
	static void showMenu() {
		System.out.println("----------------------");
		System.out.println("��Ʈ����б� �������� ���α׷�");
		System.out.println("\t1.�Է�");
		System.out.println("\t2.���");
		System.out.println("\t3.����");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int korean = 0;
		int math = 0;
		int english = 0;
		String name = new String();
		
		while(true) {
			showMenu(); //showMenu�޼ҵ�
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�Է� �޼ҵ� ����
				
				//������ �Է¹޾Ƽ� ��ȿ�� ������ �������ִ� �޼ҵ带 ����
				//������ ������ �Է� ��Ű�ÿ�
				System.out.print("�̸��� �Է��ϼ��� : ");
				name = bufferedReader.readLine();
				
				System.out.print("���� ");
				korean = validateScore(bufferedReader); //�Է¿��� �ƴ� �޼ҵ�� ���� �Ѱ��ֱ� ���� ����
				//korean�� validateScore�� �޼ҵ� �����(score)�� ����
				
				System.out.print("���� ");
				english = validateScore(bufferedReader);//�Է¿��� �ƴ� �޼ҵ�� ���� �Ѱ��ֱ� ���� ����
				
				System.out.print("���� ");
				math = validateScore(bufferedReader);//�Է¿��� �ƴ� �޼ҵ�� ���� �Ѱ��ֱ� ���� ����
				
				
				
			}else if(userChoice == 2) {
				//��� �޼ҵ� ����
				
				//�Ķ���ͷ� �Ѿ�� �̸�, ������ ������
				//���ڰ� ����ϴ� �޼ҵ带 �ۼ��Ͻÿ�
				printScore(name, korean, english, math);
				
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}
		}
	}
	static int validateScore(BufferedReader bufferedReader) throws NumberFormatException, IOException {
	//�ܺηκ��� BufferedReader������ �ϳ� �޾ƿͼ� ���
	//main�޼ҵ忡 �ִ� korean, english, math�� �޾ƿ� score�� ����
	//Ű����� �Է��� ������ ���⼭ ���͸���, 
	//���͸��� ���� �ٽ� main���� ���ư� ����(korean, english, math)�� �����
		
		System.out.print("������ �Է��ϼ��� : ");
		int score = Integer.parseInt(bufferedReader.readLine());
		
		while(score < 0 || score > 100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			System.out.print("������ �Է��ϼ��� : ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		return score; //while���� �ش����� �ʴ� ��(��ȿ�� ����)�� score������ ����
	}
		
	static void printScore(String name, int korean, int english, int math) {
		System.out.println("==================================");
		System.out.println("\t�̸� : " + name);
		System.out.printf("���� : %d ���� : %d ���� : %d\n",korean, english, math);
		int sum = korean + english + math;
		double average = sum / (double)3;
		System.out.printf("���� : %d ��� : %.2f\n",sum,average);
		
	}
	
}
