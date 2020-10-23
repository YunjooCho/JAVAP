package inheritance;
/*
//Ŭ������ ���� �޼ҵ� �� �ܿ��� �ʾƵ� ��
class Object{
	public boolean equals(Object ob) //������ ��
	public String toString(){} //��Ű����.Ŭ������@16����
	public int hashCode(){}//10����
}

final class String extends Object{
	public boolean equals(Object ob){} //���ڿ� ��, ObjectŬ������ equals()�޼ҵ� �������̵�
	public String toString(){} 
	//���ڿ�(StringŬ������ java��ü���� toString�������̵��� �Ǿ��־� toString()�������̵��� ����ڰ� ���� �ʾƵ�
	             �ڵ����� �ּҰ��� �ƴ� ���ڿ��� ��µ�)
	//final�� ����� �����ֱ� ������ �ڽ�Ŭ�������� �������̵嵵 �Ұ���    
	public int hasCode(){}
	//���ڿ��� 10������ ��ȯ
	//���ڿ� ���Ŀ� ���ؼ� ������� ��
	//���ڿ��� �����̹Ƿ� 10������ �� ǥ���� �� ����
	//�ٸ� ���ڿ��̾ ���� �ؽð��� �߻� �� �� �ִ�
	//int�� 21�ﰳ�ε� ����, ���ڿ��� ���Ѵ�� ǥ�ð� �Ұ����ϴ�         

*/

class Test2 extends Object{ //�ٸ� �͵鵵 extends Object�� �����Ǿ� ����
	@Override
	public String toString() { //ObjectŬ����(�θ�Ŭ����)�� toString()�żҵ带
							   //Test2(�ڽ�Ŭ����)���� �������̵�(�������̵� �� �ڽ� �޼ҵ常 ȣ���)
		//return super.toString();
		return "���ٺ�";
	}
}


public class ObjectMain {

	public static void main(String[] args) {
		Test2 t = new Test2();
		System.out.println("��ü t = " + t);
		System.out.println("��ü t = " + t.toString()); //toString()�� �ּҰ�(16����)�� ������ ����
		System.out.println("��ü t = " + t.hashCode());
	
		String str = "apple";
		System.out.println("��ü str = " + str);
		System.out.println("��ü str = " + str.toString());
		System.out.println("��ü str = " + str.hashCode()); //�ź����� ���� ����
		System.out.println(str);
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb : " + (aa==bb)); //�ּҰ� ��, false
		System.out.println("aa.equals(bb): " + aa.equals(bb)); //���ڿ� ��, true
		System.out.println();
		
		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : " + (cc==dd)); //�ּҰ� ��, false
		System.out.println("cc.equals(dd): " + cc.equals(dd)); //�ּҰ� ��(ObjectŬ������ �ҷ����Ƿ�), false
		System.out.println();
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee==ff)); //�ּҰ� ��, false
		System.out.println("ee.equals(ff): " + ee.equals(ff)); //Override�� �ڽ�Ŭ������ equals()�� ȣ��(������) 
		                                                       // ���ڿ� ��, true
		System.out.println();
		
	}
	

}

