package p11_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTestP {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("호랑이"); //입력한 순서대로 저장됨, 제네릭이 없어서 Warning이 뜸
		set.add("사자");
		set.add("호랑이"); //중복허용X, 순서X
		set.add("기린");
		set.add("코끼리");

		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
