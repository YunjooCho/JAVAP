package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMainT {

	public ArrayList<PersonDTO> init() {
		PersonDTO aa =  new PersonDTO("홍길동", 25); //aa,bb,cc - 지역변수, 주소값을 담고 있음
		PersonDTO bb =  new PersonDTO("또치", 40);
		PersonDTO cc =  new PersonDTO("도우너", 30);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); //list도 주소값을 담고있음
		list.add(aa); //get(0)
		list.add(bb); //get(1)
		list.add(cc); //get(2)
		
		return list;
		
	}
	
	public static void main(String[] args) {
		PersonMainT pm = new PersonMainT();
		ArrayList<PersonDTO> list = pm.init();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("이름 = " + list.get(i).getName() + "\t 나이 = " + list.get(i).getAge());
		}
		
		System.out.println("-----------------------------------");
		for(PersonDTO dto : list) { //이걸 제일 많이 사용
			System.out.println("이름 = " + dto.getName() + "\t 나이 = " + dto.getAge());
		}
		
		System.out.println("-----------------------------------");
		Iterator<PersonDTO> it = list.iterator(); //삭제문제에서는 이걸 씀
		while(it.hasNext()) {
			PersonDTO dto = it.next(); //it.next() - 객체의 주소값
			System.out.println("이름 = " + dto.getName() + "\t 나이 = " + dto.getAge());
		}
		
	}

}
