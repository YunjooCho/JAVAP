package p11_collection;

import java.util.ArrayList;

public class CollectionTest2P {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("호랑이"); //입력한 순서대로 저장됨
		list.add("사자");
		list.add("호랑이"); //중복허용, 순서
		//list.add(25);   //제너릭이 String이라 들어갈 수 없음, 만약 사용하고 싶으면 <String>을 삭제
		//list.add(43.8);
		list.add("기린");
		list.add("코끼리");
		
		list.get(0);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=======================");
		for(String data : list) {
			System.out.println(data);
		}

	}

}
