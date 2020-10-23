package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import day0916.CarT;
import util.ArrayUtil;

//�������� ���α׷�
//1. �Է�
// �Է½ÿ��� �迭�� �̹� �Ȱ��� ��ȣ�� ���� �ÿ��� ���� ��ȣ�� �ٽ� �Է¹ް� �ϼ���
//2. ��� ���
// ��� ��½ÿ���  
//         1. ������ȣ
//         2. ������ȣ
//         3. ������ȣ
// �� �������� ����� ��µǰ� ����ڰ� ��ȣ�� �����Ͽ� �󼼺���� �� �� �ְ� �ϼ���
//3. �� ����
// ��Ͽ��� ������ ��ȣ�� ���� �󼼺���� ����
// ���� ��ȣ ���� ���� ���� ����
// ���� ���� ���� ����
//   ����) ������ȣ: 00�� 0000 ��������: ���� ��������: ������
//        ��������: 2020 ����  ��������: 20000000�� 
// �� ��µǰ� 
// ���� ���� ��ϵ��ư��� �� ��µǰ� ���弼��
// A) ����
//    �������� ����, ����, ������ ������ �� �ְ� ���弼��.
// B) ����
//    ���� �ÿ��� ����ڰ� �����ϸ� �����ϰ� ������� �̵��ϰ� �������� ���� �ÿ��� �ش� ������ �������� �������� �̵��ϼ���
// C) ��Ϻ���
//    �ٽ� ������� �̵��մϴ�.
public class CarEx01 {
	//1.�ʵ弱��
	private static BufferedReader bufferedReader;
	//private static DecimalFormat decimalFormat;
	private static CarT[] carArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.�迭����
		carArray = new CarT[0];	
		//3.���۸��� �ʱ�ȭ
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
				
		showMenu();
		
	}//main
	
	
	//3.�޴� �޼ҵ� - �޴� ���� ����ֱ�
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("==============================");
			System.out.println("���� ���� ���α׷�");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("> ");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�Է¸޼ҵ� 
				add();
			}else if(userChoice == 2) {
				//��¸޼ҵ�
				printAll();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �޴��� ������ �ּ���.");
			}
		}//�޴� while
	}//�޴� �޼ҵ�
	
	
	//4.��ü�� ������ �Է��ϴ� �޼ҵ�
	private static CarT setCarInfo() throws NumberFormatException, IOException {
		CarT c = new CarT();
		System.out.print("���� ��ȣ: ");
		c.setNumber(bufferedReader.readLine());
		//�ߺ�Ȯ��
		while(ArrayUtil.contains(carArray, c)) {
			System.out.println("�̹� �����ϴ� ������ȣ�Դϴ�.");
			System.out.print("���� ��ȣ: ");
			c.setNumber(bufferedReader.readLine());
		}
		
		System.out.print("���� ����: ");
		c.setType(bufferedReader.readLine());
		
		System.out.print("���� ����: ");
		c.setColor(bufferedReader.readLine());
		
		System.out.print("���� ����: ");
		c.setYear(validateIntegerValue(2000, 2020));
		
		System.out.print("���� ����: ");
		c.setPrice(validateIntegerValue(0));
		
		return c;
		
	}//setCarInfo �޼ҵ�
	
	//8-1. ���� ������ �� Ȯ��(�����ε� 1)
	private static int validateIntegerValue(int minimum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(bufferedReader.readLine());
		while(value < minimum) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
			System.out.println("> ");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		
		
		return value;
	}
	
	//8-2. ���� ������ �� Ȯ��(�����ε� 2)
	private static int validateIntegerValue(int minimum, int maximum) throws NumberFormatException, IOException {
			int value = Integer.parseInt(bufferedReader.readLine());
			while(value < minimum || value > maximum) {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				System.out.println("> ");
				value = Integer.parseInt(bufferedReader.readLine());
			}
			
			return value;
		}
	
	
	//5.4�� ���� ���� ��ü������ �迭�� �߰��ϴ� �޼ҵ�
	private static void add() throws NumberFormatException, IOException {//setCarInfo����
		carArray = ArrayUtil.add(carArray, setCarInfo()); 				 //ArrayUtil�� �迭 ����
		//���� : carArray = ArrayUtil.add(carArray, c); //��üc        	 //������ �κп� �߰��� ��ü�� setCarInfo�� �����Ͽ� ���� �Է� �� �߰�
	}
	
	
	//6.�迭�� ����ϴ� �޼ҵ� - �Ϻ� > �� (�޴�2)
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("--------------------");
		System.out.println("�Ϸù�ȣ\t���� ��ȣ");
		for(int i = 0; i < carArray.length; i++) {
			System.out.printf("%d. \t%s\t\n", (i+1), carArray[i].getNumber());
		}
		System.out.println("--------------------");
		System.out.println("���� ������ ������ȣ�� ������ �ּ���(0�� ����)");
		System.out.print("> ");
		int userCarNumber = validateIntegerValue(0, carArray.length) - 1; //0�� �ּҰ�, carArray.length-1�� �ִ밪, ��°��� �ϳ�
