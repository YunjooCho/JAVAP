package p11_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMainT {
	
	public ArrayList<PersonDTOP> init(){ 
		PersonDTOP aa = new PersonDTOP("홍길동", 25);
		PersonDTOP bb = new PersonDTOP("몽실이", 15);
		PersonDTOP cc = new PersonDTOP("뭉치", 15);
		
		ArrayList<PersonDTOP> list = new ArrayList<PersonDTOP>();
		list.add(aa); //get(0)
		list.add(bb); //get(1)
		list.add(cc); //get(2)
		
		return list;
	}
	
	public static void main(String[] args) {
		PersonMainT pm = new PersonMainT();
		ArrayList<PersonDTOP> list = pm.init();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("이름 = " + list.get(i).getName() + "\t 나이 = " + list.get(i).getAge());
		}
		
		System.out.println("-----------------------------------");
		
		for(PersonDTOP dto : list) {
			System.out.println("이름 = " + dto.getName() + "\t 나이 = " + dto.getAge());
		}
		
		System.out.println("-----------------------------------");
		Iterator<PersonDTOP> it = list.iterator();
		while(it.hasNext()) {
			PersonDTOP dto = it.next();
			System.out.println("이름 = " + dto.getName() + "\t 나이 = " + dto.getAge());
		}

	}

}
