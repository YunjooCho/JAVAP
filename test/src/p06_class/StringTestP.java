package p06_class;

public class StringTestP {
	public static void main(String[] args){
		//���ڿ� literal����
		String a = "apple"; 
		String b = "apple";
		
		//������ ��
		if(a==b)System.out.println("a�� b�� �������� ����");
		else System.out.println("a�� b�� �������� �ٸ���");
		
		//���ڿ� ��
		if(a.equals(b))System.out.println("a�� b�� ���ڿ��� ����");
		else System.out.println("a�� b�� ���ڿ��� �ٸ���");
		System.out.println();
		
		
		//String ��ü ����
		String c = new String("apple");
		String d = new String("apple");
		//������ ��
		if(c==d) System.out.println("c�� d�� �������� ����");
		else System.out.println("c�� d�� �������� �ٸ���");
		//���ڿ� ��
		if(c.equals(d)) System.out.println("c�� d�� ���ڿ��� ����");
		else System.out.println("c�� d�� ���ڿ��� �ٸ���");
		System.out.println();
		
		String e = "���� ��¥�� " + 2020 + 9 + 25;
		//�տ� ���ڿ��� �ֱ� ������ �ڿ� ���ڴ� ������ �ƴ� ������ ��
		//4ȸ �޸𸮰� ����(+�� ����ɶ�����)
		//JVM�� ���ؼ� ������ Garbage Collector�� ����
		//Garbage Collector�� ����Ǹ� ��ǻ�ʹ� �����(�ſ� ���� �ӵ�)
		System.out.println("e = " + e);
		
		//���ڿ� ũ�� Ȯ��
		System.out.println("���ڿ� ũ�� = " + e.length());//���鵵 ���ڷ� ���
		System.out.println();
		
		//�ش� �ε����� ���ڸ� ������
		for(int i = 0; i < e.length(); i++) {
			System.out.println(i + " : " + e.charAt(i));
		}
		System.out.println();
		
		System.out.println("�κ� ���ڿ� ���� = " + e.substring(7));
		System.out.println("�κ� ���ڿ� ���� = " + e.substring(7, 11));
		
		System.out.println("�빮�� ���� = " + "Hello".toUpperCase());
		System.out.println("�ҹ��� ���� = " + "Hello".toLowerCase());
		
		System.out.println("���ڿ� �˻� = " + e.indexOf("¥"));
		System.out.println("���ڿ� �˻� = " + e.indexOf("��¥"));
		System.out.println("���ڿ� �˻� = " + e.indexOf("���ٺ�"));
		
		
	}
}
