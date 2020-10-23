package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04MultiArray03 {

	//�ִ� �л� �� üũ�� ���
	   final static int STUDENT_SIZE = 10;
	   //���� �� ����
	   final static int CLASS_NUMBER = 4;
	   
	   public static void main(String[] args) throws NumberFormatException, IOException {
	      // �Է��� ������ ����� BufferedReader ���� (= ��ü) ����
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	      // ������ ������ int[][][] scoreArray ����
	      //3���� : int[][][] scoreArray = new int[CLASS_NUMBER][][];
	      
	      //2����
	      int[][] koreanArray = new int[CLASS_NUMBER][];
	      int[][] englishArray = new int[CLASS_NUMBER][];
	      int[][] mathArray = new int[CLASS_NUMBER][];
	      
	      while(true) {
	         //�޴� �޼ҵ� ȣ��
	         showMenu();
	         int choice = Integer.parseInt(bufferedReader.readLine());
	         if(choice == 1) {
	            //������ �Է��ϱ�
	            
	            //1. ���� �����Ѵ�.
	            int classNumber = selectClassNumber(bufferedReader);
	            //2. �л� �Ը� �����Ѵ�.
	            int studentSize = selectStudentSize(bufferedReader);
	            //3. for���� �̿��ؼ� �л��� ������ ���ʴ�� �־��ش�.
	            //3���� : scoreArray[classNumber] = new int[studentSize][3];
	            
	            koreanArray[classNumber] = new int[studentSize];
	            englishArray[classNumber] = new int[studentSize];
	            mathArray[classNumber] = new int[studentSize];
	            
	            for(int i = 0; i < koreanArray[classNumber].length; i++) {
	               System.out.println((i+1)+"�� �л��� ���� �Է�");
	               //3����
//	               scoreArray[classNumber][i][0] = validateScore(bufferedReader, 1);
//	               scoreArray[classNumber][i][1] = validateScore(bufferedReader, 2);
//	               scoreArray[classNumber][i][2] = validateScore(bufferedReader, 3);
	               
	               koreanArray[classNumber][i] = validateScore(bufferedReader,1);
	               englishArray[classNumber][i] = validateScore(bufferedReader,2);
	               mathArray[classNumber][i] = validateScore(bufferedReader,3);
	            }
	            
	         }else if(choice == 2) {
	            //������ ����ϱ�
	            //1. ���� �Է¹޴´�.
	            int classNumber = selectClassNumber(bufferedReader);
	            
	            //2. �ش� ���� �ʱ�ȭ�Ǿ����� üũ�Ѵ�.
	            if(koreanArray[classNumber] == null) {
	               //���� �ʱ�ȭ �ȵ������Ƿ� ��� �޽��� ���
	               System.out.println("���� �Է��� ���� ���� ���Դϴ�.");
	            }else {
	            //3. �ʱ�ȭ �Ǿ������� ����Ѵ�.
	               for(int i = 0; i < koreanArray[classNumber].length; i++) {
	                  System.out.println("=======================");
	                  System.out.println((i+1)+"�� �л��� ����");
	                  System.out.printf("����:%3d�� ����:%3d�� ����:%3d��\n", 
	                        koreanArray[classNumber][i], englishArray[classNumber][i], mathArray[classNumber][i]);
	               }
	            }
	         }else if(choice == 3) {
	            System.out.println("������ּż� �����մϴ�.");
	            break;
	         }else {
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	         }
	      }
	   }
	   static void showMenu() {
	      System.out.println("======================");
	      System.out.println("��Ʈ����б� �������� ���α׷�");
	      System.out.println("======================");
	      System.out.println("|\t1. �Է�\t|");
	      System.out.println("|\t2. ���\t|");
	      System.out.println("|\t3. ����\t|");
	   }
	   static int selectClassNumber(BufferedReader reader) throws NumberFormatException, IOException {
	      System.out.println("���� �������ּ���");
	      System.out.print("> ");
	      int classNumber = Integer.parseInt(reader.readLine());
	      while(classNumber < 1 || classNumber > CLASS_NUMBER) {
	         System.out.println("�߸��Է��ϼ̽��ϴ�.");
	         System.out.println("���� �������ּ���");
	         System.out.print("> ");
	         classNumber = Integer.parseInt(reader.readLine());
	      }
	      
	      return classNumber - 1;
	   }
	   static int selectStudentSize(BufferedReader reader) throws NumberFormatException, IOException {
	      System.out.println("�л� ���ڸ� �������ּ���");
	      System.out.print("> ");
	      int studentSize = Integer.parseInt(reader.readLine());
	      
	      while(studentSize < 0 || studentSize > STUDENT_SIZE) {
	         System.out.println("�߸��Է��ϼ̽��ϴ�.");
	         System.out.println("�л� ���ڸ� �������ּ���");
	         System.out.print("> ");
	         studentSize = Integer.parseInt(reader.readLine());
	      }
	      
	      return studentSize;
	   }
	   static int validateScore(BufferedReader reader, int code) throws NumberFormatException, IOException {
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
	      message += " ������ �Է����ּ���.";
	      System.out.println(message);
	      System.out.print("> ");
	      int score = Integer.parseInt(reader.readLine());
	      while(score < 0 || score > 100) {
	         System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	         System.out.println(message);
	         System.out.print("> ");
	         score = Integer.parseInt(reader.readLine());
	      }
	      
	      return score;
	   }

}
