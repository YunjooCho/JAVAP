package p11_collection;

import java.util.ArrayList;

public class PersonMainP {

	public void init() {
		PersonDTOP aa = new PersonDTOP("È«±æµ¿", 25);
		PersonDTOP bb = new PersonDTOP("¸ù½ÇÀÌ", 15);
		PersonDTOP cc = new PersonDTOP("¹¶Ä¡", 15);
		
		ArrayList<PersonDTOP> list = new ArrayList<PersonDTOP>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("ÀÌ¸§ = " + list.get(i).getName());
			System.out.println("³ªÀÌ = " + list.get(i).getAge());
		}
	}
	
	public static void main(String[] args) {
		PersonMainP pm = new PersonMainP();
		pm.init();

	}

}
