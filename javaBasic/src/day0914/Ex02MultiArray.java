package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������ �迭
//������ �迭�̶� ������ �迭�� �����Ҷ�
//���� ���� ũ�⸸ �������ְ�
//�ű⿡ ���� �迭�� ũ��� ����� �� �����ִ� ����̴�.

//����: 1�г� 1���� 30��, 2���� 29��, 3���� 32���϶�
//�迭 ������ ��� �ؾ��ұ�?
//int[][] scoreArray = int[3][];
//scoreArray[0] = new int[30];
//scoreArray[1] = new int[29];
//scoreArray[2] = new int[32];

public class Ex02MultiArray {
	
	final static int SIZE = 3;	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//1�г� ������ �л����� �Է¹ް�
		//�� �л����� �̸��� �ݸ��� �־��ִ� ���α׷�
		String[][] nameArray= new String[SIZE][]; //3���� �迭�� ���� ��� String�� ���� �����ȵǾ�����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("��Ʈ����б� �̸� ���� ���α׷�");
			System.out.println("1.�Է�  2.���  3.����");
			System.out.print("> ");
			int choice = Integer.parseInt(bufferedReader.readLine());
			if(choice == 1) {
				//�� �����ϴ� �޼ҵ� ����
				int classNumber = selectClassNumber(bufferedReader);
				
				//�̸��� �Է��ϴ� �޼ҵ� ����
				//�� �迭�� ũ�⸦ �����ؾ��ϹǷ�
				//�л� ���ڸ� �Է� �޵��� �Ѵ�.
				int studentSize = insertStudentSize(bufferedReader);
				//insertStudenSize���� �л����� ������
				
				//�Է¹޴� �ݰ� �л����ڷ� �ش� �迭�� �ʱ�ȭ���ش�
				nameArray[classNumber - 1] = new String[studentSize];
				
				//�л��� �̸��� �Է¹޴´�
				for(int i = 0; i < nameArray[classNumber - 1].length; i++) {
					System.out.println((i+1) + "�� �л��� �̸� : ");
					nameArray[classNumber - 1][i] = bufferedReader.readLine();
				}
				//insertStudentSize���� �Է��� �л� ����ŭ(�迭�̹Ƿ� [0]���� �Է��̴ϱ� [classNumber-1]
				
			}else if(choice == 2) {
				//�� �����ϴ� �޼ҵ� ����
				int classNumber = selectClassNumber(bufferedReader); 
 				
				//�̸��� ����ϴ� �޼ҵ� ����
				//�� ���⼭ �����ؾ� �� ����
				//�ش� �迭�� �ʱ�ȭ �Ǿ��ִ��� üũ�� �ؾ��Ѵ�(�Է��� �ȵǾ������� null�� ����)
				//���� �ش� �迭�� �ʱ�ȭ�Ǿ����� �ʴٸ�
				//�� ������  ���� null�� �����̹Ƿ�
				//�츮�� ������ �� ����
				//���� �� �迭�� null�������� üũ�ϰ�
				//null�� �ƴҶ����� ����ϴ� for���� �����Ѵ�
				
				//null�̶� ������ ������Ÿ���� �ʱ�ȭ��
				//���� �̷������ ���� ���¸�
				//���̶�� �Ѵ�.
				if(nameArray[classNumber - 1] == null) {
					System.out.println("���� �ش� ���� �Էµ��� ���� �����Դϴ�.");
				}else {
					for(int i = 0; i < nameArray[classNumber - 1].length; i++) {
						System.out.println(nameArray[classNumber - 1][i]);
					}//���� �л��̸� �Էºκ��� ���
				}
				
				//�⺻�� ������Ÿ�԰� ������ ������ Ÿ���� ������
				//�⺻�� : ���ÿ����� ���� ���� ��ư��ִ� ������Ÿ��
				//		 byte short int long float double char boolean 8���� ������ �ְ�
				//		  �⺻������ 0���� �ʱ�ȭ�ȴ�
				
				//������ : ���� �������� �� �������� ���� �ּҰ��� �������ְ�
				//	 	  ���� ������ �� �Ǵ� �޼ҵ�� �� ������ Ȯ���ؾ� � ��, � �޼ҵ尡 �ִ��� Ȯ�� ������ ������Ÿ��
				//		  ���������� Ŭ������(=��ü��), �迭��, �������̽��� 3������ �ְ�
				//		 new�� ���ؼ� �ʱ�ȭ���� ������ null�� �ʱ�ȭ�� �ȴ�
				//	     null�� ���¿����� �ƹ��� �޼ҵ�, �ʵ� ������ �Ұ����ϴ�
				//		 ������ �Ϸ��� �ϸ� NullPointerException�� �߻��ϰ� �ȴ�!!!
				
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}
				
		}
	
	}
	static int selectClassNumber(BufferedReader reader) throws NumberFormatException, IOException  {
		
		System.out.println("���� �������ּ��� : ");
		int classNumber = Integer.parseInt(reader.readLine());
		
		while(classNumber < 1 || classNumber > SIZE) {
			System.out.println("�� �� �Է��ϼ̽��ϴ�");
			System.out.println("���� �������ּ���(1����" + SIZE + "����");
			System.out.print("> ");
			classNumber = Integer.parseInt(reader.readLine());
		}
		return classNumber;
	}
	
	//�л��� ���ڸ� �Է¹޴� �޼ҵ�
	static int insertStudentSize(BufferedReader reader) throws NumberFormatException, IOException {
		System.out.print("�л��� ���ڸ� �Է����ּ���: ");
		int studentSize = Integer.parseInt(reader.readLine());
		while(studentSize < 0) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. 0���� ū ���� �Է����ּ���");
			System.out.println("�л��� ���ڸ� �Է����ּ��� : ");
			studentSize = Integer.parseInt(reader.readLine());
		}
		return studentSize;
	}
}
