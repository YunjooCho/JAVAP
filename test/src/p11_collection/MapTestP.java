package p11_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTestP {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����");
		map.put("book301", "�ǿ�������");
		map.put("book101", "��������"); 
		
		System.out.println(map.get("book101"));
		System.out.println(map.get("book102"));
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ڵ� �Է� : ");
		String input = scanner.next();
		
		if(map.containsKey(input)) {
			System.out.println(map.get(input));
		}else {
			System.out.println("���� key �Դϴ�");
		}
	}

}
