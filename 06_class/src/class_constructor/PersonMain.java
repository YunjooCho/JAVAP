package class_constructor;

class PersonTest{//�̰͸� ������ ��¥(�����⸸ ����)
	//�Ӽ�(�ʵ�) - �̸�, ����, Ű, ������
	//���,����,����(�޼ҵ�) - �ȴ´�, �ڴ�, �Դ´�
	
	//�ʵ�
	private String name;
	private int age;
	
	public PersonTest() { 
		//void���� �ȵ�!!!, void���� ������ ����� ��Ż�ϰ� �Ϲ� �޼ҵ尡 ��
		//()�ȿ� �μ�
		System.out.println("default ������");
		
	}//�̰� ��� �ڵ����� �⺻�����ڰ� �������
	
	public PersonTest(String n, int a) {
		name = n;
		age = a;
	}
	
	
	public void setName(String n) {//�����ڿ� ���°� ����, ���ҵ� ����. 
								   //�����ڴ� �ѹ��ۿ� ���������� setter�� ������ ��밡��
		name = n;
		
	}
	
	public void setDate(String n, int a) {//����
		name = n;
		age = a;
		
	}
	
	public void setDate() {//����
		
	}
	
	
	public PersonTest(String n) {
		name = n;
	}
	
	public String getName(){ //Name�빮�ڷ� ���°� ���
		return name;
	}
	
	public int getAge() {
		return age;
	}
}


public class PersonMain {//�̰͸� ������ ��¥(�����⸸ ����)
	public static void main(String[] args) {
		//static�� �־ new�� �ʿ����
		//���α׷��� ������
		
		System.out.println("A\tB\tC\tD\tF\tG");
		PersonTest aa;//Ŭ������ ����� ��ü(������� �� �θ�)
//		aa = new PersonTest("ȫ�浿"); //���� �ִ� ����Ʈ �����ڰ� ȣ���
		aa = new PersonTest("ȫ�浿", 25);
		//�����Ⱚ -> Ŭ������ �޸𸮿� ����
		//new PersonTest + (); - ���� + ������, �̸������Ƿ� �ּҰ��� ��
		System.out.println("��ü aa = " + aa);
//		aa.age = 25;
		System.out.println("�̸� =" + aa.getName() + "\t���� =" + aa.getAge());
		System.out.println();
		
		PersonTest bb = new PersonTest(); //���� �ִ� ����Ʈ �����ڰ� ȣ���
		//aa�� �ٸ� ���� ���ο� ��ü ����
		System.out.println("��ü bb = " + bb);
		bb.setDate("�ڳ�", 13);
		System.out.println("�̸� =" + bb.getName() + "\t���� =" + bb.getAge());
		System.out.println();
		
		PersonTest cc = new PersonTest();
		cc.setDate();
		System.out.println("�̸� =" + cc.getName() + "\t���� =" + cc.getAge());
		System.out.println();
		
	}

}


//PersonMain.java ���Ͽ� ����
//�Ʒ� �� Ŭ���������� ����
//PersonMain.class
//PersonTest.class
//�ΰ��� Ŭ������ public�� �پ��ִ� ���� ����(��ǥ,����)
//public(class)�� �ϳ��� .java�ȿ��� �ϳ��� ���� ����(Ŭ���� ��ü�� �ΰ� �̻� ���� ����)