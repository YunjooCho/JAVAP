package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {
	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		
		System.out.println("정렬 전 = ");
		for(String data : ar) {
			System.out.println(data + " ");
		}
		System.out.println();
		
		Arrays.sort(ar); //'배열'을 넘겨주면 자동으로 순서대로 나열
		
		System.out.println("정렬 후 = ");
		for(String data : ar) {
			System.out.println(data + " ");
		}
		System.out.println("\n");
		
		
		PersonDTO aa =  new PersonDTO("홍길동", 25); //aa,bb,cc - 지역변수, 주소값을 담고 있음
		PersonDTO bb =  new PersonDTO("또치", 40);
		PersonDTO cc =  new PersonDTO("도우너", 30);
		//현재 기준점이 없으므로 PersonDTO에서 설정 :compareTo(PersonDTO o) 
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("정렬 전 = " + list);
		//출력값 : [collection.PersonDTO@15db9742, collection.PersonDTO@6d06d69c, collection.PersonDTO@7852e922]
		//toString으로 오버라이딩
//		Test t = new Test();
//		System.out.println(t);
		
		System.out.println("\n나이로 정렬 - 내림차순");
		Collections.sort(list); //DTO파일에서 Comparable인터페이스를 implements해야 함
								//배열 - Arrays로 정렬, 어레이리스트는(배열아님) Collection
			                    //또는 Comporator를 사용하여 새로운 기준을 정해주고 해당 기준으로 정렬, 이때 sort의 매개변수는 2개
		                        //Collection.sort(list,com) - com은 새로운 기준을 정의한 객체
		System.out.println("정렬 후 = " + list);
		System.out.println();
		
		
		
		//정렬기준을 이름으로 변경 - 새로운 기준점 만들기
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {//(Comparator)
			//Comparator는 인터페이스이므로 new생성 할 수 없음 ->compare()메소드 오버라이딩하여 해결
			public int compare(PersonDTO p1, PersonDTO p2) {//오버라이딩
				return p1.getName().compareTo(p2.getName()) * -1; //자체비교후 값이 넘어감, 오름차순(여기에 -1을 곱하면 내림차순이 됨)
			}
		}; 
		//여기서 만약 DTO에 오버라이딩한 compareTo가 내림차순으로 변경되었을 경우, -1을 하면 다시 오름차순이 됨?
		//잡은 기준점에 근거해 출력
		System.out.println("\n이름으로 출력 - 오름차순");
		Collections.sort(list,com); //기본 기준점이 아닌 사용자가 정의한 기준점으로 정렬하도록 함(com) - Comparator
		System.out.println("정렬 후 = " + list);
	}
}
