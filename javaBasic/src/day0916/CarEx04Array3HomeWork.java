package day0916;
//����2�� �� CarEx04Arry02�� �ϼ���Ű����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.CarT;


public class CarEx04Array3HomeWork {
	private static int SIZE = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//����ڰ� �Է��� ������ Car ��ü�� ����
		//Car�迭�� ����ִ� ĭ�� �ְ�
		//����ִ� ĭ�� ������ "�� ĭ�� �����ϴ�"��� ������ ���α׷��� ������
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		CarT[] carArray = new CarT[SIZE];
		
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			//���� �Է��� ������ ��
			//��ĭ���� �ƴ����� ��� �� �� ������?
			if(userChoice == 1) {
				int index = -1;   //�����⿡ ��ġ�� ���� : �⺻���� -1�� �ΰ� ����
	      		  //��for���� else�� ���� �ۼ��Ͽ� �� �ȿ� ����, �״��� if(index == -1) {System.out.println("��ĭ�� �����ϴ�."); ���� index = -1�� ã������ �����߻�
				for(int i = 0; i < carArray.length; i++) { //��[0][1][2]������ ���� null�̸� i���� �ش� �ε����� ���� ���� [0]->[1]->[2]�� 2�� ���� �������� �� ���� ������ ���
												   //��carArray[2]���� �������� �Է��� ��
												   //��[0]->[1]->[2]������ �Է��ϰ� ������ ������ int i = carArray.length-1; i >= 0; i--�� ��
				if(carArray[i] == null) {
				index = i;
				break;    //��break�� ������ �Է� ������ [2]-[1]-[0]�� ��. break�� ������ 0�� null���̸� �ٷ� �������� [0]-[1]-[2]�� ������ �Է�
				      //��System.out.println("i: " + i + " index: " + index); ����� ������ ���� �Է��Ѱ�
				}
				
				}//��for��
				      //��System.out.println("index: " + index); ����� ������ ���� �Է��Ѱ�
				if(index == -1) { //��index�� �⺻���� -1�̹Ƿ� ��� ��ĭ�� ���ٰ� ��µ�
				System.out.println("��ĭ�� �����ϴ�.");
				}else {           //������ �迭�� null��(�ƹ� ���� ������� ���� ����)�� index ������ �� �迭�� �ε���([0],[1],[2])�� ���ԵǾ��ٸ� �Ʒ� �Է°����� �����
				CarT c = new CarT();
				System.out.print("��ȣ : ");
				c.setNumber(bufferedReader.readLine());
				System.out.print("���� : ");
				c.setType(bufferedReader.readLine());
				System.out.print("���� : ");
				c.setYear(Integer.parseInt(bufferedReader.readLine()));
				System.out.print("���� : ");
				c.setPrice(Integer.parseInt(bufferedReader.readLine()));
				System.out.print("���� : ");
				c.setColor(bufferedReader.readLine());
				carArray[index] = c; //
				
				}
			}else if(userChoice == 2) {
				//���
				//�Է°��� �ִ��� ������ Ȯ��
				for(int i = 0; i < carArray.length; i++) {
					if(carArray[i] == null) {
						
						System.out.println((i+1) + "�� : - ");
						
					}else {
						
						System.out.println((i+1) + "��: " + carArray[i]);
					}
				}
				
			}else if(userChoice == 3){
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� ������ �ּ���");
			}
			
		}//���޴��� while
	}

	//�޴� �޼ҵ�
	static void showMenu() {
		System.out.println("=====================");
		System.out.println("�������� ����� ���α׷�");
		System.out.println("1.�Է� 2.��� 3. ����");
		System.out.println("=====================");
		System.out.print("�޴��Է�> ");
	}
	
	
	
}

//���� 1: ���� �Է� �ϴ� �ڵ���� 2���� �޼ҵ�� ��������
//		 �޼ҵ� 1: �Է��� index�� ã�� �޼ҵ�
//		 �޼ҵ� 2: �迭�� �ش���ġ�� Car ��ü�� �־ �迭�� �ٽ� �������ִ� �޼ҵ�
//���� 2: ���� ��� �ϴ� �ڵ���� �޼ҵ�� �и��ϼ���
//���� 3: �޴��� ����ϴ� �ڵ���� �޼ҵ�� �и��ϼ���  

//<����>
//1. -1. userChoice == 1 �Ʒ����� ���밡��??(x) - ���������͸� 3�� �� �Է��ؾ� �޴��� �Ѿ
//   -2. int index = -1;�� �ۿ��� �����ϴ� ����?(x) - ���� if���� if(index == -1) {System.out.println("��ĭ�� �����ϴ�."); ���� index = -1�� ã������ �����߻�
//   -3. -1�� ����ִ� ������ �Ŀ� �迭ũ�Ⱑ �ٲ��� �ߺ����� �ʱ� ����?? - <������> : -1�� �迭�� ������ �� ���� �ε����̱� ������
//   -4. userChoice�帧 - 51�� carArray[index] = c;, ���� �ʱ�κ� ����
//<1-1��������>
//if(userChoice == 1) {
//	int index;
//	for(int i = 0; i < carArray.length; i++) { //[0][1][2]������ ���� null�̸� 
//		if(carArray[i] == null) {
//			index = i;
//			 System.out.println("i: " + i + "index: " + index);
//			 System.out.println();
//			 
//			 CarT c = new CarT();
//				System.out.print("��ȣ : ");
//				c.setNumber(bufferedReader.readLine());
//				System.out.print("���� : ");
//				c.setType(bufferedReader.readLine());
//				System.out.print("���� : ");
//				c.setYear(Integer.parseInt(bufferedReader.readLine()));
//				System.out.print("���� : ");
//				c.setPrice(Integer.parseInt(bufferedReader.readLine()));
//				System.out.print("���� : ");
//				c.setColor(bufferedReader.readLine());
//				carArray[index] = c;
//		}else {
//			index = -1;
//			System.out.println("��ĭ�� �����ϴ�.");
//		}
//	}