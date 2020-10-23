package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMainT {

	public ArrayList<PersonDTO> init() {
		PersonDTO aa =  new PersonDTO("ȫ�浿", 25); //aa,bb,cc - ��������, �ּҰ��� ��� ����
		PersonDTO bb =  new PersonDTO("��ġ", 40);
		PersonDTO cc =  new PersonDTO("�����", 30);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); //list�� �ּҰ��� �������
		list.add(aa); //get(0)
		list.add(bb); //get(1)
		list.add(cc); //get(2)
		
		return list;
		
	}
	
	public static void main(String[] args) {
		PersonMainT pm = new PersonMainT();
		ArrayList<PersonDTO> list = pm.init();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("�̸� = " + list.get(i).getName() + "\t ���� = " + list.get(i).getAge());
		}
		
		System.out.println("-----------------------------------");
		for(PersonDTO dto : list) { //�̰� ���� ���� ���
			System.out.println("�̸� = " + dto.getName() + "\t ���� = " + dto.getAge());
		}
		
		System.out.println("-----------------------------------");
		Iterator<PersonDTO> it = list.iterator(); //�������������� �̰� ��
		while(it.hasNext()) {
			PersonDTO dto = it.next(); //it.next() - ��ü�� �ּҰ�
			System.out.println("�̸� = " + dto.getName() + "\t ���� = " + dto.getAge());
		}
		
	}

}
