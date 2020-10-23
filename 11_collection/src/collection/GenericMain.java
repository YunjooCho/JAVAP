package collection;

class GenericTest<T>{ //<T> : �� Ŭ������ � Ÿ���� ������� �������� �ʾ����� �ǹ� / Object���
	private T a; //Ÿ��(int, boolean, String ���)�� �����ϴ� ���, T�� �Է�
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}

//------------------------------------------------------------------
public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>(); //���� T�� String���� ������
		aa.setA("ȫ�浿");
		System.out.println("�̸� = " + aa.getA());
		
		//aa.setA(25); - error : T�� StringŸ������ �����Ǿ� �־� StringŸ�� �̿��� �����ʹ� ����
		//�ٽ� ��ü�� ����, IntegerŸ������ ����
		GenericTest<Integer> bb = new GenericTest<Integer>(); //<>�ȿ��� Ŭ������ �ü� �����Ƿ� int��� Integer���
		bb.setA(25);
		System.out.println("���� = " + bb.getA());
	}

}
