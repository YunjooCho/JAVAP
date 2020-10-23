package inheritance;

public class SubTest extends SuperTest{
	protected String name; //�ڱⲨ
	protected int age;     //�ڱⲨ
	//���� �ڱⲨ 2��  + �θ� 2��(weight, height)�� �� 4���� �ʵ� ���
	//�ڽ�Ŭ������ ���������ڰ� �����̵� ��������� �⺻ ĸ��ȭ�� ����, private �ƴϸ�  
	//����� ���� ��� protected ���
	
	
	public SubTest() {
		System.out.println("SubTest �⺻ ������");
	}
	
	public SubTest(double weight, double height, String name, int age) {
		System.out.println("SubTest ������");
//		this.weight = weight; �θ�, ���� �ڽ�Ŭ������ ���� �ʵ尡 �����Ǹ�, this�� �ڽ�Ŭ������ �ʵ带 ����Ŵ
//		this.height = height; �θ�
		super.weight = weight; //�θ�, ��� ����� ǥ�⸸ �ٸ�. super�� �����(Ŭ������ �������)
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void outPut() {
		System.out.println("������ = " + weight);//super���� �������� �ʾƵ� �θ�Ŭ������ �����ϱ� ������ �����۵�
		System.out.println("Ű = " + height);//super���� �������� �ʾƵ� �θ�Ŭ������ �����ϱ� ������ �����۵�
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
	}
	
	
	public static void main(String[] args) {
		SubTest a = new SubTest(); 
		//�θ� �⺻ �����ڿ� �ڱ��ڽ��� �⺻ ������ �Ѵ� ȣ��
		System.out.println();
		
		SubTest aa = new SubTest(75.3, 185.5, "ȫ�浿", 25); 
		//�θ� �⺻ �����ڿ� �ڱ��ڽ��� �Ķ���� �ִ� ������ �Ѵ� ȣ��
		aa.outPut();//outPut()�� SubTest���� ã�´�. ������ �θ�Ŭ������ ���� ã�´�.
		System.out.println();
		
		
		aa.disp();//�θ�Ŭ���� �޼ҵ�. disp()�� SubTest���� ã�´�. ������ �θ�Ŭ������ ���� ã�´�.
		System.out.println("-----------------------");
		
		SuperTest bb = new SubTest(35.8, 156.3, "�ڳ�", 13);
		//bb.outPut(); -error : �ڽ�Ŭ���� �޼ҵ�� �θ�Ŭ�������� ȣ���� �� ����
		bb.disp();
	}
}

//�ڽ�Ŭ������ �θ� �����ڸ� �����ؼ� ȣ���� �� �ִ�.
//�ƹ� ���� ������ �θ��� �⺻ �����ڸ� ȣ���Ѵ�.
