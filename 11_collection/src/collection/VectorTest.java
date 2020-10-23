package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		System.out.println("���� ũ�� = " + v.size()); //0
		System.out.println("���� �뷮 = " + v.capacity()); //�⺻�뷮 10��, 10���� ����
		System.out.println();
		
		System.out.println("�׸� �߰�");
		for(int i = 1; i <= 10; i++) {
			v.add(i + ""); //�������� ������ ������ ""�� �Է��Ͽ� ����ȭ��
		}
		System.out.println("���� ũ�� = " + v.size()); //10
		System.out.println("���� �뷮 = " + v.capacity()); //10
		System.out.println();
		
		v.add(5 + "");
		System.out.println("���� ũ�� = " + v.size()); //11
		System.out.println("���� �뷮 = " + v.capacity()); //20
		System.out.println();
		
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i) + "   "); //  1  2  3  4  5  6  7  8  9  10  5 - �Է¼����� ����, �ε����� �迭�� ���� 0���� ����
		}
		System.out.println();
		
		v.remove("5"); // �տ� �ִ� 5�� ����
		//v.remove(10); //�ε�����ȣ, �ڿ��ִ� 5�� ����
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next() + "  ");
		}
		System.out.println();
		
		Vector<String> v2 = new Vector<String>(5,2); //�⺻�뷮 5��, 2���� ����
	}

}
