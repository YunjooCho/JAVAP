package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {
	public static void main(String[] args) {
		//Implementing Classes - HashMap
		//add가 아닌 put으로 값 입력, get으로 출력
		//킷값, 값 둘다 중복 허용, 킷값이 중복되는 경우 나중에 입력한 값이 나옴(덮어씌워짐)
		//킷값은 파이선의 딕셔너리와 유사?
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주");
		map.put("book301", "피오나공주");
		map.put("book101", "엄지공주"); 
		//"book" + i  로 사용하면 배열같이 출력가능 ->★★★되는지 확인해보기
		
		System.out.println(map.get("book101"));
		System.out.println(map.get("book102"));
		System.out.println();
		
		
		//★★★★value값으로 bookxxx 출력할 수 있는지 확인 containValue
		Scanner scanner = new Scanner(System.in);
		System.out.print("코드 입력 : ");
		String input = scanner.next();
//		if(map.get(input) == null) { //map.get(input)을 등록하지 않았으면 null이 나옴
//			System.out.println("없는 key 입니다");
//		}else {
//			System.out.println(map.get(input));
//		}
		
		if(map.containsKey(input)) {
			System.out.println(map.get(input));
		}else {
			System.out.println("없는 key 입니다");
		}
	}
}
