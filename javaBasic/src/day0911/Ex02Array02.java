package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Ex01 ���׷��̵����
//������ �ƴ϶� 
//������ ������ �����ϴ�
//���ѷ��� ���α׷��� �ۼ��Ͻÿ�(20�б���)

//���� 1. ó�� �Է½ÿ��� for �ݺ����� ����ؼ� 5���� �̸��� ������ ������ �� �Է��Ѵ�.
//���� 2. �Է��Ŀ��� ���ѷ����� ���ؼ�
//    ���� ���� ���� �л��� �̸��� ����, ����, ��ո� ���� �ְ� �Ѵ�.
//����:
//���� ���� �л��� ��ȣ�� �Է��ϼ���: (1�Է�)
//1�� �趯�� �л�
//����: 80�� ����: 80�� ����: 81��
//����: 241�� ���: 80.33��
//���� ���� �л��� ��ȣ�� �Է��ϼ���: (20000 �Է�)
//�߸��Է��ϼ̽��ϴ�.
//���� ���� �л��� ��ȣ�� �Է��ϼ���: (2�Է�)
//2�� �ֵ��� �л�
//����: 70�� ����: 69�� ����: 68��
//����: 207�� ���: 69��
//���� ���� �л��� ������ �Է��ϼ���: (-1�Է�)
//������ּż� �����մϴ�.

//Ex01�� ���� �� ������ ������ �迭�� �����
//�迭 a[i] = 5; -> �ּҰ��ƴ�, �����ִ� ���� ȣ�� 


public class Ex02Array02 {
	
	final static int SIZE = 5;
	final static int NUMBER_OF_SUBJECT = 3; //�����
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		//�̸��� ����� �迭�� �ϳ� ������
	    String[] nameArray = new String[SIZE];
	    //������ ����� �迭
	    int[] korArray = new int[SIZE];
	    //������ ����� �迭
	    int[] engArray = new int[SIZE];
	    //������ ����� �迭
	    int[] mathArray = new int[SIZE];
	    
		for(int i = 0; i < nameArray.length; i++) { //i�� �迭�� �ּ�[0]~[4]
			System.out.print((i+1) + "�� �л��� �̸� : ");
			nameArray[i] = bufferedReader.readLine();
			System.out.print(nameArray[i] + "�л��� �������� : ");
			korArray[i] = Integer.parseInt(bufferedReader.readLine());
			while(korArray[i] < 0 || korArray[i] > 100) {
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	            System.out.print(nameArray[i]+" �л��� �������� : ");
	            korArray[i] = Integer.parseInt(bufferedReader.readLine());
			}
			System.out.print(nameArray[i] + "�л��� �������� : ");
	        engArray[i] = Integer.parseInt(bufferedReader.readLine());
			while(engArray[i] < 0 || engArray[i] > 100) {
		        System.out.println("�߸��Է��ϼ̽��ϴ�.");
		        System.out.print(nameArray[i]+" �л��� �������� : ");
		        engArray[i] = Integer.parseInt(bufferedReader.readLine());	            
	         }
			System.out.print(nameArray[i] + "�л��� �������� : ");
			mathArray[i] = Integer.parseInt(bufferedReader.readLine());
			while(mathArray[i] < 0 || mathArray[i] > 100) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.print(nameArray[i] + "�л��� �������� : ");
			}
		}//for
			
			
			//���� ������� �л��� ���� ���
			while(true) {
		         System.out.println("���� ���� �л��� ��ȣ�� �Է��ϼ���(1~5, -1�� ����): ");
		         System.out.print("> ");
		         
		         int userChoice = Integer.parseInt(bufferedReader.readLine());
		         if(userChoice == -1) {
		            //����ڰ� ���Ḧ �������� ��
		            System.out.println("������ּż� �����մϴ�.");
		            break;
		         }else if(userChoice >= 1 && userChoice <= 5) {
		            //�л� ��ȣ�� ��ȿ�Ҷ�
		            int index = userChoice - 1;
		            System.out.println((index+1) + "�� " + nameArray[index] + "�л�");
		            System.out.println("���� : " + korArray[index] +"�� ���� : " + engArray[index] +"��  ���� : " + mathArray[index] + "��");
		            
		            int tot = korArray[index] + engArray[index] + mathArray[index];
					double avg = tot / (double)NUMBER_OF_SUBJECT;
					System.out.println("����: "+ tot + "�� ��� : " + String.format("%.3f", avg));
					//System.out.println(nameArray[userChoice - 1]+" �л��� ����: "+sumArray[userChoice - 1]);�� ����
		         }else {
		            //�߸��Է����� ��
		            System.out.println("�߸��Է��ϼ̽��ϴ�.");
		         }
		      }//��� while��
		}
	}


