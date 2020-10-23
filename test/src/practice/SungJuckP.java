package practice;



/*
�̸�(name),����(kor),����(eng),����(math)������ �Է¹޾Ƽ� 
����(tot),���(avg), ����(grade)�� ���Ͻÿ�

����� 90�̻��̸� 'A'����
����� 80�̻��̸� 'B'����
����� 70�̻��̸� 'C'����
����� 60�̻��̸� 'D'����
�׿ܴ� 'F'����


[������]
�̸� �Է� : ȫ�浿 
���� �Է� : 78  
���� �Է� : 89  
���� �Է� : 100

   *** ȫ�浿 ���� ***
����      ����      ����      ����      ���      ����
78     89   100    xxx   xx.xxx   x
 */
//������ switch�� ���

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuckP {

	public static void main(String[] args) throws IOException {
		//�޸� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Ű���� �Է�
		System.out.println("�̸� �Է� : ");
		String name = br.readLine();
		System.out.println("���� �Է� : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("���� �Է� : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("���� �Է� : ");
		int math = Integer.parseInt(br.readLine());
		
		
		//����
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		
		//����
		char grade;
		switch ((int)avg / 10){
		
			case 10 :
			case 9 : grade = 'A';
					 break;
			case 8 : grade = 'B';
					 break;
			case 7 : grade = 'C';
				     break;
			case 6 : grade = 'D';
					 break;
			default : grade = 'F';
			
		}
		
		//���
		System.out.println("*** " + name + " ����ǥ ***");
		System.out.println("����\t����\t����\t����\t���\t����");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg) + "\t" + grade);

	}

}
