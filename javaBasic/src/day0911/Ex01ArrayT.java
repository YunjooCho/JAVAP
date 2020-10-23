package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01ArrayT {

	final static int SIZE = 5;
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	      //�̸��� ����� �迭�� �ϳ� ������
	      String[] nameArray = new String[SIZE];
	      //������ ����� �迭�� �ϳ� ������
	      int[] sumArray = new int[SIZE];
	      
	      //���ʴ�� �Է��� �غ���
	      for(int i = 0; i < SIZE; i++) {
	         System.out.print((i+1)+"�� �л��� �̸�: ");
	         nameArray[i] = bufferedReader.readLine();
	         System.out.print(nameArray[i]+" �л��� ��������: ");
	         int korean = Integer.parseInt(bufferedReader.readLine());
	         while(korean < 0 || korean > 100) {
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	            System.out.print(nameArray[i]+" �л��� ��������: ");
	            korean = Integer.parseInt(bufferedReader.readLine());
	         }
	         System.out.print(nameArray[i]+" �л��� ��������: ");
	         int english = Integer.parseInt(bufferedReader.readLine());
	         while(english < 0 || english > 100) {
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	            System.out.print(nameArray[i]+" �л��� ��������: ");
	            english = Integer.parseInt(bufferedReader.readLine());
	         }
	         
	         System.out.print(nameArray[i]+" �л��� ��������: ");
	         int math = Integer.parseInt(bufferedReader.readLine());
	         while(math < 0 || math > 100) {
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	            System.out.print(nameArray[i]+" �л��� ��������: ");
	            math = Integer.parseInt(bufferedReader.readLine());
	         }
	         
	         sumArray[i] = korean+english+math;
	      }
	      //���� ���� �л��� ��ȣ�� �Է��ϸ� �� �л��� ������ ����ϰ� ������
	      System.out.print("���� ���� �л��� ��ȣ�� �Է��ϼ���(1~5): ");
	      int userChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
	      
	      System.out.println(nameArray[userChoice]+" �л��� ����: "+sumArray[userChoice]);
	      
	      //20�е��� �����е��� ����ϴ� �κ��� 
	      //���ѷ����� ����ð�
	      //���� ����ڰ� ���� ���� �л��� ��ȣ�� �Է��� �� - 1�� �Է��ϸ� ���α׷��� ����
	      //Ȥ�� ����ڰ� �߸��� ��ȣ�� �Է��ϸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���~��� �Է��ϰ� ���α׷��� �����غ�����.
	      //����
	      //������� �л�: 3
	      //3�� �л��� ����: 218��
	      //������� �л�: 4
	      //4�� �л��� ����: 299��
	      //������� �л�: 99
	      //�߸��Է��ϼ̽��ϴ�.
	      //������� �л�: -1
	      //������ּż� �����մϴ�.
	      
	      while(true) {
	         System.out.println("���� ���� �л��� ��ȣ�� �Է��ϼ���(1~5, -1�� ����): ");
	         System.out.print("> ");
	         userChoice = Integer.parseInt(bufferedReader.readLine());
	         if(userChoice == -1) {
	            //����ڰ� ���Ḧ �������� ��
	            System.out.println("������ּż� �����մϴ�.");
	            break;
	         }else if(userChoice >= 1 && userChoice <= 5) {
	            //�л� ��ȣ�� ��ȿ�Ҷ�
	            int index = userChoice - 1;
	            System.out.println(nameArray[index]+" �л��� ����: "+sumArray[index]);
	            //System.out.println(nameArray[userChoice - 1]+" �л��� ����: "+sumArray[userChoice - 1]);�� ����
	         }else {
	            //�߸��Է����� ��
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	         }
	      }


	}

}
