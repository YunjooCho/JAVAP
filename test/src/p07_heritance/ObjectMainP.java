package p07_heritance;
/*
class Object{
	public boolean equals(Object ob)//������ ��
	public String toString(){} //��Ű����.Ŭ������@16����
	public int hashCode(){}//10����
}

final class String extends Object{
	public boolean equals(Objectob){} //���ڿ� ��, ObjectŬ������ equals()�޼ҵ� �������̵�
	public String toString(){}
	//���ڿ�
	//final�� ����� �����ֱ� ������ �ڽ�Ŭ�������� �������̵� �Ұ���
    public int hashCode(){}
    //���ڿ��� 10������ ��ȯ
    //���ڿ� ���Ŀ� ���ؼ� ������� ��
    //���ڿ��� �����̹Ƿ� 10������ �� ǥ���� �� ����
}
  
 */

class Test extends Object{
	public String toString() {
		return "���ٺ�";
	}
}

public class ObjectMainP {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t = " + t);
		System.out.println("��ü t = " + t.toString()); //toString()�� �ּҰ�(16����)�� ������ ����
		System.out.println("��ü t = " + t.hashCode());
		System.out.println();
		
		String str = "apple";
		System.out.println("��ü str = " + str);
		System.out.println("��ü str = " + str.toString());
		System.out.println("��ü str = " + str.hashCode()); //�ź����� ���� ����
		System.out.println(str);
		System.out.println();
		
	}

}
