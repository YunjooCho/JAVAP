package day0915;

import java.text.DecimalFormat;

public class Car {

	//����
	//1.�ʵ�(�������)����
	//Car Ŭ������ �ʵ�: ������ȣ, ���� ����, ����, ����, ����
	//5.private�� ����
	//6.����&���� �ۼ�
	private String carNumber;
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarNumber() {
		return carNumber;
	}
	
	
	private String carType;
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarType() {
		return carType;
	}
	
	
	private int carYear;
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getCarYear() {
		return carYear;
	}
	
	
	private int carPrice;
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public int getCarPrice() {
		return carPrice;
	}
	
	
	private String color;
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}

	//�޼ҵ�: ���� ������ ������ ���ڰ� ����ϴ� �޼ҵ�
	public void printCar(String carNumber, String carType, int carYear, int carPrice, String color) {
		DecimalFormat df = new DecimalFormat("#,###"); //�ڡڡڡڡڡڿ� �ȵ�?? df.format(myCar.carPrice)
		System.out.printf("������ȣ: %d, ���� ����: %s, ����: %d, ����: %d, ����: %s\n", carNumber, carType, carYear, carPrice, color);
		
	}
		
	
	//2.�Ķ���Ͱ� �ִ� ������
	public Car(String carNumber, String carType, int carYear, int carPrice, String color) {
		
		this.carNumber = carNumber;//���⼭����
		this.carType = carType;
		this.carYear = carYear;
		this.carPrice = carPrice;
		this.color = color;//������� ������
		
	}
	
	//3.�Ķ���Ͱ� ���� ������
	public Car() {
		
		carNumber = "��1011";
		carType = "SUV";
		carYear = 13;
		carPrice = 300000000;
		color = "�Ͼ��";
		printCar(carNumber, carType, carYear, carPrice, color);
	}
	
	
}
