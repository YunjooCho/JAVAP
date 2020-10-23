package p07_heritance;


public class ChildTestP2 extends SuperTestP2{
	 protected String name;
	 protected int age;
	 
	 public ChildTestP2() {
		 System.out.println("ChildTestP2 �⺻ ������");
	 }
	 
	 public ChildTestP2(double weight, double height, String name, int age) {
		 super(weight, height); //�θ� ������ ȣ��, ���� ù°��
		 System.out.println("ChildTestP2 ������");
		 //super(weight, height); - error : Constructor call must be the first statement in a constructor
		 this.name = name;
		 this.age = age;
	 }
	 
	 public void disp() {//�������̵�
		 System.out.println("ChildTestP2Ŭ������ disp()");
		 System.out.println("������ = " + weight);//super���� �������� �ʾƵ� �θ�Ŭ������ �����ϱ� ������ �����۵�
		 System.out.println("Ű = " + height);
		 System.out.println("�̸� = " + name);
		 System.out.println("���� = " + age);
		 
	 }
	 
	 
	 public static void main(String[] args) {
			ChildTestP2 aa = new ChildTestP2(75.3, 185.5, "ȫ�浿", 25);
			aa.disp(); //�ڽ�Ŭ������ ChildTest���� ���� ã��
			System.out.println();
			
			//�ڽ�Ŭ������ �θ�Ŭ������ ������ �̸��� �޼ҵ�(disp())�� �ִ� ���, 
			//�θ�Ŭ������ �޼ҵ�� �ڽ�Ŭ�������� ȣ���� �� ����.
			//static �ȿ����� this, super ����� �� ����
			
			System.out.println("-----------------------");
			SuperTestP2 bb = new ChildTestP2(35.8, 156.3, "�ڳ�", 13);
			bb.disp();
		}
}
