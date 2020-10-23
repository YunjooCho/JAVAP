package class_constructor;

import java.text.DecimalFormat;

/*
�������� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�
��ü �迭�� �ۼ��Ͻÿ�

Ŭ������ : SalaryDTO
�ʵ�       : name, position, basePay, benefit, taxRate, tax, salary
������    : �����͸� �Է�
calc() - ���
getName()
getPosition()

���� = (�⺻�� + ����) * ����;
���� = �⺻�� + ���� - ����;

������ 200���� ���� : 1%(0.01), 
     400���� ���� : 2%(0.02), 
     400���� �ʰ� : 3%(0.03)���� �����Ѵ�.

[������]
�̸�      ����      �⺻��               ����      ����      ����      ����
ȫ�浿   ����      5000000      200000
���缮   ����      3500000      150000
�ڸ��   ���      1800000      100000
 */
public class SalaryMain {
	public static void main(String[] args) {
		//��ü�迭 ����
		SalaryDTO[] ar = new SalaryDTO[]{new SalaryDTO("ȫ�浿", "����", 5000000, 200000),
									 	 new SalaryDTO("���缮", "����", 3500000, 150000),
									 	 new SalaryDTO("�ڸ��", "���", 1800000, 100000)}; 
		
		//�޼ҵ� ȣ�� - ��� �޼ҵ�
		//main()�޼ҵ忡�� ����Ͻÿ�
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("�̸�\t����\t�⺻��\t\t����\t\t����\t����\t\t����");
		System.out.println("-----------------------------------------------------------------------------------");
		for(SalaryDTO dto : ar) { //for(int i = 0; i < ar.length; i++)
			dto.calc(); //ar[i].calc()
//			System.out.println(ar[i].getName() + "\t" 
//						      +ar[i].getPosition() + "\t"
//						      +df.format(ar[i].getBasePay()) + "��\t" 
//						      +df.format(ar[i].getBenefit()) + "��\t"
//						      +(int)(ar[i].getTaxRate()*100) + "%\t "
//						      +df.format(ar[i].getTax()) + "��\t" 
//						      +df.format(ar[i].getSalary()) + "��");
			System.out.println(dto); //SalaryDTO.java���� toString�������̵��� �߱� ������
							 		 //��ü�� ����ϴ� �� �����ε� ���� ���� ������ ��°���
		}

	}

}
