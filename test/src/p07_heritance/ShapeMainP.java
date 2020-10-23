package p07_heritance;


class ShapeTest{
		
		//�ʵ� ����
		protected double area;
		
		//������
		public ShapeTest() {
			System.out.println("ShapeMainP �⺻ ������");
		}
		
		
		//�޼ҵ�
		public void calcArea() {
			System.out.println("������ ������ ����մϴ�.");
		}
		
		public void dispArea() {
			System.out.println("������ ���̸� ����մϴ�.");
		}
}


class SamTest extends ShapeTest{//���(�ʵ�� �޼ҵ� ��밡��)
	//�ڽ�Ŭ������ �ʵ�
	protected int base, height;
	
	//�ڽ�Ŭ������ ������
	public SamTest(int base, int height) {
		System.out.println("SamTest ������");
		this.base = base; //�Ű�����(�Ķ����)�� ���� base�� ���� �ڽ�Ŭ���� �ʵ� base�� �Ѱ���
		this.height = height; //�Ű�����(�Ķ����)�� ���� height�� ���� �ڽ�Ŭ���� �ʵ� height�� �Ѱ���
	}
	
	//�ڽ�Ŭ������ �޼ҵ�(�������̵�� �����δ� �ڽ�Ŭ������ �޼ҵ�ۿ� �ҷ��ü� ����)
	@Override 
	//������̼� - �������̵� ���� ���� �����ڵ�
	//������̼��� ������ �������̵尡 ���� �ʾƵ� �ƿ� �ٸ� �޼ҵ�� �ν��Ͽ� ������ ������� ����
	public void calcArea() {
		
		area = base * height / 2.0; //�θ��ʵ忡 �� ��ȯ
	}
	
	
	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " + area); //�θ� �ʵ� ȣ��
	}
}//SamTest


class SaTest extends ShapeTest{
	//�ڽ�Ŭ������ �ʵ�
	private int width, height;
	
	//�ڽ�Ŭ������ ������
	public SaTest(int width, int height) {
		
		System.out.println("SaTest ������");
		this.width = width;
		this.height = height;
		
	}
	
	//�ڽ�Ŭ������ �޼ҵ�
	@Override
	public void calcArea() {
		
		area = width * height;
	}
	
	@Override
	public void dispArea() {
		
		System.out.println("�簢�� ���� = " + area);
		
	}
}//SaTest


class SadariTest extends ShapeTest{
	//�ڽ�Ŭ���� �ʵ�
	private int top, bottom, height;
	
	//�ڽ�Ŭ���� ������
	public SadariTest(int top, int bottom, int height) {
		System.out.println("SadariTest ������");
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}
	
	//�ڽ�Ŭ���� �޼ҵ�
	@Override
	public void calcArea() {
		area = (top + bottom) * height / 2.0;
	}
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " + area);
	}
	
}


public class ShapeMainP {
	public static void main(String[] args) {
		ShapeTest shape;
		shape = new SamTest(5,7);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SaTest(7,9);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SadariTest(2,3,5);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
