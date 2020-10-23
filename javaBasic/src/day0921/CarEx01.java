package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

import day0916.CarT;
import util.ArrayUtil;

//�ڵ��� ���� ���α׷��� ArrayList�� �ۼ��ϼ���(
public class CarEx01 {
	//�ʵ弱��
	private static ArrayList<CarT> carList;
	private static BufferedReader bufferedReader;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		carList = new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		showMenu();
		
	}//main

	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("���� ���� ���α׷�");
			System.out.println("1. �Է�  2. ���  3. ����");
			System.out.print("> ");
			int choice = validateNumber(1,3);
			if(choice == 1) {
				//�Է� �޼ҵ� ȣ��
				add();
			}else if(choice == 2) {
				//��� �޼ҵ� ȣ��
				printAll();
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}
		}//while
	}//showMenu
	
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(bufferedReader.readLine());
		while(value < minimum || value > maximum) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		return value;
	}
	
	private static void add() throws NumberFormatException, IOException {
		CarT c = new CarT();
		System.out.print("���� ��ȣ : ");
		c.setNumber(bufferedReader.readLine());
		while(carList.contains(c)) {//��ü�迭->��̸���Ʈ �����κ�
			System.out.println("�̹� �����ϴ� ������ȣ�Դϴ�.");
			System.out.print("���� ��ȣ: ");
			c.setNumber(bufferedReader.readLine());
		}
		System.out.print("���� ���� : ");
		c.setType(bufferedReader.readLine());
		System.out.print("���� ���� : ");
		c.setYear(validateNumber(2000, 2020));
		System.out.print("���� ���� : ");
		c.setPrice(Integer.parseInt(bufferedReader.readLine()));
		System.out.print("���� ���� : ");
		c.setColor(bufferedReader.readLine());
		
		carList.add(c);//��ü�迭->��̸���Ʈ �����κ�
	}//add
	
	
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("    �� �� �� ��");
		System.out.println("�Ϸù�ȣ   |  ������ȣ");
		for(int i = 0; i < carList.size();i++) {
			System.out.printf("%d.\t%s\n", (i+1), carList.get(i).getNumber());
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("�������� Ȯ���� ������ �Ϸù�ȣ�� �����ϼ���(0�� ���θ޴��� ���ư���):");
		int number = validateNumber(0, carList.size()) - 1;
		if(number == -1) {
			System.out.println("���θ޴��� ���ư��ϴ�");
		}else {
			printOne(number);
		}
	}//printAll
	
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		DecimalFormat df = new DecimalFormat("#,###");
		CarT c = carList.get(index);
		System.out.println("-------------------------------------------");
		System.out.printf("���� ��ȣ : %s, ���� ���� : %s\n", c.getNumber(), c.getType());
		System.out.printf("���� ���� : %d��, ���� ���� : %s\n��", c.getYear(), df.format((long)c.getPrice()));
		System.out.printf("���� ���� : %s\n", c.getColor());
		System.out.println("-------------------------------------------");
		System.out.println("1.������� ����  2.������� ����  3.���� ������� ���ư���");
		int selectNumber = validateNumber(1,3);
		if(selectNumber == 1) {
			update(index);
		}else if(selectNumber == 2) {
			delete(index);
		}else if(selectNumber == 3) {
			System.out.println("���� ������� ���ư��ϴ�.");
		}
	}
	
	
	private static void update(int index) throws NumberFormatException, IOException {
		
		System.out.print("���� ���� : ");
		carList.get(index).setColor(bufferedReader.readLine());
		System.out.print("���� ���� : ");
		carList.get(index).setYear(Integer.parseInt(bufferedReader.readLine()));
		System.out.print("���� ���� : ");
		carList.get(index).setPrice(Integer.parseInt(bufferedReader.readLine()));
		
		printOne(index);
	
	}
	
	
	private static void delete(int index) throws IOException {
		System.out.print("������ �����Ͻðڽ��ϱ�?(Y/N): ");
		String yn = new String();
		yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			carList.remove(index);
			printAll();
		}else if(yn.equals("N")) {
			printOne(index);
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			yn = new String().toUpperCase();
		}
	}
	
	
}//class
