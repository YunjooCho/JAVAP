package p11_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTestP {

	public static void main(String[] args) {
		Collection coll = new ArrayList();
		
		coll.add("호랑이"); //입력한 순서대로 저장됨, 제네릭이 없어서 Warning이 뜸
		coll.add("사자");
		coll.add("호랑이"); //중복허용, 순서
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		Iterator it = coll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
