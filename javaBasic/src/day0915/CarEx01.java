package day0915;
//����1: Car Ŭ������ ���� �� Ŭ���� ��ü�� Ȱ���ϴ� ���α׷��� �ۼ��غ�����.
//Car  Ŭ������ �ʵ�: ������ȣ, ���� ����, ����, ����, ���� (o)
//�޼ҵ�: ���� ������ ������ ���ڰ� ����ϴ� �޼ҵ� (o)
//������ ���� �Ķ���Ͱ� �ִ� �����ڿ� �Ķ���Ͱ� ���� ������ (o)
//ĸ��ȭ(o)

//����2: Student�� ������ �ʵ忡 ���ؼ� ���� ���͸� �����Ͻð� (o)
//StudentEx.java�� �˸°� ��ġ�ÿ�(o)

import java.text.DecimalFormat;

public class CarEx01 {

	
	public static void main(String[] args) {
		//��ü ����
		DecimalFormat df = new DecimalFormat("#,###"); //�ڡڡڡڡڡڿ� �ȵ�?? df.format(myCar.carPrice)
		
		//7. �ʵ� ĸ��ȭ �� ����
		
		System.out.println("�ߡߡߡߡߡߡ߳� �������ߡߡߡߡߡߡߡߡ�");
		System.out.println("�Ķ���Ͱ� ���� ������ ���");
		Car myCar = new Car();
		System.out.println();
		
		
		Car friendCar = new Car("��1212", "����", 10, 20000000,"����");
		System.out.println("�ߡߡߡߡߡߡ�ģ�� �������ߡߡߡߡߡߡߡߡ�");
		System.out.println("�Ķ���Ͱ� �ִ� ������ ���");
		friendCar.setCarNumber("��1212");
		friendCar.setCarType("����");
		friendCar.setCarYear(10);
		friendCar.setCarPrice(20000000);
		friendCar.setColor("����");
		System.out.printf("������ȣ: %d, ���� ����: %s, ����: %d, ����: %d, ����: %s", friendCar.getCarNumber(), friendCar.getCarType(), friendCar.getCarYear(), friendCar.getCarPrice(), friendCar.getColor());
		System.out.println();
		
		
//4. ĸ��ȭ ���� ���		
//		Car myCar = new Car();
//		System.out.println("�ߡߡߡߡߡߡ߳� �������ߡߡߡߡߡߡߡߡ�");
//		System.out.println("�Ķ���Ͱ� ���� ������ ���");
//		System.out.printf("������ȣ: %d, ���� ����: %s, ����: %d, ����: %d, ����: %s", myCar.carNumber, myCar.carType, myCar.carYear, myCar.carPrice, myCar.color);
//		System.out.println();
//		
//		
//		Car friendCar = new Car();
//		System.out.println("�ߡߡߡߡߡߡ�ģ�� �������ߡߡߡߡߡߡߡߡ�");
//		System.out.println("�Ķ���Ͱ� �ִ� ������ ���");
//		friendCar.carNumber = 1212;
//		friendCar.carType = "����";
//		friendCar.carYear = 10;
//		friendCar.carPrice = 20000000;
//		friendCar.color = "����";
//		System.out.printf("������ȣ: %d, ���� ����: %s, ����: %d, ����: %d, ����: %s", friendCar.carNumber, friendCar.carType, friendCar.carYear, friendCar.carPrice, friendCar.color);
//		System.out.println();
		
	}

}
