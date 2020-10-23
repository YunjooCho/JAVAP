package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.ArrayUtil;

public class PostEx01 {
	//1. �ʵ弱��
	private static BufferedReader bufferedReader;
	private static Post[] postArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2.�迭����
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		postArray = new Post[0];
		
		showMenu();
		
	}

	//2.�޴� �޼ҵ�
	private static void showMenu() throws NumberFormatException, IOException {
	
		while(true) {	
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("\t��   ��   ��\t");
			System.out.println("1.�����ۼ�   2.�۸��   3.����");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("�޴� ����> ");
			
			//�޴�����
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�ۼ��ϱ�
				add();
			}else if(userChoice == 2) {
				//��Ϻ���
				printArray();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �������ּ���!");
			}
			
		}//�޴� while��	
	}//�޴� �޼ҵ�

	
	//3.���� �ۼ��ϴ� �޼ҵ�(�Է��ϴ� �޼ҵ�) - ��ü������ �Է��ϴ� �޼ҵ�
	private static Post setPostInfo() throws IOException {
		Post p = new Post();
		System.out.print("����: ");
		p.setTitle(bufferedReader.readLine());
		System.out.print("����: ");
		p.setContents(bufferedReader.readLine());
		System.out.print("�ۼ���: ");
		p.setWriter(bufferedReader.readLine());
		
		return p;
		
	}//setPostInfor�޼ҵ�
	
	
	//4.Ȯ��� �迭�� ��ü������ �߰��� �Է��ϴ� �޼ҵ�
	private static void add() throws IOException {
		postArray = ArrayUtil.add(postArray, setPostInfo());
	}
	
	
	//5.�ۼ��� �� ����� �����ϰ� �����ִ� �޼ҵ�
	private static void printArray() throws NumberFormatException, IOException {
		
		System.out.printf(" ��������������������������������������������\n");
		System.out.printf(" ��   ��ȣ          ������       ��\n");
		System.out.printf(" ��������������������������������������������\n");
		for(int i = 0; i < postArray.length; i++) {
		System.out.printf("   %d      %s     \n", (i+1), postArray[i].getTitle());
		}
		System.out.println("���� ������ ���ϴ� ��ȣ�� ����(0�� ��ü�޴��� ���ư���)");
		System.out.print("> ");
		int selectNumber = validateNumber(0, postArray.length) - 1;
		if (selectNumber == -1) {
			System.out.println("��ü�޴��� ���ư��ϴ�");
		}else {
			//�󼼺��� �޼ҵ� ȣ��
			printOne(selectNumber);
		}
		
		
	}//printArray�޼ҵ�
	
	
	//6.�Է� ���� ��ȿ�� ������ Ȯ���ϴ� �޼ҵ�
	private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
		int number = Integer.parseInt(bufferedReader.readLine()); 
		if( number < minimum || number > maximum) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
			number = Integer.parseInt(bufferedReader.readLine()); 
		}
		
		
		return number;
	}
	
	
	//7.�󼼺��� �޼ҵ�
	private static void printOne(int index) throws NumberFormatException, IOException {
		
		System.out.printf("<%d�� �� �� �� >\n", (index+1));
		System.out.printf("���� : %s\n", postArray[index].getTitle());
		System.out.printf("���� : %s\n", postArray[index].getContents());
		System.out.printf("�ۼ��� : %s\n", postArray[index].getWriter());
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1.����    2.  ����    3. �۸��");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("> ");
		int modideleretu = validateNumber(1,3);
		if(modideleretu == 1) {
			update(index);
		}else if(modideleretu == 2) {
			delete(index);
		}else{
			printArray();
		}
	}
	
	
	//8.�����ϴ� �޼ҵ�
	private static void update(int index) throws IOException {
		
		System.out.print("����: ");
		postArray[index].setTitle(bufferedReader.readLine());
		System.out.print("����: ");
		postArray[index].setContents(bufferedReader.readLine());
		System.out.print("�ۼ���: ");
		postArray[index].setWriter(bufferedReader.readLine());	

		printOne(index);
	}
	
	
	//9.�����ϴ� �޼ҵ�
	private static void delete(int index) throws IOException {
		System.out.println("�ش� �Խñ��� �����Ͻðڽ��ϱ�?(Y/N)");
		System.out.print("> ");
		String yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			postArray = ArrayUtil.removeByIndex(postArray, index);
			printArray();
		}else if(yn.equals("N")) {
			printOne(index);
		}else {
			System.out.println("�߸� �����ϼ̽��ϴ�. �ٽ� �����ϼ���.");
		}
	}

}//PostEx01Ŭ����






