package if_switch;
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

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SungJuk {

	public static void main(String[] args) throws IOException {
		//�޸� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�Է�
		System.out.println("�̸� �Է� :");
		String name = br.readLine();
		System.out.println("���� �Է� :");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("���� �Է� :");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("���� �Է� :");
		int math = Integer.parseInt(br.readLine());
		char grade;
		
		//���
		int tot = kor + eng + math;
		double avg = (double)tot / 3;
		
		
//		//if��
//		if (avg >= 90) {
//			grade = 'A';
//		}else if (avg >= 80) {
//			grade = 'B';
//		}else if (avg >= 70) {
//			grade = 'C';
//		}else if (avg >= 60) {
//			grade = 'D';
//		}else {
//			grade = 'F';
//		}
		
		
		//switch��
		switch((int)avg / 10) {
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
		System.out.println("\t *** " + name + " ����ǥ ***");
		System.out.println("����\t����\t����\t����\t���\t����");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg) + "\t" + grade);
		
	}

}
