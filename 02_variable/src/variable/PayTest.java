package variable;

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

public class PayTest {

	public static void main(String[] args) {
		char name = 'L'; //�������� | String name = "L"; ��ü
		int basePay = 2500000;
		double tax = basePay * 0.033;
		//int tax = (int)(basePay * 0.033);
		double salary = basePay - tax;
		//int salary = basePay - tax;
		
		
		System.out.println("[������]");
		System.out.println("**** " + name + "�� ���� ***");
		System.out.println("�⺻�� : " + basePay + "��");
		System.out.println("���� : " + (int)tax + "��");
		//System.out.println("���� : " + String.format("%.0f",tax) + "��");
		System.out.println("���� : " + (int)salary + "��");
		
		

	}

}
