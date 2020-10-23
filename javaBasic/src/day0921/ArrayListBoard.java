package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import util.ArrayUtil;

public class ArrayListBoard {
    //�ʵ弱��(��� ����Ʈ, ���۸���)
	private static ArrayList<Board> boardList;
	private static BufferedReader bufferedReader;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//������
		boardList= new ArrayList<>();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		showMenu();
		
	}
	
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("\t��  ��  ��");
			System.out.println("1.�����ۼ�   2.��Ϻ���   3. ����");
			int userChoice = validateNumber(1,3);
			if(userChoice == 1) {
				//�����ۼ�
				add();
			}else if(userChoice == 2) {
				//��Ϻ���
				printAll();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�!");
				break;
			}
		}//while
	}//showMenu
	
	
	
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		System.out.print("> ");
		int number = Integer.parseInt(bufferedReader.readLine());
		if(number < minimum || number > maximum) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			System.out.print("> ");
			number = Integer.parseInt(bufferedReader.readLine());
		}
		return number;
	}//validateNumber
	
	
	
	private static Board setBoardInfo() throws NumberFormatException, IOException {
		Board b = new Board();
		System.out.print("�۹�ȣ : ");
		b.setId(Integer.parseInt(bufferedReader.readLine()));
		System.out.print("���� : ");
		b.setTitle(bufferedReader.readLine());
		System.out.print("���� : ");
		b.setContent(bufferedReader.readLine());
		System.out.print("�ۼ��� : ");
		b.setWriter(bufferedReader.readLine());
		
		return b;
		
	}//setBoardInfo
	
	
	
	private static void add() throws NumberFormatException, IOException {
		boardList.add(setBoardInfo());
	}//add
	
	
	private static void printAll() throws NumberFormatException, IOException {
		System.out.println("=========");
		System.out.println("��ȣ  |  ����");
		for(int i = 0; i < boardList.size(); i++) {
			System.out.printf("%d. %s\n", boardList.get(i).getId(), boardList.get(i).getTitle());
		}
		System.out.println("�󼼺��� �� ��ȣ (0�� �޴���)");
		int choice = validateNumber(0,boardList.size())-1; //�迭����Ʈ �ε����� ��
		if(choice == -1) {
			//�޴��� ���ư���
			System.out.println("ó���޴��� ���ư��ϴ�.");
		}else {
			printOne(choice);
		}
	}//printAll
	
	
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		System.out.println("�۹�ȣ : " + boardList.get(index).getId());
		System.out.println("���� : " + boardList.get(index).getTitle());
		System.out.println("�ۼ��� : " + boardList.get(index).getWriter());
		System.out.println("���� : " + boardList.get(index).getContent());
		System.out.println("1. ���� 2. ���� 3.�޴���");
		int updere = validateNumber(1,3);
		if(updere == 1) {
			update(index);	
		}else if(updere == 2) {
			delete(index);
		}else if(updere == 3) {
			printAll();
		}
	}//printOne
	
	
	
	private static void update(int index) throws IOException {
		
		System.out.print("���� : ");
		boardList.get(index).setTitle(bufferedReader.readLine());
		System.out.print("���� : ");
		boardList.get(index).setContent(bufferedReader.readLine());
		System.out.print("�ۼ��� : ");
		boardList.get(index).setWriter(bufferedReader.readLine());
		
		printOne(index);
		
	}
	
	private static void delete(int index) throws NumberFormatException, IOException {
		
		System.out.println("������ �����Ͻðڽ��ϱ�?(y/n)");
		String answer = bufferedReader.readLine().toLowerCase();
		if(answer.equals("y")) {
			boardList.remove(index);
			printAll();
		}else if(answer.equals("n")) {
			printOne(index);
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
		}
		
	}

}
