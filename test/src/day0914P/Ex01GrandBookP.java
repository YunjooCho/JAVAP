package day0914P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01GrandBookP {
	//����ڷκ��� ���г� ���° ������������ �Է� �޾Ƽ�
	//�ش� ��ġ�� ������ �ִ� �ڵ带 �����Ͻÿ�
	//����1. �߸��� �г��� �Էµ��� �ʰ� �Ͻÿ�
	//����2. ���° ���������� �Է� ���� �� �߸� �� ������ �Էµ��� �ʰ� �Ͻÿ�
	//����3. ������ �ùٸ� ������ �ԷµǱ� �Ͻÿ�

	//����
	//���г� �����Դϱ�? (�Է� 4)
	//�ùٸ��� ���� �г��Դϴ�.
	//���г� �����Դϱ�? (�Է� 2)
	//���° �����Դϱ�? (�Է� -2)
	//�ùٸ��� ���� �����Դϴ�.
	//���° �����Դϱ�? (�Է� 1)
	//�����Դϱ�? (�Է� 80)
	//2�г� 1�б� �߰� ��� ��� 80���� �ԷµǾ����ϴ�.
	//1�г� 1�б� �߰� 
	//���� 40 ���� 50 ���� 45
	
    //1.�������
	final static int YEAR = 3; // �г�
	final static int TEST_NUMBER = 4;//1�б� �߰�~2�б� �⸻
	public static void main(String[] args) throws IOException {
	//0.�Է¸޸� ����
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	//0.�迭����
	int[][] korArray = new int[YEAR][TEST_NUMBER];
	int[][] engArray = new int[YEAR][TEST_NUMBER];
	int[][] mathArray = new int[YEAR][TEST_NUMBER];
	
	//2-2.�޴� �޼ҵ� ���
	while(true) {
		showMenu();
		int choice = Integer.parseInt(bufferedReader.readLine());
		if(choice == 1) {
			//5-2. �г⼱�� �޼ҵ� ȣ��
			int year = selectYear(bufferedReader);
			//6-2. ���輱�� �޼ҵ� ȣ��
			int testNumber = selectTest(bufferedReader);
			//7-2. �����Է� �޼ҵ� ȣ��
			korArray[year][testNumber] = validateScore(bufferedReader,1);
			engArray[year][testNumber] = validateScore(bufferedReader,2);
			mathArray[year][testNumber] = validateScore(bufferedReader,3);
			
			
		}else if(choice == 2) {
			//5-2. �г⼱�� �޼ҵ� ȣ��
			int year = selectYear(bufferedReader);
			//6-2. ���輱�� �޼ҵ� ȣ��
			int testNumber = selectTest(bufferedReader);
			//8-2. ��� �޼ҵ� ȣ��
			String message = new String();
			switch(testNumber){
				case 1 :
					message = "1�г� �߰�";
					break;
				case 2 :
					message = "1�г� �⸻";
					break;
				case 3 :
					message = "2�г� �߰�";
					break;
				case 4 :
					message = "2�г� �⸻";
					break;
			}
			System.out.println(year + "�г� " + message);
			printScore(korArray[year][testNumber], engArray[year][testNumber], mathArray[year][testNumber]);
			
		}else if(choice == 3) {
			//3.���� ó��
			System.out.println("������ּż� �����մϴ�");
			break;
		}else {
			//4.�����Է�
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �޴��� �������ּ���");
		}
		
		
		
	}//�޴� while
	
	}//main�޼ҵ�
	
	//2-1.�޴� �޼ҵ� ����
	static void showMenu() {
		System.out.println("===========================");
		System.out.println("�ڵ�����б� �������� ���α׷�");
		System.out.println("1.�Է�   2.���   3.����");
		System.out.println("===========================");
		System.out.print("�޴� ����> ");
	}
	
	//5-1.�г� ���� �޼ҵ� ����
	static int selectYear(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		System.out.println("�г��� �������ּ���(1~3)");
		System.out.print("> ");
		int year = Integer.parseInt(bufferedReader.readLine());
		while(year < 0 || year > 3) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			System.out.println("�г��� �������ּ���(1~3)");
			System.out.print("> ");
			year = Integer.parseInt(bufferedReader.readLine());
		}//while
		return year - 1; //�迭�̹Ƿ� ����ڴ� 1,2,3�� �Է�. ���� ���� [0][1][2]�Է�
	}//selectYear�޼ҵ�
	
	//6-1. ���� ���� �޼ҵ� ����
	static int selectTest(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		System.out.println("������ �������ּ���");
		System.out.println("1.1�б� �߰�   2.1�б� �⸻   3.2�б� �߰�   4.2�б� �⸻");
		System.out.print("> ");
		int testNumber = Integer.parseInt(bufferedReader.readLine());
		while(testNumber < 0 || testNumber > 4) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			System.out.println("������ �������ּ���");
			System.out.println("1.1�б� �߰�   2.1�б� �⸻   3.2�б� �߰�   4.2�б� �⸻");
			System.out.print("> ");
			testNumber = Integer.parseInt(bufferedReader.readLine());			
		}
		return testNumber - 1;//�迭�̹Ƿ� ����ڴ� 1,2,3,4�� �Է�. ���� ���� [0][1][2][3]�Է�
	}
	
	//7-1. ���� �Է� �޼ҵ� ����
	static int validateScore(BufferedReader bufferedReader, int code) throws NumberFormatException, IOException {
		String message = new String();
		switch(code) {
		case 1 :
			message = "����";
			break;
		case 2 :
			message = "����";
			break;
		case 3 :
			message = "����";
			break;
		}//switch
		message += " ���� �Է� : ";
		System.out.print(message);
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 0 || score > 100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			System.out.print(message);
			score = Integer.parseInt(bufferedReader.readLine());
		}//while��
		return score;
	}//validateScore�޼ҵ�
	
	//8-1. ��� �޼ҵ� ����
	static void printScore(int korean, int english, int math) {
		System.out.printf("���� :%d, ���� :%d, ���� :%d\n", korean, english, math);
	}

}