//		while(userCarNumber < -1 || userCarNumber > carArray.length - 1) { //����ڴ� 0���� �迭ũ�⸸ŭ �Է������� ������ 
//																	 //userCarNumber�� �ԷµǴ� ���� -1 ~ (Array.length-1)��
//			System.out.print("�߸� �Է��ϼ̽��ϴ�. ������ȣ�� �ٽ� ������ �ּ���: ");
//			userCarNumber = Integer.parseInt(bufferedReader.readLine());
//		}
		if(userCarNumber == -1) {
			System.out.println("����ȭ������ ���ư��ϴ�.");
		}else {
			//7�� �޼ҵ带 ǥ��(�󼼺��� �޼ҵ� ȣ��)
			printOne(userCarNumber);
		}
	}//printArray
		
	
	//7.����� �������� ǥ���ϴ� �޼ҵ� - ����, ����, ���
	// ���� ��ȣ ���� ���� ���� ����
	// ���� ���� ���� ����
	private static void printOne(int index) throws NumberFormatException, IOException { //printArray�� userSelect�� �Ķ���ͷ� ����
		DecimalFormat format = new DecimalFormat("#,###");//���۸���ó�� �ʵ� ���� �����ϳ� ���⼭ ���� �ʴ������� ����ϴ� ���� ������̶� ���� �� �ʿ� ����
		System.out.println("==============================");
		System.out.printf("%s ������ ����\n", carArray[index].getNumber());
		System.out.printf("���� ��ȣ : %s, ���� ���� : %s, ���� ���� : %s\n", carArray[index].getNumber(), carArray[index].getType(),carArray[index].getColor());
		System.out.printf("���� ���� : %d��, ���� ���� : %s��\n", carArray[index].getYear(),format.format((long) carArray[index].getPrice()));
		
		//����, ������ ���� �޴� ����
		System.out.println("==============================");
		System.out.println("1.����  2.����  3.������� ���ư��� ");
		int userSelect = validateIntegerValue(1,3);
		if(userSelect == 1) {
			update(index); //���� ����, ����, ������ �����ϴ� �޼ҵ�
		}else if(userSelect == 2) {
			delete(index);
		}else if(userSelect == 3) {
			printAll();
		}
	}//printOne
	
	
	//9. ���� ����, ����, ������ �����ϴ� �޼ҵ�
	private static void update(int index) throws NumberFormatException, IOException {
		System.out.println("���� ����:");
		carArray[index].setColor(bufferedReader.readLine());
		
		System.out.println("���� ����:");
		carArray[index].setYear(validateIntegerValue(2000, 2020));
		
		System.out.println("���� ����:");
		carArray[index].setPrice(validateIntegerValue(0));
		
		printOne(index);
		
	}//update
	
	
	//10.���� ������ �����ϴ� �޼ҵ�
	private static void delete(int index) throws IOException {
		System.out.println("�ش� ������ ���� �����Ͻðڽ��ϱ�?(y/n)");
		System.out.print("> ");
		String yn = bufferedReader.readLine();
		if(yn.contentEquals("y")) {
			carArray = ArrayUtil.removeByIndex(carArray, index);
			printAll();
		}else if(yn.equals("n")) {
			printOne(index);
		}
	}
		
}



//<PrintOne ���� �ߴ� Ǯ��>		
//String userSelect = bufferedReader.readLine().toUpperCase();
//if(userSelect.equals("A")){
//	
//	System.out.print("���� ����: ");
//	carArray[index].setColor(bufferedReader.readLine());
//	
//	System.out.print("���� ����: ");
//	carArray[index].setYear(Integer.parseInt(bufferedReader.readLine()));
//	
//	System.out.print("���� ����: ");
//	carArray[index].setPrice(Integer.parseInt(bufferedReader.readLine()));
//	
//	printOne(index);
//	
//}else if(userSelect.equals("B")){
//	System.out.print("���� �����Ͻðڽ��ϱ�? (y/n): ");
//     String agree = bufferedReader.readLine().toUpperCase();
//     if(agree.equals("Y")) {
//        //�����ϰ� �л���� ����� �̵�
//        carArray = ArrayUtil.removeByIndex(carArray, index);
//        printAll();
//     }else if(agree.contentEquals("N")) {
//    	printOne(index);
//     }
//}else if(userSelect.equals("C")) {
//	printAll();
//}else {
//	System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");