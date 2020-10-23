package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

// �л� ��Ͽ� �߰����� �޼ҵ带 �� ������
// 1. ���� �л���ȣ�� �̸��� ���� �л��� �Է� �Ǹ� 
//    �߸� �Է��ߴٰ� �˷��ְ� 
//    �ߺ��� �ƴ� �л��� �Էµɶ����� �ٽ� �Է��� ����
// 2. �߸��� ������ �߸� �Է��ߴٰ� �˷��ְ�
//    �ùٸ� ������ ���ö� ���� �ٽ� �Է��� ����
public class StudentEx02T {
   private static BufferedReader bufferedReader;
   private static Student[] studentArray;

   public static void main(String[] args) throws NumberFormatException, IOException {
      studentArray = new Student[0];
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      showMenu();

   }

   private static void showMenu() throws NumberFormatException, IOException {
      while (true) {
         System.out.println("��Ʈ ���� ���� ���α׷�");
         System.out.println("1. �Է� 2. ��� 3. ����");
         System.out.print("> ");
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         if (userChoice == 1) {
            //�Է� �޼ҵ� ����
            add();
         } else if (userChoice == 2) {
            //��� �޼ҵ� ����
            printArray();
         } else if (userChoice == 3) {
            System.out.println("������ּż� �����մϴ�.");
            break;
         } else {
            System.out.println("�߸� �Է��ϼ̽��ϴ�.");
         }
      }
   }
   
   private static void printArray() throws NumberFormatException, IOException {
      System.out.println("==============================");
      System.out.println("��ȣ\t�̸�");
      System.out.println("==============================");
      for(int i = 0; i < studentArray.length; i++) {
         System.out.printf("%d\t%s\n", (i+1), studentArray[i].getName());
      }
      System.out.println("�󼼺����� ��ȣ�� �����ּ���(0�� �ڷΰ���): ");
      int userChoice = Integer.parseInt(bufferedReader.readLine())-1;
      //���� userChoice�� �ùٸ��� ������, �ٽ� �Է��� �ϵ��� ��Ų��.
      //userchoice�� �ùٸ��� ���� ���� ����� ���ΰ�?
      //userChocie�� -1�̸��̰ų� studentArray.length - 1 �ʰ��̸�
      while(userChoice < -1 || userChoice > studentArray.length - 1) {//����ڴ� 0���� �迭ũ�⸸ŭ �Է������� ������ 
    	  															  //userChoice�� �ԷµǴ� ���� -1 ~ (Array.length-1)��
         System.out.println("�߸��� ��ȣ�Դϴ�.");
         System.out.print("�󼼺����� ��ȣ�� �����ּ���: ");
         userChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
      }
      if(userChoice == -1) {
         //�޽��� �� ���
         System.out.println("�޴��� ���ư��ϴ�.");
      }else {
         //�󼼺��� �޼ҵ� ȣ��
         printOne(userChoice);
      }
   }
   
   private static void printOne(int index) throws NumberFormatException, IOException {
      System.out.printf("%s�л��� ����\n", studentArray[index].getName());
      System.out.printf("�й�: %d �̸�: %s\n", studentArray[index].getId(), studentArray[index].getName());
      System.out.printf("����: %03d�� ����: %03d�� ����: %03d��\n", 
            studentArray[index].getKorean(), studentArray[index].getEnglish(), studentArray[index].getMath());
      System.out.printf("����: %03d�� ���: %.2f��\n", studentArray[index].calculateSum(), studentArray[index].calculateAverage());
      //����, ������ ���� �Է��� �޴´�.
      System.out.println("=====================================");
      System.out.println("1. ���� 2. ���� 3. �������");
      int userChoice = Integer.parseInt(bufferedReader.readLine());
      if(userChoice == 1) {
         //���� �޼ҵ� ȣ��
         System.out.print("����: ");
         studentArray[index].setKorean(validateScore());
         
         System.out.print("����: ");
         studentArray[index].setEnglish(validateScore());
         
         System.out.print("����: ");
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
   
   
   private static void add() throws NumberFormatException, IOException {
      studentArray = ArrayUtil.add(studentArray, setStudentInfo());
   }
   
   
   private static Student setStudentInfo() throws NumberFormatException, IOException {
      Student s = new Student();
      System.out.print("�л� �̸�: ");
      s.setName(bufferedReader.readLine());
      
      System.out.print("�л� ��ȣ: ");
      s.setId(Integer.parseInt(bufferedReader.readLine()));
      // �츮�� �̸��� ��ȣ�� �Է��ϰ� ����
      // ���� �ش� �̸��� ��ȣ�� �ߺ��̸�
      // �ߺ��ΰ� �˷��ְ�
      // �ٽ� �̸��� ��ȣ�� �Է¹ް� �Ѵ�.
      // �� �����ƿ�� contains�� ������� true�� ���ȿ���
      // ��� �Է��� ������ �Ǵ� ���̴�!
      while(ArrayUtil.contains(studentArray, s)) {
         //�ߺ��� �̸��� ��ȣ�̹Ƿ� �ٽ� �Է��� �޴´�.
         System.out.println("�ߺ��� �л��Դϴ�.");
         System.out.println("�ٽ� �Է����ּ���: ");
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
      
      return s;
   }

   private static int validateScore() throws NumberFormatException, IOException {
      int score = Integer.parseInt(bufferedReader.readLine());
      
      while(score < 0 || score > 100) {
         System.out.println("�߸� �Է��ϼ̽��ϴ�.");
         System.out.print("�ٽ� �Է����ּ���: ");
         score= Integer.parseInt(bufferedReader.readLine());
      }
      
      return score;
   }
}







