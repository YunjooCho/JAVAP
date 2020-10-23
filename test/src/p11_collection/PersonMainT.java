package p11_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMainT {
	
	public ArrayList<PersonDTOP> init(){ 
		PersonDTOP aa = new PersonDTOP("ȫ�浿", 25);
		PersonDTOP bb = new PersonDTOP("������", 15);
		PersonDTOP cc = new PersonDTOP("��ġ", 15);
		
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
			System.out.println("�̸� = " + list.get(i).getName() + "\t ���� = " + list.get(i).getAge());
		}
		
		System.out.println("-----------------------------------");
		
		for(PersonDTOP dto : list) {
			System.out.println("�̸� = " + dto.getName() + "\t ���� = " + dto.getAge());
		}
		
		System.out.println("-----------------------------------");
		Iterator<PersonDTOP> it = list.iterator();
		while(it.hasNext()) {
			PersonDTOP dto = it.next();
			System.out.println("�̸� = " + dto.getName() + "\t ���� = " + dto.getAge());
		}

	}

}
