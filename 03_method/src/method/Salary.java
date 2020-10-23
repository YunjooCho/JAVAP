package method;

/*
���� ��� ���α׷�
�̸�, ����, �⺻��, ������ �Է��Ͽ� ���ݰ� ������ ����Ͻÿ�
������ �޿��� 4,000,000 ���� �̻��̸� 3% �ƴϸ� 2%�� �Ѵ�

���� �� ������ �� Ǯ���ٸ�
������ calcTax()
������ calcSalary()�� �̿��ؼ� ����Ͻÿ�

�޿� = �⺻�� + ����
���� = �޿� * ����
���� = �޿� - ����

[������]
�̸� �Է� : ȫ�浿
���� �Է� : ����
�⺻�� �Է� : 4500000
���� �Է� : 200000

   *** ȫ�浿 ���� ���� ***
���� : ����
�⺻��                    ����    		  �޿� 	   ����      ����            ����
4500000      200000     4700000   3%   xxxxx   xxxxxxx

���� 8��
���� ������
�� Ǯ�� ���� �޼ҵ� ���
yeoni5@naver.com ���� java ���� �����帮�� (�Ͽ��� 17:00����)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;



public class Salary {

	public static void main(String[] args) throws IOException {
		
		//�޸� ����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		//�Է�
		System.out.println("[������]");
		System.out.println("�̸��Է� : ");
		String name = bf.readLine();
		System.out.println("���� �Է� : ");
		String rank = bf.readLine();
		System.out.println("�⺻�� �Է� : ");
		int basePay = Integer.parseInt(bf.readLine());
		System.out.println("���� �Է� : ");
		int extraPay = Integer.parseInt(bf.readLine());
		
		//���
		int wage = basePay + extraPay;	//wage���� totalPay��� ǥ���� ����			
		double taxRate = wage >= 4000000 ? 0.03 : 0.02;
		//double tax = wage * taxRate; //int tax = (int)(totalPay * taxRate);
		//double Salary  = wage - tax;
		
		//����&���� �޼ҵ�
		Salary salarymethod = new Salary();
		double tax = salarymethod.calcTax(wage, taxRate);
		double salary = salarymethod.calcSalary(wage, tax);
		
		//���ڸ� 3�ڸ����� , ���
		DecimalFormat df = new DecimalFormat("#,###");
	    		
		//���
		System.out.println("\t*** " + name + " ���� ���� ***");
		System.out.println("���� : " + rank);
		System.out.println("�⺻��\t     ����\t     �޿�\t      ����\t����\t����");
		System.out.println(df.format(basePay) + " " + df.format(extraPay) + " " + df.format(wage) + " " + String.format("%.0f", (taxRate*100)) + "% " + df.format((int)tax) + "  " + df.format((int)salary));
	
	}

	public double calcTax(int wage, double taxRate) {
		return wage * taxRate;
	}
	public double calcSalary(int wage, double tax) { 
		return wage - tax;
	}
	
}
