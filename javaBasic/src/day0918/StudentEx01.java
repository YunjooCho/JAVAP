package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

//Student Ŭ���� �迭�� ArratUtil�� ����ؼ� �����ϴ� ���α׷�
public class StudentEx01 {
	private static BufferedReader bufferedReader; //�ڸ޼ҵ忡�� ����ϰ��� �ϴ� �Ű�����(�Ķ����)�� �ʵ�� ����Ǿ� ������ �Ķ���� ����� �ʿ���� �ٷ� ������ �� �� �ִ�
												  //�ʵ�, �������� �޼ҵ� ����� ��ü�� �޾Ҿ���(�Ķ����)
											      //calculateSum()���� �Ķ���͸� ������� ���� ���� : ������ �ʵ�� ����Ǿ� �־��� ����
												  //Null�� �ʱ�ȭ
	private static Student[] studentArray;//�ʵ� ���� ���� ������ �ʵ�ȭ��
	public static void main(String[] args) throws NumberFormatException, IOException {
		studentArray = new Student[0]; //�迭 �ʱ�ȭ
		bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //�ʱ�ȭ
		
		//���θ޼ҵ忡�� �ʱ�ȭ, �� �����ڸ� ȣ���ϰ� �������ʹ�
		//���� ���θ޼ҵ尡 �ٸ� �޼ҵ带 �� ���Ŀ� ȣ���ϰ� �ȴٸ�
		//�̹� �ʱ�ȭ�� �� �����̱� ������ NullPointerException�� �߻����� �ʰ�
		//���������� ����� �� �ִ�.
		
			showMenu();//while����, if���ǹ��� �޼ҵ�� ����
		
	}//main�޼ҵ�
	
	private static void showMenu() throws NumberFormatException, IOException{ //���⼭ �ٸ� �޼ҵ带 ȣ���� ����, �� ȣ��� �޼ҵ尡 �� �ٸ� �޼ҵ带 ȣ��
		while(true) {
			System.out.println("��Ʈ ���� ���� ���α׷�");
			System.out.println("1.�Է�  2.���  3.����");
			System.out.print("> ");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�Է¸޼ҵ� ����
				add();
			}else if(userChoice == 2) {
				//��¸޼ҵ� ����
				printArray();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		}
	}
	
	private static void printArray() {
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);//toStrong���� ���� �ּҰ��� �ƴ� ��ü ������� ������ ��
		}
	}
	
	
	private static void add() throws NumberFormatException, IOException {//���۸���, �迭�� �ʵ忡 �־��־��� ������ �Ķ���� �Է����� �ʾƵ� ����� �� ����
		studentArray = ArrayUtil.add(studentArray, setStudentInfo());
	}
	
	private static Student setStudentInfo() throws NumberFormatException, IOException {//���۸����� �ʵ忡 �־��־��� ������ �Ķ���� �Է����� �ʾƵ� ����� �� ����
		Student s = new Student();   //s��� ��ü�� ����, �ʱ�ȭ(�⺻���� 0, �������� null)
		System.out.print("�л� �̸�: ");
		s.setName(bufferedReader.readLine()); //name�ʵ尡 private�� �������ѵǾ��ֱ� ������ setName()�޼ҵ�� �������� �Է����� 
		
		System.out.print("�л� ��ȣ: ");
		s.setId(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		s.setKorean(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		s.setEnglish(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		s.setMath(Integer.parseInt(bufferedReader.readLine()));
		
		return s;//������ �Էµ� ��ü�� ��ȯ
	}
}
