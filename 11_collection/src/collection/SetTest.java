package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		//Set - 추상메소드 15개
		//Implementing Classes - HashSet
		//get()사용 못함, 중복허용 안됨, 순서가 뒤죽박죽
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
