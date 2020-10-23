package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

//�л� ��Ͽ� �߰����� �޼ҵ带 �� ������
// 1. ���� �л���ȣ�� �̸��� ���� �л��� �ԷµǸ�
//    �߸� �Է��ߴٰ� �˷��ְ�  ��for��&if��?���ư��� ���� arr[i] = arr[0],[1],[2],[3] : ��, contains�޼ҵ���
//    �ߺ��� �ƴ� �л��� �Էµɶ����� �ٽ� �Է��� ����
// 2. �߸��� ������ �߸� �Է��ߴٰ� �˷��ְ�
//    �ùٸ� ������ ���ö����� �ٽ� �Է��� ����
public class StudentEx02 {
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
	
	private static void printArray() throws NumberFormatException, IOException {
		System.out.println("============================");
		System.out.println("��ȣ\t�̸�");
		System.out.println("============================");
		for(int i = 0; i < studentArray.length; i++) {
			System.out.printf("%d\t%s\n",(i+1),studentArray[i].getName());//toStrong���� ���� �ּҰ��� �ƴ� ��ü ������� ������ ��
																		  //1,2,3,4....�� ���,�̸��� studentArray[0],[1],[2],[3]...
		}
		
		System.out.print("�󼼺����� ��ȣ�� �Է����ּ���(0�� �ڷΰ���): ");
		int userChoice = Integer.parseInt(bufferedReader.readLine())-1; //-1,0,1,2,3.....:�迭�� �ε���
		//���� userChoice�� �ùٸ��� ������, �ٽ� �Է��� �ϵ��� ��Ų��.
		//userChoice�� �ùٸ��� ���� ���� ����� ���ΰ�?
		//userChoice�� -1�̸��̰ų� studentArray.length - 1 �ʰ��̸� (-1�� �迭�� �ε��������� ���ü� �ִ� ���� �ƴϸ� �ùٸ��� ����)
		while(userChoice < -1 || userChoice > studentArray.length - 1 ) {			                               
			System.out.println("�߸��� ��ȣ�Դϴ�.");
			System.out.print("�󼼺����� ��ȣ�� �Է����ּ���(0�� �ڷΰ���): ");
			userChoice = Integer.parseInt(bufferedReader.readLine())-1; 
		}
		if(userChoice == -1) {
			//�޽����� ���
			System.out.println("�޴��� ���ư��ϴ�."); //�� �޽��� �ܿ� �ƹ� ó������ main�޼ҵ�� ���ư�
		}else {
			//�󼼺��� �޼ҵ� ȣ��
			printOne(userChoice);
		}
	}
	
	private static void printOne(int index) throws NumberFormatException, IOException{ //�� �޼ҵ尡 ȣ��Ǵ� printArray�� ���� ()�ȿ� userChoice(�迭�� �ε���)�� ���־���
											 //userChoice�� �Ķ���ͷ�(index)�� �޾� ���
		System.out.printf("%s �л��� ����\n", studentArray[index].getName());
		System.out.printf("�й� : %d, �̸� : %s\n", studentArray[index].getId(),studentArray[index].getName());
		System.out.printf("���� : %03d��, ���� : %03d��, ���� : %03d��\n", 
				studentArray[index].getKorean(), studentArray[index].getEnglish(), studentArray[index].getMath());
		System.out.printf("���� : %03d��, ��� : %.2f��\n", 
				studentArray[index].calculateSum(), studentArray[index].calculateAverage());
		//����, ������ ���� �Է��� �޴´�
		System.out.println("===============================");
		System.out.println("1.���� 2.���� 3.�������");
		int userChoice = Integer.parseInt(bufferedReader.readLine());
		 if(userChoice == 1) {
	         //���� �޼ҵ� ȣ��
	         System.out.println("���� : ");
	         studentArray[index].setKorean(validateScore());
	         
	         System.out.println("���� : ");
	         studentArray[index].setEnglish(validateScore());
	         
	         System.out.println("���� : ");
	         studentArray[index].setMath(validateScore());
	         
	         printOne(index);
	         
	      }else if(userChoice == 2) {
	    	  //���� �޼ҵ� ȣ��
	          //�����ÿ��� ���� �����Ͻðڽ��ϱ�? y/n �������
	          //�ٽ� �� �޼ҵ�� ���ƿ´�.
	          System.out.print("���� �����Ͻðڽ��ϱ�? (y/n): ");
	          String agree = bufferedReader.readLine();
	          if(agree.equals("y")) {
	             //�����ϰ� �л���� ����� �̵�
	             studentArray = ArrayUtil.removeByIndex(studentArray, index);
	             printArray();
	          }else if(agree.equals("n")) {
	             printOne(index);
	          }
	       }else if(userChoice == 3) {
	          printArray();
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
		//�츮�� �̸��� ��ȣ�� �Է��ϰ� ����
		//���� �ش� �̸��� ��ȣ�� �ߺ��̸�
		//�ߺ��ΰ� �˷��ְ�
		//�ٽ� �̸��� ��ȣ�� �Է¹ް� �Ѵ�(�̸��� ������ �������)
		//�� �����ƿ�� contains�� ������� true�� ���ȿ���
		//��� �Է��� ������ �Ǵ� ���̴�!
		while(ArrayUtil.contains(studentArray, s)) { //�ܺο��� ���� �޼ҵ带 ����߱⶧���� Ŭ������.�޼ҵ�()�� ���
			//�ߺ��� �̸��� ��ȣ�̹Ƿ� �ٽ� �Է��� �޴´�.
			System.out.println("�ߺ��� �л��Դϴ�.");
			System.out.println("�ٽ� �Է����ּ���");
			System.out.print("�л� �̸�: ");
			s.setName(bufferedReader.readLine());
			
			System.out.print("�л� ��ȣ: ");
			s.setId(Integer.parseInt(bufferedReader.readLine()));
		}
		System.out.print("���� ����: ");
		s.setKorean(validateScore());
		
		System.out.print("���� ����: ");
		s.setEnglish(validateScore());
		
		System.out.print("���� ����: ");
		s.setMath(validateScore());
		
		return s;//������ �Էµ� ��ü�� ��ȯ
	}
	
	private static int validateScore() throws NumberFormatException, IOException {
		int score = Integer.parseInt(bufferedReader.readLine());
		
		while(score < 0 || score > 100) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			System.out.print("�ٽ� �Է����ּ���: ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		
		return score;
	}
}
