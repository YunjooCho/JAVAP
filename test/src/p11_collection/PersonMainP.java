package p11_collection;

import java.util.ArrayList;

public class PersonMainP {

	public void init() {
		PersonDTOP aa = new PersonDTOP("홍길동", 25);
		PersonDTOP bb = new PersonDTOP("몽실이", 15);
		PersonDTOP cc = new PersonDTOP("뭉치", 15);
		
		ArrayList<PersonDTOP> list = new ArrayList<PersonDTOP>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("이름 = " + list.get(i).getName());
			System.out.println("나이 = " + list.get(i).getAge());
		}
	}
	
	public static void main(String[] args) {
		PersonMainP pm = new PersonMainP();
		pm.init();

	}

}
