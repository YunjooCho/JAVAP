package day0916;

import java.text.DecimalFormat;

public class CarEx01T {
	public static void main(String[] args) {
		//CarT ��ü�� ������ ������
		
		CarT c1 = new CarT();
		CarT c2 = new CarT();
		CarT c3 = new CarT();
		
		System.out.println("c1.getName().toUpperCase();" + c1.getNumber().toUpperCase());
		//c1, c2, c3�� ���͸� �̿��ؼ� ������ �Է��غ���
		c1.setNumber("00�� 0000");
		c1.setType("���");
		c1.setYear(2019);
		c1.setPrice(5000000);
		c1.setColor("������");
		
		c2.setNumber("11�� 1111");
		c2.setType("����");
		c2.setYear(2020);
		c2.setPrice(10000000);
		c2.setColor("����");
		
		c3.setNumber("22�� 2222");
		c3.setType("BMW");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("������");
		
		c1.printInfo(); //CarT.java�� ��� �޼ҵ�
		c2.printInfo(); //CarT.java�� ��� �޼ҵ�
		c3.printInfo(); //CarT.java�� ��� �޼ҵ�
		 
		DecimalFormat df = new DecimalFormat("#,###"); //���ڸ����� ,���
		System.out.println(df.format((long)c1.getPrice())); //long�� Ȥ�� double���� �����ϹǷ� long������ ��ȯ
		
		c3.setNumber("11�� 1111");//���� Ŭ���� 21~30�� �־��� ������ c2��ü�� ������ ������ ���
		c3.setType("����");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("����");
		
		c2.printInfo();
		c3.printInfo();//CarT.java�� ��� �޼ҵ�, c2.printInfo()�� c3.printInfo()�� ������ ��� ���
		//������ȣ : 11�� 1111, �������� : ����
		//���� : 2020��, ����: 10000000��
		//���� : ����
		
		
		//c2�� c3���� �Ȱ��� ������ �� �ִ�.
		//�׷��ٸ� c2.equals(c3)�� ��� �ɱ�?
		System.out.println("c2.equals(c3):" + c2.equals(c3));
		//false�� ������ ���� : �ش� �񱳴� ���� �ƴ� �ּҰ��� ���ϹǷ� false�� ���
		//CarT���� �������̵��Ͽ� true�� ��µǰ� ��
		
		System.out.println("c2.equals(abc): " + c2.equals("abc"));
		System.out.println("'abc'.equals('abc'): " + "abc".equals("abc"));
		
		System.out.println();
		System.out.println("c1> " + c1); //toString()���� �ʾ��� �� ���� : day0916.CarT@4554617c�� ��µ�
								         //��ü�� toString()(ObjectŬ������ �޼ҵ�)�� �����Ų ������� ����Ѵ�.
			                   	         //toString()�޼ҵ带 �����ʾƵ� ���������� ȣ����
	}
}
