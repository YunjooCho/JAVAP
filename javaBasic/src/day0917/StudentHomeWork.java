package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

//�����Ҵ��� �Ǵ� �迭����
public class StudentHomeWork {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1.�迭 ����(�����Ҵ�)
		Student[] studentArray =  new Student[0]; //�����Ҵ� �迭�̶� [0]�� ��

		//2.�޸� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//3-2.�޴� ���
		while(true) {
			showMenu();
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�Է� �޼ҵ� ����
				studentArray = add(studentArray, bufferedReader); //������ �Է��� �л������� �迭������ �ʿ�
			}else if(userChoice == 2){
				//��� �޼ҵ� ����
				printArray(studentArray);
			}else if(userChoice == 3){
				System.out.println("������ּż� �����մϴ�");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �Է����ּ���.");
			}
		}//�޴� while��
		
	}
	//6. �迭 ��� �޼ҵ� - ���±��� ��ü ����� �־����� �迭��� �޼ҵ�� ������
	private static void printArray(Student[] studentArray) { //private�� CarEx06�� ������� ����
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);
		}
	}
	
	//5.ArrayUtil���� ������ �迭�� ��Ҹ� �߰��� �迭�� �ø��� �޼ҵ� + ��ü�� ������ �Է��� ��ȯ�ϴ� �޼ҵ�
	//  �ΰ����� ���� ��ü�� ������ �Է��� ��, �迭�� �߰��Ͽ� �迭�� �ø�
	private static Student[] add(Student[] studentArray, BufferedReader bufferedReader) throws NumberFormatException, IOException {
		studentArray = ArrayUtil.add(studentArray, setStudentInfo(bufferedReader));
		
		return studentArray;
	}
	
	//4. ��ü�� �л������� �Է��ϴ� �޼ҵ�
	private static Student setStudentInfo(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		Student s = new Student();//Student.java���� ������ ����
		System.out.print("�̸� : ");//Student.java���� ����
		s.setName(bufferedReader.readLine());
		
		System.out.print("�й� : ");//Student.java���� ����
		s.setId(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("�������� : ");//Student.java���� ����
		s.setKorean(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("�������� : ");//Student.java���� ����
		s.setEnglish(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("�������� : ");//Student.java���� ����
		s.setMath(Integer.parseInt(bufferedReader.readLine()));
		
//		System.out.println("���� : ");//Student.java���� ����
//		s.calculateSum();
//		
//		System.out.println("��� : ");//Student.java���� ����
//		s.calculateAverage();
		
		return s;
		
	}
	
	//3-1.�޴� �޼ҵ�
	private static void showMenu() {
		System.out.println("=======================");
		System.out.println("�л� ���� ���� ���α׷�");
		System.out.println("1.�Է� 2.��� 3.����");
		System.out.println("=======================");
		System.out.print("�޴����� > ");
	}
}



//<����>
//1.�� class�� add�� ArrayUtil.add�� ���?
//2.���⼭ ������ ����� ����Ϸ���? - ���ʿ� �ʵ尡 ���� �޼ҵ常 ����, �ʵ带 ����� �����? �ʵ尡 �����Ƿ� �����ڿ��� ������ ����� �ʱ�ȭ �ϰ� ������ ����
//                          - �ƴϸ� �޼ҵ常 �־ ������ ����?

