package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
	@SuppressWarnings("all") //������ - ������̼�
	public static void main(String[] args) {
		//Collection - �������̽� & �߻�޼ҵ�
		Collection coll = new ArrayList(); //implements Collection�� �ʿ����
										   //�Ϲ�Ŭ�����̱� ������ WindowAdapter�� �޸� �͸���Ŭ���� ���̵� new�� ��������
		//�θ�                               �ڽ�           -> �̷��� ������ ���� ����
		//ArrayList implements Collection
		
		coll.add("ȣ����"); //�Է��� ������� �����, ���׸��� ��� Warning�� ��
		coll.add("����");
		coll.add("ȣ����"); //�ߺ����, ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		
		//Iterator - �׸�(���)�ϳ��ϳ��� ����ų �� ����
		//hasNext() - ���� ��ġ�� �׸��� ������ True, ������ False
		//next() - �׸��� �������� ���� �׸����� �̵�
		//��� ����Ŀ� ���� �������� �޶���(������ Collection��, setter�� �ٸ� Ŭ���������� ��밡��)
		//Iterator - ������, Collection�� �����ڸ� ����
		Iterator it = coll.iterator(); //coll(Collection)�ȿ� iterator�� �����Ͽ� �迭����Ʈ �׸��� ����Ű���� ��
		while(it.hasNext()) {//�׸��� ���� ������ �ݺ�, ���� ������ while�� ��������
			System.out.println(it.next()); //�� �׸��� �� ���(���� ���� �Է��� ������� ���µ�)
		}//while
	}

}


//Collection - Interface
//1.implements : ��� �߻�޼ҵ带 �ݵ�� �������̵� ����� ��
//  (Collection�� �߻�޼ҵ�� 15��)  
//    ��WindowListener�� 7�� -> WindowAdapter�� WindowListener�� ����ؼ� ��� Override ����
//2.�͸� innerŬ������ ��� : ��� �߻�޼ҵ带 �ݵ�� �������̵� ����� �� (Adapter���� Ŭ������ �����Ƿ�)
//3.�������� ����ؼ� ��� �߻�޼ҵ带 Override���� : Implementing Classes
//  ArrayList(�Ϲ�Ŭ����, new�� ����), Stack, Vector. TreeSet(�˰���) - WindowAdapter(�߻�Ŭ����,�͸���Ŭ������ ����)�� ���� ����