package class_constructor;

public class StringTest {

	public static void main(String[] args) {
		String a = "apple";//���ڿ� literal ����
		String b = "apple";
		if(a==b)System.out.println("a�� b�� �������� ����");//�ּҺ�
		else System.out.println("a�� b�� �������� �ٸ���");
		if(a.equals(b)) System.out.println("a�� b�� ���ڿ��� ����");
		else System.out.println("a�� b�� ���ڿ��� �ٸ���");
		System.out.println();
		
		String c = new String("apple");
		String d = new String("apple");
		if(c==d)System.out.println("c�� d�� �������� ����");
		else System.out.println("c�� d�� �������� �ٸ���");
		if(c.equals(d)) System.out.println("c�� d�� ���ڿ��� ����");
		else System.out.println("c�� d�� ���ڿ��� �ٸ���");
		System.out.println();
		
		String e = "���� ��¥�� " + 2020 + 9 + 25;
		//�տ� ���ڿ��� �ֱ� ������ ������ �ƴ� ������ ��
		//4���� �޸𸮰� ����(+�� ����ɶ����� ���ο� �޸𸮰� ������)
		//JVM�� ���ؼ� ������ Garbage Collector�� ������
		//Garbage Collector�� ����Ǹ� ��ǻ�ʹ� �����(�ſ� ���� �ӵ�)
		System.out.println("e = " + e);
		
		
		System.out.println("���ڿ� ũ�� = " + e.length());
		//�迭ũ�� : �迭��.length
		//����ũ�� : ��ü��.length()
		System.out.println();
		
		for(int i = 0; i < e.length(); i++) {
			System.out.println(i + " : " + e.charAt(i)); //�ش� �ε����� ���ڸ� ������
		}
		System.out.println();
		
		
		System.out.println("�κ� ���ڿ� ����=" + e.substring(7)); //���̽�[7:]
		System.out.println("�κ� ���ڿ� ����=" + e.substring(7,11));//���̽�[7:11] -> [7]~[10]
		
		System.out.println("�빮�� ����=" + "Hello".toUpperCase());
		System.out.println("�ҹ��� ����=" + "Hello".toLowerCase());
		
		System.out.println("���ڿ� �˻�=" + e.indexOf("¥"));
		System.out.println("���ڿ� �˻�=" + e.indexOf("��¥"));
		System.out.println("���ڿ� �˻� =" + e.indexOf("���ٺ�"));

	}

}
