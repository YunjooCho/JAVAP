package p11_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTestP {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주");
		map.put("book301", "피오나공주");
		map.put("book101", "엄지공주"); 
		
		System.out.println(map.get("book101"));
		System.out.println(map.get("book102"));
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("코드 입력 : ");
		String input = scanner.next();
		
		if(map.containsKey(input)) {
			System.out.println(map.get(input));
		}else {
			System.out.println("없는 key 입니다");
		}
	}

}
