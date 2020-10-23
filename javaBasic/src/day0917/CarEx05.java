package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import day0916.CarT; //ctrl+shift+o

//���� �� ����
//���� �տ� �ź��� �����ϰ�  ���������ʱ�ȭ?��, �޹迭�� �չ迭�� �����
//��ĭ�� ���ܼ� �� �������� ������ ��������  ��temp?��, �޹迭�� �չ迭�� �����
//�迭�� �����ϴ� ���α׷�
public class CarEx05 {
	private static int SIZE = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		CarT[] carArray = new CarT[SIZE];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�Է� �޼ҵ� ����
				carArray = add(carArray); //carArray�� add�޼ҵ忡�� ��ȯ�� ���� ���� �����
			}else if(userChoice == 2) {
				//��� �޼ҵ� ����
				printArray(carArray);
			}else if(userChoice == 3) {
				//�޽��� ��� �� ����
				System.out.println("������ּż� �����մϴ�.");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
		
	}
	
	//5. ��� �޼ҵ�
	private static void printArray(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				System.out.println(carArray[i]); //�迭�� null�� �ƴ� �� ���
			}
		}
	}
	
	
	//4. 2���� �޾ƿ� ���ڸ� �迭�� �ε����� �Է��ϰ�, �ش� �迭�� 3���� �޾ƿ� ��ü���� �Է� 
	private static CarT[] add(CarT[] carArray) throws NumberFormatException, IOException   { //����Ÿ��: �迭 (���� : Ŭ������[]) -����Ÿ�Կ��� Ŭ����, �迭 �� ���������� �� �� ����
		int index = findEmptyIndex(carArray); //�迭�� ��ĭ�� �����ְ� �� ������ �ε����� ���ο� c��ü�� �־���
										      //2�� �޼ҵ忡�� �޾ƿ� -1, 0, 1, 2�� ����
		if(index != -1) {                     //-1�� �ƴ� ��츸 3���޼ҵ尡 ����
			//��ĭ�� �����ϹǷ� index �� ĭ��            
			//Car ��ü�� �־��ش�.
			carArray[index] = setCarInfo();   //3�� �޼ҵ�, �ش� �迭�� ��ȯ�� ��üc�ּҰ��� ����(��üc�ȿ� ���������� ����)
		}else {
			//index�� -1�� ���
			//�迭�� ��� �� �� á���Ƿ� �迭�� ��ĭ�� ���ܼ�
			//�� ������ ĭ�� ���� �Էµ� c�� �ְ� ����� ����
			for(int i = 1; i < carArray.length; i++) { //�ʱⰪ�� 1�� ������ ���ڵ� ����
				carArray[i-1] = carArray[i];//�ھ� �迭�� �޹迭�� ��� ->��ĭ�� ���ܱ�
			}
			carArray[SIZE - 1] = setCarInfo(); //���� ������ ĭ�� �� ��ü�� �־���
											   //SIZE - 1�� ������ ĭ�� ����Ű�� �Ǵ� ������ 
											   //�迭�� 0 ~ (SIZE - 1)(�迭ũ�� -1)�̱� ������
		}
		return carArray;                      //��üc�ּҰ��� �Էµ� �迭�� ��ȯ(������: carArray��ü�� ��ȯ)
	}
	
	//3.��ü�� ���� �־��ִ� �޼ҵ�
	private static CarT setCarInfo() throws NumberFormatException, IOException  { //�������� �Է�
		                                                                          //����Ÿ�� : ��ü (���� : Ŭ������)
		                                                                          //��ȯ�Ǵ� ������ CarTŬ������ ��ü
																				  //NumberFormatException : ���ڸ� �־�� ��(?)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		CarT c = new CarT();//��ü �ʱ�ȭ(�⺻���� 0, �������� "")
		
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
		
		return c; //���� ������ ����� ��üc�� ��ȯ(c�� �� ������ �� �ִ� ���°� ��)
	}
	
	//2.�迭�� ����ִ��� ã�� �޼ҵ�(����ִ� ��쿡�� �ش� �޼ҵ��� �ε������� ��ȯ, ������� ���� ��쿡�� -1�� ��ȯ)
	private static int findEmptyIndex(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	
	//1.�޴� �޼ҵ�
	private static void showMenu() {
		System.out.println("��Ʈ �������� ���α׷� ver 2.0");
		System.out.println("1.�Է�   2.���   3.����");
		System.out.print("> ");
	}
}
