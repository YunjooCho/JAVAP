package collection;

class GenericTest2<T>{ //<T> : �� Ŭ������ � Ÿ���� ������� �������� �ʾ����� �ǹ�
	//�ʵ�
	private T a; //Ÿ��(int, boolean, String ���)�� �����ϴ� ���, T�� �Է�
	
	//������
	public GenericTest2(T a) {//String a�� ����
							  //�����ڿ� setter�� �ϴ� ������ ����
							  //�ٸ����� �����ڴ� ������ �ѹ��� �ʱ�ȭ, setter�� �������� ������ �ʱ�ȭ ����
		this.a = a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}

public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("ȫ�浿"); 
		//new GenericTest2<String>();�⺻ ������ - Ŭ���� �ȿ� �����ڰ� �ϳ��� ������ �ڵ����� ������ 
		// <?> �ȿ� �ִ� �ֵ��� Object�� ������ ��(Object�� ����ȯ �� ����)
		// � Ÿ���̵� ���� �� �ְ� ��
		//aa.setA("ȫ�浿"); - error : �ݵ�� �����ڸ� ���ؼ��� �����Ͱ� ���޵�(setA()�޼ҵ�� �Ұ���)
		//�����ڸ� ���ؼ��� �����͸� �����ϴ� ���� : <?>�� Ư¡

		
		//String name = aa.getA(); - error : aa ��ü�� ���� String�� �ƴ� ObjectŸ����
		String name = (String)aa.getA(); //�ڽ� -> �θ� ����ϱ� ���ؼ� ����ȯ -> �ڽ� = (�ڽ�)�θ�
		System.out.println("�̸� = " + name); 
		//new GenericTest2<String>("ȫ�浿")�����ڿ��� �ʱ�ȭ�� ������ ��µ�
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (int)bb.getA(); //autoUnboxing - ������ int�� �ƴ� Integer�� �Է��ؾ���
		System.out.println("���� = " + age);
		
	}

}
