package nested;

public class Outer {//Outer.class ������(��ÿ� ����)
	private String name;
	
	public void output() {//OuterŬ����(�ܺ�Ŭ����)�� �޼ҵ�
		//Inner inner = new Inner();
		//System.out.println("�̸� = " + name + "\t ���� = " + in.age);
		//���� �� ���� �Ʒ��� ���� ��� ������
		//�ǹ����� setter/getter�� �ַ� ��� - ���� ���� ����� �� �𸣱� ������
		System.out.println("�̸� = " + this.name + "\t ���� = " + new Inner().age);
		
		//�ٻ�Ӱ� �ٸ���1
		//��øŬ������ ������� ������ getter�޼ҵ带 �ۼ��ؼ� �ҷ��;� ��(in.getAge())
		//��øŬ������ ����ϴ� ��� getter�޼ҵ带 ������� �ʾƵ� ���� ������ ����
		//(�ܺ�Ŭ�������� ����Ŭ������ ����Ϸ��� ��ü������ �ʿ��ϱ� ��) 
		//System.out.println("�̸� = " + name + "\t ���� = " + age);  : error - ����Ŭ������ ��� ��� �Ұ�
	}
	
	
	class Inner{//Outer$Inner.class ������(������)
		private int age;
		
		public void disp() {//InnerŬ����(��øŬ����)�� �޼ҵ�
			System.out.println("�̸� = " + Outer.this.name + "\t ���� = " + this.age); 
			//�ܺ�Ŭ������ ����� ������ ��(�����ڰ� �������� ��Ȯ�� ǥ�� - Outer.this.name)
		}
	}
	
	
	public static void main(String[] args) {
		Outer ou = new Outer(); //�ٻ�Ӱ� �ٸ���2 : ��ü ������ �ڱ�͸� ����
		ou.name = "ȫ�浿";
		ou.output();
		System.out.println();
		
		Outer.Inner in = ou.new Inner(); //Outer.Inner�� ��øŬ�������� ǥ��
										 //�޸� ������ ou�ȿ� �����϶�� ����
										 //�� ������ OuterŬ���� �ȿ��� �Ͼ�� ���̹Ƿ�
		                                 //Outer.Inner in���� Outer�κ��� ���������ϴ�
										 //����Ŭ������ �����Ϸ��� �ݵ�� �ܺ�Ŭ������ ������ �ʿ��ϴ�
		in.age = 25;
		in.disp();
		//ou.output(); - ���⼭ �� �޼ҵ带 �Է��� ���, 
		//11��° ���� new Inner().age �� ���� 36��° �� new Inner()(�� 25�� �ʱ�ȭ�Ǿ�����) �� �ٸ�
		//���ο� ����Ŭ���� ��ü�� �����ǹǷ� ���� ����ȵ�(�ѱ����� ��øŬ���� ����)
		
		//in.output(); - error
		//(���� Ŭ���� ���� �ȿ����� ����Ŭ������ �ܺ�Ŭ������ ����� ����� �� ������
		//main�޼ҵ� �ȿ����� in.output()�� ����� �� ����) - InnerŬ������ �����ϱ� ������ �ܺ�Ŭ������ ����� ������ ����
		
		System.out.println();
		Outer.Inner in2 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		System.out.println();
		
		Outer.Inner in3 = new Outer().new Inner(); 
		//new Inner() �� ������ error
		//��� ������ �� �ٸ� Outer��ü ����, �� �ȿ� �� �ٸ� Inner��ü ����
		in3.age = 35;
		in3.disp();
	}
}//class Outer
