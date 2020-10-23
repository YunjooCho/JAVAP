package day0916;
//����2�� �� CarEx04Arry02�� �ϼ���Ű����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.CarT;


public class CarEx04Array02 {
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
				
				if(findEmptyIndex(carArray) == -1) {
					//��ĭ�� �����Ƿ� ���޽����� ���
					System.out.println("��ĭ�� �����ϴ�.");
				}else {
					//��ĭ�� �����ϱ� c��ü�� ����� ����
					CarT c = new CarT();
					System.out.print("���� ��ȣ : ");
					c.setNumber(bufferedReader.readLine());
					
					System.out.print("���� ���� : ");
					c.setType(bufferedReader.readLine());
					
					System.out.print("���� ���� : ");
					c.setYear(Integer.parseInt(bufferedReader.readLine()));
					
					System.out.print("���� ���� : ");
					c.setPrice(Integer.parseInt(bufferedReader.readLine()));
					
					System.out.print("���� ���� : ");
					c.setColor(bufferedReader.readLine());
					
					carArray = add(carArray, c);
				}
				
			}else if(userChoice == 2) {
				//���
				//�Է°��� �ִ��� ������ Ȯ��
				printArray(carArray); //toString(), �����ߴ� printInfo(c1)�� ���÷�����
			}else if(userChoice == 3){
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� ������ �ּ���");
			}
		}//���޴��� while
		
	}//��main
		
	
	
	//1. �迭�� ��ĭ�� ã���ִ� findEmptyIndex(CarT[] carArray)�޼ҵ�
	private static int findEmptyIndex(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				return i; //ĭ�� ��������� return, ���⿡ �������� ���ϸ� ��ĭ�� ���ٴ� ��, �Ʒ� ������ ���� -1�� ������
			}
		}//��for��
		return -1; 
	}//1.�޼ҵ� (index�� ���൵ �Ǳ� �Ұ� ������ �Ʒ��� ����ϹǷ� ���� �ʿ�����)
	
	
	//2. �Ķ���ͷ� Car�迭�� Car��ü�� �޾Ƽ� Car��ü�� �迭�� �־
	//   �� �迭�� �����ϴ� add(Car[] carArray, Car c)�޼ҵ�
	private static CarT[] add(CarT[] carArray, CarT c) { //main�޼ҵ尡 ����ϱ� ������  static�� ����
		int index = findEmptyIndex(carArray); //��� �޼ҵ带 ������
											  //��ĭ�� �����Ƿ� ���޽����� ���
											  //��� �޼ҵ忡�� -1�� ���� ���, �ڵ��� �帧�� ���� ��� �޼ҵ尡 ȣ��� 
											  //main�޼ҵ� �ȿ��� if��(if(findEmptyIndex(carArray) == -1))���� �ɷ����� ������
											  //���� �޼ҵ忡�� -1��ü�� ������ ����
		System.out.println("��ĭ�� �����ϴ�.");
		carArray[index] = c; //��ü�� �ּҰ��� �迭�� �����
		
		return carArray;
	}
	
	private static void printArray(CarT[] carArray) { //�迭�� �ִ� ������ ����ϴµ� �־ �迭�� ������ null�� �ƴ� ��츸 ���
		                                              //main�޼ҵ尡 ����ϱ� ������  static�� ����
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				System.out.println(carArray[i]);
			}
		}
	}
	
	
	//3.�޴� �޼ҵ�
	private static void showMenu() { //main�޼ҵ尡 ����ϱ� ������  static�� ����
		System.out.println("=====================");
		System.out.println("�������� ���α׷�");
		System.out.println("1.�Է� 2.��� 3. ����");
		System.out.println("=====================");
		System.out.print("�޴��Է�> ");
	}//�޴� �޼ҵ�
	
	
}//Class

	
	


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