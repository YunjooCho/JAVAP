package p03_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

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
public class Salary {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�̸� �Է� : ");
		String name = br.readLine();
		System.out.print("���� �Է� : ");
		String position = br.readLine();
		System.out.print("�⺻�� �Է� : ");
		int basePay = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		int extraPay = Integer.parseInt(br.readLine());
		
		int totalPay = basePay + extraPay;
		double taxRate = totalPay >= 4000000 ? 0.03 : 0.02;
		
		Salary sal = new Salary();
		double tax = sal.calcTax(totalPay, taxRate);
		double salary = sal.calcSalary(totalPay, tax);

		
		//���ڸ� 3�ڸ����� , ���
		DecimalFormat df = new DecimalFormat("#,###");
		
		//���
		System.out.println("\t*** " + name + " ���� ���� ***");
		System.out.println("���� : " + position);
		System.out.println("�⺻��\t     ����\t     �޿�\t      ����\t����\t����");
		System.out.println(df.format(basePay) + " " + df.format(extraPay) + " " + df.format(totalPay) + " " + String.format("%.0f", (taxRate*100)) + "% " + df.format((int)tax) + "  " + df.format((int)salary));
		

	}
	
	public double calcTax(int totalPay, double taxRate) {
		return totalPay * taxRate;
	}
	
	public double calcSalary(int totalPay, double tax) {
		return totalPay - tax;
	}

}
