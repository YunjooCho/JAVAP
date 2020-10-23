package p07_heritance;

public class SubTestP extends SuperTestP{
	protected String name;
	protected int age;
	
	public SubTestP() {
		System.out.println("SubTestP �⺻ ������");
	}
	
	public SubTestP(double weight, double height, String name, int age) {
		System.out.println("SubTestP ������");
		super.weight = weight;
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void output() {
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
	}
	
	public static void main(String[] args) {
		SubTestP a = new SubTestP();
		System.out.println();
		
		SubTestP aa = new SubTestP(75.3, 185.6, "ȫ�浿", 25);
		aa.output();
		System.out.println();
		
		aa.disp();//�θ�Ŭ������ �޼ҵ带 ������
		
		SuperTestP bb = new SubTestP(35.8, 156.3, "�ڳ�", 13);
		bb.disp();//bb.outpu()�� ����Ҽ� ����
	}
}
