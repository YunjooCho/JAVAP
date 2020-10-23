package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.CarT;
import util.ArrayUtil;

//�����Ҵ��� �Ǵ� �迭����
public class CarEx06 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//�迭 ����(�����Ҵ�)
		CarT[] carArray = new CarT[0];//�����Ҵ����� �迭�� ũ�⸦ ������ �����̱� ������ 0�� �Է�
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//carArray �߰� �޼ҵ� ����
				carArray = add(carArray,bufferedReader);
			}else if(userChoice == 2) {
				//carArray ��� �޼ҵ� ����
				printArray(carArray);
			}else if(userChoice == 3){
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		}//�޴� �ݺ�while		
	}
	private static void showMenu() {
		System.out.println("1.�Է� 2.��� 3.����");
		System.out.print("> ");
	}
	
	private static CarT[] add(CarT[] carArray, BufferedReader bufferedReader) throws NumberFormatException, IOException {
		//���۵帮���� �Ķ���͸� ��� �Ѱ��� ����
		carArray = ArrayUtil.add(carArray,setCarInfo(bufferedReader)); //��ü �߰��ϴ� �޼ҵ�
																	   //setCarInfo���� ��ü�� �� ���������� �־���
		return carArray;
	}
	
	private static CarT setCarInfo(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		//��ü������, �迭�� �Է��� ���� ����
		//�� �޼ҵ尡 ����ɶ����� ���ο� c��ü�� �����Ǿ� ������ c���� �ּҰ��� �޶���
		//�� �޼ҵ� ���� �Ŀ��� ���ο��� ��üc�� �����־� main�޼ҵ忡�� �� �޼ҵ尡 ȣ��� ������ ���� �Ѱ���
		//�����ȣ 1,2,3,4....�� ���� �̹���
		//�� �޸� ���� - ��ü�����, ����-?? 
		CarT c = new CarT();
		
		System.out.print("���� ��ȣ: ");
		c.setNumber(bufferedReader.readLine());
		
		System.out.print("���� ����: ");
		c.setType(bufferedReader.readLine());
		
		System.out.print("���� ����: ");
		c.setYear(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		c.setPrice(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		c.setColor(bufferedReader.readLine());
		
		return c;
		
	}
	
	private static void printArray(CarT[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			System.out.println(carArray[i]);
		}
	}
}
