package day0916;



public class CarT {
	//����1: Car Ŭ������ ���� �� Ŭ���� ��ü�� Ȱ���ϴ� ���α׷��� �ۼ��غ�����.
	//Car  Ŭ������ �ʵ�: ������ȣ, ���� ����, ����, ����, ����
	//�޼ҵ�: ���� ������ ������ ���ڰ� ����ϴ� �޼ҵ�
	//������ ���� �Ķ���Ͱ� �ִ� �����ڿ� �Ķ���Ͱ� ���� ������ 
	//ĸ��ȭ
	
	//�ʵ�
	private String number;
	private String type;
	private int year;
	private int price;
	private String color;
	
	//�޼ҵ�
	//���� ���� ��¸޼ҵ�
	public void printInfo() {
		
		System.out.printf("������ȣ : %s, �������� : %s\n", number, type);
		System.out.printf("���� : %d��, ����: %d��\n", year, price);
		System.out.printf("���� : %s\n", color);
		
	}
	
	//�Ķ���� ���� ������
	public CarT() {
		number = new String(); //null�� ����
		type = new String();
		year = 0;
		price = 0;
		color = new String();
	}
	
	//�Ķ���Ͱ� �ִ� ������
	public CarT(String number, String type, int year, int price, String color) {
		this.number = number; //this�� ��ü�� ����Ŵ(�ʵ�� �Ķ���� ����), ���⼭ �ʱ�ȭ
		this.type = type;
		this.year = year;
		this.price = price;
		this.color = color;
	}
	
	//�ʵ忡 ���� ĸ��ȭ
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setYear(int year) {
		this.year = year;
	}	
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	//equasls�� toString�� Ŭ�������� ������־���� 
	public boolean equals(Object obj) { //���� ��Ű���� Ex01Class.java���� 
										//java.lang.Object�� ��� �޾ұ� ������ ����� ���� �ذ�
		                                //�ٹ�ȣ ���� ���ﰢ�� : �������̵���
			//�Ķ���ͷ� �Ѿ�� ��ü�� �� equals�޼ҵ带 �����ϴ� ��ü�� ������ ���Ϸ���
			//1. obj�� �� CarT Ŭ������ ��ü���� Ȯ���Ѵ�
			//2. obj�� CarT Ŭ������ ��ü�� �´ٸ�
			//   �ʵ� �� ��� ������ ���ؼ� ���� ������ (���ϱ� ���� ����ȯ ��)
			//   return true ���ش�.
			
			//1. obj�� �ش� Ŭ������ü���� Ȯ���Ҷ�����
			//	 instanceof Ŭ�����̸� �̶� �ڵ�� Ȯ�� �����ϴ�
			//   instanceof : �ش� Ŭ������ ��ü���� �ƴ����� Ȯ���ϴ� ���๮
		if(obj instanceof CarT) { //obj�� ����ȯ�� �����ϴٸ�(�ش� Ŭ���� ��ü���!!!!!!!)obj�� ����ȯ ������
								  //���� : ��ü  + instanceof + Ŭ���� ->����ȯ & �ش� Ŭ������ ��ü���� �ƴ��� Ȯ��
								  //obj�� CarT Ŭ������ ��ü�̹Ƿ�(obj������ ���� ��� ��ü)
							      //obj�� ī�� ����ȯ ������ �� �ִ�.
							      //Object obj = new Object();���� �ʵ尡 ����
			CarT c = (CarT)obj;   //Object���� �ʵ尡 �����Ƿ� Ŭ������ CarT�� �ٲ���(����ȯ)
			                      //���� �θ�Ŭ�����̹Ƿ� �ڽ�Ŭ������ �°� �������̵�(number, type�� ������ �� �ְ� �������)
			if(number.equals(c.number)){
					//�Ѵ� CarT�� ��ü
					//�տ� number�� equals�� �����ϴ� ��ü(c2.equals(c3)�� �����غ��� -c2��ü�� number), 
					//c.number�� �Ķ���ͷ� �Ѿ�� obj�� c�� �ٲ� number 
				return true;
			}
		}
		return false;
		
	}
	public String toString() {
		return "���� ��ȣ: " + number +
				", ���� ���� : " + type +
				", ���� ���� : " + price + "��, " +
				", ���� ���� : " + year + "��, " + 
				", ���� ����  : " + color;
	}
}
