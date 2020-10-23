package inheritance;

public class ChildTest extends SuperTest {
	protected String name; //�ڱⲨ
	protected int age;     //�ڱⲨ
	
	public ChildTest() {
		System.out.println("Child �⺻ ������");
	}
	
	public ChildTest(double weight, double height, String name, int age) {
		super(weight, height); //�θ������ ȣ��(�Ʒ� �ߺ� �ڵ带 ���ֱ� ���� super()�޼ҵ� ���
		//�ݵ�� ù°�ٿ��� ȣ�� �ƴϸ� error : Constructor call must be the first statement in a constructor
//		this.weight = weight; �θ�, ���� �ڽ�Ŭ������ ���� �ʵ尡 �����Ǹ�, this�� �ڽ�Ŭ������ �ʵ带 ����Ŵ
//		this.height = height; �θ�
//		super.weight = weight; //�θ𲨶� �ߺ�, ��� ����� ǥ�⸸ �ٸ�. super�� �����(Ŭ������ �������)
//		super.height = height; //�θ𲨶� �ߺ�
		System.out.println("Child ������");
		this.name = name;
		this.age = age;
	}
	
	public void disp() { //�������̵�
		System.out.println("ChildTestŬ������ disp()");
		System.out.println("������ = " + weight);//super���� �������� �ʾƵ� �θ�Ŭ������ �����ϱ� ������ �����۵�
		System.out.println("Ű = " + height);
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
	}
	
	public static void main(String[] args) {
		ChildTest aa = new ChildTest(75.3, 185.5, "ȫ�浿", 25);
		aa.disp(); //�ڽ�Ŭ������ ChildTest���� ���� ã��
		System.out.println();
		
		//�ڽ�Ŭ������ �θ�Ŭ������ ������ �̸��� �޼ҵ�(disp())�� �ִ� ���, 
		//�θ�Ŭ������ �޼ҵ�� �ڽ�Ŭ�������� ȣ���� �� ����.
		//static �ȿ����� this, super ����� �� ����
		
		System.out.println("-----------------------");
		SuperTest bb = new ChildTest(35.8, 156.3, "�ڳ�", 13);
		bb.disp();
	}
}
