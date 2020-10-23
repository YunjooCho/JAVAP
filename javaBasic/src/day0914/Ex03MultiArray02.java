package day0914;

//�� ���� ������ ������ ���� �����ϴ� ���α׷��� �ۼ��غ�����
//���� �� ������ 4���Դϴ�
//�� ���� �ִ� �л����� 10���Դϴ�
//���� �Է��� �ȵ� ����
//�Է��� �ȵǾ��ٰ� ��µǰ� �ϼ���

//�Է��� �����ϸ�
//�� ������ �Է��� �ް�
//�� ���� �л����� �Է¹ް�
//�� �� �л����� ������ ������ ���ʴ�� �Է¹ް� �ϼ���.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03MultiArray02 {
	//1. �������
	//�ִ� �л��� üũ�� ���
	final static int CLASS_NUMBER = 4;
	//���� �� ����
	final static int STUDENT_SIZE = 10;

	public static void main(String[] args) throws IOException{
	//0.�Է¹��� �� ����� ����(=��ü)����
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));	
	//2.�迭���� -������ ������ int[][] socreArray����
	//���� �迭 ����
	//�Ǵ� scoreArray Ŀ�ٶ� �迭�� ����
	int[][][] scoreArray = new int[CLASS_NUMBER][][];
	
	//scoreArray[0]�� ������ ���ϴ°�?
	//scoreArray[0][3] 1�� 4���л�
	//scoreArray[0][3][1] 1�� 4���л� ��������
	
	//3-2.�޴� ���
	while(true) {
		showMenu();
	    int selectMenu = Integer.parseInt(bufferedReader.readLine());
	    if(selectMenu == 1) {
	    	//7-2.�Է¸޼ҵ� ���
	    	
	    	//5-2.�ݼ���
	    	int classNumber = selectClassNumber(bufferedReader);
	    	//6-2.�л��� �Է�
	    	int studentSize = selectStudentSize(bufferedReader);
	    	

	    	//�Է�(for��)
	    	scoreArray[classNumber] = new int[studentSize][3];
	    	 //scoreArray�� classNumber �ε�����
	    	 //int 2���� �迭�̴�
	    	 //2���� �迭�� classNumber��ŭ ���ִ� 3���� �迭�̴�
	    	 //3������ 2���� �迭�� �𿩼� �Ȱ�, [3]�� �����
	    	 //���� 2����,1������ �ʱ�ȭ(3������ classNumber = 4�� ��������߱⶧���� �ʱ�ȭ����)
	    	 //���� ��� ���� 3���� �ʱ�ȭ �Ѵٸ� �Ʒ��� ����
	    	 //int[][][] scoreArray = new int[4][][]
	   
	    	//���� �ڵ��� �ǹ̴�
	    	//scoreArray�� int�� 3���� �迭�ε� int 2���� �迭�� CLASS_NUMBER�� ��ŭ ���ִٴ� �ǹ̰� �ȴ�
	    	//�츮�� scoreArray[0]�� ����Ϸ���
	    	//�� 0���� � ũ���� 2���� �迭�� �̷�����ִ����� �����ؾ��Ѵ�.
	    	//scoreArray[0] = new int[studentSize][]
	    	//�̷��� ������
	    	//scoreArray�� 0�� �ε����� int�� 3�� ���ִ� int 1���� �迭�� studentSize��ŭ �����ִ� int 2���� �迭�̴�
	    	
	    	//scoreArray�� classNumber �ε����� int 2�����迭�̰� ũ��� 2������ studenNumber, 1������ 3�� ũ��� �ǹ�
	    	
	    	//int[4] �� int�� 4�� ���ִ�
	    	//int[2][4] ��
	    	//          int�� 4�� �����ִ� �迭�� 2�� ���ִ�.
	    	
	    	//int[5][2][4]��
	    	//			int�� 4�����ִ� �迭��
	    	//			2�� �𿩼� �ϳ��� �迭�� �ǰ�(2�����迭)
	    	//			�׷��� �迭�� 5���� ���ִ� ��� �ǹ̰� �ȴ�.
	    	//int[][][] arr = int[5][2][4]
	    	//            -arr[0]: int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[1]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[2]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[3]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[4]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	
	    	// int[] arr = new int[5]
	    	// int�� 5������ ��
	    	
	    	// int[][] arr = new int[3][5]
	    	// �̰��� int[]�� 3���� ���ΰ� arr�̴�
	    	// �׷��ٸ� arr[0]�� �����ΰ�?
	    	// int[5]�̴�
	    	// �� �ڼ��ϰ� ���ϸ� arr[0]�� int �迭�� �迭�̴�
	    	
	    	//���� scoreArray[i][j][z]�ȿ� ����������ϱ�
	    	//print(scoreArray[i]) �̰ų�
	    	//print(scoreArray[i][j]) �̷��� ����ϸ� 3�����迭�� �ƴ� �׳�  1����, 2���� �迭�� �ν��ؼ� ������ ����
	    	//print(scoreArray[i][j][z])���� �ؾ� ���� ����
	    	
	    	for(int i = 0; i < scoreArray[classNumber].length; i++) {
	    		System.out.println((i+1)+ "�� �л��� ���� �Է� : ");
	    		scoreArray[classNumber][i][0] = validateScore(bufferedReader, 1); //[classNumber��][i���л�][0]��������
	    		scoreArray[classNumber][i][1] = validateScore(bufferedReader, 2); //[classNumber��][i���л�][1]��������
	    		scoreArray[classNumber][i][2] = validateScore(bufferedReader, 3); //[classNumber��][i���л�][2]��������
	    		//�л�����ŭ ���� �Է�(�л����� ������ ����ڰ� �Է��� ��)
	    	}
			
	    	
	    }else if(selectMenu == 2) {
	    	//8-2.��¸޼ҵ�
	    	//5-2�ݼ���
	    	int classNumber = selectClassNumber(bufferedReader);
	    	//�ش���� �ʱ�ȭ �Ǿ����� üũ
	    	//�ʱ�ȭ �Ǿ� ������ ���
	    	if(scoreArray[classNumber] == null) {
	    		//���� �ʱ�ȭ�� �ȵǾ� �����Ƿ� ���޽��� ���
				System.out.println("���� �Էµ��� ���� �����Դϴ�.");
			}else {
				for(int i = 0; i < scoreArray[classNumber].length; i++) {
					System.out.println("==========================");
					System.out.println((i+1) + "�� �л��� ����");
					System.out.printf("����: %03d�� ����: %03d�� ����: %03d��\n",
							scoreArray[classNumber][i][0], scoreArray[classNumber][i][1], scoreArray[classNumber][i][2]);
				}//���� �л��̸� �Էºκ��� ���
			}
	    	
	    	
	    }else if(selectMenu == 3) {
	    	System.out.println("������ּż� �����մϴ�");
	    	break;
	    }else {
	    	System.out.println("�޴��� �߸� �Է��ϼ̽��ϴ�.");
	    	System.out.print("�޴� ����> ");
	    	selectMenu = Integer.parseInt(bufferedReader.readLine());
	    }
	}
	}
	
	//3-1.�޴� �޼ҵ� �����
	static void showMenu() {
		System.out.println("==========================");
		System.out.println("��Ʈ����б� ������ �������� ���α׷�");
		System.out.println("1.�Է�\t2.���\t3.����");
		System.out.println("==========================");
		System.out.print("�޴� ����> ");
	}//showMenu
	
	
	//5. �ݼ��� �޼ҵ� �����
	static int selectClassNumber(BufferedReader buffredReader) throws IOException {
		System.out.print("���� �����ϼ���(1~4) :");
		System.out.print("> ");
		int classNumber = Integer.parseInt(buffredReader.readLine());
		while(classNumber < 1 || classNumber > CLASS_NUMBER) {
			System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���.");
			System.out.print("���� �����ϼ���(1~4) :");
			System.out.print("> ");
			classNumber = Integer.parseInt(buffredReader.readLine());
		}
		return classNumber - 1;//�迭��[0]���� �����ϹǷ� -1�� [0][1][2][3]�� �ش�
	}//selectClassNumber
	
	//6-1. �л��� �Է� �޼ҵ�
	static int selectStudentSize(BufferedReader bufferedReader) throws IOException{
		System.out.println("�л��� ���ڸ� ������ �ּ��� :");
		System.out.print("> ");
		int studentSize = Integer.parseInt(bufferedReader.readLine());
		while(studentSize < 0 || studentSize > STUDENT_SIZE) {
			System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���");
			System.out.println("�л��� ���ڸ� �Է��� �ּ��� (~10):");
			studentSize = Integer.parseInt(bufferedReader.readLine());
			}
		return studentSize; //���⼭�� -1 �ʿ����, �迭�� ũ�⸦ �����ϱ� ���� �����̱� ����
	}
	
	//7-1. �Է¸޼ҵ� �����
	static int validateScore(BufferedReader bufferedReader, int code) throws IOException {
		String message = new String();
		switch(code) {
		case 1:
			message = "����";
			break;
		case 2:
			message = "����";
			break;
		case 3:
			message = "����";
			break;
		}
		message += " ������ �Է��ϼ���: ";
		System.out.println(message);
		System.out.print("> ");
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 0 || score > 100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			System.out.print(message);
			System.out.print("> ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		return score;
	}
	
	//8-1. ��¸޼ҵ� �����
}
