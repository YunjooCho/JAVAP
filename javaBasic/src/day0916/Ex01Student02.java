package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�л��� ������ �����ϴ� ���α׷��� �ۼ��ϼ���
//�۵������  CarEx02.java�� ����

import day0915.Student;

public class Ex01Student02 {
	public static void main(String[] args) throws IOException {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	Student student = new Student();
	
	while(true) {
		System.out.println("=======================");
		System.out.println("�л� ���� ���α׷�");
		System.out.println("1. �Է�     2. ���    3. ����");
		int choice = Integer.parseInt(bufferedReader.readLine());
		if(choice == 1) {
			
			//�л� ���� �Է�
			 System.out.print("�̸�: ");
			 student.setName(bufferedReader.readLine());
			 System.out.print("�й�: ");
			 student.setId(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("��������: ");
			 student.setKorean(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("��������: ");
			 student.setEnglish(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("��������: ");
			 student.setMath(Integer.parseInt(bufferedReader.readLine()));
			 
		}else if(choice == 2) {
			//�л� ���� ���
			if(student.getName().equals("")) { //student.getName().isEmpty(); ->true/false
				System.out.println("���� �Էµ� ������ �����ϴ�");
			}else {
				System.out.printf("�̸�: %s, �й�: %d\n", student.getName(), student.getId());
				System.out.printf("����: %d, ����: %d, ����: %d",student.getKorean(),student.getEnglish(),student.getMath());
				System.out.printf("����: %d, ���: %.2f\n", student.calculateSum(), student.calculateAverage());
			}
		}else if(choice == 3) {
			System.out.println("������ּż� �����մϴ�");
			break;
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� ������ �ּ���");
		}
	}//�޴� while
	
	}
}
