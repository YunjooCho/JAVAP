package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {
	public static void main(String[] args) {
		//Implementing Classes - HashMap
		//add�� �ƴ� put���� �� �Է�, get���� ���
		//Ŷ��, �� �Ѵ� �ߺ� ���, Ŷ���� �ߺ��Ǵ� ��� ���߿� �Է��� ���� ����(�������)
		//Ŷ���� ���̼��� ��ųʸ��� ����?
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����");
		map.put("book301", "�ǿ�������");
		map.put("book101", "��������"); 
		//"book" + i  �� ����ϸ� �迭���� ��°��� ->�ڡڡڵǴ��� Ȯ���غ���
		
		System.out.println(map.get("book101"));
		System.out.println(map.get("book102"));
		System.out.println();
		
		
		//�ڡڡڡ�value������ bookxxx ����� �� �ִ��� Ȯ�� containValue
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ڵ� �Է� : ");
		String input = scanner.next();
//		if(map.get(input) == null) { //map.get(input)�� ������� �ʾ����� null�� ����
//			System.out.println("���� key �Դϴ�");
//		}else {
//			System.out.println(map.get(input));
//		}
		
		if(map.containsKey(input)) {
			System.out.println(map.get(input));
		}else {
			System.out.println("���� key �Դϴ�");
		}
	}
}
