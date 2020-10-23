package class_constructor;

public class ThisTest {
	private String name; //�⺻�� : 0
	private int age;//�⺻�� : null

	 public ThisTest() {
		 System.out.println("default ������");
		 System.out.println("this = " + this); //Ŭ������ �ּ�
		 System.out.println();
	 }
	
	 public ThisTest(String name) {
		 System.out.println("ThisTest(String name)");
		 System.out.println("this = " + this); //Ŭ������ �ּ�
		 this.name = name; // Ŭ������ name = �޼ҵ� �Ķ������ name;
		 System.out.println();
	 }
	 
	 public ThisTest(int age) {
		 this("�ڳ�"); //ThisTest(String name) �����ڸ� ȣ��, �� ���ٸ� ����
		 System.out.println("ThisTest(int age)");
		 System.out.println("this = " + this); //Ŭ������ �ּ�
		 this.age = age; // Ŭ������ name = �޼ҵ� �Ķ������ name;
		 System.out.println();
		 
	 }
	 
	public static void main(String[] args) {
		ThisTest aa = new ThisTest();//�ʵ带 ����ϱ� ���ؼ� �����ڰ� �ʿ�, �⺻ ������(������ �ۼ����ص� ����)
		System.out.println("��üaa = " + aa);
		System.out.println("�̸� = " + aa.name + "    ���� = " + aa.age);
		System.out.println();
		
		ThisTest bb = new ThisTest("ȫ�浿");
		System.out.println("��übb = " + bb);
		System.out.println("�̸� = " + bb.name + "    ���� = " + bb.age);
		System.out.println();
		
		ThisTest cc = new ThisTest(25);
		System.out.println("��ücc = " + cc);
		System.out.println("�̸� = " + cc.name + "    ���� = " + cc.age);
		System.out.println();
		
	}

}
