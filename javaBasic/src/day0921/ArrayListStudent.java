package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import day0915.Student;

//����:
//Student�� ��̸���Ʈ �������� ���弼��
//�� ���ڸ� �Է��Ҷ� ���ڰ� �ԷµǸ�
//�߸��Է��ϼ����� �ٽ� ���ڸ� �Է��ϼ���
//�� �ߵ��� ���弼��

//+�ߺ� �л� Ȯ��, 
//+yn �߸��Է� ���� �� ����� �� ���� �Էµ� ������ �ݺ�

public class ArrayListStudent {

	//1.�ʵ弱��
	private static BufferedReader bufferedReader;
	private static ArrayList<Student> studentList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.�ʵ� �ʱ�ȭ
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		studentList = new ArrayList<>();
		
		showMenu();
	}
	
	//3.�޴� �޼ҵ�
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("�л� ���� ���� ���α׷�");
			System.out.println("1.�Է�   2.���   3.����");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("�޴����� ");
			int choice = validateNumber(1,3);
			if(choice == 1) {
				//�Է¸޼ҵ� ȣ��
				add();
			}else if(choice == 2) {
				//��¸޼ҵ� ȣ��
				printAll();
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
			}
		}//showMenu
	}
	
	//4.��ȿ�� Ȯ�� �޼ҵ�(����)
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		System.out.print("(���ڸ� �Է����ּ���) : ");
		String inputWord = new String();
		inputWord = bufferedReader.readLine();
		while(!inputWord.matches("\\d*")) {
			System.out.print("���ڸ� �Է����ּ��� : ");
			inputWord = bufferedReader.readLine();
		}
		int value = Integer.parseInt(inputWord);
		if(value < minimum || value > maximum) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			value = Integer.parseInt(bufferedReader.readLine());
		}
		
		return value;
	}//validateNumber
	
	//4-2.��ȿ�� Ȯ�� �޼ҵ�(����, ����)
	private static int validateNumber() throws IOException {
		System.out.print("(���ڸ� �Է����ּ���) : ");
		String inputWord = new String();
		inputWord = bufferedReader.readLine();
		while(!inputWord.matches("\\d*")) {
			System.out.print("���ڸ� �Է����ּ��� :");
			inputWord = bufferedReader.readLine();
		}
		int value = Integer.parseInt(inputWord);
		return value;
	}
	
	//5. �Է� �޼ҵ�
	private static void add() throws NumberFormatException, IOException {
		Student s = new Student();
		System.out.print("�̸� : ");
		s.setName(bufferedReader.readLine());
		System.out.print("�й� ");
		s.setId(validateNumber());
		while(studentList.contains(s)) {
			System.out.println("�ߺ��� �л��Դϴ�.�ٽ� �Է����ּ���.");
			System.out.print("> ");
			s.setName(bufferedReader.readLine());
		}
		System.out.print("�������� ");
		s.setKorean(validateNumber(0,100));
		System.out.print("�������� ");
		s.setEnglish(validateNumber(0,100));
		System.out.print("�������� ");
		s.setMath(validateNumber(0,100));
		
		studentList.add(s);
		
	}//add
	
	
	//6.��� �޼ҵ�
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("-----------------");
		System.out.println("�� �� �� �� �� ��");
		System.out.println("�Ϸù�ȣ | �̸� ");
		for(int i = 0; i < studentList.size(); i++) {
			System.out.printf("%d.  %s\n", (i+1), studentList.get(i).getName());
		}
		System.out.println("-----------------");
		System.out.println("������ �л���ȣ�� �������ּ���(0�� ���θ޴���)");
		int selectNumber = validateNumber(0,studentList.size()) - 1;
		if(selectNumber == -1) {
			System.out.println("���θ޴��� ���ư��ϴ�.");
		}else {
			printOne(selectNumber);
		}
	}
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		System.out.println("-----------------");
		System.out.println("�� �� �� �� �� ��");
		System.out.printf("�л���ȣ : %d, �̸� : %s\n", studentList.get(index).getId(), studentList.get(index).getName());
		System.out.printf("�������� : %03d��, �������� : %03d, �������� : %03d\n", studentList.get(index).getKorean(),studentList.get(index).getEnglish(),studentList.get(index).getMath());
		System.out.printf("���� : %03d��, ��� : %.3f��\n", studentList.get(index).calculateSum(), studentList.get(index).calculateAverage());
		System.out.println("-----------------");
		System.out.println("1.����   2.����   3.�������");
		int choice = validateNumber(1,3);
		if(choice == 1) {
			update(index);
		}else if(choice == 2) {
			delete(index);
		}else if(choice == 3) {
			printAll();
		}
	}//printOne
	
	
	private static void update(int index) throws NumberFormatException, IOException {
		
		System.out.print("�������� : ");
		studentList.get(index).setKorean(validateNumber(0,100));
		System.out.print("�������� : ");
		studentList.get(index).setEnglish(validateNumber(0,100));
		System.out.print("�������� : ");
		studentList.get(index).setMath(validateNumber(0,100));
		
		printOne(index);
	}//update
	
	
	private static void delete(int index) throws NumberFormatException, IOException {
		System.out.print("������ �����Ͻðڽ��ϱ�?(Y/N) : ");
		String yn = new String();
		yn = bufferedReader.readLine().toUpperCase();
		while(true) {
			if(yn.equals("Y")) {
				studentList.remove(index);
				printAll();
			}else if(yn.equals("N")) {
				printOne(index);
			}else {
				
					System.out.println("�߸��Է��ϼ̽��ϴ�.�ٽ� �Է��ϼ���.");
					System.out.print("> ");
					yn = bufferedReader.readLine().toUpperCase();
			}
		}
	}
}

