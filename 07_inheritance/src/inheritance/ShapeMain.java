package inheritance;

class ShapeTest{
	protected double area;
	public ShapeTest() {
		System.out.println("ShapeTest �⺻ ������");
	}
	
	public void calcArea() {
		System.out.println("������ ����մϴ�");
	}
	
	public void dispArea() {
		System.out.println("������ ����մϴ�");
	}
}

class SamTest extends ShapeTest{
	protected double base, height;
	
	public SamTest(double base, double height) {
		System.out.println("SamTest ������");
		this.base = base;
		this.height = height;
	}
	
	@Override//������̼� - �������̵� �ϰ��� �ϴ� �޼ҵ忡 �޼ҵ���� �޶� ������ ������� ����(�ٸ� �޼ҵ�� �ν�)
	//������ ������̼��� ���� �������̵尡 �ƴ��� üũ�Ͽ� ���� �ʾ����� ������ �����
	public void calcArea() {
		area = base * height / 2.0;
	}
	
	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " + area);//�θ�Ŭ���� �ʵ带 ������
	}
}



class SaTest extends ShapeTest{
	protected double width, height;
	
	public SaTest(double width, double height) {
		System.out.println("SaTest ������");
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void calcArea() {
		area = width * height;
	}
	
	@Override
	public void dispArea() {
		System.out.println("�簢�� ���� = " + area);
	}
	
}



class SadariTest extends ShapeTest{
	protected double top, bottom, height;
	
	public SadariTest(double top, double bottom, double height) {
		System.out.println("SadariTest ������");
		this.top = top;
		this.bottom = bottom;
		this.height =  height;
	}
	
	@Override
	public void calcArea() {
		area = (top + bottom) * height / 2;
	}
	
	@Override
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " + area);
	}
}


public class ShapeMain {
	public static void main(String[] args) {
		/*
		//Ŭ���� ����
		SamTest sam = new SamTest(5,7); 
		sam.calcArea();//�ڽ�Ŭ���� �޼ҵ尡 ���(�θ�� ���� ��¾ȵ�)
		sam.dispArea();//�ڽ�Ŭ���� �޼ҵ尡 ���(�θ�� ���� ��¾ȵ�)
		System.out.println();
		
		SaTest sa = new SaTest(7,9);
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadari = new SadariTest(2,3,5);
		sadari.calcArea();
		sadari.dispArea();
		System.out.println();
		*/
		
		//������ -> �θ� = �ڽ�, ���յ��� ����������
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
		
		//������ ��ü�� �������
	}
}
