package p11_collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class PersonSortP {
	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		
		System.out.println("정렬 전 = ");
		for(String fruit : ar) {
			System.out.println(fruit + " ");
		}
		System.out.println();
		
		Arrays.sort(ar); //배열을 넘겨주면 자동으로 순서대로 나열
		
		System.out.println("정렬 후 = ");
		for(String fruit : ar) {
			System.out.println(fruit + " ");
		}
		System.out.println();
		
		PersonDTOP aa = new PersonDTOP("몽실", 15);
		PersonDTOP bb = new PersonDTOP("뭉치", 14);
		PersonDTOP cc = new PersonDTOP("물", 1000);
		
		ArrayList<PersonDTOP> list = new ArrayList<PersonDTOP>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("정렬 전 = "); //toString오버라이딩
		for(PersonDTOP dto : list) {
			System.out.println(dto);
		}
		
		System.out.println("\n나이로 정렬 - 내림차순");
		Collections.sort(list);
		
		System.out.println("정렬 후 = ");
		for(PersonDTOP dto : list) {
			System.out.println(dto);
		}
		System.out.println();
		
		//새로운 기준점 만들기
		Comparator<PersonDTOP> com = new Comparator<PersonDTOP>() {
			public int compare(PersonDTOP p1, PersonDTOP p2) {
				return p1.getName().compareTo(p2.getName()); 
			}
		};
		
		System.out.println("\n이름으로 출력 - 오름차순");
		Collections.sort(list,com);
		System.out.println("정렬 후 = " + list);
		
	}
}
