package p02_variable;
/*
�̸��� L(name)�� ����� �⺻��(basePay)�� 2500000�� ��
3.3% ����(tax, 0.033)�� ����(salary)�� ����Ͻÿ�

���� = �⺻�� * 3.3%(0.033)
���� = �⺻�� - ����

<��³���>
[������]
*** L�� ���� ***
�⺻�� : 2500000��
���� : 82500��
���� : 2417500�� 

���� : 4�� 
���� ����X
������ �� �ѻ�� �� �� ����� ���� ���� ���
�Ҽ����� ǥ��X, ������(�׳� �߶� �ǰ�, �ݿø��� ����)
*/

public class PayTestP {
	public static void main(String[] args) {
		String name = "L";
		int basePay = 2500000;
		double tax = basePay * 0.033;
		int salary = basePay - (int)tax;
		
		System.out.println("*** " + name + "�� ���� ***");
		System.out.println("�⺻�� : " + basePay + "��");
		System.out.println("���� : " + (int)tax + "��");
		System.out.println("���� : " + salary + "��");
		

	}

}
