package p11_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTestP {

	public static void main(String[] args) {
		Collection coll = new ArrayList();
		
		coll.add("ȣ����"); //�Է��� ������� �����, ���׸��� ��� Warning�� ��
		coll.add("����");
		coll.add("ȣ����"); //�ߺ����, ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		
		Iterator it = coll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
